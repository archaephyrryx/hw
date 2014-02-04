// Peter Duchovni
// Period 9
// HW 24
// November 14, 2013

public class Monster extends Character {
  private int _hp;
  private int _strength;
  private int _defence; /* Nasty, British, and Short */
  private double _attack;

  public Monster() {
    _hp = 150;
    _defence = 20;
    _attack = 1;
    _strength = (int) (Math.random() * 45) + 20;
  }

  public int getDefence() { return _defence; }
  public int getDefense() { return _defence; }
  public String getName() { return "E. Magnet"; }

  public boolean isAlive() {
    return (_hp > 0);
  }

  public void lowerHp( int damage ) {
    _hp -= damage;
  }

  public int attack( Warrior worrier ) {
    int daMage; /* Da monster attacks da mage */
    daMage = ((int) (_strength * _attack)) - worrier.getDefence();
    worrier.lowerHp( daMage );

    return daMage;
  }
}
