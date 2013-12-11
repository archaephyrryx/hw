// Peter Duchovni
// Period 9
// Homework 20
// October 30

import cs1.Keyboard;

public class PersonApp {
    public static void main( String[] args ) {
	String henry;
	String higgs;
	String beep;
	String boop;
	String henryhair;
	String steelwool;
	String eyes;
	String nose;
	String hair;
	String mouth;
	Face iggssface;
	Face boopsface;
	Face iggssnewface;
	Face boopsnewface;

	Person enryiggs = new Person("Henry", "Higgs", (new Face( "SCIENCE", "| O-O |", "| ->- |", "|  o  |")), (new Body((2))));



	Person beepboop = new Person("Beep", "Boop", (new Face ("_______", "|[0|0]|", "|  @  |", "| --- |")), (new Body((1))));

	System.out.println(enryiggs);
	System.out.println(beepboop);

        // prompt user to modify hair
	System.out.print("Change Henry's hair: ");
	hair = Keyboard.readString();
	iggssface = enryiggs.getFace();
	iggssface.setHair(hair);
	enryiggs.setFace(iggssface);
	System.out.println("Eureka:");
	System.out.println(enryiggs);

	// prompt user to modify eyes
	System.out.print("Henry has special eyes: ");
	eyes = Keyboard.readString();
	iggssface = enryiggs.getFace();
	iggssface.setEyes(eyes);
	enryiggs.setFace(iggssface);
	System.out.println("Eureka:");
	System.out.println(enryiggs);

	// prompt user to modify nose
	System.out.print("Oh nose!: ");
	nose = Keyboard.readString();
	iggssface = enryiggs.getFace();
	iggssface.setNose(nose);
	enryiggs.setFace(iggssface);
	System.out.println("Eureka:");
	System.out.println(enryiggs);

	// prompt user to modify mouth
	System.out.print("Mouth to mouth: ");
	mouth = Keyboard.readString();
	iggssface = enryiggs.getFace();
	iggssface.setMouth(mouth);
	enryiggs.setFace(iggssface);
	System.out.println("Eureka:");
	System.out.println(enryiggs);

	// prompt user to swap names
	System.out.print("Enter one key to swap names, more to not: ");
	String swapnames = Keyboard.readString();
	if (swapnames.length() == 1 ) {
	  beep = beepboop.getFirstName();
	  boop = beepboop.getLastName();
	  henry = enryiggs.getFirstName();
	  higgs = enryiggs.getLastName();

	  enryiggs.setFirstName(beep);
	  enryiggs.setLastName(boop);
	  beepboop.setFirstName(henry);
	  beepboop.setLastName(higgs);
	}
	System.out.println("Hmm?:");
	System.out.println(enryiggs);
	System.out.println(beepboop);

	// prompt user to swap hairstyles
	System.out.print("Enter one key to swap hairstyles, more to not: ");
	String swaphair = Keyboard.readString();
	if (swaphair.length() == 1 ) {
		steelwool = (beepboop.getFace()).getHair();
		henryhair = (enryiggs.getFace()).getHair();

		iggssnewface = enryiggs.getFace();
		iggssnewface.setHair(steelwool);
		boopsnewface = beepboop.getFace();
		boopsnewface.setHair(henryhair);

		enryiggs.setFace(iggssnewface);
		beepboop.setFace(boopsnewface);
	}
	System.out.println("Yearbook photos:");
	System.out.println(enryiggs);
	System.out.println(beepboop);

    }

}
