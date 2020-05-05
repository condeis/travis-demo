package eventbus;

import io.vertx.core.Vertx;

public class MainEventBusSecond {
	public static void main (String [] args)
	{
		Vertx vertx= Vertx.vertx();
		vertx.deployVerticle(Receiver.class.getName());
		vertx.deployVerticle(Sender.class.getName());
	//	vertx.deployVerticle(SecondReceiver.class.getName());
	}
	

}
