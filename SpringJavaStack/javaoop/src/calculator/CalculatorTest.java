package calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculate1 = new Calculator();
		
		calculate1.setOperandOne(10.5);
		calculate1.setOperandTwo(5.5);
		calculate1.setOperation("+");
		calculate1.performOperation();
		calculate1.setOperandOne(10.5);
		calculate1.setOperandTwo(5.5);
		calculate1.setOperation("-");
		calculate1.performOperation();
		calculate1.setOperandOne(6.5);
		calculate1.setOperandTwo(5.5);
		calculate1.setOperation("-");
		calculate1.performOperation();
		calculate1.getResults();
		
		
	}

}
