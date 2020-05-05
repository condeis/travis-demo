import io.vertx.core.Vertx;

public class MainVertexStopper {
	
	public static void main (String [] args)
	{
		Vertx vertx= Vertx.vertx();
		System.out.println(vertx.deploymentIDs());
			vertx.close();
		
	}

}
