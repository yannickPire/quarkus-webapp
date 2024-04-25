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

    public String getFilm(Short filmId) {
        Optional<Film> film = repository.getFilm(filmId);
        return film.isPresent() ? film.get().getTitle() : "No film was found";
    }
}
