package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Elena on 14.07.2016.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
    @MyRequestMethod(urlPath = "/one")
    public String getOneEmployee() {
        return "oneEmployee";
    }

    @MyRequestMethod(urlPath = "/all")
    public String getAllEmployees() {
        return "allEmployees";
    }
}
