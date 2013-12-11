// Peter Duchovni
// Period 9
// Homework 20
// October 30


public class Body {
    // instance vars
    private String _body;

    //Pre-set bodies
    private static final String ALIEN = "  | |  \n <   > \n /   \\ \n \\   / \n |   | \n U   U ";
    private static final String ROBOT = "  | |  \n=======\n|| | ||\n|| | ||\n<> | <>\n o---o ";
    private static final String HUMAN = "<|   |>\n ===== \n // \\\\ \n || || \n( | | )" ;

    // constructor
    public Body() {
	this((int) (3 * Math.random()));
    }

    public Body( int choice ) {
	_body = (choice % 3 == 0) ? ALIEN : (choice % 3 == 1) ? ROBOT : HUMAN;
   }

   public String toString() {
	return _body;
    }

    // main() will be commented out once fxnality verified, using /* & */
    public static void main (String[] args) {
    	Body pea;
	pea = new Body(0);
	System.out.println(pea);
    }

}
