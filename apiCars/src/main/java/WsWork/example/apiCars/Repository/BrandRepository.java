package WsWork.example.apiCars.Repository;

import WsWork.example.apiCars.Entity.Brand;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand , Long> {
}
