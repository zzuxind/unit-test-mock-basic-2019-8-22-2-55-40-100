package cashregister;

public class MockPrinter extends Printer {
	
	private String tempText;
	public String getTempText() {
		return tempText;
	}
	public void setTempText(String tempText) {
		this.tempText = tempText;
	}
	@Override
	public void print(String printThis) {
		// TODO Auto-generated method stub
		super.print(printThis);
		tempText=printThis;
	}

}
