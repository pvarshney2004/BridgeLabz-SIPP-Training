package train.route.management;

class Station{
	String sName;
	String sCode;
	Station next;
	public Station(String sName, String sCode) {
		this.sName=sName;
		this.sCode=sCode;
		this.next = null;
	}
	public String toString() {
		return this.sName + "-" + this.sCode + "-->";
	}
}

public class RailwaySystem implements ControlOffice{
	private Station head;
	private Station tail;
	private int noOfStations=0;
	@Override
	public void addStation(String name, String code) {
		Station nn = new Station(name,code);
		if(noOfStations==0) {
			head=tail=nn;
		}
		else {
			tail.next=nn;
			tail=nn;
		}
		noOfStations++;
		
	}
	@Override
	public void removeStation(String name) {
		Station temp = head;
		Station temp2 = tail;
		
		if(temp.sName.equals(name)) {
			removeFirst();
		}
		else {
			while(temp.next.sName!=name) {
				temp=temp.next;
			}
			Station s = temp.next;
			temp.next = s.next;
			s.next=null;
		}
		
	}
	public void removeFirst() {
		head = head.next;
	}
	
	public void display() {
		Station temp=head;
		while(temp!=null) {
			System.out.print(temp);
			temp=temp.next;
		}
		System.out.println("END");
	}
	
	public static void main(String[] args) {
		RailwaySystem rs = new RailwaySystem();
		rs.addStation("Mathura", "MT85");
		rs.addStation("Agra", "AG81");
		rs.display();
		rs.removeStation("Mathura");
		rs.display();
	}
}
