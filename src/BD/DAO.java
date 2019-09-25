package BD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.problema;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {


    Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }



    public ObservableList<problema> fetchAllProblemas() {
        ObservableList<problema> transactions = FXCollections.observableArrayList();
        try {
            System.out.println("entra a consulta");
            String query = "select nombre,idProblema,clasificacion,dificultad from problema";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            problema p = null;
            while (rs.next()) {
                p = new problema(
                        rs.getInt("idProblema"),
                        rs.getString("nombre"),
                        rs.getString("clasificacion"),
                        rs.getInt("dificultad")
                );
                transactions.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transactions;

    }

    public ObservableList<problema> fetchAllProblemas(String type,int dific) {
        ObservableList<problema> transactions = FXCollections.observableArrayList();
        try {
            System.out.println("entra a consulta");
            String query = "SELECT * FROM problema WHERE clasificacion='" + type + "' AND dificultad="+dific;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            problema p = null;
            while (rs.next()) {
                p = new problema(
                        rs.getInt("idProblema"),
                        rs.getString("nombre"),
                        rs.getString("clasificacion"),
                        rs.getInt("dificultad")
                );
                transactions.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transactions;

    }

    public String fetchAllCodigo(int idProblema,int idSolucion) {
        String codigo="";
        try {
            System.out.println("entra a consulta");
            String query = "SELECT codigo FROM solucion WHERE idProblema= "+ idProblema + " AND  idSolucion="+idSolucion;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            problema p = null;
            while (rs.next()) {
             codigo=rs.getString("codigo");
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return codigo;

    }
    public ObservableList<problema> fetchDificultad(int dific) {
        ObservableList<problema> transactions = FXCollections.observableArrayList();
        try {
            System.out.println("entra a consulta");
            String query = "SELECT * FROM problema WHERE dificultad="+dific;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            problema p = null;
            while (rs.next()) {
                p = new problema(
                        rs.getInt("idProblema"),
                        rs.getString("nombre"),
                        rs.getString("clasificacion"),
                        rs.getInt("dificultad")
                );
                transactions.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transactions;

    }
    public ObservableList<problema> fetchSolucion(int sol) {
        ObservableList<problema> transactions = FXCollections.observableArrayList();
        String query;
        try {
            System.out.println("entra a consulta");

                query = "SELECT p.idProblema,p.nombre,p.clasificacion,p.dificultad FROM solucion s inner join problema p on s.idProblema=p.idProblema WHERE idSolucion=2";


            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            problema p = null;
            while (rs.next()) {
                p = new problema(
                        rs.getInt("p.idProblema"),
                        rs.getString("p.nombre"),
                        rs.getString("p.clasificacion"),
                        rs.getInt("p.dificultad")
                );
                transactions.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transactions;

    }
    public ObservableList<problema> fetchSinSolucion(int sol) {
        ObservableList<problema> transactions = FXCollections.observableArrayList();
        String query;
        try {
            System.out.println("entra a consulta");

            query = "SELECT p.idProblema,p.nombre,p.clasificacion,p.dificultad FROM solucion s inner join problema p on s.idProblema=p.idProblema WHERE p.idProblema!= (select count(p.idProblema)=1);";


            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            problema p = null;
            while (rs.next()) {
                p = new problema(
                        rs.getInt("p.idProblema"),
                        rs.getString("p.nombre"),
                        rs.getString("p.clasificacion"),
                        rs.getInt("p.dificultad")
                );
                transactions.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return transactions;

    }

}