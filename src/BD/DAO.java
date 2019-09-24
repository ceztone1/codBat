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


    /*
    public Boolean insertarUsuario(usuarios insertUsuario) {
        try {
            String query = "insert into usuarios "
                    + " (nombre, email, nombre_usuario,fecha_nac, contraseña, tipo_user)"
                    + " values (?, ?, ?, ?, ?,?)";
            PreparedStatement st =  conn.prepareStatement(query);
            st.setString(1, insertUsuario.getNombre());
            st.setString(2, insertUsuario.getEmail());
            st.setString(  3, insertUsuario.getNombre_usuario());
            st.setString(4, String.valueOf(insertUsuario.getFecha_nac()));
            st.setString(5,insertUsuario.getContraseña());
            st.setString(6, String.valueOf(insertUsuario.getTipo_user()));
            st.execute();
            //data.add(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }


    public usuarios validarUsuario(String pusuario, String ppassword)
    {
        usuarios objeto=null;
        try {
            String query = "SELECT nombre_usuario,tipo_user FROM usuarios WHERE nombre_usuario='" + pusuario + "' AND contraseña=('" + ppassword + "')";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next())
            {
                char tipo = rs.getString("tipo_user").charAt(0);
                String nombre=rs.getString("nombre_user");
                objeto=new usuarios(rs.getString("nombre_usuario"),rs.getString("tipo_user"));

                return tipo;
            }
            else
                return null;
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
*/

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



/*
        public ObservableList<enfermerasPorArea> metodo() {
        {
            ObservableList<enfermerasPorArea> transactions2 = FXCollections.observableArrayList();
            try {
                String query = "select nombreArea, nombre,descTurno\n" +
                        "from areas inner join enfermeras on areas.cveArea=enfermeras.cveArea\n" +
                        "\tinner join turnosEnf on turnosEnf.idEnf=enfermeras.idEnf\n" +
                        "\tinner join turnos on turnos.cveTurno=turnosEnf.cveTurno\n" +
                        "\tinner join usuarios on usuarios.usuario=enfermeras.usuarioEnf\n" +
                        "\tinner join agenda on agenda.idAgenda=usuarios.idAgenda;\n" +
                        "\n";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                enfermerasPorArea p = null;
                while (rs.next()) {
                    p = new enfermerasPorArea(
                            rs.getString("nombreArea"),
                            rs.getString("nombre"),
                            rs.getString("descTurno")

                    );
                    transactions2.add(p);
                }
                rs.close();
                st.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al recuperar información...");
            }
            return transactions;

*/









