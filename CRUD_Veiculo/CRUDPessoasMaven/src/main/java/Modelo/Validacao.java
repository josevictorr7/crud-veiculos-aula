package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Validacao
{
    public String mensagem;
    public int id;

    public void validarIdVeiculo(String identificacao)
    {
        this.mensagem = "";

        try
        {
            this.id = Integer.parseInt(identificacao);
        }
        catch (Exception e)
        {
            this.mensagem = "ID inválido";
        }
    }

    public void validarDadosVeiculo(List<String> listaDadosVeiculo)
    {
        this.mensagem = "";

        validarIdVeiculo(listaDadosVeiculo.get(0));

        if (listaDadosVeiculo.get(1).length() < 3)
            this.mensagem += "Modelo deve ter pelo menos 3 caracteres\n";

        if (listaDadosVeiculo.get(1).length() > 100)
            this.mensagem += "Modelo deve ter no máximo 100 caracteres\n";

        if (listaDadosVeiculo.get(2).length() < 2)
            this.mensagem += "Fabricante deve ter pelo menos 2 caracteres\n";

        if (listaDadosVeiculo.get(2).length() > 100)
            this.mensagem += "Fabricante deve ter no máximo 100 caracteres\n";

        try
        {
            int ano = Integer.parseInt(listaDadosVeiculo.get(3));

            if (ano < 1886)
                this.mensagem += "Ano de fabricação inválido\n";
        }
        catch (Exception e)
        {
            this.mensagem += "Ano de fabricação inválido\n";
        }

        if (listaDadosVeiculo.get(4).length() < 3)
            this.mensagem += "Cor deve ter pelo menos 3 caracteres\n";

        if (listaDadosVeiculo.get(4).length() > 50)
            this.mensagem += "Cor deve ter no máximo 50 caracteres\n";

        try
        {
            BigDecimal valor = new BigDecimal(listaDadosVeiculo.get(5));

            if (valor.compareTo(BigDecimal.ZERO) <= 0)
                this.mensagem += "Valor deve ser maior que zero\n";
        }
        catch (Exception e)
        {
            this.mensagem += "Valor inválido\n";
        }
    }
}