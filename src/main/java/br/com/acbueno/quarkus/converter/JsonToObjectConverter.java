package br.com.acbueno.quarkus.converter;

import java.lang.reflect.Type;
import javax.enterprise.context.ApplicationScoped;
import io.smallrye.reactive.messaging.MessageConverter;
import io.smallrye.reactive.messaging.amqp.IncomingAmqpMetadata;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class JsonToObjectConverter implements MessageConverter {

  @Override
  public boolean canConvert(org.eclipse.microprofile.reactive.messaging.Message<?> in, Type target) {
    return in.getMetadata(IncomingAmqpMetadata.class)
        .map(meta -> meta.getContentType().equals("application/json")  && target instanceof Class)
        .orElse(false);
  }

  @Override
  public Message<?> convert(Message<?> in, Type target) {
    return in.withPayload(((JsonObject) in .getPayload()).mapTo((Class<?>) target));
  }

}
