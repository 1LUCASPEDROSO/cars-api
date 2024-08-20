package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.DTO.CarDTO;
import WsWork.example.apiCars.Entity.Car;
import WsWork.example.apiCars.service.CarServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cars.json")
public class CarController {
    private CarServices carService;

    private CarController(CarServices carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody CarDTO dto){
        Car newCar = carService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }
    @GetMapping
    public ResponseEntity<List<CarDTO>> listAllCars(){
        List<CarDTO> cars = carService.listAllCars();
        return ResponseEntity.ok(cars);
    }
    @PutMapping
    public ResponseEntity<Car> updateCar(CarDTO dto){
        Car updetedCar = carService.updateCar(dto);
        return ResponseEntity.ok(updetedCar);
    }
    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable long id){
        carService.deleteCar(id);
    }
}
