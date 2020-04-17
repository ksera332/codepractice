package exday4;

public class SampleClassEx402 {

    public static void main(String[] args){
        Tank t = new Tank();
        System.out.println(t.getName() + "武器の名前" + Tank.Weapon_name);
        System.out.println(t.getName() + "武器のタイプ" + Tank.TYPE_NAME);
        System.out.println();
        t.attack();
    }
}