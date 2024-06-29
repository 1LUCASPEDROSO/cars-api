package WsWork.example.apiCars.service;

import WsWork.example.apiCars.Entity.Model;
import WsWork.example.apiCars.Repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServices {

    private ModelRepository modelRepository;

    public ModelServices(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Model create(Model model){
        return modelRepository.save(model);
    };

    public List<Model> listAllModels(){
        return modelRepository.findAll();
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
}
