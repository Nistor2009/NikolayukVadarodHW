package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Client;
import by.vadarod.nikolatyk_v.entity.Employee;
import by.vadarod.nikolatyk_v.entity.Visitor;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    private final SessionFactory sessionFactory;

    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Employee add(Employee employee) {
        Session session = sessionFactory.openSession();
        session.detach(employee);
        session.getTransaction().begin();
        session.merge(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findALl() {
        Session session = sessionFactory.openSession();
        List<Employee> employees;
        try {
            employees = session.createQuery("select e FROM Employee e").getResultList();
            session.close();
        } catch (NoResultException e) {
            employees = List.of();
        }
        return employees;
    }

    @Override
    public Optional<Employee> getById(Long id) {
        Employee employee;
        Session session = sessionFactory.openSession();
        try {
            employee = session.get(Employee.class, id);
        } catch (NoResultException e) {
            employee = null;
        }
        session.close();
        return Optional.ofNullable(employee);
    }

    @Override
    public Optional<Employee> getHighlyPaidEmployee() {
        Employee employee;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("select e FROM Employee e order by salary desc", Client.class);
            query.setMaxResults(1);
            employee = (Employee)query.getSingleResult();
        } catch (NoResultException e) {
            employee = null;
        }
        session.close();
        return Optional.ofNullable(employee);
    }

    @Override
    public Optional<Employee> getLowerPaidEmployee() {
        Employee employee;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("select e FROM Employee e order by salary");
            query.setMaxResults(1);
            employee = (Employee)query.getSingleResult();
        } catch (NoResultException e) {
            employee = null;
        }
        session.close();
        return Optional.ofNullable(employee);
    }

    @Override
    public double getEmployeeExpenses() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select sum(e.salary) from Employee e");
        double result = (Double)query.getSingleResult();
        session.close();
        return result;
    }
}
