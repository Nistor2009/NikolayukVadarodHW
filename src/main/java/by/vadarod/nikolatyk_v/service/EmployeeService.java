package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Employee;
import by.vadarod.nikolatyk_v.repository.EmployeeRepository;
import by.vadarod.nikolatyk_v.repository.EmployeeRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final SessionFactory sessionFactory;
    public EmployeeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Employee add(Employee employee) {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(sessionFactory);
        employeeRepository.add(employee);
        return employee;
    }

    public List<Employee> findALl() {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(sessionFactory);
        return employeeRepository.findALl();
    }

    public Optional<Employee> getById(Long id) {
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(sessionFactory);
        return employeeRepository.getById(id);
    }
}
