/**
 * Created by Danny on 11/25/2017.
 */
import java.util.Random;
public class Area {
    private String name;
    private String description;
    private int monster;
    private int table;
    private int code;
    private static int monstersSlain;
    Area(String n, String d, int m, int t, int c, int s){
        name = n;
        description = d;
        monster = m; // total amount of monsters in area
        table = t; // what monster table to use
        code = c;
        monstersSlain = 0;
    }
    Area(String n, String d, int m, int t, int c){
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
        System.out.println("You have entered a new area: " + a.name + "(MonsterTable " + a.table +")");
        System.out.println(a.description);
        System.out.println("There are " + a.monster +" monsters in this area.");
        while(a.monstersSlain<=a.monster){ // checking if player hasn't killed all monsters in the area
            if(a.table == 1){
                Random rand = new Random();
                int r = rand.nextInt(2);
                if(r==0){
                    Monster.encounter(Game.rat, a);
                    ++a.monstersSlain;
                }else if(r==1){
                    Monster.encounter(Game.bat, a);
                    ++a.monstersSlain;
                }
            }else if(a.table == 2){
                Random rand = new Random();
                int r = rand.nextInt(2);
                if(r==0){
                    Monster.encounter(Game.slime, a);
                    ++a.monstersSlain;
                }else if(r==1){
                    Monster.encounter(Game.rat, a);
                    ++a.monstersSlain;
                }else if(r == 2){
                    Monster.encounter(Game.bat, a);
                }
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
}
