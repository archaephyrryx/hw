//definition file for class Driver
//follow prompts below

public class Driver { 

    public static void main( String[] args ) {

	String greeting;  

	//build 3 instances of class BigSib
	BigSib grizz = new BigSib("Hey ya");    
	BigSib dotCom = new BigSib("Sup");
	BigSib tracy = new BigSib("Salutations");    

	System.out.println();
	System.out.println("before taking a foreign language...");
	System.out.println( tracy.greet("Dr. Spaceman") );
	System.out.println( grizz.greet("Kong Fooey") );
	System.out.println( dotCom.greet("mom") );

	grizz.setHelloMsg("Bonjour");
	dotCom.setHelloMsg("Bongiorno");
	tracy.setHelloMsg("Hola");

	System.out.println();
	System.out.println("after taking a foreign language...");
	System.out.println( tracy.greet("Dr. Spaceman") );
	System.out.println( grizz.greet("Kong Fooey") );
	System.out.println( dotCom.greet("mom") );

    } //end main()

} //end Driver
