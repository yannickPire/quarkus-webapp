package be.quarkus.webapp.resource;

import be.quarkus.webapp.model.Film;
import be.quarkus.webapp.service.FilmService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/")
public class FilmResource {

    @Inject
    private FilmService service;

    @GET
    @Path("/helloWorld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello World";
    }

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilm(short filmId) {
//        TODO yannick move to service layer, return String
        Optional<Film> film = service.getFilm(filmId);
        return film.isPresent() ? film.get().getTitle() : "No film was found";
    }

}
