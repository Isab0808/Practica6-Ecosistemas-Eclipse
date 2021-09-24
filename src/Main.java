import com.google.gson.Gson;
import communicaton.OnMessageListener;
import communicaton.TCP_Singleton;
import model.Circle;
import model.Colors;
import model.Direction;
import model.Generic;
import processing.core.PApplet;

public class Main extends PApplet implements OnMessageListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");	
	}
	private TCP_Singleton tcp;
	private Circle circle;

	
	public void settings() {
		
		size(600,600);
	}
	
	public void setup() {
		
		tcp= TCP_Singleton.getInstance();
		tcp.SetObserver(this);
		circle = new Circle (this,width/2,height/2);
	}
	public void draw() {
		background(0);
		circle.Draw();	
	}
	@Override
	public void OnMessage(String msg) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();

		Generic generic = gson.fromJson(msg, Generic.class);
		
		switch(generic.getType()) {
		case "Direction" :

			Direction tempD = gson.fromJson(msg, Direction.class);
			circle.Move(tempD.getDirection());
			break;
			
		case "Color":
			Colors tempC = gson.fromJson(msg, Colors.class);
			circle.setR(tempC.getR());
			circle.setG(tempC.getG());
			circle.setB(tempC.getB());
			break;
		}
	
			
		
			
		
	}
}
