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
    CarRepository carRepository;

    public CarServices(CarRepository carRepository) {
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
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setTimestamp_cadastro(car.getRegister_date().getTime() / 1000L);
        dto.setModelo_id(car.getModel().getId());
        dto.setAno(car.getYear());
        dto.setCombustivel(car.getGas_type());
        dto.setNum_portas(car.getNum_Doors());
        dto.setCor(car.getColor());
        dto.setNome_modelo(car.getModel().getName());
        dto.setValor(car.getModel().getFipe_value());
        return dto;
    }
}
