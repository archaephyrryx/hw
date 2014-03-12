public class Person implements Comparable<Person>{
	private String name;
	private int age;

	public Person(String myName) {
		name = myName;
		age = ((int) (Math.random() * 100) + 1);
	}

	public String toString() { 
		String s = "";
		/** s += this.name; /**/
		/**/ s += this.age; /**/
		return s;
	}

	public int compareTo(Person other) {
		/** return (this.name.compareTo(other.name)); /**/
		/**/ return (this.age - other.age); /**/
	}
}
