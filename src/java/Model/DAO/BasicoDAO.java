/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.util.List;

/**
 *
 * @author fernando
 */
public interface BasicoDAO {

    public void salvar(Object bean);

    public void deletar(Object bean);

    public Object getById(int id);

    public List<Object> getAll();
    
    public List<Object> getByWhere(String where);

}
