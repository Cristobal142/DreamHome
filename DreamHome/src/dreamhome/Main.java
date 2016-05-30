/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreamhome;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author CyC
 */


public class Main {

    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    static String bd = "XE";
    static String login = "DREAMHOME";
    static String password = "123";
    static String url = "jdbc:oracle:thin:@localhost:1521:XE";

    public static Connection Enlace(Connection conn) throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException e) {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }
    
    public Main Conectar()
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
        conn= DriverManager.getConnection(BaseDeDatos,"DREAMHOME","123");
        if(conn!=null)
        {
        System.out.println("Conexion exitosa a registro");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {System.out.println("error"+e);}
       
    return this;
    }
    
     public static void main(String[] args) {
  Main obconeccion=new Main ();
    obconeccion.Conectar();
    }

    public static Statement sta(Statement st) throws SQLException {
        conn = Enlace(conn);
        st = conn.createStatement();
        return st;
    }

    public static ResultSet EnlEst(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from DREAMHOME.CLIENTE");
        return rs;
    }
    public static ResultSet En2Est(ResultSet rs) throws SQLException {
        st = sta(st);
        rs = st.executeQuery("select * from DREAMHOME.PROPIEDAD");
        return rs;

    } 
     public static ResultSet En3Est() throws SQLException {
        st = sta(st);
        String sql="begin ProGetPrueba1(?,?); end;";
        CallableStatement callableStatement=conn.prepareCall(sql);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
				callableStatement.setLong(2, 1L);
				callableStatement.execute();
				//Se obtiene el cursor en forma de ResultSe
				ResultSet rs = (ResultSet)callableStatement.getObject(1);

        return rs;
	
    } 
     public static ResultSet En4Est() throws SQLException {
        st = sta(st);
        String sql="begin FN_total_pagar(?,?,?,?); end;";
        CallableStatement callableStatement=conn.prepareCall(sql);
        callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
				callableStatement.setLong(2, 1L);
                                callableStatement.setLong(3, 1L);
                                callableStatement.setLong(4, 1L);
				callableStatement.execute();
				//Se obtiene el cursor en forma de ResultSe
				ResultSet rs = (ResultSet)callableStatement.getObject(1);

        return rs;
	
    } 
     
     
}
    
