import java.util.HashMap;

public abstract class Room {
	
	private int roomId;
	private String items;
	private int money;
	private boolean visited;
	private String message;
	private String wrongmessage;
	private HashMap<Integer, Integer> direction;
	
	public Room()
	{
		
	}
	
	public Room(int roomId, String items, int money, String message, HashMap<Integer, Integer> direction)
	{
		this.setRoomId(roomId);
		this.setItems(items);
		this.setMoney(money);
		this.setMessage(message);
		this.setDirection(direction);
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
