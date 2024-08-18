package WsWork.example.apiCars.service;

import WsWork.example.apiCars.DTO.RequestDTOModel;
import WsWork.example.apiCars.Entity.Brand;
import WsWork.example.apiCars.Entity.Model;
import WsWork.example.apiCars.DTO.ModelDto;
import WsWork.example.apiCars.Repository.BrandRepository;
import WsWork.example.apiCars.Repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelServices {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository ;

    public ModelServices(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    public Model create(RequestDTOModel dto){
            Brand brand = brandRepository.findById(dto.brand_id())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id: " + dto.brand_id()));
            Model newModel = new Model (brand, dto.name(), dto.fipe_value());
            return modelRepository.save(newModel);
    }
    public List<ModelDto> listAllModels(){
        return modelRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Model updateModel(RequestDTOModel dto) {
        Optional<Model> existModel = modelRepository.findById(dto.id());
        if (existModel.isPresent()){
            Brand brand = brandRepository.findById(dto.brand_id())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id: " + dto.brand_id()));
            Model updatedModel = existModel.get();
            updatedModel.setBrand(brand);
            updatedModel.setName(dto.name());
            updatedModel.setFipe_value(dto.fipe_value());
            return modelRepository.save(updatedModel);
        }
        else {
            throw new RuntimeException("Model not found with id: " + dto.id());
        }
    }
    public void deleteModel(long id){
        modelRepository.deleteById(id);
    }
    private ModelDto convertToDto(Model model){
        ModelDto  dto = new ModelDto();
        dto.setId(model.getId());
        dto.setBrand_id(model.getBrand().getId());
        dto.setName(model.getName());
        dto.setFipe_value(model.getFipe_value());
        return dto;
    }
}
