package WsWork.example.apiCars.service;

import WsWork.example.apiCars.DTO.CarDTO;
import WsWork.example.apiCars.Entity.Model;
import WsWork.example.apiCars.Repository.CarRepository;
import WsWork.example.apiCars.Entity.Car;
import WsWork.example.apiCars.Repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServices {
     private final CarRepository carRepository;
     private final ModelRepository modelRepository;

    public CarServices(CarRepository carRepository, ModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;
    }

    public Car create(CarDTO dto){
        Model model = modelRepository.findById(dto.modelId()).
                orElseThrow(() -> new RuntimeException("Model not found with id: " + dto.modelId()));
        Car newCar = new Car(
                dto.registerDate(),
                model,
                dto.year(),
                dto.gasType(),
                dto.numDors(),
                dto.color()
        );
        return carRepository.save(newCar);
    }

    public List<CarDTO> listAllCars(){
        return carRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    public Car updateCar(CarDTO dto){
        Optional<Car> existCar = carRepository.findById(dto.id());
        if (existCar.isPresent()){
            Model model = modelRepository.findById(dto.modelId()).
                    orElseThrow(() -> new RuntimeException("Model not found with id: " + dto.modelId()));
            Car updatedCar = existCar.get();
            updatedCar.setRegister_date(dto.registerDate());
            updatedCar.setModel(model);
            updatedCar.setYear(dto.year());
            updatedCar.setGas_type(dto.gasType());
            updatedCar.setNum_Doors(dto.numDors());
            return carRepository.save(updatedCar);
        }
        else {
            throw new RuntimeException("Car not found with id: " + dto.id());
        }
    }
    public void deleteCar(long id){
        carRepository.deleteById(id);
    }

    private CarDTO convertToDTO(Car car) {
        long timeStampCadaster = car.getRegister_date().getTime() / 1000L;
       return new CarDTO(
               car.getId(),
               car.getRegister_date(),
               car.getModel().getId(),
               car.getYear(),
               car.getGas_type(),
               car.getNum_Doors(),
               car.getColor(),
               car.getModel().getName(),
               car.getModel().getFipe_value()
       );
    }
}
