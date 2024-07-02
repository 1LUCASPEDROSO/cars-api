package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.DTO.BrandDto;
import WsWork.example.apiCars.Entity.Brand;
import WsWork.example.apiCars.service.BrandServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/brands")
public class BrandController {

    private  BrandServices brandServices;

    public BrandController(BrandServices brandServices) {
        this.brandServices = brandServices;
    }

    @PostMapping
    public Brand createBrand(@RequestBody Brand brand){
        return brandServices.create(brand);
    }
    @GetMapping
    public List<BrandDto> listAllBrand(){
        return brandServices.listAllBrands();
    }
    @PutMapping
    public Brand updateBrand(@RequestBody Brand brand){
        return brandServices.updateBrand(brand);
    }
    @DeleteMapping("{id}")
    public void deleteBrand(@PathVariable Long id){
        brandServices.deleteBrand(id);
    }
}

