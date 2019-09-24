package sample;

import BD.DAO;
import BD.MySQL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class controllerProblema implements Initializable {
    int idProblema;
    DAO dao = new DAO(MySQL.getConnection());
    @FXML
    Label lblCodPropio,lblCodSol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarLabels();
    }

    void llenarLabels(){
        lblCodPropio.setText(dao.fetchAllCodigo(idProblema,1));
        lblCodSol.setText(dao.fetchAllCodigo(idProblema,2));
    }

    public controllerProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }




}
