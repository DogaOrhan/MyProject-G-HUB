
public class Deck {
	public String suits;
	public String values;
	
	Deck() {
		suits=" ";
		values=" ";
		
	}
    //get
	public String getSuits() {
		return suits;
	}
	public String getValues() {
		return values;
	}
	//set
	public void setSuits(String Suits) {
		this.suits=Suits;
	}
	public void setValues(String Values) {
		this.values=Values;
	}
}
