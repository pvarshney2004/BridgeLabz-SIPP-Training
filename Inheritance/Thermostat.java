package Inheritance;

public class Thermostat extends Device {
	String tempSetting;
	public Thermostat(int id, String status, String tempSetting) {
		super(id,status);
		this.tempSetting = tempSetting;
	}
	
	public void displayStatus() {
		super.displayStatus();
		System.out.println("Temperature settings: "+ tempSetting);
	}
	public static void main(String[] args) {
		Thermostat ob = new Thermostat(101, "on", "setting on");
		ob.displayStatus();
	}
}
