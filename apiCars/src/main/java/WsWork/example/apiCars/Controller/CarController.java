package WsWork.example.apiCars.Controller;

import WsWork.example.apiCars.Entity.Car;
import WsWork.example.apiCars.Repository.CarRepository;
import WsWork.example.apiCars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars.json")
public class CarController {
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car create(@RequestBody Car car){
       return carService.create(car);
    }
    @GetMapping
    public List<Car> listAllCars(){
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
