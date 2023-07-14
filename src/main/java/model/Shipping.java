package model;

public class Shipping {


	private int shippingId;
	private String fullName;
	private String contactNumber;
	private String adress;
	private String country;
	private String pincode;
	private String city;
	private String state;
	
	public Shipping(String fullName, String contactNumber, String adress, String country, String pincode,
			String city, String state) {
		this.fullName = fullName;
		this.contactNumber = contactNumber;
		this.adress = adress;
		this.country = country;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
	}

	public int getShippingId() {
		return shippingId;
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
