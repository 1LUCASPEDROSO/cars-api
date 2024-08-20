package WsWork.example.apiCars.DTO;

import java.math.BigDecimal;
import java.util.Date;

public record CarDTO(long id,Date registerDate, long modelId, int year, String gasType, int numDors,String color,String nameModel, BigDecimal fipeValue) {
}
