import java.util.Random;
import java.util.Scanner;

public class Gamei {
	public String[] suits= {"maca","kupa","sinek","karo"};//{"♠","♣","♥ ","♦"}
	public String[] values= {"ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	Deck[] Tablecard=new Deck[52];
	Deck[] deck = new Deck[52];
	Deck[] Table= new Deck[4];
	Deck[] Player1= new Deck[4];
	Deck[] Player2= new Deck[4];
	
	
	public void Deck() {
		for (int i=0;i<52;i++) {
			deck[i]=new Deck();
		}
		int num=0;
		for(int j=0;j<4;j++) {
			for(int i=0;i<13;i++) {
				deck[num].setSuits(suits[j]);
				deck[num].setValues(values[i]);
				num++;
			}
		}
		
		
	}
	
	public void Shuffle() {
		Random rd = new Random();
		for(int i=0; i<deck.length;i++) {
			int random = rd.nextInt(52);
			Deck Temp = deck[i];
			deck[i]=deck[random];
			deck[random]=Temp;
			
		}
		for(int i=0; i<deck.length;i++) {
		
		}
		//System.out.println("finish");


	}
		
	public void Cut() {
		Random r=new Random();
		int cut = r.nextInt(deck.length);
		Deck[] deck2=new Deck[deck.length];
		Deck[] top=new Deck[cut];
		Deck[] bottom=new Deck[deck.length-cut];
		
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
			System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
		}
		//System.out.println("..........");
		//System.out.println("PLAYER2'S CARDS");
		for(int i=1;i<8;i=i+2) {
			Player2[(i-1)/2]=deck[i];
			//System.out.println(Player2[(i-1)/2].getValues()+Player2[(i-1)/2].getSuits());
		}
		//System.out.println("..........");
				
		for(int i=8;i<12;i++) {
			Table[i-8]=deck[i-8];
			Tablecard[i-8]=Table[i-8];
			//System.out.println(Table[i-8]);
						
		}
		System.out.println("..........");

		System.out.println("topcard= " + Table[3].getValues()+Table[3].getSuits());
	}

	public void Move() {			
		Scanner sc =new Scanner(System.in);
		Deck[] Sidecards1=new Deck[52];
		Deck[] Sidecards2=new Deck[52];
		
		int counter=0;
		counter=counter+4;
		for (int i=0;i<6;i++) {
			for (int j=0;j<4;j++) {
			System.out.println("SELECT CARD");
			//p1
			int P1card=sc.nextInt()-1;
			while(P1card>=4) {
				System.out.println("ENTER VALİD NUMBER");
				P1card=sc.nextInt()-1;
			}
			System.out.println("topcard="+Player1[P1card].getValues()+Player1[P1card].getSuits());
			
			Tablecard[counter]=Player1[P1card];
			
			
			if(((String) Tablecard[counter-1].getValues()).compareTo((String)Player1[P1card].getValues()) == 0) {
				System.out.println("ALL CARDS ARE YOURS");
				counter++;
				
				// alınan kartları oyuncuya ver
				
				System.out.println("Topcard=  ");
				
			}else {
				System.out.println("SELECTED CARD=" + Player1[P1card].getValues()+Player1[P1card].getSuits());
				System.out.println("PLAYER2'S TURN");
				System.out.println("..............");
			}
			Player1[P1card]=null;
			
			//P2
			Random r= new Random();
			int P2card = r.nextInt(4);
			Tablecard[counter]=Player2[P2card];
			while(true) {
				for (int k=0;k<4;k++) {
					if(((String) Tablecard[counter-1].getValues()).compareTo((String)Player2[P2card].getValues()) == 0) { 
					    System.out.println("ALL CARDS ARE PLAYER2'S");
					    System.out.println("Topcard=  ");
					    break;
					}
				}
				for (int k=0;k<4;k++) {
					if((String) Player2[P2card].getValues()== "J" ) {
						System.out.println("ALL CARDS ARE PLAYER2'S");
						System.out.println("Topcard=  ");
						break;
					}
				}
				
					System.out.println("DISCARDED =" + Player2[P2card].getValues()+Player2[P2card].getSuits());
					System.out.println("YOUR TURN");
					System.out.println("..............");
				 
			}
			}
		}
	}
}

	

