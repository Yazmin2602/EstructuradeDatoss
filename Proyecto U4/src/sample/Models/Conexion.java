package sample.Models;

import java.sql.*;

public class Conexion {
        private String usuario = "root";
        private String password = "";
        private String bd = "abarrotes";
        private String servidor = "localhost";
        public Connection connection;

        public Conexion(){
            try{
                connection = DriverManager.getConnection("jdbc:mysql://"+servidor+"/"+bd,usuario,password);
                System.out.println("Conectado exitosamente");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        public ResultSet consultar(String sql){
            ResultSet resultSet = null;
            try{
                Statement consulta = connection.createStatement();
                resultSet = consulta.executeQuery(sql);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return resultSet;
        }
        //insertar, Modificaro eliminar
        public void insmodel(String consulta){
            try {
                Statement st=connection.createStatement();
                st.executeUpdate(consulta);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
