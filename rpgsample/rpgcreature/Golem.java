package rpgcreature;

import java.util.Random;

public class Golem extends Monster{
    public Golem(){
        super("ごーれむ",100);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        
        Random r = new Random();
        int damage = 0;
        if( r.nextInt(100) < 5){
            System.out.printf("%sクリティカルヒット\n",getName());
            damage = r.nextInt(30);
        }else{
            System.out.printf("%sの攻撃！\n",getName());
            damage = r.nextInt(5)+5;
        }
        opponent.damaged(damage);
        
        displayMessage(opponent,damage);
        
    }
}
 

