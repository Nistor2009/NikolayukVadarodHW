package by.vadarod.nikolatyk_v.repository;


import by.vadarod.nikolatyk_v.entity.SportServ;

import java.util.Optional;

public interface SportServRepository {

    public SportServ addSportServ(SportServ services);

    public SportServ getSportServByName(String name);

    public Optional<SportServ> getLowerPriceCriteria();

}
