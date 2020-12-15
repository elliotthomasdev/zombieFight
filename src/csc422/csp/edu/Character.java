package csc422.csp.edu;

//12/15/2020 
//CSC 422 
//zombie war application
//Release 3 candidate update

public abstract class Character
{

    //properties
    protected String name;
    protected String type;
    private int attackDamage;
    private boolean isAlive;
    private int currentHealth;
    private Weapon equippedWeapon;

    public Character(int startingHealth, int damageValue, int nameCount)
    {
        currentHealth = startingHealth;
        attackDamage = damageValue;
        type = this.getClass().getSimpleName();

        String temp = type;
        temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
        temp += " ";
        //append string formatted name
        temp += String.format("%02d", nameCount);
        name = temp;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getCurrentHealth()
    {
        return currentHealth;
    }

    public void setCurrentHealth(int newHealth)
    {
        this.currentHealth = newHealth;
    }

    public int getDamage()
    {
        return attackDamage;
    }

    public void setDamage(int damage)
    {
        this.attackDamage = damage;
    }

    public boolean getIsAlive()
    {
        return currentHealth > 0;
    }
    
    public Weapon getEquippedWeapon()
    {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon)
    {
        this.equippedWeapon = equippedWeapon;
    }


    @Override
    public String toString()
    {
        return getType();
    }

    public void inflictDamage(Character target)
    {
        //character hand to hand damage
        int damage = this.getDamage();

        //opponent health
        int targetHealth = target.getCurrentHealth();

        //if character has a weapon, use that damage instead unless it is less
        //also requires comparison to see if it hits
        boolean hasWeapon = equippedWeapon != null;

        if (hasWeapon)
        {
            //generate a percent chance to hit 
            int hitRoll = (int) (Math.random() * 99);
            hitRoll += 1;

            //check if weapon hits
            //set damage based on: if weapon hits, if weapon is better than HtH value
            if (hitRoll <= equippedWeapon.getPercentageAccuracy())
            {
                damage = (equippedWeapon.getWeaponDamage() > this.getDamage()) ? equippedWeapon.getWeaponDamage() : this.getDamage();
            }
            else
            {
                //System.out.println("Weapon missed");
                damage = 0;
            }
        }

        //damage
        int newHealth = targetHealth - damage;
        target.setCurrentHealth(newHealth);

        if (newHealth < 1)
        {
            if (this.equippedWeapon != null)
            {
                System.out.println(this.getName() + " killed " + target.getName() + " using a " + equippedWeapon.getType() + ".");
            }
            else
            {
                System.out.println(this.getName() + " killed " + target.getName());
            }
        }
    }


}
