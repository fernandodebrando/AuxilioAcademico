/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

import Model.DAO.UsuarioDAO;
import Model.VO.Usuario;
import java.util.List;

/**
 *
 * @author fernando
 */
public class UsuarioBO {
    
    public Usuario valida(Usuario obj) {

        if (obj == null) {
            return null;
        }

        try {
            
            obj = UsuarioDAO.getInstance().getByWhere(obj);
                      
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
    
}
