public class BigSib {
    private static String welcomeMsg = "welcome to stuy";
    private String helloMsg;

    public BigSib() {
	helloMsg = "Hello";
    }

    public BigSib( String newMsg ) {
	helloMsg = newMsg;
    }

    public void setHelloMsg( String newMsg ) {
	helloMsg = newMsg;
    }
    public String greet( String name ) {
        return helloMsg + " " + name + ", " + welcomeMsg;
    } 
    public String greet( String first, String last ) {
        return helloMsg + " " + first + " " + last + ", " + welcomeMsg;
    } 
}
