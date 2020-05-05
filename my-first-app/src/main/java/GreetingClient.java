


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;

public class GreetingClient extends AbstractVerticle{
	
	public static void main (String [] args)
	{
	//	Vertx vertx= Vertx.vertx();
		//vertx.undeploy(MyFirstVerticle.class.getName());
	//	vertx.deployVerticle(GreetingClient.class.getName());
	
	//	System.out.println(vertx.deploymentIDs());
		// What should appear here ?
		
	}
	
	
	@Override
	  public void start( ) {
WebClient client= WebClient.create(vertx);
	    vertx
	        .createHttpServer()
	        .requestHandler(r -> {
	        HttpRequest <Buffer> request= client.get(8081,"localhost","/");
	        request.send(asyncres->{
	        	if (asyncres.succeeded())
	        	{
	        		String msg=asyncres.result().bodyAsJsonObject().getString("message");
	        		r.response().end(msg);
	        	}
	        	else 
	        	{
	        		r.response().setStatusCode(500);
	        	}
	        });
	        
	  }).listen(8082);
	}
}