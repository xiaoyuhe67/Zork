import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void printroomTest() {
		
		//Test printroom
		String out = House.printroom(2, true, 100);	
		//System.out.println(out);
		
		//Test move
		int move=House.move(6, 1, true);	
		//System.out.println(move);
		assertTrue(move==7);
		
		//Test BadGuy
		BadGuy bad=new BadGuy();			
		bad.setBadguy(4);
		bad.setStolen(100);
		String badguy=bad.ranintoBadGuy(4, 100);
		System.out.println(badguy);
		System.out.println(bad.getBadguy());
		assertTrue(bad.getBadguy()==-1);
		int stolen=bad.getStolen();
		System.out.println(stolen);
		assertTrue(stolen==100);
		
		//LAmp
		Lamp lamp=new Lamp();
		String lampDescription=lamp.lampDescription(8);
		System.out.println(lampDescription);
		
		//ranintoLamp
		lamp.setLamp(8);
		String raintolamp=lamp.ranintoLamp(8);
		System.out.println(raintolamp);
		
		//takelamp
		lamp.setLamp(-1);
		lamp.setSecretpassage(true);
		String takelamp=lamp.takeLamp(3);
		System.out.println(takelamp);
		
		String takelamp1=lamp.takeLamp(8);
		System.out.println(takelamp1);
		
		lamp.setSecretpassage(false);
		String takelamp3=lamp.takeLamp(3);
		System.out.println(takelamp3);
		
	}

}
