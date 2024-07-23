package WsWork.example.apiCars.service;

import WsWork.example.apiCars.Entity.Model;
import WsWork.example.apiCars.DTO.ModelDto;
import WsWork.example.apiCars.Repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelServices {

    private final ModelRepository modelRepository;

    private ModelServices(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Model create(Model model){
        return modelRepository.save(model);
    };

    public List<ModelDto> listAllModels(){
        return modelRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Model updateModel(Model model) {
        Optional<Model> existModel = modelRepository.findById(model.getId());
        if (existModel.isPresent()){
            return modelRepository.save(model);
        }
        else {
            throw new RuntimeException("Model not found with id: " + model.getId());
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
