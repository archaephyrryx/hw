// Peter Duchovni
// Period 9
// HW 23
// November 14, 2013

public class Monster {
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

  public boolean isAlive() {
    return (_hp > 0);
  }

  public int getDefence() { return _defence; }
  public int getDefense() { return _defence; }

  public String getName() { return "E. Magnet"; }

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
