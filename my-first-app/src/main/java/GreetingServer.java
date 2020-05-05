import java.util.Date;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class GreetingServer extends AbstractVerticle{
	
	public static void main (String [] args)
	{
		Vertx vertx= Vertx.vertx();
		//vertx.undeploy(MyFirstVerticle.class.getName());
		vertx.deployVerticle(GreetingServer.class.getName());
	
		System.out.println(vertx.deploymentIDs());
		// What should appear here ?
		
	}
	
	 @SuppressWarnings("deprecation")
	@Override
	  public void start(Future<Void> fut) {
		 Date date = new Date(System.currentTimeMillis());
	    vertx
	        .createHttpServer()
	        .requestHandler(r -> {
	          r.response().end(new JsonObject().put("message"," Hello   WURI TechTeam from my first \" +\r\n" + 
	          		"	              \"Vert.x 3 application</h1> at: </br> \"+date.toGMTString()").encode());
	        })
	        .listen(8081)/**, result -> {
	          if (result.succeeded()) {
	            fut.complete();
	            System.out.println(vertx.deploymentIDs());
	          } else {
	            fut.fail(result.cause());
	          }
	        })**/;
	  }
	}