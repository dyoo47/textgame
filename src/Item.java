/**
 * Created by Danny on 11/22/2017.
 */
public class Item {
    private String name;
    private int id;
    private double atk;
    Item(String n, int i, double a){
        name = n;
        id = i;
        atk = a;
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
