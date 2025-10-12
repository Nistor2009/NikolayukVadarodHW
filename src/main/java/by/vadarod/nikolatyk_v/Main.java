package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.service.SportCenterService;

public class Main {
    public static void main(String[] args) throws Exception {
        SportCenterService service = new SportCenterService();
//        service.fillRecordAndVisitTables();
        System.out.println(service.findALlVisitors());
//        service.deleteBuildingById(13L);
    }
}