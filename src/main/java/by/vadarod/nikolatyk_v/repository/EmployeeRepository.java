package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    public Employee add(Employee employee);
    public List<Employee> findALl();
    public Optional<Employee> getById(Long id);
}
