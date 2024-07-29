package WsWork.example.apiCars.DTO;

import java.math.BigDecimal;

public record RequestDTOModel(long id,long brand_id, String name, BigDecimal fipe_value) {
}
