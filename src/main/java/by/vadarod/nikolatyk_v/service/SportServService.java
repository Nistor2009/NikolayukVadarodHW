package by.vadarod.nikolatyk_v.service;

import by.vadarod.nikolatyk_v.entity.SportServ;
import by.vadarod.nikolatyk_v.repository.SportServRepository;
import by.vadarod.nikolatyk_v.repository.SportServRepositoryImpl;
import org.hibernate.SessionFactory;

public class SportServService {
    private final SportServRepository sportServRepository;
    public SportServService(SessionFactory sessionFactory) {
        sportServRepository = new SportServRepositoryImpl(sessionFactory);
    }
    public SportServ addSportServ(SportServ sportServ) {
        sportServRepository.addSportServ(sportServ);
        return sportServ;
    }

    public SportServ getSportServByName(String name) {
        return sportServRepository.getSportServByName(name);
    }
}
