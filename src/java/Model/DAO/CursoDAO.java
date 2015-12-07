/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.VO.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ejb.Stateless;


/**
 *
 * @author fernando
 */
@Stateless
public class CursoDAO {
   
    private static CursoDAO instance;
    @PersistenceContext
    protected EntityManager entityManager;

    public CursoDAO() {
        entityManager = getEntityManager();
    }

    public static CursoDAO getInstance() {
        if (instance == null) {
            instance = new CursoDAO();
        }

        return instance;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AuxilioAcademicoPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void salvar(Object bean) {

        /*entityManager.getTransaction().begin();
         if (bean.getId == null) {
         entityManager.persist(bean);
         } else {
         entityManager.merge(bean);
         }
         entityManager.getTransaction().commit();*/
    }

    public void deletar(Object bean) {
        /* Usuario user = (Usuario) bean;

         entityManager.getTransaction().begin();
         entityManager.remove(entityManager.merge(user));
         entityManager.getTransaction().commit();*/

    }

    public Object getById(int id) {

        Curso curso = entityManager.find(Curso.class, id);

        return (curso);
    }

    public List<Curso> getAll() {

        List<Curso> listaCurso = null;
        try {

            listaCurso = entityManager.createQuery("SELECT u FROM Curso u").getResultList();

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listaCurso;
    }

    public void salvar(Curso curso) {

        try {
            //entityManager.getTransaction().begin();
            if (curso.getId() == null) {
                entityManager.persist(curso);
            } else {
                entityManager.merge(curso);
            }
            //entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            //entityManager.getTransaction().rollback();
        }

    }

    public void deletar(Curso curso) {

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(curso));
        entityManager.getTransaction().commit();

    }

}
