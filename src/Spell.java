import java.util.Scanner;

public class Spell {
    private String name;
    private int type;
    private double amount;
    private int cost;
    Spell(String n, int t, double a, int c){
        name = n;
        type = t;
        amount = a;
        cost = c;
    }
    String getName(){
        return name;
    }
    int getType(){
        return type;
    }
    double getAmount(){
        return amount;
    }
    int getCost(){
        return cost;
    }
}
