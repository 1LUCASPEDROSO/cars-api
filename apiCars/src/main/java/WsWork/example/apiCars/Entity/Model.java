package WsWork.example.apiCars.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name="model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private String name;
    private BigDecimal fipe_value;

    public Model() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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
