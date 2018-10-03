package calculator;

//import java.util.ArrayList;

public class CalculatorTwo implements CalcTwoInterface{
//	private double operandOne;
//	private double operandTwo;
//	private String operation;
	private double result = 0;
//	private static ArrayList<String> operationRecords = new ArrayList<String>();
	private boolean lastOperand = false;
	private String lastOperator = "+";
	private String record = " ";
	
	@Override
	public void performOperation(double operand) {
		if(this.lastOperand == true) {
			System.out.println("Invalid input - input not entered");
		}else {
			if(this.lastOperator == "+") {
				this.result = this.result + operand;
			}else if(this.lastOperator == "-") {
				this.result = this.result - operand;
			}else if(this.lastOperator == "*") {
				this.result = this.result * operand;
			}else if(this.lastOperator == "/") {
				this.result = this.result / operand;
			}else {
				System.out.println("what did enter for the operator? Something's wrong.");
			}
			this.record += " "+operand+" ";
			this.lastOperand = true;
			System.out.println(" = "+this.result);
		}
	}
	
	@Override
	public void performOperation(String operator) {
		if(this.lastOperand == false) {
			System.out.println("Invalid input - input not entered");			
		}else {
			this.lastOperand = false;
			this.lastOperator = operator;
		}
		this.record += " "+operator+" ";
	}
	
	public String getResults() {
		this.record += " = "+this.result;
		return this.record;
	}
}
