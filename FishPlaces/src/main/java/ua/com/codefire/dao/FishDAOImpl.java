/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import ua.com.codefire.dao.entity.Fish;
import ua.com.codefire.dao.entity.Place;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 1
 */
public class FishDAOImpl implements IFishDAO {

    private static SessionFactory sessionFactory;

    public FishDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Fish> getAll() {
        return (List<Fish>) sessionFactory.getCurrentSession().createCriteria(Fish.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    @Transactional
    public void addFish(Fish fish) {
        Session session = sessionFactory.openSession();
        session.save(fish);
    }

    @Override
    public Fish getByName(String name) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Fishes.findByFishName").setParameter("fishName", name);
        return (Fish) query.uniqueResult();
    }

    @Override
    public Fish getById(int id) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Fishes.findByFishId").setParameter("fishId", id);
        return (Fish) query.uniqueResult();
    }

}
