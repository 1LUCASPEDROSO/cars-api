package WsWork.example.apiCars.Repository;

import WsWork.example.apiCars.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
