package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Elena on 14.07.2016.
 */
@MyController(urlPath = "/jobs")
public class JobController {
    @MyRequestMethod(urlPath = "/one")
    public String getOneJob() {
        return "onejob";
    }

    @MyRequestMethod(urlPath = "/all")
    public String getAllJobs() {
        return "alljobs";
    }
}