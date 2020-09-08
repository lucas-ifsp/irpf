package br.edu.ifsp.database.dao;


import br.edu.ifsp.database.utils.ConnectionFactory;
import br.edu.ifsp.model.GastoDedutivel;
import br.edu.ifsp.model.GastoEducacao;
import br.edu.ifsp.model.GastoSaude;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GastoDedutivelDAO implements GenericDAO<GastoDedutivel, Integer> {

    @Override
    public void save(GastoDedutivel gastoDedutivel) {
        throw new RuntimeException("Método não implementado");
    }


    @Override
    public void update(GastoDedutivel gastoDedutivel) {
        throw new RuntimeException("Método não implementado");
    }

    @Override
    public void delete(Integer key) {
        throw new RuntimeException("Método não implementado");
    }

    @Override
    public GastoDedutivel load(Integer key) {
        throw new RuntimeException("Método não implementado");
    }

    @Override
    public List<GastoDedutivel> loadAll() {
        String sql = "SELECT * FROM Deducao";
        List<GastoDedutivel> gastos = new ArrayList<>();

        try(PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String descricao = rs.getString("descricao");
                String cnpj = rs.getString("cnpj");
                String instituicao = rs.getString("instituicao");
                String conselho = rs.getString("conselho");
                Double valor = rs.getDouble("valor");
                Integer id = rs.getInt("id");
                if(instituicao != null)
                    gastos.add(new GastoEducacao(descricao, valor, cnpj, instituicao, id));
                else
                    gastos.add(new GastoSaude(descricao, valor, cnpj, conselho, id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gastos;
    }
}
