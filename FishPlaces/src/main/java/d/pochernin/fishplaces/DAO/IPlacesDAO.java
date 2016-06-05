/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishplaces.DAO;

import d.pochernin.fishplaces.entity.Place;
import java.util.List;

/**
 *
 * @author 1
 */
public interface IPlacesDAO {
    List<Place> getAll();
    Place getById (int id);
    void add(Place place);
}
