package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Elena on 14.07.2016.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {
    @MyRequestMethod(urlPath = "/one")
    public String getOneDepartment() {
        return "oneDepartment";
    }

    @MyRequestMethod(urlPath = "/all")
    public String getAllDepartments() {
        return "allDepartments";
    }
}
