package Modelo;

import DAL.VeiculoDAO;
import java.math.BigDecimal;
import java.util.List;

public class Controle
{
    public String mensagem;

    public void cadastrarVeiculo(List<String> listaDadosVeiculo)
    {
        this.mensagem = "";

        Validacao validacao = new Validacao();
        validacao.validarDadosVeiculo(listaDadosVeiculo);

        this.mensagem = validacao.mensagem;

        if (this.mensagem.equals(""))
        {
            Veiculo veiculo = new Veiculo();

            veiculo.setModelo(listaDadosVeiculo.get(1));
            veiculo.setFabricante(listaDadosVeiculo.get(2));
            veiculo.setAnoFabricacao(
                    Integer.parseInt(listaDadosVeiculo.get(3)));
            veiculo.setCor(listaDadosVeiculo.get(4));
            veiculo.setValor(
                    new BigDecimal(listaDadosVeiculo.get(5)));

            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.cadastrarVeiculo(veiculo);

            this.mensagem = veiculoDAO.mensagem;
        }
    }

    public Veiculo pesquisarVeiculoId(List<String> listaDadosVeiculo)
    {
        this.mensagem = "";

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo = new Veiculo();
        Validacao validacao = new Validacao();

        validacao.validarIdVeiculo(listaDadosVeiculo.get(0));

        this.mensagem = validacao.mensagem;

        if (this.mensagem.equals(""))
        {
            veiculo.setId(validacao.id);

            veiculo = veiculoDAO.pesquisarVeiculoId(veiculo);

            this.mensagem = veiculoDAO.mensagem;
        }

        return veiculo;
    }

    public void editarVeiculo(List<String> listaDadosVeiculo)
    {
        this.mensagem = "";

        Validacao validacao = new Validacao();
        validacao.validarDadosVeiculo(listaDadosVeiculo);

        this.mensagem = validacao.mensagem;

        if (this.mensagem.equals(""))
        {
            Veiculo veiculo = new Veiculo();

            veiculo.setId(validacao.id);
            veiculo.setModelo(listaDadosVeiculo.get(1));
            veiculo.setFabricante(listaDadosVeiculo.get(2));
            veiculo.setAnoFabricacao(
                    Integer.parseInt(listaDadosVeiculo.get(3)));
            veiculo.setCor(listaDadosVeiculo.get(4));
            veiculo.setValor(
                    new BigDecimal(listaDadosVeiculo.get(5)));

            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.editarVeiculo(veiculo);

            this.mensagem = veiculoDAO.mensagem;
        }
    }

    public void excluirVeiculo(List<String> listaDadosVeiculo)
    {
        this.mensagem = "";

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo = new Veiculo();
        Validacao validacao = new Validacao();

        validacao.validarIdVeiculo(listaDadosVeiculo.get(0));

        this.mensagem = validacao.mensagem;

        if (this.mensagem.equals(""))
        {
            veiculo.setId(validacao.id);

            veiculoDAO.excluirVeiculo(veiculo);

            this.mensagem = veiculoDAO.mensagem;
        }
    }
}

