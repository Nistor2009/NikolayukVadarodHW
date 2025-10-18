package by.vadarod.nikolatyk_v;

import by.vadarod.nikolatyk_v.service.SportCenterService;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws Exception {
        SportCenterService service = new SportCenterService();
        System.out.println(service.getClientByName("Вася"));
        System.out.println(service.getHighlyPaidEmployee().orElseThrow(()->new NoSuchElementException("No any employee")));
        System.out.println(service.getLowerPaidEmployee().orElseThrow(()->new NoSuchElementException("No any employee")));
        System.out.println("Expenses = " + service.getEmployeeExpenses());
        System.out.println("Price = " + service.getPriceForPerson(2L));
    }
}