/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.dao.IFishDAO;
import ua.com.codefire.dao.IPlacesDAO;
import ua.com.codefire.dao.entity.Fish;
import ua.com.codefire.dao.entity.FishInPlace;
import ua.com.codefire.dao.entity.Place;

/**
 *
 * @author CodeFire
 */
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private IPlacesDAO placesDAO;
    @Autowired
    private IFishDAO fishDAO;

    @Transactional(readOnly = true)
    @Override
    public Place findPlaceById(int id) {
        return placesDAO.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Map<String, Double> getGEObyPlaceId(final int id) {

        Map<String, Double> data = new HashMap<String, Double>() {
            {
                put("lat", placesDAO.getById(id).getPlaceGeoLat());
                put("lng", placesDAO.getById(id).getPlaceGeoLong());
            }
        };
        return data;
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Fish> getFishListInPlace(int id) {
    Set<FishInPlace> fishInPlace = placesDAO.getById(id).getFishInPlaceses();
    HashSet<Fish> fishes = null;
    for(FishInPlace element:fishInPlace){
        fishes.add(element.getFishes());
    }
    return fishes;
    }
}
