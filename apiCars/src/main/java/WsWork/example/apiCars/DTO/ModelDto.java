package WsWork.example.apiCars.DTO;

import WsWork.example.apiCars.Entity.Model;

import java.math.BigDecimal;

public class ModelDto {
    private long id;
    private long brand_id;
    private String name;
    private BigDecimal fipe_value;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(long brand_id) {
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFipe_value() {
        return fipe_value;
    }

    public void setFipe_value(BigDecimal fipe_value) {
        this.fipe_value = fipe_value;
    }
}
