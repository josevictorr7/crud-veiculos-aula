package DAL;

import Modelo.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void cadastrarVeiculo(Veiculo veiculo)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "insert into Veiculos "
                    + "(modelo, fabricante, anoFabricacao, cor, valor) "
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getFabricante());
            stmt.setInt(3, veiculo.getAnoFabricacao());
            stmt.setString(4, veiculo.getCor());
            stmt.setBigDecimal(5, veiculo.getValor());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Veículo cadastrado com sucesso no sistema!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro";
        }
    }
    
    public Veiculo pesquisarVeiculoId(Veiculo veiculo)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "select * from Veiculos where id = ?";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setInt(1, veiculo.getId());
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next())
            {
                veiculo.setModelo(resultSet.getString("modelo"));
                veiculo.setFabricante(resultSet.getString("fabricante"));
                veiculo.setAnoFabricacao(resultSet.getInt("anoFabricacao"));
                veiculo.setCor(resultSet.getString("cor"));
                veiculo.setValor(resultSet.getBigDecimal("valor"));
            }
            else
            {
                this.mensagem = "Veiculo não encontrado no sistema!";
            }
            
            conexao.desconectar();
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro";
        }
        return veiculo;
    }
    
    public void editarVeiculo(Veiculo veiculo)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "update Veiculos "
                    + "set modelo = ?, "
                    + "fabricante = ?, "
                    + "anoFabricacao = ?, "
                    + "cor = ?, "
                    + "valor = ? "
                    + "where id = ?";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getFabricante());
            stmt.setInt(3, veiculo.getAnoFabricacao());
            stmt.setString(4, veiculo.getCor());
            stmt.setBigDecimal(5, veiculo.getValor());
            stmt.setInt(6, veiculo.getId());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Informações do veiculo alteradas com sucesso!";
        }
        catch (SQLException e)
        {
            this.mensagem = "Erro ao editar veículos.";
        }
        catch (Exception ex)
        {
            this.mensagem = "Erro indefinido";
        }
    }
    
    public void excluirVeiculo(Veiculo veiculo)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "delete from Veiculos "
                    + "where id = ?";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setInt(1, veiculo.getId());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Veiculo excluido com sucesso do sistema!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro na exclusão";
        }
    }
}
