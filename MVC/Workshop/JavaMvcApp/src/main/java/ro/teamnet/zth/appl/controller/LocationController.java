package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Elena on 14.07.2016.
 */
@MyController(urlPath = "/locations")
public class LocationController {
    @MyRequestMethod(urlPath = "/one")
    public String getOneLocation() {
        return "oneLocation";
    }

    @MyRequestMethod(urlPath = "/all")
    public String getAllLocations() {
        return "allLocations";
    }
}
