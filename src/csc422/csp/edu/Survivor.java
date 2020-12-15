package csc422.csp.edu;


//12/14/2020
//CSC 422
//zombie war application

import java.util.ArrayList;

public abstract class Survivor extends Character
{

    public Survivor(int startingHealth, int damageValue, int nameCount)
    {
        super(startingHealth, damageValue, nameCount);
    }

    public static ArrayList<Character> createRandomSurvivors() throws Exception
    {
        ArrayList<Character> list = new ArrayList<>();

        //tracking for naming purposes
        int soldierCount = 0;
        int teacherCount = 0;
        int childCount = 0;

        //(min + (int) (Math.random() * ((max - min) + 1)))
        int number = (int) (Math.random() * 15);
        number += 6;

        while (number >= 0)
        {
            //create a random zombie
            int type = (int) (Math.random() * 5) + 1;

            switch (type)
            {
                //in a zombie war, adults should be more common while children are staying off the street
                //so I am upping # of soldiers and teachers
                case 1:
                case 2:
                    soldierCount++; //tracking the count for naming
                    list.add(new Soldier(100, 10, soldierCount));
                    break;
                case 3:
                case 4:
                    teacherCount++;
                    list.add(new Teacher(50, 5, teacherCount));
                    break;
                case 5:
                    childCount++;
                    list.add(new Child(20, 2, childCount));
                    break;
                default:
                    throw new Exception("not implemented");
            }
            number--;
        }
        return list;
    }
}
