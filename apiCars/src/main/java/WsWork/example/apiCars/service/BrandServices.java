package WsWork.example.apiCars.service;

import WsWork.example.apiCars.Entity.Brand;
import WsWork.example.apiCars.Repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServices {
    private BrandRepository brandRepository;

    public BrandServices(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand create(Brand brand){
        return brandRepository.save(brand);
    };
}
