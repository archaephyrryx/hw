// Peter Duchovni
// pd #9
// HW#4
// 2012-09-25

public class BigSib {
    // constant part of greeting
    private static String welcomeMsg = "welcome to stuy";
    // variable part of greeting
    private String helloMsg;

    // constructor: takes string, assigns value to helloMsg
    public BigSib( String newMsg ) {
	helloMsg = newMsg;
    }

    // mutator: takes string, assigns value to helloMsg
    public void setHelloMsg( String newMsg ) {
	helloMsg = newMsg;
    }
    // accessor: returns full greeting, takes string for name
    public String greet( String name ) {
        return helloMsg + " " + name + ", " + welcomeMsg;
    } 
}
