//take an integer, print "Fizz" if divisible by 3, "Buzz" if divisible by 5, or "Fizzbuzz and the integer" if divisible by both 3 and 5" 
public class FizzBuzz {
	public String fizzBuzz(int num) {
		String outcome;
		if(num%3 == 0 && num%5 == 0){
			outcome =("FizzBuzz "+num);
		}else if( num%3 == 0) {
			outcome ="Fizz";
		}else if(num%5 == 0){
			outcome = "Buzz";
		}else {
			outcome = String.format("%s", num);
		}
		return outcome;
	}

}
