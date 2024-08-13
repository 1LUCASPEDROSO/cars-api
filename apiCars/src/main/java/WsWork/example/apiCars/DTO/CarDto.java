package WsWork.example.apiCars.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class CarDto {
    private long id;
    private long cadaster_timestamp;
    private long model_id;
    private Integer year;
    private String gasType;
    private Integer num_doors;
    private String color;
    private String model_name;
    private BigDecimal value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getCadaster_timestamp() {
        return cadaster_timestamp;
    }

    public void setCadaster_timestamp(long cadaster_timestamp) {
        this.cadaster_timestamp = cadaster_timestamp;
    }
    
    public long getModel_id() {
        return model_id;
    }

    public void setModel_id(long model_id) {
        this.model_id = model_id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public Integer getNum_doors() {
        return num_doors;
    }

    public void setNum_doors(Integer num_doors) {
        this.num_doors = num_doors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
