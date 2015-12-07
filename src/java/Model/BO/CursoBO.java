/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

import Model.DAO.CursoDAO;
import Model.VO.Curso;
import java.util.List;

/**
 *
 * @author fernando
 */
public class CursoBO {
            
     public List<Curso> getAll() {

         List<Curso> list = null;
        
        try {
            
             list = CursoDAO.getInstance().getAll();
                      
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
     
      public void salvar(Curso curso) {

        CursoDAO.getInstance().salvar(curso);
        

    }

    public void deletar(Curso curso) {
   
         CursoDAO.getInstance().deletar(curso);

    }
    
}
