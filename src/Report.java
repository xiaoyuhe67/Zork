import java.util.Random;

public class Report {
	
	
	public String goReportexit(int count, int[] visited, int badguy, int ghost, int stolen, int money){
		
		String content="";
				
        content+=("You leave the house safely! \rYou took "+count+" steps."+"\n");		
		content+=("You found:"+"\n");
		if(visited[1]==0)content+=("A dead scorpion"+"\n");
		if(visited[2]==0)content+=("A piano"+"\n");
		if(visited[3]==0)content+=("A spider"+"\n");
		if(visited[4]==0)content+=("Some bats"+"\n");
		if(visited[5]==0)content+=("Dusty boxes"+"\n");
		if(visited[6]==0)content+=("3 skeletons"+"\n");
		if(visited[7]==0)content+=("A treasure chest"+"\n");
		if(visited[8]==0)content+=("And piles of gold!"+"\n");
		if(visited[9]==0)content+=("And piles of gold!"+"\n");
		
		if(badguy==-1) content+=("You ran into Mean Dave! He stole " + stolen + " money!"+"\n");
		
		content+=("You left with " + money + " money!  Congratulations!"+"\n");
		
		
		if(ghost==0)
		{
			content+=("You see a ghost!!"+"\n");
		}
		return content;
		
	}
	

}
