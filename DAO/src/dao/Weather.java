package dao;

public class Weather extends Entity {
	private int temp;
	private int water;
	private String region;
	private String date;
	

	public Weather() {
		
	}

	public Weather(int id,int temp,int water,String region,String date) {
		super(id);
		this.temp=temp;
		this.water=water;
		this.region=region;
		this.date=date;
	}
	
	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "\n---------\nDate: "+date+"\nTEMP: "+temp+"\nREGION: "+region+"\nWATER: "+water;
	}

}