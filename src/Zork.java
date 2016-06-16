import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Zork {
	private static Scanner sc;
	private static final Boolean APPEND = false; 
	public static void main(String[] args) throws IOException
	{
    try{
		File file = new File("mydatafile.txt");

		file.createNewFile();

		FileWriter fwr = new FileWriter(file, APPEND);
		BufferedWriter bwr = new BufferedWriter(fwr); 
		
		Random rand=new Random();
		
		int[] visited = new int[9];
		int[] taken = {0,0,0,0,0,0,0,0,0};
		for(int i = 0; i < 9; i++){
			visited[i] = rand.nextInt(1000)+1;
		}
		
		boolean found=false;
		
		boolean secretpassage=false;
		int money = 0;
		int room=1;


		int badguy = rand.nextInt(8)+1;
		int lamp = rand.nextInt(8)+1;
		
		int stolen = 0;
		
		sc = new Scanner(System.in);
		
		int count=1;

		while (1>0)
		{
			money+=visited[room];//Get money
			
			if(visited[room]!=0)// if player didn't visit the room
			{
				//write to the file
				bwr.write("You visted room " +room + ", there is "+visited[room]+ " money \n");
			}
								
			visited[room]=0;// set the money in the room is 0
			
			//if there is a bad guy in the room
			if(room==badguy){
				
				stolen=money;
				money=0;// money is stolen
				System.out.println("You ran into Mean Dave, he mugs you and takes all your money!");
				badguy = -1; //bad guy is gone
			}
			//if there is a lamp in the room
			if(room==lamp){
				System.out.println("You found the magic lamp!  Type 'take item' to take it");
				
			}
			//Describe the room
			printroom(room,found,money);
			
			//if lamp is taken and the item in the room is not taken and room is not library
			if(lamp==-1&&taken[room]==0&& room!=3)
				
				System.out.println("The lamp reveals " + lamp(room) + "type ', take item' to grab it!");
			
			//if lamp is taken and room is library and the secret passage is not found
			if(room==3&& lamp==-1 && secretpassage==false)
			{
				System.out.print("The lamp reveals inspect scroll in the library");
				System.out.println("Type 'inspect scroll' to check it out.");
				
			}
			//if room is library and secret passage is found
			if(room==3&&secretpassage==true)
			{
				System.out.println("Press 3 to take the secret passage.");
			}
            // prompt user to input
			String direction=sc.nextLine();
			
			if(direction.equals("kkk")){
	            throw new MyAppException("You shouldn't enter kkk, you need to enter an integer or specific string");
	        }
            
			//if user type history read history file
			if(direction.equals("history"))
			{
				bwr.flush();
				FileReader fr = new FileReader(file);
			      BufferedReader br = new BufferedReader(fr);
			      String line;
			      while ( (line = br.readLine())!= null)     {
			            System.out.println(line);
			        }
			        br.close();
				}
			//if room is foyer, direction is 2, the user will quit the game
			else if(room==1&& direction.equals("2"))
			{	
				break;
						
			}
			//if room is library,lamp is taken, type inspect scrool to reveal secret passage
			else if(direction.equals("inspect scroll"))
			{
				if(room==3&& lamp==-1)
				{
					System.out.println("The scroll reveals the secret passage to the secret room!");
					secretpassage=true;// secrete passage is found
					taken[3]=1;// the item in the library is taken
					
				}
			}
			//if type take item
			else if(direction.equals("take item")){
				if(room==lamp){// there is a lamp in the room
					lamp = -1;// take the lamp
					found=true; 
					bwr.write("You found the magic lamp in room " + room + "\n");
				}
				else{//there is no lamp in the room take item
					bwr.write("You found the " + lamp(room) + "in room " + room + "\n");
					taken[room]=1;// take items from this room
				}
			}
			//if room is library, secret passage is found and type 3 to take the passage
			else if(room==3 && secretpassage && direction.equals("3"))
			{
				room=8;// go to secret room
				count++;// count the number of visited room
			}
			// normally move
			else
			{
				room=move(room,Integer.parseInt(direction),found);//move the room		
            
				count++;// count the number of visited room
				// if room is vault
				if(room==6)
				{
					if(rand.nextInt(4)==0)//there is 25% to go to the secret room
					{
						found=true; // go to secret room
					}
			}
			}
			
		}
		
		
	    
	    
		System.out.println("You leave the house safely! \rYou took "+count+" steps.");
		
		System.out.println("You found:");
		if(visited[1]==0)System.out.println("A dead scorpion");
		if(visited[2]==0)System.out.println("A piano");
		if(visited[3]==0)System.out.println("A spider");
		if(visited[4]==0)System.out.println("Some bats");
		if(visited[5]==0)System.out.println("Dusty boxes");
		if(visited[6]==0)System.out.println("3 skeletons");
		if(visited[7]==0)System.out.println("A treasure chest");
		if(visited[8]==0)System.out.println("And piles of gold!");
		
		if(badguy==-1)System.out.println("You ran into Mean Dave! He stole " + stolen + " money!");
		
		System.out.println("You left with " + money + " money!  Congratulations!");
		
		
		int ghost;
		ghost=rand.nextInt(4);
		
		if(ghost==0)
		{
			System.out.println("You see a ghost!!");
		}
		
		

		
    }catch(IOException e)
    {
    	System.out.println(e.getMessage());
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
    	System.out.println(e.getMessage());
    }
    catch(IndexOutOfBoundsException e)
    {
    	System.out.println(e.getMessage());
    }
    catch(NumberFormatException e)
    {
    	System.out.println(e.getMessage());
    }
    catch(MyAppException mae){
        System.out.println("Inside catch block: "+mae.getMessage());
    }
    catch(Exception e)
    {
    	System.out.println(e.getMessage());
    }
			
		
	}

	public static void printroom(int room, boolean found, int money)
	{
		switch(room)
		{
		case 1:System.out.println("You are standing in the foyer of an old house."
				+ "\rYou see a dead scorpion.");

		System.out.println("You can (1) exit to the north or press 2 to quit");
		break;

		case 2: System.out.println("You are standing in the front room of an old house."
				+ "\rYou see a piano.");

		System.out.println("You can (1) exit to the south, (2)exit to the west, (3)exit to east");
		break;

		case 3: System.out.println("You are standing in the library of an old house."
				+ "\rYou see spiders.");

		System.out.println("You can (1) exit to the east or (2) exit to the north");
		break;
		case 4: System.out.println("You are standing in the kitchen of an old house."
				+ "\rYou see bats.");

		System.out.println("You can (1) exit to the west or (2) exit to the north");
		break;
		case 5: System.out.println("You are standing in the dining room of an old house."
				+ "\rYou see dust and empty box.");

		System.out.println("You can (1) exit to the south");
		break;

		case 6: System.out.println("You are standing in the vault of an old house."
				+ "\rYou see 3 walking skeletons.");

		System.out.println("You can (1) exit to the east");
		if(found)
		{
			System.out.println("You see the secret room!! Press 2 to enter");
		}
		break;

		case 7: System.out.println("You are standing in the parlor of an old house."
				+ "\rYou see treasure chest.");

		System.out.println("You can (1) exit to the west or (2) exit to the south");
		break;
		case 8: System.out.println("You are standing in the secret room of an old house."
				+ "\rYou see piles of gold.");

		System.out.println("You can (1) exit to the west");
		break;
		default: System.out.println("Unknown");
		break;	

		}
		System.out.println("You have " +money+ " money.");
	}
	
	public static String lamp(int room)
	{
		switch(room){
		case 1: return "spider web made from pure silk";
		case 2: return "the sheet music for your favorite song";
		case 3: return  "a scroll on the wall";
		case 4: return "a refrigerator full of your favorite food/drink";
		case 5: return "the box is not actually empty, it contains an Amazon gift card";
		case 7: return "a portrait of your favorite movie star and tickets to their latest movie";
		case 8: return "contains a map of the house along with the piles of gold";
		default: return "";
		}
		
	}
	
	
	
	public static int move(int room, int direction, boolean found)
	{

		switch(room)
		{
		case 1: if(direction==1) return 2; else  return 1;
		case 2: if(direction==1) return 1; else if (direction==2)return 3; else if(direction==3) return 4;
		break;
		case 3: if(direction==1) return 2; else if (direction==2)return 5; 
		break;

		case 4: if(direction==1) return 2; else if (direction==2)return 7; 
		break;

		case 5: if(direction==1) return 3; 
		break;

		case 6: if(direction==1) return 7; else if (direction==2 &&found) return 8;
		break;

		case 7: if(direction==1) return 6; else if (direction==2)return 4; 
		break;

		case 8: if(direction==1) return 6;
		break;

		default: return room;

		}
		return room;

	}
	

	    

}
