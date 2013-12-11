// Peter Duchovni
// Period 9
// Homework 24
// November 14, 2013

public class Character {
  protected int _hp;
  protected int _strength;
  protected int _defence;
  protected double _attack;

  public boolean isAlive() {
    return (_hp > 0);
  }

  public void lowerHp( int damage ) {
    _hp -= damage;
  }

  public int getDefence() { return _defence; }

  public int attack( Character istic ) {
    int damage;
    damage = ((int) (_strength * _attack)) - istic.getDefence();
    damage = (damage < 0) ? 0 : damage;
    istic.lowerHp(damage);
    return damage;
  }
}
