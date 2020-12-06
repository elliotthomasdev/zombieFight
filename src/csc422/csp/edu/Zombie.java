package csc422.csp.edu;
import java.util.ArrayList;

// 12/6/2020
// CSC 422
// zombie war application

public abstract class Zombie extends Character
{

    public Zombie(int startingHealth, int damageValue, int nameCount)
    {
        super(startingHealth, damageValue, nameCount);
    }

    public static ArrayList<Character> createRandomZombies() throws Exception
    {
        ArrayList<Character> list = new ArrayList<>();

        //second version of this is specifying that the characters have names like Tank 02.
        //tracking counts in order to append names
        int tankCount = 0;
        int commonInfectCount = 0;

        //(min + (int) (Math.random() * ((max - min) + 1)))
        int number = (int) (Math.random() * 13);
        number += 3;

        while (number >= 0)
        {
            //create a random zombie
            int type = (int) (Math.random() * 3) + 1;

            switch (type)
            {
                //seems like tanks should be more rare and "common" infects more common
                //adjusted generation numbers
                case 1:
                    //increment tank count for naming
                    tankCount++;
                    list.add(new Tank(150, 20, tankCount));
                    break;
                case 2:
                case 3:
                    commonInfectCount++;
                    list.add(new CommonInfect(30, 5, commonInfectCount));
                    break;
                default:
                    throw new Exception("not implemented");
            }
            number--;
        }
        return list;
    }
}











