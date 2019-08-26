package cashregister;

public class StubPurchase extends Purchase{

	public StubPurchase() {
		super(new Item[0]);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String asString() {
		// TODO Auto-generated method stub
		return "test product\t1.0\n";
	}
}
