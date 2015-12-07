/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fernando
 */
public class ExecuteSQL extends ConexaoMySQL { 

    private Statement stmt = null;

    public ResultSet executeQuery(String query) throws SQLException {

        try {
            Connection connection = getConexaoMySQL();

            this.stmt = connection.createStatement();
            return stmt.executeQuery(query);
            
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {
            fecharConexao();            
            //stmt.close();
        }
       return null;
    } 
    
     public Boolean insert(String query) throws SQLException {

        try {
            Connection connection = getConexaoMySQL();

            this.stmt = connection.createStatement();
            return stmt.execute(query);
            
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {
            fecharConexao();            
            //stmt.close();
        }
       return null;
    }  

}
