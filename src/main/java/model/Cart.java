package model;

public class Cart extends Products{
	
	private String username;
	private int  cartQuantity;
	
	
	public void setcartQuantity(int q){
		this.cartQuantity=q;
	}
	
	public int getcartQuantity() {
		return cartQuantity;
	}
	
	public void setusername(String username){
		this.username=username;
	}
	
	public String getusername() {
		return username;
	}

	@Override
	public String toString() {
		return "Cart [cartQuantity=" + cartQuantity +" username=" +username+ "product_id="+id+"]";
	}
	
	
	
	

}
