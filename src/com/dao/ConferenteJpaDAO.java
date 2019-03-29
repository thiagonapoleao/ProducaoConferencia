/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Conferente;
import com.bean.Conferente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author thiago.napoleao
 */
public class ConferenteJpaDAO {
    private static ConferenteJpaDAO instance;
    protected EntityManager entityManager;
    
    public static ConferenteJpaDAO getInstance(){
    	if (instance == null){
    		instance = new ConferenteJpaDAO();
        }
    	return instance;
    }

    public ConferenteJpaDAO() {
    	entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
        	entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Conferente getById(final Long id) {
    	return entityManager.find(Conferente.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Conferente> findAll() {
        entityManager.clear();
      return entityManager.createQuery("FROM " + Conferente.class.getName()).getResultList();
       
    }

    public void persist(Conferente produto) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.persist(produto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Conferente produto) {
    	try {
    		entityManager.getTransaction().begin();
            entityManager.merge(produto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Conferente produto) {
    	try {
    		entityManager.getTransaction().begin();
            produto = entityManager.find(Conferente.class, produto.getCodigo());
            entityManager.remove(produto);
            entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
    	try {
    		Conferente produto = getById(id);
    		remove(produto);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }   
    
     public void removeAll() {
        try {
            
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE conferente").executeUpdate();
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
   
     
    public List<Conferente> findByCodigo(String codigo) {
        try {
            entityManager.clear();
            Query query = entityManager.createQuery("from Conferente e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Conferente> produtos = query.getResultList();
            return produtos; 
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
}
    
    public List<Conferente> findByMtr(String codigo) {
        try {
          
            
            Query query = entityManager.createQuery("from Conferente e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Conferente> produtos = query.getResultList();
            return produtos;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
}

   
}
