package ua.com.codefire.controllers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ua.com.codefire.services.PlaceService;

@Controller
public class CoordinatesController {

    @Autowired
    private PlaceService placeService;

    private static final Logger LOGGER = Logger.getLogger(CoordinatesController.class.getName());
    private static Map<String, Double> testCoordinates = new TreeMap<>();

    public static Map<String, Double> getTestCoordinates() {
        return testCoordinates;
    }

    @RequestMapping(value = "/coordinates")
    public String getMapPage() {
        return "coordinates";
    }

    @RequestMapping(value = "/coordinates/{id}", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public @ResponseBody
    String getCoordinates(@PathVariable(value = "id") int id) {
        Gson gson = new Gson();
        String result = gson.toJson(placeService.findPlaceById(id));
        LOGGER.info(result);
        return result;
    }

    @RequestMapping(value = "/coordinates/showAllPlaces")
    public @ResponseBody
    String getAllCoordinates() {

        Map<String, Double> coordinatesOfPlace = new TreeMap<>();

        Map<String, Map<String, Double>> place = new HashMap<>();
        //Iraq
        coordinatesOfPlace.put("lat", 30.610313);
        coordinatesOfPlace.put("lng", 46.404486);

        place.put("IRAQ", coordinatesOfPlace);

        coordinatesOfPlace.clear();

        coordinatesOfPlace.put("lat", 40.7128);
        coordinatesOfPlace.put("lng", 74.0059);

        place.put("SOMALI", coordinatesOfPlace);

        return new Gson().toJson(place);

    }
}
