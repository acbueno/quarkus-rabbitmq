package br.com.acbueno.quarkus.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.acbueno.quarkus.model.Movie;
import br.com.acbueno.quarkus.producer.MovieProducer;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

  @Inject
  MovieProducer producer;

  @POST
  public Response send(Movie movie) {
    producer.send(movie);
    return Response.accepted().build();
  }

}