/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

    public ResultSet select(String query) throws SQLException {

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
    public ResultSet inserir(String query) throws SQLException{
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

}
