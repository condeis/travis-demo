package eventbus;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import utils.Runner;

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class Sender extends AbstractVerticle {

  // Convenience method so you can run it in your IDE
  public static void main(String[] args) {
    Runner.runExample(Sender.class);
  }

  @Override
  public void start() throws Exception {
    EventBus eb = vertx.eventBus();
    
    System.out.println(" Sender Vertx HashCode --"+vertx.hashCode());
	System.out.println("Current Thread  Receiver - " + Thread.currentThread().getId());
    // Send a message every three second

    vertx.setPeriodic(3000, v -> {

      eb.send("ping-address", "ping!", reply -> {
        if (reply.succeeded()) {
          System.out.println("Received reply " + reply.result().body());
        } else {
          System.out.println("No reply");
        }
      });

    });
  }
}
