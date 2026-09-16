package Modelo;

import java.math.BigDecimal;

public class Veiculo
{
    private int id;
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String cor;
    private BigDecimal valor;

    // Getters
    
    public int getId() {
        return id;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public String getFabricante() {
        return fabricante;
    }
    
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    
    public String getCor() {
        return cor;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    // Setters
    
    public void setId(int id)
    {
        this.id = id;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }

    public void setAnoFabricacao(int anoFabricacao)
    {
        this.anoFabricacao = anoFabricacao;
    }
    
    public void setCor(String cor)
    {
        this.cor = cor;
    }

    public void setValor(BigDecimal valor)
    {
        this.valor = valor;
    }
    
    
}
