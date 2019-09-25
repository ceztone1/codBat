package sample;

import BD.DAO;
import BD.MySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class controllerProblema implements Initializable {
    int idProblema;
    DAO dao = new DAO(MySQL.getConnection());
    @FXML
    Label lblCodPropio, lblCodSol;
    @FXML
    TableView<prueba> tblResult = new TableView<>();
    ObservableList<prueba> obResult;
    ejercicio ejer = new ejercicio();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblResult.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        llenarLabels();
    }

    void llenarLabels() {
        lblCodPropio.setText(dao.fetchAllCodigo(idProblema, 1));
        lblCodSol.setText(dao.fetchAllCodigo(idProblema, 2));
        llenarTablaArrayCount(idProblema);
    }

    void llenarTablaArrayCount(int id) {
        switch (id) {
            case 1:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba("arrayCount9([1, 2, 9]) → 1", "2", "OK"));
                obResult.add(new prueba("arrayCount9([1, 9, 9]) → 2", "2", "OK"));
                obResult.add(new prueba("arrayCount9([1, 9, 9, 3, 9]) → 3", "3", "OK"));
                obResult.add(new prueba("arrayCount9([1, 2, 3]) → 0", "0", "OK"));
                tblResult.setItems(obResult);
                break;
            case 2:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba("roundSum(16, 17, 18) → 60", "60", "OK"));
                obResult.add(new prueba(" roundSum(12, 13, 14) → 30", "30", "OK"));
                obResult.add(new prueba("roundSum(6, 4, 4) → 10", "10", "OK"));
                obResult.add(new prueba("roundSum(4, 6, 5) → 20", "20", "OK"));
                tblResult.setItems(obResult);
                break;
            case 3:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba("alarmClock(1, false) → 7:00","7:00","OK"));
                obResult.add(new prueba("alarmClock(5, false) → 7:00","7:00","OK"));
                obResult.add(new prueba("alarmClock(0, false) → 10:00","10:00"	,"OK"));
                obResult.add(new prueba("alarmClock(6, false) → 10:00","10:00","OK"));


                tblResult.setItems(obResult);
                break;
            case 4:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba("shareDigit(12, 23) → true	","true"	,"OK"));
                obResult.add(new prueba( "shareDigit(12, 43) → false",	"false","OK"));
                obResult.add(new prueba("shareDigit(12, 44) → false",	"false"	,"OK"));
                obResult.add(new prueba( "shareDigit(23, 12) → true",	"true",	"OK"));

                tblResult.setItems(obResult);
                break;
            case 5:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba( "answerCell(false, false, false) → true",	"true",	"OK"));
                obResult.add(new prueba(   "answerCell(false, false, true) → false"	,"false",	"OK"));
                obResult.add(new prueba(  "answerCell(true, false, false) → false"	,"false"	,"OK"));
                obResult.add(new prueba( "answerCell(true, true, false) → true","	true",	"OK"));
                tblResult.setItems(obResult);
                break;

        }


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
