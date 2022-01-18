package br.com.acbueno.quarkus.consumer;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import br.com.acbueno.quarkus.model.Movie;
import org.jboss.logging.Logger;


@ApplicationScoped
public class MovieConsumer {

  private final Logger log = Logger.getLogger(MovieConsumer.class);

  @Incoming("movies-in")
  public void receive(Movie movie) {
    log.info(String.format("Got a movie: %s - %s", movie.getYear() , movie.getTitle()));
  }





}
