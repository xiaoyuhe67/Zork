import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Zork {
	private static Scanner sc;
	private static final Boolean APPEND = true; 
	public static void main(String[] args) throws IOException
	{

		File file = new File("mydatafile.txt");

		file.createNewFile();

		FileWriter fwr = new FileWriter(file, APPEND);
		BufferedWriter bwr = new BufferedWriter(fwr); 
		
		Random rand=new Random();
		
		int[] visited = new int[9];
		for(int i = 0; i < 9; i++){
			visited[i] = rand.nextInt(1000)+1;
		}
		
		boolean found=false;
		int money = 0;
		int room=1;


		int badguy = rand.nextInt(8)+1;
		int stolen = 0;
		
		sc = new Scanner(System.in);
		
		int count=1;

		while (1>0)
		{
			money+=visited[room];
			
			if(visited[room]!=0)
			{
				bwr.write("You visted room " +room + ", there is "+visited[room]+ " money \n");
			}
								
			visited[room]=0;		
			if(room==badguy){
				stolen=money;
				money=0;
				System.out.println("You ran into Mean Dave, he mugs you and takes all your money!");
				badguy = -1;
			}
			printroom(room,found,money);

			String direction=sc.next();		
     
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
			else if(room==1&& direction.equals("2"))
			{	
				break;
						
			}else 
			{
				room=move(room,Integer.parseInt(direction),found);
			
            
			count++;
			if(room==6)
			{
				if(rand.nextInt(4)==0)
				{
					found=true;
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
