package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.SportServ;
import by.vadarod.nikolatyk_v.repository.SportServRepository;
import by.vadarod.nikolatyk_v.repository.SportServRepositoryImpl;
import org.hibernate.SessionFactory;

public class SportServService {
    private final SessionFactory sessionFactory;
    public SportServService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SportServ addSportServ(SportServ sportServ) {
        SportServRepository sportServRepository = new SportServRepositoryImpl(sessionFactory);
        sportServRepository.addSportServ(sportServ);
        return sportServ;
    }

    public SportServ getSportServByName(String name) {
        SportServRepository sportServRepository = new SportServRepositoryImpl(sessionFactory);
        return sportServRepository.getSportServByName(name);
    }
}
