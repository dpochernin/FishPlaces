/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishplaces.dao;

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
public class PlacesDAOImpl implements IPlacesDAO {

    private static SessionFactory sessionFactory;

    public PlacesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Place> getAll() {
        @SuppressWarnings("unchecked")
        List<Place> listPlaces = (List<Place>) sessionFactory.getCurrentSession()
                .createCriteria(Place.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listPlaces;
    }

    @Override
    @Transactional
    public void add(Place place) {
        @SuppressWarnings("unchecked")
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(place);
        session.close();

    }

    @Override
    public Place getById(int id) {
        Place place = null;
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Places.findByPlaceId").setInteger("placeId", id);
        place = (Place) query.uniqueResult();
        return place;
    }

    @Override
    public Place getByName(String name) {
        Place place = null;
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Places.findByPlaceName").setString("placeName", name);
        place = (Place) query.uniqueResult();
        return place;
    }

}
