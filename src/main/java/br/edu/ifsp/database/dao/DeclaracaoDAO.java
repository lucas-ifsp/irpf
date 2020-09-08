package br.edu.ifsp.database.dao;

import br.edu.ifsp.database.utils.ConnectionFactory;
import br.edu.ifsp.model.Declaracao;
import br.edu.ifsp.model.DeclaracaoCompleta;
import br.edu.ifsp.model.DeclaracaoSimplificada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DeclaracaoDAO implements GenericDAO<Declaracao, Integer> {

    @Override
    public void save(Declaracao declaracao) {
        String sql = "INSERT INTO Declaracao(valor_pago, renda, tipo) VALUES(?,?,?)";
        try(PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setDouble(1, declaracao.getValorPago());
            statement.setDouble(2, declaracao.getRendaTributavel());
            statement.setInt(3, declaracao instanceof DeclaracaoSimplificada ? 0 : 1);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Declaracao declaracao) {
        String sql = "UPDATE Declaracao SET valor_pago = ?, renda = ?, tipo = ? WHERE id = ?";
        try(PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setDouble(1, declaracao.getValorPago());
            statement.setDouble(2, declaracao.getRendaTributavel());
            statement.setInt(3, declaracao instanceof DeclaracaoSimplificada ? 0 : 1);
            statement.setInt(4, declaracao.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer integer) {
        throw new RuntimeException("Método não implementado");
    }


    @Override
    public Declaracao load(Integer key) {
        String sql = "SELECT * FROM Declaracao WHERE id = ?";
        Declaracao declaracao = null;
        try(PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            statement.setInt(1, key);

            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Integer tipo = rs.getInt("tipo");
                if(tipo == 0)
                    declaracao = new DeclaracaoSimplificada(rs.getDouble("renda"), rs.getDouble("valor_pago"));
                else
                    declaracao = new DeclaracaoCompleta(rs.getDouble("renda"),  rs.getDouble("valor_pago"));
                declaracao.setId(rs.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return declaracao;
    }

    @Override
    public List<Declaracao> loadAll() {
        throw new RuntimeException("Método não implementado");
    }
}
