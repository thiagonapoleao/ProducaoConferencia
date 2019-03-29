/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.Monitoramento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author thiago.napoleao
 */
public class MonitoramentoJpaDAO {
      private static MonitoramentoJpaDAO instance;
    protected EntityManager entityManager;
    
    public static MonitoramentoJpaDAO getInstance(){
    	if (instance == null){
    		instance = new MonitoramentoJpaDAO();
        }
    	return instance;
    }

    public MonitoramentoJpaDAO() {
    	entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
        	entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Monitoramento getById(final int id) {
    	return entityManager.find(Monitoramento.class, id);
    }
    
       public Monitoramento getByCod(String codigo) {
    	return entityManager.find(Monitoramento.class, codigo);
    }

    @SuppressWarnings("unchecked")
    public List<Monitoramento> findAll() {
        entityManager.clear();
      return entityManager.createQuery("FROM " + Monitoramento.class.getName()).getResultList();
       
    }

    public void persist(Monitoramento monitoramento) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.persist(monitoramento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Monitoramento monitoramento) {
    	try {
            entityManager.clear();
            entityManager.getTransaction().begin();
            entityManager.merge(monitoramento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
        	ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Monitoramento monitoramento) {
    	try {
            entityManager.getTransaction().begin();
            monitoramento = entityManager.find(Monitoramento.class, monitoramento.getId());
            entityManager.remove(monitoramento);
            entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

      public void removeById(final int id) {
        try {
            Monitoramento monitoramento = getById(id);
            remove(monitoramento);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        public void removeCodigo(String codigo) {
        try {
            Monitoramento monitoramento = getByCod(codigo);
            remove(monitoramento);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

         
    
     public void removeAll() {
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE monitoramento").executeUpdate();
            entityManager.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
   
     
    public List<Monitoramento> findByCodigo(String codigo) {
        try {
            entityManager.clear();
            Query query = entityManager.createQuery("from Monitoramento e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Monitoramento> monitoramentos = query.getResultList();
            return monitoramentos; 
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
}
    
    public List<Monitoramento> findByMtr(String codigo) {
        try {
          
            
            Query query = entityManager.createQuery("from Monitoramento e where e.codigo = :codigo");
            query.setParameter("codigo", codigo);
            List<Monitoramento> monitoramentos = query.getResultList();
            return monitoramentos;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
}

    public void removeCodigo(List<Monitoramento> mt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
