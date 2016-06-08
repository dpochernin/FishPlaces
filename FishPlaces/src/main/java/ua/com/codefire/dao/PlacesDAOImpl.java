/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import ua.com.codefire.dao.entity.Place;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 1
 */
@Repository
@Transactional
public class PlacesDAOImpl implements IPlacesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Place> getAll() {
        return (List<Place>) sessionFactory.getCurrentSession()
                .createCriteria(Place.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public void add(Place place) {
        Session session = sessionFactory.getCurrentSession();
        session.save(place);
    }

    @Transactional
    @Override
    public Place getById(int id) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Places.findByPlaceId").setInteger("placeId", id);
        return (Place) query.uniqueResult();
    }

    @Transactional
    @Override
    public Place getByName(String name) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Places.findByPlaceName").setString("placeName", name);
        return (Place) query.uniqueResult();
    }

}
