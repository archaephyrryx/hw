// Peter Duchovni
// Period 9
// HW#4
// 2012-09-24

public class Driver { 

    public static void main( String[] args ) {
	String greeting;

/* Answer: as main is run without being called
by another function, visibility makes no sense,
as there is nothing for it to be visible or invisible to */

	BigSib finnegan = new BigSib();    
	BigSib lowdee = new BigSib();    
	BigSib lancelot = new BigSib();    
	BigSib joshua = new BigSib();    

	finnegan.setHelloMsg("Top o' the mornin'");
	lowdee.setHelloMsg("Hi");
	lancelot.setHelloMsg("How farest thee, good");
	joshua.setHelloMsg("GREETINGS PROFESSOR");

	greeting = finnegan.greet("Seamus");
	System.out.println(greeting);
/* Answer: changing "private helloMsg" to "private helloMsg"
in BigSib.java would make it possible */ 

	greeting = lowdee.greet("Minus Heidi-Low");
	System.out.println(greeting);
	greeting = lancelot.greet("sirrah");
	System.out.println(greeting);
	greeting = joshua.greet("FALKEN");
	System.out.println(greeting);
    }
}
