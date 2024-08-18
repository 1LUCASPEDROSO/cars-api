package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.DTO.ModelDTO;
import WsWork.example.apiCars.Entity.Model;
import WsWork.example.apiCars.service.ModelServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Model> createModel( @RequestBody ModelDTO dto){
        Model model = modelServices.create(dto);
      return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }
    @GetMapping
    public ResponseEntity<List<ModelDTO>> listAllModels() {
        List<ModelDTO> models = modelServices.listAllModels();
        return ResponseEntity.ok(models);
    }
    @PutMapping
    public ResponseEntity<Model> updateModel(@RequestBody ModelDTO dto){
        Model updetedModel = modelServices.updateModel(dto);
       return ResponseEntity.ok(updetedModel);
    }
    @DeleteMapping("{id}")
    public void deleteModel(@PathVariable Long id){
        modelServices.deleteModel(id);
    }
}
