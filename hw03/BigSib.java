// Peter Duchovni
// Period 9
// HW#4
// 2012-09-24

public class BigSib {
    private String helloMsg;

    public void setHelloMsg( String newMsg ) {
	helloMsg = newMsg;
    }
    public String greet( String name ) {
        return helloMsg + " " + name;
    } 
}
