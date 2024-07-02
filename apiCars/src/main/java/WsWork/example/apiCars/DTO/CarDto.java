package WsWork.example.apiCars.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class CarDto {
    private long id;
    private long timestamp_cadastro;
    private Date date_cadastro;
    private long modelo_id;
    private Integer ano;
    private String combustivel;
    private Integer num_portas;
    private String cor;
    private String nome_modelo;
    private BigDecimal valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp_cadastro() {
        return timestamp_cadastro;
    }

    public void setTimestamp_cadastro(long timestamp_cadastro) {
        this.timestamp_cadastro = timestamp_cadastro;
    }

    public Date getDate_cadastro() {
        return date_cadastro;
    }

    public void setDate_cadastro(Date date_cadastro) {
        this.date_cadastro = date_cadastro;
    }

    public long getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(long modelo_id) {
        this.modelo_id = modelo_id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Integer getNum_portas() {
        return num_portas;
    }

    public void setNum_portas(Integer num_portas) {
        this.num_portas = num_portas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome_modelo() {
        return nome_modelo;
    }

    public void setNome_modelo(String nome_modelo) {
        this.nome_modelo = nome_modelo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


}
