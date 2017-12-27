public class MonsterTable {

    public int total;
    public Monster monster;
    public Monster monster2;
    public Monster monster3;
    public Monster monster4;
    public Monster monster5;
    public Monster monster6;

    MonsterTable(Monster m){
        total = 1;
        monster = m;
    }
    MonsterTable(Monster m, Monster m2){
        total = 2;
        monster = m;
        monster2 = m2;
    }
    MonsterTable(Monster m, Monster m2, Monster m3){
        total = 3;
        monster = m;
        monster2 = m2;
        monster3 = m3;
    }
    MonsterTable(Monster m, Monster m2, Monster m3, Monster m4){
        total = 4;
        monster = m;
        monster2 = m2;
        monster3 = m3;
        monster4 = m4;
    }
    MonsterTable(Monster m, Monster m2, Monster m3, Monster m4, Monster m5){
        total = 5;
        monster = m;
        monster2 = m2;
        monster3 = m3;
        monster4 = m4;
        monster5 = m5;
    }
    MonsterTable(Monster m, Monster m2, Monster m3, Monster m4, Monster m5, Monster m6){
        total = 6;
        monster = m;
        monster2 = m2;
        monster3 = m3;
        monster4 = m4;
        monster5 = m5;
        monster6 = m6;
    }
}
