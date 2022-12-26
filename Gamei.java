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
	Deck[] decknew= new Deck[52];
	int deal=0;
	
	
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
	public void Dealfirst() {
			
			System.out.println("YOUR CARDS");			
			for(int i=0;i<8;i=i+2) {
				
					Player1[i/2]=deck[i];
					System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
				}
			
			for(int i=1;i<8;i=i+2) {
				Player2[(i-1)/2]=deck[i];
			}
					
			for(int i=8;i<12;i++) {
				Table[i-8]=deck[i];
				Tablecard[i-8]=Table[i-8];						
			}
			System.out.println("..........");
	
			System.out.println("topcard= " + Table[3].getValues()+Table[3].getSuits());
			
			
		
		}
	public void Dealothers() {
		deal=deal+8;

		System.out.println("YOUR CARDS");			
		for(int i=0;i<8;i=i+2) {
			
				Player1[i/2]=deck[i+deal];
				System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
			}
		
		//System.out.println("..........");
		//System.out.println("PLAYER2'S CARDS");
		for(int i=1;i<8;i=i+2) {
			Player2[(i-1)/2]=deck[i+deal];
			//System.out.println(Player2[(i-1)/2].getValues()+Player2[(i-1)/2].getSuits());
		}
		//System.out.println("..........");
				
		for(int i=8;i<12;i++) {
			Table[i-8]=deck[i];
			Tablecard[i-8]=Table[i-8];
			//System.out.println(Table[i-8]);
						
		}
		System.out.println("..........");
	}

	public void Move() {			
		Scanner sc =new Scanner(System.in);
		Deck[] Sidecards1=new Deck[52];
		Deck[] Sidecards2=new Deck[52];
		
		int lastcard=0;
		int Sidecounter1=0;
		int Sidecounter2=0;
		lastcard=lastcard+4;
		
		int a =0;
			for (int j=0;j<4;j++) {
				a=0;
				//p1
				System.out.println("SELECT CARD");
				int P1card=sc.nextInt()-1;
				while(P1card>=4 || Player1[P1card]==null) {
					System.out.println("ENTER VALID NUMBER");
					P1card=sc.nextInt()-1;
				}
				
			
				Tablecard[lastcard]=Player1[P1card];
				if(lastcard>1) {
					if(((String) Tablecard[lastcard-1].getValues()).compareTo((String)Player1[P1card].getValues()) == 0) {
						System.out.println("topcard="+Player1[P1card].getValues()+Player1[P1card].getSuits());
						System.out.println("ALL CARDS ARE YOURS");
						lastcard++;
						Sidecounter1=Sidecounter1+lastcard;
					
						System.out.println("Topcard=  ");
						for(int i= Sidecounter1;i<Sidecounter1+lastcard;i++) {
							Sidecards1[i]=Tablecard[i];
						}
						for (int b=0;b<lastcard;b++) {
							Tablecard[b]=null;
						}
						lastcard=0;
						a++;
					}
				}
				if(lastcard>1) {
					if (a==0) {
						if((String) Player1[P1card].getValues()== "J" ) {
							System.out.println("topcard="+Player1[P1card].getValues()+Player1[P1card].getSuits());
							System.out.println("ALL CARDS ARE YOURS");
							System.out.println("Topcard=  ");
							a++;
							for(int i= Sidecounter1;i<Sidecounter1+lastcard;i++) {
								Sidecards1[i]=Tablecard[i];
							}
							for (int b=0;b<lastcard;b++) {
								Tablecard[b]=null;
							}
						lastcard=0;
						}
					}
				}
			 	
				if(a==0) {
						System.out.println("SELECTED CARD=" + Player1[P1card].getValues()+Player1[P1card].getSuits());
						System.out.println("PLAYER2'S TURN");
						System.out.println("..............");
					
				}
				Player1[P1card]=null;
				
				//P2
				
				
				a=0;
					for (int k=0;k<4;k++) {
						if(lastcard>1) {
							if(Player2[k]!=null) {
								if(((String) Tablecard[lastcard-1].getValues()).compareTo((String)Player2[k].getValues()) == 0) {
									Tablecard[lastcard]=Player2[k];
									lastcard++;
								    System.out.println("ALL CARDS ARE PLAYER2'S");
								    System.out.println("DISCARDED =" + Player2[k].getValues()+Player2[k].getSuits());
									System.out.println("Topcard=  ");
								    System.out.println("YOUR TURN");
								    System.out.println("YOUR CARDS");			
									for(int i=0;i<8;i=i+2) {
										if(Player1[i/2]!=null) {
											Player1[i/2]=deck[i];
											System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
							
										}else {
											System.out.println((i/2)+1+" = " +"_____");
									    }
									}
								    
								    a++;
								    for(int i= Sidecounter2;i<Sidecounter2+lastcard;i++) {
										Sidecards2[i]=Tablecard[i];
								    }
								    for (int b=0;b<lastcard;b++) {
										Tablecard[b]=null;
									}
								    lastcard=0;
								    Player2[k]=null;
								}
							}
						}
					}
						if (a==0) {
							for (int k=0;k<4;k++) {
								if(Player2[k]!=null) {
									if((String) Player2[k].getValues()== "J" ) {
										System.out.println("ALL CARDS ARE PLAYER2'S");
										System.out.println("DISCARDED =" + Player2[k].getValues()+Player2[k].getSuits());
										System.out.println("Topcard=  ");
										System.out.println("YOUR TURN");	
										System.out.println("YOUR CARDS");			
										for(int i=0;i<8;i=i+2) {
											if(Player1[i/2]!=null) {
												Player1[i/2]=deck[i];
												System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
				
											}else {
												System.out.println((i/2)+1+" = " +"_____");
											}
										}
										a++;
										for(int i= Sidecounter2;i<Sidecounter2+lastcard;i++) {
											Sidecards2[i]=Tablecard[i];
										}
										for (int b=0;b<lastcard;b++) {
											Tablecard[b]=null;
										}
										lastcard=0;
										Player2[k]=null;
								}
							}
						}
					
					}
						Random r= new Random();
						int P2card = r.nextInt(4);
						while(Player2[P2card] ==null) {
							 P2card = r.nextInt(4);
							
						}
					if(a==0) {
						System.out.println("DISCARDED =" + Player2[P2card].getValues()+Player2[P2card].getSuits());
						System.out.println("YOUR TURN");
						System.out.println("..............");
						for(int i=0;i<8;i=i+2) {
							if(Player1[i/2]!=null) {
								Player1[i/2]=deck[i];
								System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
				
							}else {
								System.out.println((i/2)+1+" = " +"_____");
						    }
						}
						a++;
						Player2[P2card]=null;
					}
				}
			
			}
			
		
	public void Point() {
		int P1point=0;
		int P2point=0;
		
	}
}
		
				
		
		
	


	

