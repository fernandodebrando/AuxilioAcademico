/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;   
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class GradeCurricular {
    
    public ArrayList<String> list() throws SQLException{
        
        ArrayList<String> arrayList = new ArrayList();
        ExecuteSQL exec = new ExecuteSQL();
        
        ResultSet rs = exec.select("select * from disciplina");
        
          while (rs.next()) { 
            arrayList.add(rs.getString("nome_disciplina")); 
        }      
       
                
        return arrayList;
        
    }
    
}
