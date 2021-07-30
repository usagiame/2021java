import java.util.*;
public class ShipGame {
    public static final int stageSize = 5;
    private int turnNum = 0;
    private int shipNum = 3;
    private int remainingShipCnt = 0;

public void gameStart(){
    Scanner sc = new Scanner(System.in);
    System.out.println("********************");
    System.out.println("　　 戦艦ゲーム 　　　");
    System.out.println("********************");

    ship[][]stage = new ship[stageSize][stageSize];
    ship[]shipstorage=new ship[shipNum];
    for(int i = 0; i<shipNum; i++){
        ship ship = new ship();
        shipstorage[i] = ship;
        ship.placement(stage,ship);
        remainingShipCnt++;
    }

    while(remainingShipCnt>0 && turnNum < 100){
        turnNum++;
        System.out.printf("------[%dターン目]------\n",turnNum);
        for(int i = 0; i<shipNum;i++){
            if(shipstorage[i] != null){
            int sHp = shipstorage[i].getHp();
            System.out.printf("船%d:生存中(hp:%d)\n",i+1,sHp);
        }else{
            System.out.printf("船%d:沈没した\n",i+1);
        }
    }
    int bombx;
    System.out.println("爆弾のx座標を入力してください(1-5)");
    do{
        bombx = sc.nextInt();
        if(bombx < 1 || bombx > 5){
            System.out.println("1ー5の間で選択してください");
        }
    }while(bombx <= 0 || bombx >= 6);
    
    int bomby;
    System.out.println("爆弾のy座標を入力してください(1-5)");
    do{
        bomby = sc.nextInt();
        if(bomby < 1 || bomby > 5){
            System.out.println("1ー5の間で選択してください");
        }
    }while(bomby <= 0 || bomby >= 6);

    for(int i = 0; i<shipNum; i++){
        if(shipstorage[i]!= null){
            ship ship = shipstorage[i];
            int result = ship.judmentship(bombx-1,bomby-1);
            if(result == 0){
                ship.damage();
                int shipHp = ship.getHp();
                if(shipHp <= 0){
                    System.out.printf("船%d:%s\n",i+1,"沈没しました");
                    shipstorage[i] = null;
                    remainingShipCnt--;
                }else{
                    System.out.printf("船%d:%s\n",i+1,"命中したが沈まない。船が移動しました");
                    ship.move(stage,ship);
                }
            }else if(result == 1){
                System.out.printf("船%d:%s\n",i+1,"波高し");
            }else{
                System.out.printf("船%d:%s\n",i+1,"外れた");
            }
        }
    }
}
System.out.println("--------------------");
System.out.println("********************");
System.out.println("　　　ゲームクリア　　　");


System.out.println("********************");
System.out.printf("全ての船を沈没させるのに%dターンかかりました。",turnNum++);
sc.close();
}
}