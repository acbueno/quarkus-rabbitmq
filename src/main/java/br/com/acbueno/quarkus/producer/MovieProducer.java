package br.com.acbueno.quarkus.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import br.com.acbueno.quarkus.model.Movie;

@ApplicationScoped
public class MovieProducer {

  @Inject
  @Channel("movies-out")
  Emitter<Movie> emiter;

  public void send(Movie movie) {
    emiter.send(movie);
  }

}
