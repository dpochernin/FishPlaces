/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishplaces.DAO;

import d.pochernin.fishplaces.entity.Place;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 1
 */
public class PlacesDAOImpl implements IPlacesDAO {

    private SessionFactory sessionFactory;

    public PlacesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
        public List<Place> allPlaces() {
        @SuppressWarnings("unchecked")
        List<Place> listPlaces = (List<Place>) sessionFactory.getCurrentSession()
                .createCriteria(Place.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listPlaces;
    }

    @Override
    @Transactional
    public float getLat(int placeId) {
        @SuppressWarnings("unchecked")
        Place place = (Place) sessionFactory.openSession().get(Place.class, placeId);
        return place.getPlaceGeoLat();
    }

    @Override
    @Transactional
    public float getLong(int placeId) {
        Place place = (Place) sessionFactory.openSession().get(Place.class, placeId);
        return place.getPlaceGeoLong();
    }
}
