import java.util.*;

public class Zork {
	private static Scanner sc;
	public static void main(String[] args)
	{
		boolean found=false;

		int room=1;

		Random rand=new Random();

		sc = new Scanner(System.in);
		
		int count=1;

		while (1>0)
		{
			printroom(room,found);		

			int direction=sc.nextInt();		

			if(room==1&& direction==2)
			{
				break;
			}

			room=move(room,direction,found);
            
			count++;
			if(room==6)
			{
				if(rand.nextInt(4)==0)
				{
					found=true;
				}
			}
		}
		System.out.println("You leave the house safely! \rYou took "+count+" steps.");
		
		int ghost;
		ghost=rand.nextInt(4);
		
		if(ghost==0)
		{
			System.out.println("You see a ghost!!");
		}
		
	}

	public static void printroom(int room, boolean found)
	{
		switch(room)
		{
		case 1:System.out.println("You are standing in the foyer of an old house."
				+ "\r You see a dead scorpion.");

		System.out.println("You can (1) exit to the north or press 2 to quit");
		break;

		case 2: System.out.println("You are standing in the front room of an old house."
				+ "\r You see a piano.");

		System.out.println("You can (1) exit to the south, (2)exit to the west, (3)exit to east");
		break;

		case 3: System.out.println("You are standing in the library of an old house."
				+ "\r You see spiders.");

		System.out.println("You can (1) exit to the east or (2) exit to the north");
		break;
		case 4: System.out.println("You are standing in the kitchen of an old house."
				+ "\r You see bats.");

		System.out.println("You can (1) exit to the west or (2) exit to the north");
		break;
		case 5: System.out.println("You are standing in the dining room of an old house."
				+ "\r You see dust and empty box.");

		System.out.println("You can (1) exit to the south");
		break;

		case 6: System.out.println("You are standing in the vault of an old house."
				+ "\r You see 3 walking skeletons.");

		System.out.println("You can (1) exit to the east");
		if(found)
		{
			System.out.println("You see the secret room!! Press 2 to enter");
		}
		break;

		case 7: System.out.println("You are standing in the parlor of an old house."
				+ "\r You see treasure chest.");

		System.out.println("You can (1) exit to the west or (2) exit to the south");
		break;
		case 8: System.out.println("You are standing in the secret room of an old house."
				+ "\r You see piles of gold.");

		System.out.println("You can (1) exit to the west");
		break;
		default: System.out.println("Unknown");
		break;	

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
