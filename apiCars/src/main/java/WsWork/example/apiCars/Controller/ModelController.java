package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.DTO.ModelDto;
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
    public Model createModel( @RequestBody Model model){
      return modelServices.create(model);
    }
    @GetMapping
    public List<ModelDto> listAllModels(){
      return modelServices.listAllModels();
    }
    @PutMapping
    public Model updateModel(@RequestBody Model model){
       return modelServices.updateModel(model);
    }
    @DeleteMapping("{id}")
    public void deleteModel(@PathVariable Long id){
        modelServices.deleteModel(id);
    }
}
