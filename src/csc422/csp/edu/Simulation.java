package csc422.csp.edu;

import java.util.ArrayList;

// 12/6/2020
// CSC 422
// zombie war application

public class Simulation
{

    private ArrayList<Character> zombies;
    private ArrayList<Character> survivors;
    private String survivalReport = null;

    public void runCombatSimulation() throws Exception
    {
        initializeCombatants();

        //tallies for string output
        int tanks = 0;
        int commoninfects = 0;
        int soldiers = 0;
        int teachers = 0;
        int children = 0;

        for (Character zombie : zombies)
        {
            String test = zombie.getType();
            if (test.equals("Tank"))
            {
                tanks++;
            }
            else if (zombie.getType().equals( "CommonInfect"))
            {
                commoninfects++;
            }
        }

        for (Character survivor : survivors)
        {
            switch (survivor.getType()) {
                case "Soldier":
                    soldiers++;
                    break;
                case "Teacher":
                    teachers++;
                    break;
                case "Child":
                    children++;
                    break;
            }
        }

        System.out.println(
                "We have " + survivors.size() + " survivors trying to make it to safety (" + children + " children, " + teachers + " teachers, " + soldiers + " soldiers)");

        System.out.println(
                "But there are " + zombies.size() + " zombies waiting for them (" + commoninfects + " common infected, " + tanks + " tanks)");

        fightZombiesVersusSurvivors(survivors, zombies);

    }

    private void initializeCombatants() throws Exception
    {
        zombies = Zombie.createRandomZombies();
        survivors = Survivor.createRandomSurvivors();
    }

    private void fightZombiesVersusSurvivors(ArrayList<Character> team1, ArrayList<Character> team2)
    {
        survivalReport = "";
        boolean team2IsStillAlive = false;

        for (Character attacker : team1) //foreach loop, also need logic to check if attacker is alive before they attack
        {
            if (attacker.getIsAlive())
            {
                for (Character defender : team2) //foreach loop
                {
                    if (defender.getIsAlive())//true
                    {
                        //injure the defender
                        attacker.inflictDamage(defender); //then the defender calculates if the damage they just took was enough to kill them
                    }
                }
            }
        }
        //test at the end of the attacking side turn - check if all defenders are dead
        for (Character defender : team2)
        {
            if (defender.getIsAlive())
            {
                team2IsStillAlive = true;
                break;
            }
        }

        if (team2IsStillAlive)
        {
            fightZombiesVersusSurvivors(team2, team1);
        }
        else
        {
            generateSurvivalReport();
        }

    }

    public void generateSurvivalReport()
    {
        int survivorsTotal = 0;
        for (Character survivor : survivors)
        {
            if (survivor.getIsAlive())
            {
                survivorsTotal++;
            }
        }

        int zombieTotal = 0;
        for (Character zombie : zombies)
        {
            if (zombie.getIsAlive())
            {
                zombieTotal++;
            }
        }

        if (survivorsTotal > zombieTotal)
        {
            System.out.println(survivorsTotal + " survivors have made it to safety.");
        }
        else
        {
            System.out.println("None of the survivors have made it.");
        }
    }

}
