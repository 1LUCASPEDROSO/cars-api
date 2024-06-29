package WsWork.example.apiCars.service;

import WsWork.example.apiCars.Entity.Brand;
import WsWork.example.apiCars.Repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServices {
    private BrandRepository brandRepository;

    public BrandServices(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand create(Brand brand){
        return brandRepository.save(brand);
    };

    public List<Brand> listAllBrands(){
       return brandRepository.findAll();
    }

    public Brand updateBrand(Brand brand) {
        Optional<Brand> existBrand = brandRepository.findById(brand.getId());
        if (existBrand.isPresent()){
            return brandRepository.save(brand);
        }
        else {
            throw new RuntimeException("Brand not found with id: " + brand.getId());
        }
    }
    public void deleteBrand(long id){
        brandRepository.deleteById(id);
    }
}
