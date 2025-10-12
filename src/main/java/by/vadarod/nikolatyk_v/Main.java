package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.entity.Visitor;
import by.vadarod.nikolatyk_v.service.SportCenterService;

import java.util.Optional;


public class Main {
    public static void main(String[] args) throws Exception {
        SportCenterService service = new SportCenterService();
//        service.fillRecordAndVisitTables();
        System.out.println(service.findALlVisitors());
    }
}