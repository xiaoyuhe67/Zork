import java.util.HashMap;
import java.util.Random;

public class frontroom extends Room{
	
	private int roomId;
	private String items;
	private int money;
	private boolean visited;
	private String message;
	private String wrongmessage;
	private HashMap<Integer, Integer> direction;

	public frontroom() {
		
		HashMap<Integer, String> defaultdirection=new HashMap<Integer, String>();
		
		defaultdirection.put(1, "East");
		defaultdirection.put(2, "North");
		defaultdirection.put(3, "West");
		defaultdirection.put(4, "South");
		
		Random rand=new Random();
		this.roomId=2;
		this.items="piano";
		this.money=rand.nextInt(1000)+1;
		this.visited=false;
		direction=new HashMap<Integer, Integer>();
		this.direction.put(4, 1);
		this.direction.put(3, 3);
		this.direction.put(1, 4);
		this.message="You are standing in the front room of an old house."+"\n"
		+"There is "+this.money+" money. "+"\n"+"There is a "+this.items+" \n"
				+"Which direction do you want to go?";
	     this.wrongmessage="You can't go that way.";		
	}
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String getWrongmessage() {
		return wrongmessage;
	}

	public void setWrongmessage(String wrongmessage) {
		this.wrongmessage = wrongmessage;
	}

	public HashMap<Integer, Integer> getDirection() {
		return direction;
	}

	public void setDirection(HashMap<Integer, Integer> direction) {
		this.direction = direction;
	}
	

}
