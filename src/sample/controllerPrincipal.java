package sample;

import BD.DAO;
import BD.MySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controllerPrincipal implements Initializable {
    @FXML
    TableView<problema> tblProblema = new TableView<>();
    @FXML
    Button btnLog1,btnLog2,btnMap,btnWar,btnShow;
    @FXML
    ComboBox cbSolucion, cbDificultad;
    int id;
    DAO dao = new DAO(MySQL.getConnection());

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        tblProblema.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        actions();
         mostrartablaProblemas();
         llenarCombo();

    }

    void actions(){
        btnLog1.setOnAction(x->{
            tblProblema.setItems(dao.fetchAllProblemas("LOGIC",1));
            System.out.println("siiiiiiii");

        });
        btnLog2.setOnAction(x->{
            tblProblema.setItems(dao.fetchAllProblemas("LOGIC",2));
            System.out.println("siiiiiiii");


        });

        btnMap.setOnAction(x->{
            tblProblema.setItems(dao.fetchAllProblemas("MAP",2));
            System.out.println("siiiiiiii");

        });
        btnWar.setOnAction(x->{
            tblProblema.setItems(dao.fetchAllProblemas("WARMUP",2));
            System.out.println("siiiiiiii");
        });
        btnShow.setOnAction(x->{
            id=tblProblema.getSelectionModel().getSelectedItem().id;
            mostrarVentana(id);

        });
        cbSolucion.setOnAction(x->{

            if(cbSolucion.getSelectionModel().getSelectedItem().equals("Without Solution")){
                tblProblema.setItems(dao.fetchSinSolucion(1));
            }else{
                tblProblema.setItems(dao.fetchSolucion(2));
            }
        });
        cbDificultad.setOnAction(x->{

            if(cbDificultad.getSelectionModel().getSelectedItem().equals("Dificulty 1")){

                tblProblema.setItems(dao.fetchDificultad(1));
                System.out.println("unooooooooooooo");

            }else{

                tblProblema.setItems(dao.fetchDificultad(2));
                System.out.println("doooos");

            }
        });

    }
    private void mostrartablaProblemas() //llama metodo fetch para mostrar los datos en el tableView
    {   try {
        tblProblema.setItems(dao.fetchAllProblemas());
    }catch (Exception e){
        System.out.println("tabla vacia");
    }

    }

    private void mostrarVentana(int id)
    {

        System.out.println("llamar");
        Stage stage =new Stage();
        FXMLLoader loader;
        Parent parent;


            controllerProblema paciente = new controllerProblema(id,stage);
            stage.setTitle("Problema");
            loader = new FXMLLoader(getClass().getResource("../fxml/problema.fxml"));

            loader.setController(paciente);
            stage.setResizable(false);


            try {
                parent = loader.load();
              //  parent.getStylesheets().add("sample/style.css");
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                reloadData();

            }
        });
    }

    private void reloadData()
    {
        tblProblema.getItems().clear();
        tblProblema.setItems(dao.fetchAllProblemas());


    }
    void llenarCombo(){
        ObservableList<String> options2 =
                FXCollections.observableArrayList(
                        "Dificulty 1",
                        "Dificulty 2"
                );
        ObservableList<String> options1 =
                FXCollections.observableArrayList(
                        "Without Solution",
                        "With Solution"
                );
        cbDificultad.setItems(options2);
        cbSolucion.setItems(options1);


    }


}
