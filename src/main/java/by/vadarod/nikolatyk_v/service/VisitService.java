package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.Visit;
import by.vadarod.nikolatyk_v.repository.VisitRepository;
import by.vadarod.nikolatyk_v.repository.VisitRepositoryImpl;
import org.hibernate.SessionFactory;

public class VisitService {
    private final VisitRepository visitRepository;
    public VisitService(SessionFactory sessionFactory) {
        visitRepository = new VisitRepositoryImpl(sessionFactory);
    }
    public Long addVisit(Visit visit){
        return visitRepository.addVisit(visit);
    }
}
