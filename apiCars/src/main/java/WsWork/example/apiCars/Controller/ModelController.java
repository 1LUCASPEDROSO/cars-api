package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.Entity.Model;
import WsWork.example.apiCars.service.ModelServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/models")
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
    public List<Model> listAllModels(){
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
