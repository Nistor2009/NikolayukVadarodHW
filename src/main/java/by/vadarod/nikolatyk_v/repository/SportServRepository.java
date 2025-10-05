package by.vadarod.nikolatyk_v.repository;


import by.vadarod.nikolatyk_v.entity.SportServ;

public interface SportServRepository {

    public SportServ addSportServ(SportServ services);
    public SportServ getSportServByName(String name);
}
