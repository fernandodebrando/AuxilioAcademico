/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.BO.GradeCurricularBO;
import Model.VO.Curso_old;
import Model.VO.GradeCurricular;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author fernando
 */
@Stateless
public class RepositorioGradeCurricular {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
      public List<Curso_old> getGradeCurricular(){
        
        
         List<Curso_old> list = null;
        
        try {
            
            GradeCurricularBO gcBO = new GradeCurricularBO();
            list = gcBO.list();
                      
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
        
    }
}
