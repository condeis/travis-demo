
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpRequest;;
public class HelloWorld extends AbstractVerticle {
	public static void main (String [] args)
	{
		Vertx vertx= Vertx.vertx();
		
		vertx.deployVerticle(HelloWorld.class.getName());
	
		System.out.println(vertx.deploymentIDs());
		// What should appear here ?
		
	}
 
     @Override
     public void start() {
          WebClient client = WebClient.create(vertx);
          HttpRequest<JsonObject> httpRequest = client.get(8081, "localhost", "/").as(BodyCodec.jsonObject());
          vertx.createHttpServer().requestHandler(request -> {
              httpRequest.send(ar -> {
                 if (ar.succeeded()) {
                     String message = ar.result().body().getString("message");
                    request.response().end(message);
               } else {
                    request.response().setStatusCode(500).end();
               }
            });
        }).listen(8080, "localhost");
    }
}
