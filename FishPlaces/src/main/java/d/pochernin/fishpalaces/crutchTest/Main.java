/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.pochernin.fishpalaces.crutchTest;

import d.pochernin.fishplaces.DAO.IPlacesDAO;
import d.pochernin.fishplaces.DAO.PlacesDAOImpl;
import d.pochernin.fishplaces.entity.Place;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 1
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        IPlacesDAO placeDAO = context.getBean(IPlacesDAO.class);
        List<Place> places = placeDAO.allPlaces();
        String geo = null;
        for (Place place : places) {
            Float lat = (Float)place.getPlaceGeoLat();
            Float lon_g = (Float)place.getPlaceGeoLong();
            geo=lon_g.toString()+";"+lat.toString();
            System.out.println(geo+"   placeID:"+place.getPlaceId());
        }
    }
}
