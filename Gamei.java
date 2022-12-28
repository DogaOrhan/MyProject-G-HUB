import java.util.Random;

import java.util.Scanner;

public class Gamei {
	public String[] suits= {"maca","kupa","sinek","karo"};//{"♠","♣","♥ ","♦"}
	public String[] values= {"ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	Deck[] Tablecard=new Deck[52];
	Deck[] deck = new Deck[52];
	Deck[] Table= new Deck[4];// deal
	Deck[] Player1= new Deck[4];//deal
	Deck[] Player2= new Deck[4];//deal
	Deck[] decknew= new Deck[52];
	Deck[] Sidecards1=new Deck[52];
	Deck[] Sidecards2=new Deck[52];
	int deal=0;
	int P1point=0;
	int P2point=0;
	int Sidecounter1=0;
	int Sidecounter2=0;
	int lastcard=0;
	String last = "player";//  at the end of the game who will take the last cards -->player1 , -->player2

	
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
			Deck Temp = deck[i];//additional empty place to shuffle
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
	
	
	public void Dealfirst() {//to deal 12 card in first dealing
			
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
			
			lastcard=lastcard+4;

		
		}
	public void Dealothers() {//to deal 8 card in 6 rounds(FOR İN MAİNN)
		deal=deal+8;//to deal the next 8 cards

		System.out.println("YOUR CARDS");			
		for(int i=0;i<8;i=i+2) {
			
				Player1[i/2]=deck[i+deal];////////P1'S CARDS FOR EACH ROUNDS(AFTER THE FİRST ROUND)
				System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
		}
		
		for(int i=1;i<8;i=i+2) {/////////P2'S CARDS FOR EACH ROUNDS(AFTER THE FİRST ROUND)
			Player2[(i-1)/2]=deck[i+deal];
		}
				
		System.out.println("..........");

	}

	public void Move() {			
		Scanner sc =new Scanner(System.in);
		

		
		int a =0;
			for (int j=0;j<4;j++) {
				a=0;
				////////////////////////////////////////// P1 ///////////////////////////////////////////
				System.out.println("SELECT CARD");
				int P1card=sc.nextInt()-1;    //array begins from 0 so -1
				while(P1card>=4 || Player1[P1card]==null) {
					System.out.println("ENTER VALID NUMBER");
					P1card=sc.nextInt()-1;
				}
				
			
				Tablecard[lastcard]=Player1[P1card];
				if(lastcard>=1) {
					if(((String) Tablecard[lastcard-1].getValues()).compareTo((String)Player1[P1card].getValues()) == 0) {
						System.out.println("topcard="+Player1[P1card].getValues()+Player1[P1card].getSuits());
						System.out.println("ALL CARDS ARE YOURS");
						
						if(lastcard<2) {   //it means there is just 1 card on the table 
							P1point +=10;
							System.out.println("--------------------------------------------------"+P1point  );
							System.out.println("PISTI");
						}
						lastcard++;  //integer 
						Sidecounter1=Sidecounter1+lastcard;// adding 
					
						System.out.println("Topcard=  ");
						for(int i= Sidecounter1;i<Sidecounter1+lastcard;i++) {
							Sidecards1[i]=Tablecard[i];  //to fill the sidecards with taken from table
						}
						  for(int i=0;i<lastcard;i++) {  //FOR POİNT
							     if(Tablecard[i].getValues()=="2" &&  Tablecard[i].getSuits()=="sinek") {
									 P1point += 2;
								 } else if (Tablecard[i].getValues()=="10" &&  Tablecard[i].getSuits()=="karo") {
									 P1point += 3;
								 } else {
									 P1point++;
								 }
							//  System.out.println("--------------------------------------------------"+P1point  );

							}
						for (int b=0;b<lastcard;b++) {
							Tablecard[b]=null;//TO MAKE TABLE EMPTY
						}
						lastcard=0;
						a++;
						last = "player1";
						
					}
				}
				if(lastcard>=1) {
					if (a==0) {
						if((String) Player1[P1card].getValues()== "J" ) {
							System.out.println("topcard="+Player1[P1card].getValues()+Player1[P1card].getSuits());
							System.out.println("ALL CARDS ARE YOURS");
							System.out.println("Topcard=  ");
							a++;
							for(int i= Sidecounter1;i<Sidecounter1+lastcard;i++) {
								Sidecards1[i]=Tablecard[i];
								
							}
							for(int i=0;i<lastcard;i++) {
						     if(Tablecard[i].getValues()=="2" &&  Tablecard[i].getSuits()=="sinek") {
								 P1point += 2;
							 } else if (Tablecard[i].getValues()=="10" &&  Tablecard[i].getSuits()=="karo") {
								 P1point += 3;
							 } else {
								 P1point++;
							 }
			//			      System.out.println("--------------------------------------------------"+P1point  );

							}
							for (int b=0;b<lastcard;b++) {
								Tablecard[b]=null;
							}
						lastcard=0;
						last="player1";
						}
					}
				}
			 	
				if(a==0) {
						System.out.println("SELECTED CARD=" + Player1[P1card].getValues()+Player1[P1card].getSuits());
						System.out.println("PLAYER2'S TURN");
						System.out.println("..............");
						lastcard++;
				}
				Player1[P1card]=null;
				
				//////////////////////////////////////P2////////////////////////////////////////////
				
				
				a=0;
					for (int k=0;k<4;k++) {
						if(lastcard>1) {
							if(Player2[k]!=null) {
								if(((String) Tablecard[lastcard-1].getValues()).compareTo((String)Player2[k].getValues()) == 0) {
									Tablecard[lastcard]=Player2[k];
									
									if(lastcard<2) {
										P2point +=10;
										 // System.out.println("--------------------------------------------------"+P2point  );
										System.out.println("PISTI");
									}
									lastcard++;
								    System.out.println("ALL CARDS ARE PLAYER2'S");
								    System.out.println("DISCARDED =" + Player2[k].getValues()+Player2[k].getSuits());
									System.out.println("Topcard=  ");
								    System.out.println("YOUR TURN");
								    System.out.println("YOUR CARDS");			
									for(int i=0;i<8;i=i+2) { // if not null show card ,else show "------"
										if(Player1[i/2]!=null) {
											Player1[i/2]=deck[i + deal];
											System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
							
										}else {
											System.out.println((i/2)+1+" = " +"_____");
									    }
									}
								    
								    a++;
								    for(int i= Sidecounter2;i<Sidecounter2+lastcard;i++) {
										Sidecards2[i]=Tablecard[i];
								    }
								    for(int i=0;i<lastcard;i++) { //point
									     if(Tablecard[i].getValues()=="2" &&  Tablecard[i].getSuits()=="sinek") {
											 P2point += 2;
										 } else if (Tablecard[i].getValues()=="10" &&  Tablecard[i].getSuits()=="karo") {
											 P2point += 3;
										 } else {
											 P2point++;
										 }
									    // System.out.println("--------------------------------------------------"+P2point  );

									}
								    
								    for (int b=0;b<lastcard;b++) {
										Tablecard[b]=null;
									}
								    lastcard=0;
								    Player2[k]=null;
								    last="player2";
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
										
										for(int i=0;i<8;i=i+2) { // if not null show card ,else show" ------"
											if(Player1[i/2]!=null) {
												Player1[i/2]=deck[i];
												System.out.println((i/2)+1 +" = "+ Player1[i/2].getValues()+Player1[i/2].getSuits());
				
											}else {
												System.out.println((i/2)+1+" = " +"_____");
											}
										}
										a++;
										P2point++;
										for(int i= Sidecounter2;i<Sidecounter2+lastcard;i++) {
											Sidecards2[i]=Tablecard[i];  //adding to Sidecards2
										}
										  for(int i=0;i<lastcard;i++) {  //POİNT
											     if(Tablecard[i].getValues()=="2" &&  Tablecard[i].getSuits()=="sinek") {
													 P2point += 2;
												 } else if (Tablecard[i].getValues()=="10" &&  Tablecard[i].getSuits()=="karo") {
													 P2point += 3;
												 } else {
													 P2point++;
												 }
											   //  System.out.println("--------------------------------------------------"+P2point  );
											}
										for (int b=0;b<lastcard;b++) {
											Tablecard[b]=null;//to make table empty
										}
										lastcard=0;
										Player2[k]=null;
										last="player2";
								}
							}
						}
					
					}
						Random r= new Random();
						int P2card = r.nextInt(4);
						while(Player2[P2card] ==null) {
							 P2card = r.nextInt(4);
							
						}
						Tablecard[lastcard]=Player2[P2card];

					if(a==0) {
						System.out.println("DISCARDED =" + Player2[P2card].getValues()+Player2[P2card].getSuits());
						System.out.println("YOUR TURN");
						System.out.println("..............");
						lastcard++;
						for(int i=0;i<8;i=i+2) {
							if(Player1[i/2]!=null) {
								Player1[i/2]=deck[i+deal];
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
		 if (last == "player1") {
			 for(int i= Sidecounter1;i<Sidecounter1+lastcard;i++) {
					Sidecards1[i]=Tablecard[i]; 
					P1point++;
					Tablecard[i]=null;
			 }
		 }
		 if (last == "player2") {
			 for(int i= Sidecounter2;i<Sidecounter2+lastcard;i++) {
					Sidecards2[i]=Tablecard[i]; 
					P2point++;
					Tablecard[i]=null;
			 }
		 }
		 if(Sidecounter1>Sidecounter2) { //card majority
			 P1point+=3;
		 }
		 System.out.println(P1point);
		 
		 if(Sidecounter2>Sidecounter1) { // card majority
			 P2point+=3;
		 }
		 System.out.println(P2point);
		 
		 
		 System.out.println("////////////////////////////////////////////////////////////////////");
	     System.out.println("END OF THE GAME");
	     if(P1point>P2point) {
	    	 System.out.println("PLAYER1 WON");
	     }else if(P1point<P2point) {
	    	 System.out.println("PLAYER2 WON");
	     }else {
	    	 System.out.println("DRAW");
	     }
	 }
}
			 
			 
		 
		
		
		
	

		
				
		
		
	


	

