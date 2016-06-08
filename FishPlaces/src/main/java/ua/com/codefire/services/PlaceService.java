/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.services;

import java.util.List;
import java.util.Map;
import java.util.Set;
import ua.com.codefire.dao.entity.Fish;
import ua.com.codefire.dao.entity.Place;

/**
 *
 * @author CodeFire
 */
public interface PlaceService {
    Place findPlaceById(int id);
    Map<String, Double> getGEObyPlaceId(int id);
    Set<Fish> getFishListInPlace(int id); 
    
}
