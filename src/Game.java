/**
 * Created by Danny on 11/22/2017.
 */
import java.util.Scanner;
import java.util.Random;
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
    static public Item healthSerum = new Item("HEALTH SERUM", 4, 6);
    static public Item manaSerum = new Item("MANA SERUM", 5, 6);
    //Monster(String n, int v, double h, double m, double a, Item i)
    static public Monster rat = new Monster("RAT", 10, 3, 0, 3, claw);
    static public Monster bat = new Monster("BAT", 20, 7, 0, 2, wing);
    static public Monster slime = new Monster("SLIME", 25, 10, 0, 6, grease);
    static public Monster elite = new Monster("ELITE", 40, 30, 0, 12, claw);
    static public Monster mimic = new Monster("MIMIC", 1, 5, 10, 50);
    static public Monster lakeBoss = new Monster("LAKE BOSS", 100, 100, 20, 15);
    //Area(String n, String d, int m, int t, int c)
    static public Area start = new Area("START", "You are in the starting location.", 10, 1, 1, 0);
    static public Area sewer = new Area("SEWER", "You are in the sewer. Brackish water fills every crevice in your sight.", 5, 2, 2);
    static public Area sewerRoom = new Area("SRWER ROOM", "You enter a small room separated from the main passage.", 1, 3, 3);
    static public Area underground = new Area("UNDERGROUND", "The walls expand as you slowly make your descent. You are below the sewers, surrounded by rock.", 10, 4, 4);
    static public Area tunnel = new Area("TUNNEL", "You enter a dark tunnel that splits off from the main path.", 5, 4, 5);
    static public Area tunnelRoom = new Area("TUNNEL ROOM", "You enter a small room separated from the main passage.", 1, 3, 6);
    static public Area lake = new Area("LAKE", "The surrounding walls slope away dramatically, exposing an enormous cavern. A lake can be seen in the center of it.", 10, 5, 7);

    static public ArrayList<Item> inventory = new ArrayList<>(5);
    static public int turn = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        inventory.add(0, blank);
        inventory.add(1, blank);
        inventory.add(2, blank);
        inventory.add(3, blank);
        inventory.add(4, blank);

        //script start
        System.out.println("Welcome to the dungeon, adventurer. What is your name?");
        name = input.nextLine();
        displayI();
        System.out.println(name + "? That's a strange name. Anyways, your journey starts now. Hopefully you are well prepared.");
        display();
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
    }
    static double getAtk(){
        return atk;
    }
    static void setAtk(double d){
        atk = d;
    }
    static void setArea(int a){
        area = a;
    }
}
