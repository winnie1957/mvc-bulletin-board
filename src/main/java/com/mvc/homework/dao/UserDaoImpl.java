package com.mvc.homework.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.mvc.homework.model.UserEntity;
import com.mvc.homework.service.UsernameAlreadyExistsException;
import com.mvc.homework.util.HibernateUtil;

@Repository
public class UserDaoImpl implements UserDao{
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
    

	@Override
	public Optional<UserEntity> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        UserEntity entity = null;
        
        try {
			
        	tx = session.beginTransaction();
        	entity = session.get(UserEntity.class, id);
        	tx.commit();
        	
		} catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}else {
				throw new RuntimeException(e);
			}
		}
        
//        session.close();
        return Optional.ofNullable(entity);
	}
	
	@Override
	public Optional<UserEntity> findByUsername(String username){
		Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        String hql = "from UserEntity where username = :username";
        UserEntity entity = null;
        
        try {

        	tx = session.beginTransaction();
        	Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
        	query.setParameter("username", username);
        	entity = query.getSingleResult();
        	tx.commit();
        	
        } catch (NoResultException ex) {
        	return Optional.empty();

		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
        
//        session.close();
		return Optional.ofNullable(entity);
	}

	@Override
	public List<UserEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        String hql = "from UserEntity";
        List<UserEntity> entites = null;
        
        try {

        	tx = session.beginTransaction();
        	entites = session.createQuery(hql, UserEntity.class).list();
        	tx.commit();
        	
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}else {
				throw new RuntimeException(e);
			}
		}
        
//        session.close();
        return entites;
	}

	@Override
	public void save(UserEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        Object key = null; 
        try {
			
        	tx = session.beginTransaction();
        	key = session.save(entity);
        	tx.commit();
        	
//        } catch (DataIntegrityViolationException e) {
//
//			if(tx != null) {
//				tx.rollback();
//			}else {
//
//	            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
//	                throw new UsernameAlreadyExistsException("Username already exists: " + entity.getUsername());
//	            } else {
//	                throw e;
//	            }
//	            
//			}
        
		} catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}else {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
        
//        session.close();
        return;
	}

//	@Override
//	public void update(UserEntity entity) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tx = null; 
//        try {
//        	tx = session.beginTransaction();
//        	session.save(entity);
//        	tx.commit();
//        	
//		} catch (Exception e) {
//			
//			if(tx != null) {
//				tx.rollback();
//			}else {
//				throw new RuntimeException(e.getMessage(), e);
//			}
//		}
//        
//        session.close();
//        return;
//	}
	
//	public void changePassword(String username, String oldPassword, String newPassword) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tx = null; 
//        
//        try {
//        	tx = session.beginTransaction();
//
//        	saveEntity = session.get(UserEntity.class, entity);
//        	
//        	session.save(entity);
//        	tx.commit();
//        	
//		} catch (Exception e) {
//			
//			if(tx != null) {
//				tx.rollback();
//			}else {
//				throw new RuntimeException(e.getMessage(), e);
//			}
//		}
//        
//        session.close();
//        return;
//	}

	@Override
	public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        try {
			
        	tx = session.beginTransaction();
        	UserEntity entity = new UserEntity(id);
        	session.delete(entity);
        	tx.commit();
        	
		} catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}else {
				throw new RuntimeException(
					String.format("delete ID=%s UserEntity fail", id), 
					e);
			}
		}
        
//        session.close();
        return;
	}

}
