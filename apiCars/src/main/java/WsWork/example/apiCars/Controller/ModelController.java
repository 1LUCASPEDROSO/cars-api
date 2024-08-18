package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.DTO.ModelDTO;
import WsWork.example.apiCars.Entity.Model;
import WsWork.example.apiCars.service.ModelServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/models.json")
public class ModelController {
    ModelServices modelServices;

    public ModelController(ModelServices modelServices) {
        this.modelServices = modelServices;
    }
    @PostMapping
    public Model createModel( @RequestBody ModelDTO dto){
      return modelServices.create(dto);
    }
    @GetMapping
    public List<ModelDTO> listAllModels(){
      return modelServices.listAllModels();
    }
    @PutMapping
    public Model updateModel(@RequestBody ModelDTO dto){
       return modelServices.updateModel(dto);
    }
    @DeleteMapping("{id}")
    public void deleteModel(@PathVariable Long id){
        modelServices.deleteModel(id);
    }
}
