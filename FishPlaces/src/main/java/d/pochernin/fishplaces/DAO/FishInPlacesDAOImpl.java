/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishplaces.dao;

import d.pochernin.fishplaces.entity.Fish;
import d.pochernin.fishplaces.entity.Place;
import d.pochernin.fishplaces.entity.FishInPlace;
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
public class FishInPlacesDAOImpl implements IFishInPlaceDAO {

    private static SessionFactory sessionFactory;

    public FishInPlacesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addFishInPlace(Fish fish, Place place) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        FishInPlace fishinplace = new FishInPlace(fish, place);
        session.save(fishinplace);
        session.close();
    }

    @Override
    @Transactional
    public List<Fish> getFishInPlace(Place place) {
        Query query = sessionFactory.getCurrentSession().
                getNamedQuery("FishInPlaces.findByPlaceId").setInteger("place_id", place.getPlaceId());
        List<Fish> listFish = query.list();
        return listFish;
    }

    @Override
    public List<Place> getPlacesWithFish(Fish fish) {
        Query query = sessionFactory.getCurrentSession().
                getNamedQuery("FishInPlaces.findByPlaceId").setInteger("place_id", fish.getFishId());
        List<Place> listPlaces = query.list();
        return listPlaces;
    }

}
