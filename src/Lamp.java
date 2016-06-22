import java.util.Random;

public class Lamp {
	
	Random rand=new Random();
	
	private int lamp=rand.nextInt(9)+1;
	
	private boolean secretpassage=false;

	private int[] taken = {0,0,0,0,0,0,0,0,0,0};
	

	
	public  String lampDescription(int room)
	{
		switch(room){
		case 1: return "spider web made from pure silk";
		case 2: return "the sheet music for your favorite song";
		case 3: return  "a scroll on the wall";
		case 4: return "a refrigerator full of your favorite food/drink.";
		case 5: return "the box is not actually empty, it contains an Amazon gift card";
		case 6: return "a map of the house along with the piles of gold";
		case 7: return "a portrait of your favorite movie star and tickets to their latest movie";
		case 8: return "contains a map of the house along with the piles of gold";
		case 9: return "contains a map of the house along with the piles of gold";
		default: return "";
		}
		
	}
	
	public String ranintoLamp(int room)
	{
		String content="";
		if(room==getLamp()){
			content=("You found the magic lamp!  Type 'take item' to take it"+"\n");
			
		}
		return content;
	}
	
	public String takeLamp(int room)
	{
		String content="";
		//if lamp is taken and the item in the room is not taken and room is not library
		if(lamp==-1&&taken[room]==0&& room!=3)
			
			content+=("The lamp reveals " + lampDescription(room) +"\n"+ "Type ' take item' to grab it!")+"\n";
		
		//if lamp is taken and room is library and the secret passage is not found
		if(room==3&& lamp==-1 && secretpassage==false)
		{
			content+=("The lamp reveals inspect scroll in the library")+"\n";
			content+=("Type 'inspect scroll' to check it out.")+"\n";
			
		}
		//if room is library and secret passage is found
		if(room==3&&secretpassage==true)
		{
			content+=("Press 'take secret passage' to take the secret passage.")+"\n";
		}
		return content;
	}
	public int getLamp() {
		return lamp;
	}

	public void setLamp(int lamp) {
		this.lamp = lamp;
	}

	public boolean isSecretpassage() {
		return secretpassage;
	}

	public void setSecretpassage(boolean secretpassage) {
		this.secretpassage = secretpassage;
	}

	public int[] getTaken() {
		return taken;
	}

	public void setTaken(int[] taken) {
		this.taken = taken;
	}
	
	public void setTakenItem(int room)
	{
		this.taken[room]=1;
	}
	
}
