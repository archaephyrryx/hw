//definition file for class Driver
public class Driver { 
    public static void main( String[] args ) {
	BigSib mrRoboto = new BigSib();    
	BigSib grizz = new BigSib("Hey ya");    
	BigSib dotCom = new BigSib("Sup");
	BigSib tracy = new BigSib("Salutations");    
	
	System.out.println();
	System.out.println( mrRoboto.greet("Kevin Li") );
	System.out.println( tracy.greet("Dr. Spaceman") );
	System.out.println( grizz.greet("Kong Fooey") );
	System.out.println( dotCom.greet("mom") );
	System.out.println();
	System.out.println( mrRoboto.greet( "Bruce", "Lee" ) );
	System.out.println( tracy.greet( "Chris","Parnell" ) );
	System.out.println( grizz.greet( "Kong Fooey", "Jones" ) );
	System.out.println( dotCom.greet( "Liz", "Lemon" ) );
    }
}
