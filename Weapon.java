package csc422.csp.edu;

import java.util.ArrayList;

public abstract class Weapon
{

    private int _weaponDamage;
    private int _percentageAccuracy;
    private String _type;

    public Weapon()
    {
        _type = this.getClass().getSimpleName();
    }

    public Weapon(int weaponDamage, int weaponAccuracyInPercent)
    {
        _type = this.getClass().getSimpleName();
        _weaponDamage = weaponDamage;
        _percentageAccuracy = weaponAccuracyInPercent;
    }

    public int getWeaponDamage()
    {
        return _weaponDamage;
    }

    public void setWeaponDamage(int _weaponDamage)
    {
        this._weaponDamage = _weaponDamage;
    }

    public int getPercentageAccuracy()
    {
        return _percentageAccuracy;
    }

    public void setPercentageAccuracy(int _percentageAccuracy)
    {
        this._percentageAccuracy = _percentageAccuracy;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String _type)
    {
        this._type = _type;
    }

    public static ArrayList<Weapon> createWeaponsCache()
    {
        ArrayList<Weapon> list = new ArrayList<>();

        int count = (int) (Math.random() * 20);
        count += 6;

        while (count >= 0)
        {
            //create a random weapon
            int type = (int) (Math.random() * 6) + 1;

            switch (type)
            {
                case 1:
                    list.add(new Shotgun());
                case 2:
                    list.add(new Submachinegun());
                    break;
                case 3:
                    list.add(new AssaultRifle());
                case 4:
                    list.add(new Pistol());
                    break;
                case 5:
                    list.add(new Axe());
                case 6:
                    list.add(new Crowbar());
                case 7:
                    list.add(new FryingPan());
                    break;
                default:
                    break;
            }
            count--;
        }
        return list;

    }

}

