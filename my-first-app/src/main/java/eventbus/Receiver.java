package eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import utils.Runner;

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class Receiver extends AbstractVerticle {

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		// Convenience method so you can run it in your IDE

		Runner.runExample(Receiver.class);
	}

	@Override
	public void start() throws Exception {

		EventBus eb = vertx.eventBus();
		System.out.println(" Receiver Vertx hashCode--" + vertx.hashCode());
		System.out.println("Current Thread  Receiver - " + Thread.currentThread().getId());
		eb.consumer("ping-address", message -> {

			System.out.println("Received message: " + message.body());
			// Now send back reply
			message.reply("pong!");
		});

		System.out.println("Receiver ready!");
	}
}
