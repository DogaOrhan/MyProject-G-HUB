import java.util.Random;

import java.util.Scanner;


public class Gamei {
	public String[] shapes= {"karo","maça","kupa","sinek"};
	public String[] suits= {"ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
	public String[] deck= new String [52];
	
	
	public void Deck() {
		for(int i=0;i<deck.length; i++) {
			deck[i] =shapes[i/13] + suits[i%13];
 			//System.out.println(deck[i]);
		}
		
		
	}
	
	public void Shuffle() {
		Random rd = new Random();
		for(int i=0; i<deck.length;i++) {
			int random = rd.nextInt(52);
			String Temp = deck[i];
			deck[i]=deck[random];
			deck[random]=Temp;
			
		}
		for(int i=0; i<deck.length;i++) {
		//	System.out.println(deck[i]);
		}
		//System.out.println("finish");


	}
		
	public void Cut() {
		Random r=new Random();
		int cut = r.nextInt(deck.length);
		String[] deck2=new String[deck.length];
		String[] top=new String[cut];
		String[] bottom=new String[deck.length-cut];
		
		for(int i=0 ;i<cut ;i++) {
			top[i]=deck[i];
			deck2[i]=top[i];
		}
		
		for(int i=cut; i<deck.length; i++) {
			bottom[i-cut]=deck[i];
			deck2[i]=bottom[i-cut];
		}
		for(int i=0;i<52;i++) {
			System.out.println(deck2[i]);
			
		}
	}
	public void Deal() {
		String[] Table= new String[4];
		
			
		for(int i=0;i<8;i=i+2) {
				
		}
		for(int i=1;i<8;i=i+2) {
				
		}
	}
}
		
		
	
	

        
		
		
		
	


