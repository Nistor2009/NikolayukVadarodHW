package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Visitor;
import by.vadarod.nikolatyk_v.repository.VisitorRepository;
import by.vadarod.nikolatyk_v.repository.VisitorRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class VisitorService {
    private final SessionFactory sessionFactory;
    public VisitorService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Long add(Visitor visitor) {
        VisitorRepository visitorRepository = new VisitorRepositoryImpl(sessionFactory);
        return  visitorRepository.add(visitor);
    }

    public List<Visitor> findALl() {
        VisitorRepository visitorRepository = new VisitorRepositoryImpl(sessionFactory);
        return visitorRepository.findALl();
    }

    public Optional<Visitor> getById(Long id) {
        VisitorRepository visitorRepository = new VisitorRepositoryImpl(sessionFactory);
        return visitorRepository.getById(id);
    }
}
