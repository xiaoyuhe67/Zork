import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class House {
	private static Scanner sc;
	private static final Boolean APPEND = false; 
	
	static foyer foyer=new foyer();
	static frontroom frontroom=new frontroom();
	static library library=new library();
	static kitchen kitchen=new kitchen();
	static diningroom diningroom =new diningroom();
	static vault vault=new vault();
	static parlor parlor=new parlor();
	static secretroom secretroom=new secretroom();
	static Dungeon Dungeon=new Dungeon();
	static String direction;
	static String content="";
	
	public static void main(String[] args) throws IOException
	{
		
		
    try{
		File file = new File("mydatafile.txt");

		file.createNewFile();

		FileWriter fwr = new FileWriter(file, APPEND);
		BufferedWriter bwr = new BufferedWriter(fwr); 
		
		Random rand=new Random();
		
		int[] visited = new int[10];
		visited[1]=foyer.getMoney();
		visited[2]=frontroom.getMoney();
		visited[3]=library.getMoney();
		visited[4]=kitchen.getMoney();
		visited[5]=diningroom.getMoney();
		visited[6]=vault.getMoney();
		visited[7]=parlor.getMoney();
		visited[8]=secretroom.getMoney();
		visited[9]=Dungeon.getMoney();			
		boolean found=false;		
		int money = 0;
		int room=1;
		
		BadGuy badguy=new BadGuy();
		
		Lamp lampInstance=new Lamp();
		
		Report ret=new Report();			
		sc = new Scanner(System.in);
		
		int count=1;
		
		LinkedList<String> ll=new LinkedList<String>();

		while (1>0)
		{		
			money+=visited[room];//Get money
			
			if(visited[room]!=0)// if player didn't visit the room
			{
				//write to the file			
				
				bwr.write("You visted room " +room + ", there is "+visited[room]+ " money \n");
				ll.add("You visted room " +room + ", there is "+visited[room]+ " money");
			}
								
			visited[room]=0;// set the money in the room is 0
			
			//if there is a bad guy in the room
			
			System.out.print(badguy.ranintoBadGuy(room, money));
		
			//if there is a lamp in the room
			
			System.out.print(lampInstance.ranintoLamp(room));
			
			//Describe the room
			System.out.println(printroom(room,found,money));;
			
			System.out.print(lampInstance.takeLamp(room));
            // prompt user to input
			direction=sc.nextLine();
			
			int dir=0;
			
			if(direction.equals("go East"))
			{
				dir=1;
			}
			else if(direction.equals("go North"))
			{
				dir=2;
			}
			else if(direction.equals("go West"))
			{
				dir=3;
			}
			else if(direction.equals("go South"))
			{
				dir=4;
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
			            content+=line+"\n";
			        }
			        br.close();
				}
			//if  direction is quit, the user will quit the game
			else if(direction.equals("quit"))
			{				
				break;						
			}			
			//if room is library,lamp is taken, type inspect scroll to reveal secret passage
			else if(direction.equals("inspect scroll"))
			{
				if(room==3&& lampInstance.getLamp()==-1)
				{
					System.out.println("The scroll reveals the secret passage to the secret room!");
					lampInstance.setSecretpassage(true);// secrete passage is found
					
					lampInstance.setTakenItem(3);// the item in the library is taken
					
				}
			}
			//if type take item
			else if(direction.equals("take item")){
				if(room==lampInstance.getLamp()){// there is a lamp in the room
					
					lampInstance.setLamp(-1);// take the lamp
					found=true; 
					bwr.write("You found the magic lamp in room " + room + "\n");
					ll.add("You found the magic lamp in room " + room );
				}
				else{//there is no lamp in the room take item
					bwr.write("You found the " + lampInstance.lampDescription(room)+ "in room " + room + "\n");
					ll.add("You found the " + lampInstance.lampDescription(room)+ "in room " + room );
					lampInstance.setTakenItem(room);// take items from this room
				}
			}
			//if room is library, secret passage is found and type 3 to take the passage
			else if(room==3 && lampInstance.isSecretpassage() && direction.equals("take secret passage"))
			{
				room=8;// go to secret room
				count++;// count the number of visited room
			}//
			
			else if(direction.equals("Enter")&&found==true&&room==6)
			{
				room=8;
				count++;
			}
			
			// normally move
			else if(direction.equals("go East")||direction.equals("go South")||direction.equals("go West")||direction.equals("go North"))
			{
				room=move(room,dir,found);//move the room		
            
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
			else
			{
				System.out.println("You can not go that way!");
				continue;
			}
			
		}
		
		int ghost;
		ghost=rand.nextInt(4);
		
		for(int i=0;i<ll.size();i++)
		{
			System.out.println(ll.get(i));
		}
		
		
		
		System.out.println(ret.goReportexit(count, visited, badguy.getBadguy(), ghost, badguy.getStolen(), money));
		
		
		
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
   
    catch(Exception e)
    {
    	System.out.println(e.getMessage());
    }
				
	}
	

	public static String printroom(int room, boolean found, int money)
	{
		String content="";
		switch(room)
		{
		case 1:content+=(foyer.getMessage()+"\n");
		       content+=("Press 'quit' to quit"+"\n");
		break;

		case 2: content+=(frontroom.getMessage()+"\n");
				content+=("Press 'quit' to quit"+"\n");
		break;

		case 3: content+=(library.getMessage()+"\n");
		content+=("Press 'quit' to quit"+"\n");

				break;
		case 4: content+=(kitchen.getMessage()+"\n");
		content+=("Press 'quit' to quit"+"\n");

		break;
		case 5: content+=(diningroom.getMessage()+"\n");
		content+=("Press 'quit' to quit"+"\n");

		break;
		case 6: content+=(vault.getMessage()+"\n");
		content+=("Press 'quit' to quit"+"\n");
		if(found)
		{
			content+=("You see the secret room!! Press 'Enter' to enter"+"\n");
			content+=("Press 'quit' to quit"+"\n");
		}
		break;

		case 7: content+=(parlor.getMessage()+"\n");
		content+=("Press 'quit' to quit"+"\n");

		break;
		case 8: content+=(secretroom.getMessage()+"\n");
		content+=("Press 'quit' to quit"+"\n");	

		break;
		case 9: content+=(Dungeon.getMessage()+"\n");
		content+=("Press 'quit' to quit"+"\n");

		break;
		
		default: content+=("You can't go that way"+"\n");
		break;	

		}
		content+=("You have " +money+ " in total");
		return content;
		
	}
	
	
	
	public static int move(int room, int direction, boolean found)
	{
		
		switch(room)
		{
		case 1: if(foyer.getDirection().containsKey(direction)) return foyer.getDirection().get(direction); else  return 0;
		case 2: if(frontroom.getDirection().containsKey(direction)) return frontroom.getDirection().get(direction); else return 0;
		case 3: if(library.getDirection().containsKey(direction)) return library.getDirection().get(direction); else return 0;
		case 4: if(kitchen.getDirection().containsKey(direction)) return kitchen.getDirection().get(direction); else return 0; 
		case 5: if(diningroom.getDirection().containsKey(direction)) return diningroom.getDirection().get(direction); else return 0;
		case 6: if(vault.getDirection().containsKey(direction)) 	      
			        	return vault.getDirection().get(direction);
			    else return 0;
		case 7: if(parlor.getDirection().containsKey(direction)) return parlor.getDirection().get(direction); else return 0;
		case 8:if(secretroom.getDirection().containsKey(direction)) return secretroom.getDirection().get(direction); else return 0;
		case 9:if(Dungeon.getDirection().containsKey(direction)) return Dungeon.getDirection().get(direction); else return 0;
		default:
		
			return 0;
		}

	}
	

	    

}
