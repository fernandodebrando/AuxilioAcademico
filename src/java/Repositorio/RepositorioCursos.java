/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.BO.CursoBO;
import Model.VO.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author fernando
 */
@Stateless
public class RepositorioCursos {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
        
    public List<Curso> getCursos(){
        
        
         List<Curso> list = null;
        
        try {
            
            CursoBO cBO = new CursoBO();
            list = cBO.getAll();
                      
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
        
    }
}
