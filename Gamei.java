import java.util.Random;
import java.util.Scanner;


public class Gamei {
	public String[] shapes= {"♠","♣","♥ ","♦"};

	public String[] suits= {"ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
	public String[] deck= new String [52];
	String[] Table= new String[4];
	String[] Player1= new String[4];
	String[] Player2= new String[4];
	
	
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
		
	}
	public void Deal() {
		System.out.println("YOUR CARDS");			
		for(int i=0;i<8;i=i+2) {
			Player1[i/2]=deck[i];
			System.out.println((i/2)+1 +" = "+ Player1[i/2]);
		}
		System.out.println("..........");
		System.out.println("PLAYER2'S CARDS");
		for(int i=1;i<8;i=i+2) {
			Player2[(i-1)/2]=deck[i];
			System.out.println(Player2[(i-1)/2]);
		}
		System.out.println("..........");
				
		for(int i=8;i<12;i++) {
			Table[i-8]=deck[i];
			//System.out.println(Table[i-8]);
						
		}
		System.out.println("..........");

		System.out.println("topcard= " + Table[3]);
	}

	public void Move() {			
		Scanner sc =new Scanner(System.in);
		
		for (int i=0;i<6;i++) {
			System.out.println("SELECT CARD");
			//p1
			int P1card=sc.nextInt()-1;
			while(P1card>=4) {
				System.out.println("ENTER VALİD NUMBER");
				P1card=sc.nextInt()-1;
			}
			
			if(Player1[P1card]==Table[3]) {
				System.out.println("ALL CARDS ARE YOUR");
			}else {
				System.out.println("SELECTED CARD=" + Player1[P1card]);
				System.out.println("PLAYER2'S TURN");
				System.out.println("..............");
			}
			//P2
			Random r= new Random();
			int P2card = r.nextInt(4);
			if(Player2[P2card]==Player1[P1card]) {
			    System.out.println("ALL CARDS ARE PLAYER2'S");
			}else {
				System.out.println("DİSCARDED =" + Player2[P2card]);
				System.out.println("YOUR TURN");
				System.out.println("..............");
			}
		}
	}
}
	

