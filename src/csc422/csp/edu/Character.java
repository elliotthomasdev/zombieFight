package csc422.csp.edu;

//12/4/2020
//CSC 422
//zombie war application

public abstract class Character
{
    //properties
    protected String name;
    protected String type;
    private int attackDamage;
    private boolean isAlive;
    private int currentHealth;

    //default constructor used for subtypes
    //though this class cannot instantiate
    //should be the only one needed for all
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

    @Override
    public String toString()
    {
        return getType();
    }

    public void inflictDamage(Character target)
    {
        int damage = this.getDamage();
        int targetHealth = target.getCurrentHealth();
        int newHealth = targetHealth - damage;
        target.setCurrentHealth(newHealth);
        if (newHealth < 1)
        {
            System.out.println(this.getName() + " killed " + target.getName());
        }
    }
}
