
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

import io.vertx.core.http.*;
/**
 * 
 * @author CONDEIS
 *
 */
public class RouterExample extends AbstractVerticle {

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		// vertx.undeploy(MyFirstVerticle.class.getName());
		vertx.deployVerticle(RouterExample.class.getName());

		System.out.println(vertx.deploymentIDs());
	}

	@Override
	public void start() throws Exception {
		HttpServer server = vertx.createHttpServer();
		Router router = Router.router(vertx);

		Route route = router.route("/routing");
		route.handler(routingContext -> {

			HttpServerResponse response = routingContext.response();
			// enable chunked responses because we will be adding data as
			// we execute over other handlers. This is only required once and
			// only if several handlers do output.
			response.setChunked(true);

			response.write("route1\n");

			// Call the next matching route after a 5 second delay
			routingContext.vertx().setTimer(5000, tid -> routingContext.next());
		});

		route.handler(routingContext -> {

			HttpServerResponse response = routingContext.response();
			response.write("route2\n");

			// Call the next matching route after a 5 second delay
			routingContext.vertx().setTimer(5000, tid -> routingContext.next());
		});

		route.handler(routingContext -> {

			HttpServerResponse response = routingContext.response();
			response.write("route3");

			// Now end the response
			routingContext.response().end();
		});
		server.requestHandler(router).listen(8080);
	}
}
