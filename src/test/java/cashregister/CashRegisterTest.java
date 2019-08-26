package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CashRegisterTest {
	private static MockPrinter mockPrinter;
	private static CashRegister cashRegister;
	
	@BeforeAll
	static void setup() {
		// TODO Auto-generated method stub
		mockPrinter=new MockPrinter();
		cashRegister=new CashRegister(mockPrinter);
	}
	
	@BeforeEach
	private void resetup() {
		// TODO Auto-generated method stub
		mockPrinter.setTempText("");
	}

    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Item[] items= {new Item("test product", 1)};
    	Purchase purchase=new Purchase(items);
//    	MockPrinter mockPrinter=new MockPrinter();
//    	CashRegister cashRegister=new CashRegister(mockPrinter);
        //when
    	cashRegister.process(purchase);
        //then
    	Assertions.assertEquals("test product\t1.0\n", mockPrinter.getTempText());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
    	StubPurchase stubPurchase=new StubPurchase();
        //when
    	cashRegister.process(stubPurchase);
        //then
    	Assertions.assertEquals("test product\t1.0\n", mockPrinter.getTempText());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
    	Printer printer=Mockito.mock(Printer.class);
    	Purchase purchase=Mockito.mock(Purchase.class);
        //when
    	Mockito.when(purchase.asString()).thenReturn("project A");
    	CashRegister cashRegister1=new CashRegister(printer);
    	cashRegister1.process(purchase);
        //then
    	Mockito.verify(printer).print("project A");
    }

}
 