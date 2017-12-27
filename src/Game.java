/**
 * Created by Danny on 11/22/2017.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    //player stats
    private static double atk = 5.0;
    private static double health = 100.00;
    private static int points = 0;
    private static String name = "";
    private static double mana = 100.00;
    private static int area = 1;
    //Item(String n, int i, double a)
    static public Item blank = new Item("---", 0, 0);
    static public Item claw = new Item("CLAW", 1, 2);
    static public Item wing = new Item("BATWING", 2, 5);
    static public Item grease = new Item("GREASE", 3, 4);
    static public Item healthSerum = new Item("HEALTH SERUM", 4, 6, 1);
    static public Item manaSerum = new Item("MANA SERUM", 5, 6, 2);

    static public Spell blankSpell = new Spell("---", 0, 0, 0);
    static public Spell heal = new Spell("HEAL", 1, 10, 10);
    static public Spell fireball = new Spell("FIREBALL", 2, 20, 25);
    static public Spell greaterHeal = new Spell("GREATER HEAL", 1, 30, 15);
    static public Spell vortex = new Spell("VORTEX", 2, 60, 60);
    //Monster(String n, int v, double h, double m, double a, Item i)
    static public Monster rat = new Monster("RAT", 10, 3, 0, 3, claw);
    static public Monster bat = new Monster("BAT", 20, 7, 0, 2, wing);
    static public Monster slime = new Monster("SLIME", 25, 10, 0, 6, grease);
    static public Monster elite = new Monster("ELITE", 40, 30, 0, 12, claw);
    static public Monster mimic = new Monster("MIMIC", 1, 5, 10, 50);
    static public Monster lakeBoss = new Monster("LAKE BOSS", 100, 100, 20, 15, healthSerum);
    static public Monster desertBoss = new Monster("DESERT BOSS", 100, 120, 60, 20, manaSerum);

    static public MonsterTable mt1 = new MonsterTable(rat, bat);
    static public MonsterTable mt2 = new MonsterTable(rat, bat, slime);
    static public MonsterTable mt3 = new MonsterTable(elite);
    static public MonsterTable mt4 = new MonsterTable(slime, mimic);
    static public MonsterTable mt5 = new MonsterTable(lakeBoss);
    static public MonsterTable mt6 = new MonsterTable(desertBoss);
    //Area(String n, String d, int m, int t, int c)
    static public Area start = new Area("START", "You are in the starting location.", 10, mt1, 1, 0);
    static public Area sewer = new Area("SEWER", "You are in the sewer. Brackish water fills every crevice in your sight.", 5, mt2, 2);
    static public Area sewerRoom = new Area("SEWER ROOM", "You enter a small room separated from the main passage.", 1, mt3, 3);
    static public Area underground = new Area("UNDERGROUND", "The walls expand as you slowly make your descent. You are below the sewers, surrounded by rock.", 10, mt4, 4);
    static public Area tunnel = new Area("TUNNEL", "You enter a dark tunnel that splits off from the main path.", 5, mt4, 5);
    static public Area tunnelRoom = new Area("TUNNEL ROOM", "You enter a small room separated from the main passage.", 1, mt3, 6);
    static public Area lake = new Area("LAKE", "The surrounding walls slope away dramatically, exposing an enormous cavern. A lake can be seen in the center of it.", 10, mt5, 7);
    static public Area shop = new Area("SHOP", "", 1, mt3, 8);
    static public Area desert = new Area("DESERT", "", 10, mt6, 9);

    static public ArrayList<Item> inventory = new ArrayList<>(5);
    static public ArrayList<Spell> spellInventory = new ArrayList<>(5);
    static public int turn = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        inventory.add(0, blank);
        inventory.add(1, blank);
        inventory.add(2, blank);
        inventory.add(3, blank);
        inventory.add(4, blank);
        spellInventory.add(0, blankSpell);
        spellInventory.add(1, blankSpell);
        spellInventory.add(2, blankSpell);
        spellInventory.add(3, blankSpell);
        spellInventory.add(4, blankSpell);


        //script start
        System.out.println("Welcome to the dungeon, adventurer. What is your name?");
        name = input.nextLine();
        displayI();
        System.out.println(name + "? That's a strange name. Anyways, your journey starts now. Hopefully you are well prepared.");
        display();
        spellInventory.add(0, fireball);
        addSpell(heal);
        Area.encounter(start);
        Area.encounter(sewer);
        Monster.encounter(elite, sewer);
        choice(sewer, sewerRoom);

        //script end
    }
    static void display(){
        System.out.println("---" + name + "'s STATS---");
        System.out.println("POINTS: " + points);
        System.out.println("HEALTH: " + health);
        System.out.println("MANA: " + mana);
        System.out.println("ATK: " + atk);
        System.out.println("AREA: " + area);
    }
    static void displayI(){
        System.out.println("---" + name + "'s INVENTORY---");
        System.out.println("SLOT1: " + (inventory.get(0)).getName());
        System.out.println("SLOT2: " + (inventory.get(1)).getName());
        System.out.println("SLOT3: " + (inventory.get(2)).getName());
        System.out.println("SLOT4: " + (inventory.get(3)).getName());
        System.out.println("SLOT5: " + (inventory.get(4)).getName());
    }
    static void displayS(){
        System.out.println("---" + name + "'s SPELLS---");
        System.out.println("SPELL1: " + (spellInventory.get(0)).getName());
        System.out.println("SPELL2: " + (spellInventory.get(1)).getName());
        System.out.println("SPELL3: " + (spellInventory.get(2)).getName());
        System.out.println("SPELL4: " + (spellInventory.get(3)).getName());
        System.out.println("SPELL5: " + (spellInventory.get(4)).getName());
    }
    static int getEmptySlots(ArrayList<Item> b){
        int numberOfEmptySlots = 0;
        for(int i = 0; i<b.size(); ++i){
            if((b.get(i)).getName().equals("---")){
                ++numberOfEmptySlots;
            }
        }
        return numberOfEmptySlots;
    }
    static void choice(Area area1, Area area2){
        System.out.println("You have come to a fork in the road. Choose a path. " + Area.getName(area1) + "[a] or " + Area.getName(area2) + "[b]");
        Scanner input = new Scanner(System.in);
        String response = input.nextLine();
        if(response.equals("a")){
            Area.encounter(area1);
        }else if(response.equals("b")){
            Area.encounter(area2);
        }
    }
    static void addTurn(){
        turn = turn + 1;
    }
    static void addAtk(double d){
        atk = atk + d;
    }
    static void addPoint(int p){
        points = points + p;
    }
    static void addItem(Item i){
        inventory.remove(4);
        inventory.add(0, i);
    }
    static void removeItem(int i){
        inventory.remove(i);
        inventory.add(4, blank);
    }
    static void addHealth(double d){
        health = health +d;
        if(health > 100){
            health = 100;
        }
    }
    static double getAtk(){
        return atk;
    }
    static void setAtk(double d){
        atk = d;
        if(atk > 99){
            atk = 99;
        }
    }
    static void setMana(double d){
        mana = d;
    }
    static double getMana(){
        return mana;
    }
    static void setArea(int a){
        area = a;
    }
    static void addSpell(Spell spell){
        spellInventory.remove(4);
        spellInventory.add(0, spell);
    }
    static double getHealth(){
        return health;
    }
    static void displayEnd(String m){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(name + " was killed by " + m);
        System.out.println("Stats at time of death:");
        display();
        System.out.println("Inventory at time of death:");
        displayI();
        System.out.println("Spells at time of death:");
        displayS();
        System.out.println("");
        System.out.println("OVERALL SCORE: " + points + " points");
        System.out.println("");
        System.out.println("Rest in peace " + name + ".");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        System.exit(0);
    }
}
