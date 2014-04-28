import java.io.*;

public class RPN {
    private RPNStack s = new RPNStack();


    private void parse(String str) {
	if (str.matches("(-)?[0-9]+(\\.[0-9]+)?")) {
	    s.push(Double.parseDouble(str));
	    return;
	}
	if (str.equals("pi")) {
	    s.push(Math.PI);
	    return;
	}
	if (str.equals("e")) {
	    s.push(Math.E);
	    return;
	}
	if (str.equals("+")) {
	    double y = s.pop();
	    double x = s.pop();
	    s.push(x+y);
	    return;
	}
	if (str.equals("-")) {
	    double y = s.pop();
	    double x = s.pop();
	    s.push(x-y);
	    return;
	}
	if (str.equals("*")) {
	    double y = s.pop();
	    double x = s.pop();
	    s.push(x*y);
	    return;
	}
	if (str.equals("/")) {
	    double y = s.pop();
	    double x = s.pop();
	    s.push(x/y);
	    return;
	}
	if (str.equals("^")) {
	    double y = s.pop();
	    double x = s.pop();
	    s.push(Math.pow(x,y));
	    return;
	}
	if (str.equals("~")) {
	    double x = s.pop();
	    s.push(-1*x);
	    return;
	}
	if (str.equals("\\")) {
	    double x = s.pop();
	    s.push(1/x);
	    return;
	}

	return;
    }


    public static void main (String[] args) {
	RPN r = new RPN();
	InputStreamReader input = new InputStreamReader(System.in);
	BufferedReader buff = new BufferedReader(input);
	System.out.println("Operations: + - * / ^ negation(~) reciprocal(\\)");
	System.out.println("Type 'quit' to exit at any time");
	String str = "";
	while (!(str.equals("quit"))) {
	    r.parse(str);
	    System.out.println(r.s);
	    try {
		str = buff.readLine();
	    } catch (IOException e) {
		System.err.println("IOException: " + e.getMessage());
	    }
	}
    }
}
