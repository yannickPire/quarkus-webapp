package be.quarkus.webapp.service;

import be.quarkus.webapp.model.Film;
import be.quarkus.webapp.repository.FilmRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class FilmService {

    @Inject
    private FilmRepository repository;

    public String getFilm(Short filmId) {
        Optional<Film> film = repository.getFilm(filmId);
        return film.isPresent() ? film.get().getTitle() : "No film was found";
    }

    public String retrievePagedFilm(long page, short minLength) {
        return repository.paged(page, minLength)
                .map(f -> String.format("%s (%d min)", f.getTitle(), f.getLength()))
                .collect(Collectors.joining("\n"));
    }

    public String getFilms(String startWith, short minLength) {
        return repository.actors(startWith, minLength)
                .map(f -> String.format("%s (%d min): %s",
                        f.getTitle(),
                        f.getLength(),
                        f.getActors().stream()
                                .map(a -> String.format("%s %s ", a.getFirstName(), a.getLastName())).collect(Collectors.joining(", "))))
                .collect(Collectors.joining("\n"));
    }

    @Transactional
    public void updateRentalRate(short minLength, Float rentalRate) {
        repository.updateRentalRate(minLength, rentalRate);
    }

    public String getFilms(short minLength) {
        return repository.getFilms(minLength)
                .map(f -> String.format("%s (%d min) - %f", f.getTitle(), f.getLength(), f.getRentalRate()))
                .collect(Collectors.joining("\n"));
    }
}
