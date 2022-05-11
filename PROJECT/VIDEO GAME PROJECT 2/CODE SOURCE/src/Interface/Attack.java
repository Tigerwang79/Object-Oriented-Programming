package Interface;

import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import Unity.Player;

public interface Attack {

	<T extends Enemy>void attackEnemy(T e, Weapon w);

	void attackPlayer(Player p);

	//Effectue une attaque aléatoire
	void aleaAttak( Player p);
}