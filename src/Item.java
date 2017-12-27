/**
 * Created by Danny on 11/22/2017.
 */
public class Item {
    private String name;
    private int id;
    private double atk;
    private int type;
    Item(String n, int i, double a){
        name = n;
        id = i;
        atk = a;
    }
    Item(String n, int i, double a, int t){
        name = n;
        id = i;
        atk = a;
        type = t;
    }
    int getID(){
        return id;
    }
    String getName(){
        return name;
    }
    double getAtk(){
        return atk;
    }
}
