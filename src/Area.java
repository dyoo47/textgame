/**
 * Created by Danny on 11/25/2017.
 */
import java.util.Random;
public class Area {
    private String name;
    private String description;
    private int monster;
    private MonsterTable table;
    private int code;
    private static int monstersSlain;
    Area(String n, String d, int m, MonsterTable t, int c, int s){
        name = n;
        description = d;
        monster = m; // total amount of monsters in area
        table = t; // what monster table to use
        code = c;
        monstersSlain = 0;
    }
    Area(String n, String d, int m, MonsterTable t, int c){
        name = n;
        description = d;
        monster = m; // total amount of monsters in area
        table = t; // what monster table to use
        code = c;
        monstersSlain = 0;
    }
    static void encounter(Area a){
        a.monstersSlain = 0;
        Game.setArea(a.code);
        System.out.println("You have entered a new area: " + a.name + "(" + a.table +")");
        System.out.println(a.description);
        System.out.println("There are " + a.monster +" monsters in this area.");
        while(a.monstersSlain<=a.monster){ // checking if player hasn't killed all monsters in the area
            Random rand = new Random();
            int r = rand.nextInt(a.table.total);
            System.out.println("Rolled a " + r);
            if(r == 0){
                Monster.encounter(a.table.monster, a);
            }else if(r == 1){
                Monster.encounter(a.table.monster2, a);
            }else if(r == 2){
                Monster.encounter(a.table.monster3, a);
            }
        }
        /*if(a.table == 1){
            Random rand = new Random();
            int r = rand.nextInt(2);
            if(r==0){
                Monster.encounter(Game.rat);
            }else if(r==1){
                Monster.encounter(Game.bat);
            }
        }*/
    }
    static void setSlain(int i, Area a){
        a.monstersSlain = i;
    }
    static int getSlain(Area a){
        return a.monstersSlain;
    }
    static String getName(Area a){
        return a.name;
    }
}
