/**
 * Created by Danny on 11/22/2017.
 */
import java.util.Scanner;
public class Monster {
    private String name, currentMonster;
    private int value;
    private double health, mana, atk;
    private Item drop;

    Monster(String n, int v, double h, double m, double a, Item i){
        name = n;
        value = v;
        health = h;
        mana = m;
        atk = a;
        drop = i;

    }
    Monster(String n, int v, double h, double m, double a){
        name = n;
        value = v;
        health = h;
        mana = m;
        atk = a;
        drop = Game.blank;
    }
    static void display(Monster m){
        System.out.println("A " + m.name + " approaches.");
        System.out.println("---" + m.name + "'s STATS---");
        System.out.println("VALUE: " + m.value);
        System.out.println("HEALTH: " + m.health);
        System.out.println("MANA: " + m.mana);
        System.out.println("ATK: " + m.atk);
    }
    static void display(Monster m, double h, double ma, double a){
        System.out.println("---" + m.name + "'s STATS---");
        System.out.println("VALUE: " + m.value);
        System.out.println("HEALTH: " + h);
        System.out.println("MANA: " + ma);
        System.out.println("ATK: " + a);
    }

    static void encounter(Monster m, Area area){
        display(m);
        int v = m.value;
        double h = m.health;
        double ma = m.mana;
        double a = m.atk;
        Scanner input = new Scanner(System.in);
        while(h>0){
            Game.addTurn();
            System.out.println("What will you do? ATTACK[a] ESCAPE[e] INVENTORY[i] Turn: " + Game.turn);
            String response = input.nextLine();
            if(response.equals("a")){
                h = h - Game.getAtk();
                System.out.println("You hit the " + m.name + " for " + Game.getAtk() + " damage.");
                Game.addHealth(-m.atk);
                System.out.println("The " + m.name + " hits you for " + a + " damage.");
                display(m, h, ma, a);
                Game.display();
                if(h <= 0){
                    Game.addPoint(v);
                    System.out.println("The " + m.name + " was slain.");
                    //add to a.monstersSlain
                    Area.setSlain(Area.getSlain(area) +1, area);
                    System.out.println("A " + m.drop.getName() + " was dropped. Would you like to pick it up? You currently have " + (5 - Game.getEmptySlots(Game.inventory)) + "/5 items. YES[y] NO[n]");
                    response = input.nextLine();
                    if(response.equals("y")){
                        Game.addItem(m.drop);
                        System.out.println("You picked up the " + m.drop.getName() + ".");
                    }else{
                        System.out.println("You didn't pick up the " + m.drop.getName() + ".");
                    }
                }
            }else if(response.equals("e")){
                Game.addHealth(-3*m.atk);
                System.out.println("You escaped, but got hit in the process.");
                Game.display();
                break;
            }else if(response.equals("i")){
                Game.displayI();
                System.out.println("Use an ITEM? SLOT[1,2,3,4,5] BACK[b]");
                String r = input.nextLine();
                if(r.length()==1 && Integer.parseInt(r)>0 && Integer.parseInt(r)<6){
                    Game.addAtk((Game.inventory.get(Integer.parseInt(r) - 1)).getAtk());
                    System.out.println("You used the " + (Game.inventory.get(Integer.parseInt(r)-1).getName()) + ".");
                    Game.removeItem(Integer.parseInt(r)-1);

                }else{
                    System.out.println("You did not use an item.");
                }
            }
        }
    }
    static double mStatDouble(Monster m, String i){
        if(i.equals("h"))
            return m.health;
        else if(i.equals("m"))
            return m.mana;
        else if(i.equals("a"))
            return m.atk;
        else
            return 0;
    }
    static String mStatString(Monster m){
        return m.name;
    }
    static int mStatInt(Monster m){
        return m.value;
    }
}
