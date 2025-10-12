package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.service.SportCenterService;

public class Main {
    public static void main(String[] args) throws Exception {
        SportCenterService service = new SportCenterService();
//        service.addFourEmployeesAndVisitors();
        System.out.println(service.findALlVisitors());
        System.out.println(service.findALlEmployees());
    }
}