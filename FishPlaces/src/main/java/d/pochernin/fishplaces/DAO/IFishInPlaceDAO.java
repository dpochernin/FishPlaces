/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishplaces.dao;

import d.pochernin.fishplaces.entity.Fish;
import d.pochernin.fishplaces.entity.Place;
import java.util.List;

/**
 *
 * @author 1
 */
public interface IFishInPlaceDAO {
    
    void addFishInPlace (Fish fish, Place place);
    List<Fish> getFishInPlace (Place place);
    List<Place> getPlacesWithFish (Fish fish);
 
    
}
