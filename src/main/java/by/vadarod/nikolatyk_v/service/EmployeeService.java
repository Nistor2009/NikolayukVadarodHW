package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Employee;
import by.vadarod.nikolatyk_v.repository.EmployeeRepository;
import by.vadarod.nikolatyk_v.repository.EmployeeRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(SessionFactory sessionFactory) {
        employeeRepository = new EmployeeRepositoryImpl(sessionFactory);
    }
    public Employee add(Employee employee) {
        employeeRepository.add(employee);
        return employee;
    }

    public List<Employee> findALl() {
        return employeeRepository.findALl();
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.getById(id);
    }
    public Optional<Employee> getHighlyPaid(){
        return employeeRepository.getHighlyPaidEmployee();
    }
    public Optional<Employee> getLowerPaidEmployee() {
        return employeeRepository.getLowerPaidEmployee();
    }

    public double getEmployeeExpenses() {
        return employeeRepository.getEmployeeExpenses();
    }
}
