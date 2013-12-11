// Peter Duchovni
// Period 9
// Homework 20
// October 30

// class Person
// for practice with instance vars that are Objects

public class Person {

    // instance variables 
    private String _firstName, _lastName;
    private Face _myFace;
    private Body _myBody;

    // CONSTRUCTORS
    // default: William Shatner with a default Face
    public Person() {
       	_firstName = "William";
	_lastName = "Shatner";
	_myFace = new Face(); // Q: What happens if comment out?
	_myBody = new Body();
    }

    // 1st overload: initialize _firstName, _lastName, set _myFace to null
    public Person( String firstName, String lastName ) {
	_firstName = firstName;
	_lastName = lastName;
	_myBody = new Body();
    }

    // 2nd overload: initialize _firstName, _lastName, _myFace
    public Person( String firstName, String lastName, Face face ) {
    	_firstName = firstName;
	_lastName = lastName;
	_myFace = face;
	_myBody = new Body();
    }

    // 2nd overload: initialize _firstName, _lastName, _myFace, _myBody
    public Person( String firstName, String lastName, Face face, Body body ) {
    	_firstName = firstName;
	_lastName = lastName;
	_myFace = face;
	_myBody = body;
    }


    // ACCESSORS
    public String getFirstName( ) { return _firstName; }
    public String getLastName( )  { return _lastName; }
    public Face getFace( )        { return _myFace; }
    public Body getBody( )        { return _myBody; }

    // MUTATORS
    // each returns old value
    public String setFirstName(String firstName) { 
	String old = _firstName;
	_firstName = firstName;
	return old;
    }
    public String setLastName(String lastName) {
	String old = _lastName;
	_lastName = lastName;
	return old;
    }
    public Face setFace(Face newFace) {
	Face old = _myFace;
	_myFace = newFace;
	return old;
    }

    public Body setBody(Body newBody) {
	Body old = _myBody;
	_myBody = newBody;
	return old;
    }

    public String toString() {
	return _myFace + "\n" + _myBody + "\n" +  _firstName + " " +  _lastName;
    }

}//end class Person
