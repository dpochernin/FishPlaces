/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishplaces.dao;

import d.pochernin.fishplaces.entity.Fish;
import d.pochernin.fishplaces.entity.Place;
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
        @SuppressWarnings("unchecked")
        List<Fish> listFish = (List<Fish>) sessionFactory.getCurrentSession()
                .createCriteria(Fish.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listFish;
    }

    @Override
    @Transactional
    public void addFish(Fish fish) {
        @SuppressWarnings("unchecked")
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(fish);
        session.close();
    }

    @Override
    public Fish getByName(String name) {
        Fish fish = null;
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Fishes.findByFishName").setString("fishName", name);
        fish = (Fish) query.uniqueResult();
        return fish;
    }

}
