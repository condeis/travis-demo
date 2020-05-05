import java.util.Date;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class MyFirstVerticle extends AbstractVerticle{
	
	public static void main (String [] args)
	{
		Vertx vertx= Vertx.vertx();
		//vertx.undeploy(MyFirstVerticle.class.getName());
		vertx.deployVerticle(MyFirstVerticle.class.getName());
	
		System.out.println(vertx.deploymentIDs());
		// What should appear here ?
		String processName =
			      java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
			    
		Long pid=Long.parseLong(processName.split("@")[0]);
		System.out.println("MyFirstVerticle:"+pid);
		System.out.println("Current Thread  Main- " + 
		Thread.currentThread().getId() );                       
    

	
	}
	
	 @SuppressWarnings("deprecation")
	@Override
	  public void start(Future<Void> fut) {
		 Date date = new Date(System.currentTimeMillis());
	    vertx
	        .createHttpServer()
	        .requestHandler(r -> {
	          r.response().end("<h1>Hello   WURI TechTeam from my first " +
	              "Vert.x 3 application</h1> at: </br> "+date.toGMTString());
	        })
	        .listen(8088, result -> {
	          if (result.succeeded()) {
	            fut.complete();
	            System.out.println("Deployment completed: "+vertx.deploymentIDs());
	            System.out.println("Current Thread  Verticle- " + 
	            		Thread.currentThread().getId() );    
	         
	          } else {
	            fut.fail(result.cause());
	          }
	        });
	  }
	}