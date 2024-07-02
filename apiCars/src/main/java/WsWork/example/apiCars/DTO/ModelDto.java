package WsWork.example.apiCars.DTO;

import java.math.BigDecimal;

public class ModelDto {
    private long id;
    private long marca_id;
    private String nome;
    private BigDecimal valor_fipe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(long marca_id) {
        this.marca_id = marca_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(BigDecimal valor_fipe) {
        this.valor_fipe = valor_fipe;
    }
}
