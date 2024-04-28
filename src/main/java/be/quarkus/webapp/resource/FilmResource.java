package be.quarkus.webapp.resource;

import be.quarkus.webapp.service.FilmService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class FilmResource {

    @Inject
    private FilmService service;

    @GET
    @Path("/helloWorld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World";
    }

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilm(short filmId) {
        return service.getFilm(filmId);
    }

    @GET
    @Path("/pagedFilms/{page}/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String paged(long page, short minLength) {
        return service.retrievePagedFilm(page, minLength);
    }

    @GET
    @Path("/pagedFilms/{startsWith}/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String actor(String startsWith, short minLength) {
        return service.getFilms(startsWith, minLength);
    }

    @GET
    @Path("/pagedFilms/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilms(short minLength) {
        return service.getFilms(minLength);
    }

    @GET
    @Path("/update/{minLength}/{rentalRate}")
    @Produces(MediaType.TEXT_PLAIN)
    public String paged(short minLength, Float rentalRate) {
        service.updateRentalRate(minLength, rentalRate);
        return service.getFilms(minLength);
    }
}
