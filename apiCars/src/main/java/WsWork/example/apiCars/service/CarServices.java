package WsWork.example.apiCars.service;

import WsWork.example.apiCars.DTO.CarDto;
import WsWork.example.apiCars.Repository.CarRepository;
import WsWork.example.apiCars.Entity.Car;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServices {
     private final CarRepository carRepository;

    private CarServices(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car){
        return carRepository.save(car);
    }

    public List<CarDto> listAllCars(){
        return carRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
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
    private CarDto convertToDTO(Car car) {
        // baseado no modelo de exemplo dos dados fou ultilizado DTO para alinhar e corresponder ao modelo, bem como para tratamento do valor Date para timestamp unix
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setCadaster_timestamp(car.getRegister_date().getTime() / 1000L); // conversão de date para timestamp unix
        dto.setModel_id(car.getModel().getId());
        dto.setYear(car.getYear());
        dto.setGasType(car.getGas_type());
        dto.setNum_doors(car.getNum_Doors());
        dto.setColor(car.getColor());
        dto.setModel_name(car.getModel().getName());
        dto.setValue(car.getModel().getFipe_value());
        return dto;
    }
}
