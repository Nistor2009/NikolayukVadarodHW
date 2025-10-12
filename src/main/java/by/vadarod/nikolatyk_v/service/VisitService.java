package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Visit;
import by.vadarod.nikolatyk_v.repository.VisitRepository;
import by.vadarod.nikolatyk_v.repository.VisitRepositoryImpl;
import org.hibernate.SessionFactory;

public class VisitService {
    private final SessionFactory sessionFactory;
    public VisitService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Long addVisit(Visit visit){
        VisitRepository visitRepository = new VisitRepositoryImpl(sessionFactory);
        return visitRepository.addVisit(visit);
    }
}
