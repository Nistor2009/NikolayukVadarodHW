package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.service.SportCenterService;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws Exception {
        SportCenterService service = new SportCenterService();
        service.getAllCriteria().forEach(System.out::println);
        System.out.println(service.getLowerPrice());
        System.out.println(service.findByAgeCriteria(50,100));
        System.out.println(service.getAllPeopleCriteria());
        System.out.println(service.findOlderFiftyCriteria());
    }
}