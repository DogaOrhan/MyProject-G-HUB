
public class mainn {
	public static void main(String[] args) {
		Gamei run = new Gamei();
		run.Deck();
		run.Shuffle();
		run.Cut();
		run.Dealfirst();
		run.Move();
		for(int i=0;i<5;i++) {
			run.Dealothers();
		    run.Move();
		}
	
	}

}
