package WsWork.example.apiCars.service;

import WsWork.example.apiCars.Entity.Brand;
import WsWork.example.apiCars.Entity.Car;
import WsWork.example.apiCars.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public Car create(Car car){
        //long timestamp = car.getRegister_date().getTime() / 1000L;
        //car.setRegister_date(timestamp);
        return carRepository.save(car);
    }

    public List<Car> listAllCars(){
       return carRepository.findAll();
    }
    public Car updateCar(Car car){
        Optional<Car> existCar = carRepository.findById(car.getId());
        if (existCar.isPresent()){
            return carRepository.save(car);
        }
        else {
            throw new RuntimeException("Car not found with id: " + car.getId());
        }
    }
    public void deleteCar(long id){
        carRepository.deleteById(id);
    }
}
