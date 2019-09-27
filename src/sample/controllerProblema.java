package sample;

import BD.DAO;
import BD.MySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class controllerProblema implements Initializable {
    int idProblema;
    DAO dao = new DAO(MySQL.getConnection());
    @FXML
    Label lblCodPropio, lblCodSol;
    @FXML
    TableView<prueba> tblResult = new TableView<>();
    @FXML
    Button btnRegresar;
    ObservableList<prueba> obResult;

    Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblResult.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        actions();
        llenarLabels();
    }

    void actions(){
        btnRegresar.setOnAction(x->{
            stage.close();
        });
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

                /*asdadsad*/
            case 6:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba( "has271([1, 2, 7, 1]) → true","	true",	"OK"));
                obResult.add(new prueba(   "has271([1, 2, 8, 1]) → false",	"false",	"OK"));
                obResult.add(new prueba(  "has271([2, 7, 1]) → true","true",	"OK"));
                obResult.add(new prueba( "has271([3, 8, 2]) → true","true","OK"));
                tblResult.setItems(obResult);
            case 7:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba( "evenlySpaced(2, 4, 6) → true",	"true",	"OK"));
                obResult.add(new prueba(   "evenlySpaced(4, 6, 2) → true",	"true",	"OK"));
                obResult.add(new prueba(  "evenlySpaced(4, 6, 3) → false",	"false",	"OK"));
                obResult.add(new prueba( "evenlySpaced(6, 2, 4) → true",	"true","OK"));
                tblResult.setItems(obResult);

                break;
            case 8:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba( "pairs([code, bug]) → {b: g, c: e}",	"{b: g, c: e}",	"OK"));
                obResult.add(new prueba(   "pairs([man, moon, main]) → {m: n}",	"{m:n}"	,"OK"));
                obResult.add(new prueba(  "pairs([]) → {}"	,"{}"	,"OK"));
                tblResult.setItems(obResult);

                break;
            case 9:
                obResult = FXCollections.observableArrayList();
                obResult.add(new prueba( "allSwap([ab, ac]) → [ac, ab]"	,"[ac, ab]",	"OK"));
                obResult.add(new prueba(    "allSwap([ab, ac]) → [ac, ab]",	"[ac, ab]",	"OK"));
                obResult.add(new prueba( "allSwap([ax, bx, cx, cy, by, ay, aaa, azz]) → [ay, by, cy, cx, bx, ax, azz, aaa]",	"[ay, by, cy, cx, bx, ax, azz, aaa]",	"OK"));
                tblResult.setItems(obResult);
                break;
        }


    }

    public controllerProblema(int idProblema,Stage s) {
        this.idProblema = idProblema;
        stage=s;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }



}
