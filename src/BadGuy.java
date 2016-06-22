import java.util.Random;

public class BadGuy {
	
	Random rand=new Random();
	private int badguy = rand.nextInt(9)+1;
	private int stolen=0;
	
	public String ranintoBadGuy(int room, int money)
	{
		String content="";
		if(room==badguy){
			
			setStolen(money);
			money=0;// money is stolen
			//System.out.println("You ran into Mean Dave, he mugs you and takes all your money!");
			setBadguy(-1);
			
			content=("You ran into Mean Dave, he mugs you and takes all your money!"+"\n");
		}
		return content;
	}

	public int getStolen() {
		return stolen;
	}

	public void setStolen(int stolen) {
		this.stolen = stolen;
	}
	
	public int getBadguy() {
		return badguy;
	}

	public void setBadguy(int Badguy) {
		this.badguy = Badguy;
	}


}
