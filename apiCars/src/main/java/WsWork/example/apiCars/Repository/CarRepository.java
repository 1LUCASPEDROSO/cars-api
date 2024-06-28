package WsWork.example.apiCars.Repository;

import WsWork.example.apiCars.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
