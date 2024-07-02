package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.DTO.CarDto;
import WsWork.example.apiCars.Entity.Car;
import WsWork.example.apiCars.service.CarServices;
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
    public Car create(@RequestBody Car car){
        return carService.create(car);
    }
    @GetMapping
    public List<CarDto> listAllCars(){
        return carService.listAllCars();
    }
    @PutMapping
    public Car updateCar(Car car){
        return carService.updateCar(car);
    }
    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable long id){
        carService.deleteCar(id);
    }
}
