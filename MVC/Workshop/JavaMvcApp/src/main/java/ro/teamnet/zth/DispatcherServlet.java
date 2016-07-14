package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Elena on 14.07.2016.
 */
public class DispatcherServlet extends HttpServlet {
    // rol de registru
    // cheia - urlPath
    // valoarea - info despre metoda care va procesa acest url
    HashMap<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {
        //cautare clase din pachet
        try {
            Iterable<Class> controllers = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers) {
                if (controller.isAnnotationPresent(MyController.class)) {
                    MyController myCtrlAnnotation = (MyController) controller.getAnnotation(MyController.class);
                    String controllerUrlPath = myCtrlAnnotation.urlPath();
                    Method[] controllerMethods = controller.getMethods();
                    for (Method controllerMethod : controllerMethods) {
                        if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)) {
                            // creez cheia
                            MyRequestMethod myRequestMethod = controllerMethod.getAnnotation(MyRequestMethod.class);
                            String myRequestMethodUrl = myRequestMethod.urlPath();
                            String urlPath = controllerUrlPath + myRequestMethodUrl;

                            // creez valoarea
                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(myRequestMethod.methodType());
                            methodAttributes.setMethodName(controllerMethod.getName());

                            // adaug in registru
                            allowedMethods.put(urlPath, methodAttributes);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instructiuni de delegare
        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //instructiuni de delegare
    }

    protected void dispatchReply(String requestType, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //dispatch
        Object response = null;
        try {
            response = dispatch(req, resp);
        }
        catch (Exception e) {
            sendExceptiopnError(e, req, resp);
        }
        //reply
        try {
            reply(response, req, resp);
        } catch (IOException e) {
            sendExceptiopnError(e, req, resp);
        }
        //sendExceptiopnError

    }



    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getPathInfo();
        /*if (req.getPathInfo().startsWith("/employees")) {
            EmployeeController employeeController = new EmployeeController();
            String result = employeeController.getAllEmployees();
            return result;
        }
        if (req.getPathInfo().startsWith("/departments")) {
            DepartmentController departmentController = new DepartmentController();
            String result = departmentController.getAllDepartments();
            return result;
        }*/
        String urlPath = req.getPathInfo();
        MethodAttributes methodNeeded = (MethodAttributes) allowedMethods.get(urlPath);
        if (methodNeeded == null) {
            // nu putem procesa url-ul
            return "error - URL cannot be processed!";
        }

        String controllerName = methodNeeded.getControllerClass();
        try {
            Class<?> controllerClass = Class.forName(controllerName);
            Object controllerInstance = controllerClass.newInstance();
            Method method = controllerClass.getMethod(methodNeeded.getMethodName());
            final Object result = method.invoke(controllerInstance);
            return result;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return "test";
    }

    private void reply(Object response, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.printf(response.toString());
    }

    private void sendExceptiopnError(Exception e, HttpServletRequest req, HttpServletResponse resp) {
    }
}