/*
    public ObservableList<datosEnfermera> mostrarDatosEnf()
    {
        ObservableList<datosEnfermera> datosEnf = FXCollections.observableArrayList();
        try {
            String query = " select cedulaEnf, descTurno, horario, nombreArea\n" +
                    "from enfermeras e inner join turnosEnf te on e.idEnf=te.idEnf\n" +
                    "\t\tinner join turnos t on t.cveTurno=te.cveTurno\n" +
                    "\t\tinner join areas a on a.cveArea=e.cveArea";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            datosEnfermera p = null;
            while(rs.next()) {
                p = new datosEnfermera(rs.getString("cedulaEnf"),
                        rs.getString("descTurno"),
                        rs.getString("horario"),
                        rs.getString("nombreArea")
                );
                datosEnf.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return datosEnf;
    }

*/













   /*
    public int obteneridDoctor (int idAgenda) {
        int idDoc=0;
        try {
            String query = "select idDoc\n" +
                    "from doctores\n" +
                    "where exists (select *\n" +
                    "\t\tfrom usuarios\n" +
                    "\t\twhere doctores.usuarioDoc=usuarios.usuario and exists (select *\n" +
                    "\t\t\t\t\t\t\t\t\tfrom agenda\n" +
                    "\t\t\t\t\t\t\t\t\twhere agenda.idAgenda=usuarios.idAgenda and idAgenda="+idAgenda+"));";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()) {
                idDoc = rs.getInt(1);
            }
            rs.close();
            st.close();
            return idDoc;
        }

        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información de esta consulta...");
            return idDoc;
        }
         }

*/


   /*
    public int obtenerIDEnfermera(int idAgenda) {

        try {

            String query21="select idEnf\n" +
                    "from enfermeras\n" +
                    "where exists (select *\n" +
                    "from usuarios\n" +
                    "where enfermeras.usuarioEnf=usuarios.usuario and exists (select *\n" +
                    "from agenda\n" +
                    "where agenda.idAgenda=usuarios.idAgenda and idAgenda="+idAgenda+"));";


            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query21);

            if(rs.next()) {
                c = rs.getInt(1);
                System.out.println("este valor es"+c);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sigue calyendo");
        }

        return c;
    }








   ///consulta para ver si existe

    public boolean validar1(String usuario, String contraseña)
    {
        usuarios objeto=null;
        try {
            String query = "SELECT * FROM usuarios WHERE usuario='" + usuario + "' AND contrasena=('" + contraseña + "')";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next())
            {
                objeto=new usuarios(rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("tipoUsuario"),
                        rs.getInt("idAgenda"));


                return true;
            }
            else
                return false;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }



*/









   /*

    public usuarios validar2()
    {
        List<usuarios> movimiento = new ArrayList<usuarios>();
        usuarios objeto = null;
        try {
            char tipo_user;
            String nombre,nombre_usuario,email,contraseña;
            //char tipo_user;
            java.util.Date fecha_nac;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next())
            {
                objeto=new usuarios();
                nombre=rs.getString("nombre");
                nombre_usuario=rs.getString("nombre_usuario");
                email=rs.getString("email");
                contraseña=rs.getString("contraseña");
                tipo_user= rs.getString("tipo_user").charAt(0);
                fecha_nac=rs.getDate("fecha_nac");

                objeto.setNombre(nombre);
                objeto.setNombre_usuario(nombre_usuario);
                objeto.setEmail(email);
                objeto.setContraseña(contraseña);
                objeto.setTipo_user(tipo_user);
                objeto.setFecha_nac((Date) fecha_nac);
                movimiento.add(objeto);

            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objeto;
    }







    public Boolean actualizarAdmin(usuarios pusuarios,String identificador) {
        try {
            System.out.println("tu te llamas"+identificador);
            String query = "update usuarios "
                    + " set nombre = ?, email = ?, fecha_nac = ?, nombre_usuario = ?, contraseña = ?"
                    + " where nombre_usuario='" + identificador + "'";
            System.out.println(query + "updating....");
            PreparedStatement st =  conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            st.setString(1, pusuarios.getNombre());
            System.out.println("agrga nombre"+pusuarios.getNombre());
            st.setString(2, pusuarios.getEmail());
            System.out.println("agrega emial"+pusuarios.getEmail());
            st.setDate(  3, pusuarios.getFecha_nac());
            System.out.println("agrega fecha"+pusuarios.getFecha_nac());
            st.setString(4, pusuarios.getNombre_usuario());
            System.out.println("agrega nombre usuario"+pusuarios.getNombre_usuario());
            st.setString(5, pusuarios.getContraseña());
            System.out.println("agrega contra"+pusuarios.getContraseña());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }


    public Boolean actualizarUsuario(usuarios pusuarios,String identificador) {
        try {
            System.out.println("tu te llamas"+identificador);
            String query = "update usuarios "
                    + " set nombre = ?, email = ?, fecha_nac = ?, nombre_usuario = ?, contraseña = ?"
                    + " where nombre_usuario='" + identificador + "'";
            System.out.println(query + "updating....");
            PreparedStatement st =  conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            st.setString(1, pusuarios.getNombre());
            System.out.println("agrga nombre"+pusuarios.getNombre());
            st.setString(2, pusuarios.getEmail());
            System.out.println("agrega emial"+pusuarios.getEmail());
            st.setDate(  3, pusuarios.getFecha_nac());
            System.out.println("agrega fecha"+pusuarios.getFecha_nac());
            st.setString(4, pusuarios.getNombre_usuario());
            System.out.println("agrega nombre usuario"+pusuarios.getNombre_usuario());
            st.setString(5, pusuarios.getContraseña());
            System.out.println("agrega contra"+pusuarios.getContraseña());

            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }


    public Boolean actualizarHistorialUsuario(String identificador) {
        try {
            String query = "update historial "
                    + " set usuario = ? where usuario='" + identificador + "'";
            System.out.println(query + "updating....");
            PreparedStatement st =  conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            st.setString(1, identificador);


            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }

    public Boolean actualizarFavoritosUsuario(String identificador) {
        try {
            String query = "update favoritos "
                    + " set usuario = ? where usuario='" + identificador + "'";
            System.out.println(query + "updating....");
            PreparedStatement st =  conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            st.setString(1, identificador);


            st.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }


    public ObservableList<usuarios> fetchAll() {
        ObservableList<usuarios> transactions = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM usuarios";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            usuarios p = null;
            while (rs.next()) {
                p = new usuarios(
                        rs.getString("nombre_usuario"),
                        rs.getString("nombre"), rs.getString("email"), rs.getString("contraseña"),
                        rs.getString("tipo_user").charAt(0), rs.getDate("fecha_nac"));
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

    */

}