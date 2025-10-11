package by.vadarod.nikolatyk_v.repository;

import by.vadarod.nikolatyk_v.entity.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorRepository {
    public Visitor add(Visitor visitor);
    public List<Visitor> findALl();
    public Optional<Visitor> getById(Long id);
}
