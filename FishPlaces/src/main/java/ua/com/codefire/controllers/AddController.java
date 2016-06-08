package ua.com.codefire.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by oleg_svitskiy on 6/5/16.
 */

@Controller
public class AddController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPlace(@RequestParam (value = "place") String place,
                         @RequestParam (value = "lat") double lat,
                         @RequestParam (value = "lng") double lng) {


        //TODO: Add marker to database

        CoordinatesController.getTestCoordinates().put("lat", lat);
        CoordinatesController.getTestCoordinates().put("lng", lng);

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddpage() {

        return "add";

    }
}
