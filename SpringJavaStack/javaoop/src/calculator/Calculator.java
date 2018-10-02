package calculator;
import java.util.ArrayList;

public class Calculator implements CalculatorInterface{
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	private static ArrayList<String> operationRecords = new ArrayList<String>();
	
	public Calculator() {
		this.operandOne = 0;
		this.operandTwo = 0;
		this.operation = null;
		
	}
	
	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operator) {
		this.operation = operator;
	}

	public void performOperation() {
		if(this.operation.equals("+")) {
			this.result = this.operandOne + this.operandTwo;
			Calculator.operationRecords.add(this.operandOne+" + "+this.operandTwo+" = "+this.result);
		}else if(this.operation.equals("-")) {
			this.result = this.operandOne - this.operandTwo;
			Calculator.operationRecords.add(this.operandOne+" - "+this.operandTwo+" = "+this.result);
		}else {
			System.out.println("Invalid input - unable to calcate - please try again");
		}
		
	}
	
	public void getResults(){
		for(int i = 0; i < Calculator.operationRecords.size(); i++) {
			System.out.println(Calculator.operationRecords.get(i));
		}
	}	
	
}
