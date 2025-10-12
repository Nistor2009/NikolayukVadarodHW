package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Visitor;
import by.vadarod.nikolatyk_v.repository.VisitorRepository;
import by.vadarod.nikolatyk_v.repository.VisitorRepositoryImpl;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class VisitorService {
    private final VisitorRepository visitorRepository;
    public VisitorService(SessionFactory sessionFactory) {
        visitorRepository = new VisitorRepositoryImpl(sessionFactory);
    }
    public Long add(Visitor visitor) {
        return  visitorRepository.add(visitor);
    }

    public List<Visitor> findALl() {
        return visitorRepository.findALl();
    }

    public Optional<Visitor> getById(Long id) {
        return visitorRepository.getById(id);
    }
}
