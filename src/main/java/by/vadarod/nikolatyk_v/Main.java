package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.service.SportCenterService;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws Exception {
        SportCenterService service = new SportCenterService();
        service.testCash3Request(); //Делает 3 запроса в бд
        service.testCash2Request(); //Делает 2 запроса в бд при условии, что все id существуют. Списком передать не получилось, даже использую кэш второго уровня
    }
}