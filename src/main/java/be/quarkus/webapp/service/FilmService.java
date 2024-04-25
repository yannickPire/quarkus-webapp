package be.quarkus.webapp.service;

import be.quarkus.webapp.model.Film;
import be.quarkus.webapp.repository.FilmRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FilmService {

    @Inject
    private FilmRepository repository;

    public Optional<Film> getFilm(Short filmId) {
        return repository.getFilm(filmId);
    }
}
