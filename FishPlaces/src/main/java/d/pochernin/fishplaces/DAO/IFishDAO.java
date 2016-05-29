/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishplaces.DAO;

import d.pochernin.fishplaces.entity.Fish;
import java.util.List;

/**
 *
 * @author 1
 */
public interface IFishDAO {
    
    List<Fish> getAll();
    void addFish(Fish fish);
      
    
}
