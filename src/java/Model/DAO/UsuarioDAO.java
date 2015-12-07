/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.VO.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public class UsuarioDAO {

    @PersistenceContext
    private static UsuarioDAO instance;
    protected EntityManager entityManager;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }

        return instance;
    }

    private UsuarioDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AuxilioAcademicoPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void salvar(Object bean) {

        Usuario user = (Usuario) bean;

        entityManager.getTransaction().begin();
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        entityManager.getTransaction().commit();

    }

    public void deletar(Object bean) {
        Usuario user = (Usuario) bean;

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(user));
        entityManager.getTransaction().commit();

    }

    public Object getById(int id) {

        Usuario user = entityManager.find(Usuario.class, id);

        return (user);
    }

    public List<Usuario> getAll() {

        try {

            List<Usuario> listaUsuario = entityManager.createQuery("SELECT u FROM Usuario u").getResultList();
            entityManager.close();
            return (listaUsuario);

        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;
    }

    public Usuario getByWhere(Usuario user) {

        try {

            Query q = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :emailParam and u.password = :passwordParam");
            q.setParameter("emailParam", user.getEmail()).setParameter("passwordParam", user.getPassword());
          
            user = (Usuario) q.getSingleResult();

            return user;

        } catch (Exception e) {
            e.getStackTrace();
        }

        return null;

    }

}
