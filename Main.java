import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Player mohammed = new Player("mohammed", 10, 100);
        System.out.println(mohammed.toString());
        saveObject(mohammed);

        mohammed.setHitPoints(12);
        mohammed.setWeapon("axe");
        System.out.println(mohammed);
        saveObject(mohammed);
        loadObject(mohammed);

        ISaveable wearwolf = new Monster("wearwolf", 20, 100 );

    }
    public static ArrayList<String> readValues()
    {
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("1 - to enter a string");
        System.out.println("0 - quit");
        while(!quit)
        {
            System.out.println("choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice)
            {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("enter a string");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave)
    {
        for(int i = 0; i < objectToSave.write().size(); i++)
        {
            System.out.println("saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad)
    {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
