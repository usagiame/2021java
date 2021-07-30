import java.util.*;

public class ship {
    private int x;
    private int y;
    private int hp;


public ship(){
    Random x = new Random();
    this.x = x.nextInt(5);
    Random y = new Random();
    this.y = y.nextInt(5);
    this.hp = 2;
}

public int getX(){
    return x;
}
public int getY(){
    return y;
}
public int getHp(){ 
return hp;
}

public void placement(ship[][] stage,ship ship){
    boolean endFlag = false;
    int cnt = 0;
    while(endFlag == false && cnt < 99){
        Random x = new Random();
        this.x = x.nextInt(4);
        Random y = new Random();
        this.y = y.nextInt(4);
        if(stage[this.x][this.y] == null){
            stage[this.x][this.y] = ship;
            //System.out.printf("%d,%d\n",this.x+1,this.y+1);
            endFlag = true;
        }
        cnt++;
    }
}

public int judmentship(int bombx,int bomby){
    if(bombx == x && bomby == y){
        return 0;
    }
    int[] shipsideNear = {x-1,x+1};
    int[] shipVerticalNear = {y-1,y+1};
    boolean flag = false;
    for(int i=0; i<2; i++){
        if(shipsideNear[i] == bombx && y == bomby){
            flag = true;
        }if(shipVerticalNear[i] == bomby && x == bombx){
            flag = true;
        }
    }
    if(flag == true){
        return 1;
    }else{
        return 2;
    }
}

public void move(ship[][] stage,ship ship){
    stage[this.x][this.y] = null;
    boolean endFlag = false;
    int cnt = 0;
    while(endFlag == false && cnt < 99){
        Random x = new Random();
        this.x = x.nextInt(5);
        if(stage[this.x][this.y] == null){
            stage[this.x][this.y] = ship;
            //System.out.printf("%d,%d\n",this.x+1,this.y+1);
            endFlag = true;
        }
        cnt++;
    }
}

public void damage(){
    hp--;
}
}