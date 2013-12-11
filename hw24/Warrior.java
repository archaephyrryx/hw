// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013
 
public class Warrior extends Character {
  private String _name;
  private int _hp;
  private int _strength;
  private int _defence; /* An English Warrior */
  private double _attack;

  public Warrior() {
    _name = "Handscio Norris"; /* Hwalker, Geatland Ranger */
    _hp = 125;
    _strength = 100;
    _defence = 40;
    _attack = 0.4;
  }

  public Warrior( String name ) {
    this();
    _name = name;
  }

  public boolean isAlive() {
    return _hp > 0;
  }

  public int getDefence() { return _defence; }
  public int getDefense() { return _defence; } /* New in v0.1: Compatible with more languages */
  public String getName() { return _name; } /* netGame */


  public void lowerHp( int damage ) {
    _hp -= damage;
  }

  public int attack( Monster mash ) {
    int smiteMight; /* Bright white knight fights wight, smites right night-blight */
    smiteMight = ((int) (_strength * _attack)) - mash.getDefence();

    mash.lowerHp( smiteMight );

    return smiteMight;
  }

  public void specialize() {
    _attack = 1.0; /* That's a big 10/4, driver */
    _defence = 10; 
  }

  public void normalize() {
    _attack = 0.4;
    _defence = 40; 
  }
}
