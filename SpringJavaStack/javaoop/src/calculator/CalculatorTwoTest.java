package calculator;

public class CalculatorTwoTest {
	public static void main(String[] args) {
		
		CalculatorTwo calculate2 = new CalculatorTwo();
		
		calculate2.performOperation("/");
		calculate2.performOperation(2.5);
		calculate2.performOperation("+");
		calculate2.performOperation(2.5);
		calculate2.performOperation("/");
		calculate2.performOperation(2.5);
		calculate2.performOperation("-");
		calculate2.performOperation(0.5);
		calculate2.performOperation(0.5);
		calculate2.performOperation("*");
		calculate2.performOperation(6);
		System.out.println(calculate2.getResults());
	}
}
