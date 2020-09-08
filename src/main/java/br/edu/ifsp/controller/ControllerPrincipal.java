package br.edu.ifsp.controller;

import br.edu.ifsp.database.dao.DeclaracaoDAO;
import br.edu.ifsp.database.dao.GastoDedutivelDAO;
import br.edu.ifsp.model.DeclaracaoCompleta;
import br.edu.ifsp.model.DeclaracaoSimplificada;
import br.edu.ifsp.model.GastoDedutivel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerPrincipal {

    @FXML TableView<GastoDedutivel> tableView;
    @FXML TableColumn<GastoDedutivel, String> cTipo;
    @FXML TableColumn<GastoDedutivel, String> cDescricao;
    @FXML TableColumn<GastoDedutivel, String> cValor;
    @FXML Label lbCompleta;
    @FXML Label lbSimplificada;
    @FXML TextField txtRenda;
    @FXML TextField txtPago;

    private ObservableList<GastoDedutivel> values;
    private DeclaracaoCompleta completa;
    private DeclaracaoSimplificada simplificada;

    public void add(ActionEvent actionEvent) {

    }

    public void edit(ActionEvent actionEvent) {

    }

    public void remove(ActionEvent actionEvent) {

    }

    public void calc(ActionEvent actionEvent) {
        if(!txtRenda.getText().equals("") &&  !txtPago.getText().equals("")){
            Double renda = Double.valueOf(txtRenda.getText());
            Double pago = Double.valueOf(txtPago.getText());
            completa.setRendaTributavel(renda);
            completa.setValorPago(pago);
            simplificada.setRendaTributavel(renda);
            simplificada.setValorPago(pago);
        }

        lbCompleta.setText(String.format("%.2f",completa.valorAPagar()));
        lbSimplificada.setText(String.format("%.2f",simplificada.valorAPagar()));
        DeclaracaoDAO dao = new DeclaracaoDAO();
        dao.update(completa);
        dao.update(simplificada);
    }

    @FXML
    private void initialize(){
        cTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        cDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        cValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        values = FXCollections.observableArrayList();
        tableView.setItems(values);
        loadTableView();
        loadFields();
    }

    private void loadFields(){
        DeclaracaoDAO dao = new DeclaracaoDAO();
        if(dao.load(1) == null)
            dao.save(new DeclaracaoSimplificada(0,0));
        if(dao.load(2) == null)
            dao.save(new DeclaracaoCompleta(0,0));

        this.simplificada = (DeclaracaoSimplificada) dao.load(1);
        this.completa = (DeclaracaoCompleta) dao.load(2);

        for (GastoDedutivel value : values)
            completa.addGasto(value);

        txtPago.setText(Double.toString(simplificada.getValorPago()));
        txtRenda.setText(Double.toString(simplificada.getRendaTributavel()));
    }

    private void loadTableView(){
        GastoDedutivelDAO gastoDAO = new GastoDedutivelDAO();
        values.setAll(gastoDAO.loadAll());
    }
}
