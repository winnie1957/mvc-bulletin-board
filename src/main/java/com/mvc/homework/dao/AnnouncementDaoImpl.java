package com.mvc.homework.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.homework.model.AnnouncementEntity;
import com.mvc.homework.util.HibernateUtil;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao {

	private final SessionFactory sessionFactory;
	
	@Autowired
	public AnnouncementDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
    
	@Override
    public Optional<AnnouncementEntity> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        AnnouncementEntity entity = null;
        try {
			
        	tx = session.beginTransaction();
        	entity = session.get(AnnouncementEntity.class, id);
        	tx.commit();
        	
		} catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}else {
				throw new RuntimeException(e);
			}
		}
//        AnnouncementEntity entity = session.get(AnnouncementEntity.class, id);
//        session.close();
        return Optional.ofNullable(entity);
    }

    @Override
    public List<AnnouncementEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        String hql = "from AnnouncementEntity";
        List<AnnouncementEntity> entites = null;
        try {

        	tx = session.beginTransaction();
        	entites = session.createQuery(hql, AnnouncementEntity.class).list();
        	tx.commit();
        	
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}else {
				throw new RuntimeException(e);
			}
		}
//        String hql = "from AnnouncementEntity";
//        List<AnnouncementEntity> entites = session.createQuery(hql, AnnouncementEntity.class).list();
//        session.close();
        
        return entites;
    }
    
    @Override
    public void save(AnnouncementEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        try {
			
        	tx = session.beginTransaction();
        	session.save(entity);
        	tx.commit();
        	
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

	@Override
	public void update(AnnouncementEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        
        try {

        	tx = session.beginTransaction();
        	session.update(entity);        	
        	tx.commit();
        	
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

	@Override
	public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        try {
			
        	tx = session.beginTransaction();
        	AnnouncementEntity entity = new AnnouncementEntity(id);
        	session.delete(entity);
        	tx.commit();
        	
		} catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}else {
				throw new RuntimeException(
					String.format("delete ID=%s AnnouncementEntity fail", id), 
					e);
			}
		}
        
//        session.close();
        return;
	}
	
}
