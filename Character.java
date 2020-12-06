//Character.java

public class Character {

   // Character types
   protected static final String ZOMBIE = "Zombie";
   protected static final String SURVIVOR = "Survivor";

   // Variable Health or Attack 
   private String cType;
   private int health;
   private int attack;


   public Character(String cType, int health, int attack) {
       this.cType = cType;
       this.health = health;
       this.attack = attack;
   }



   public void attack(Character c) {
       // Health Equation of Attack and remaining health
       c.health = c.health - this.attack;
   }

   
   public boolean isDead() {
       return (health <= 0);
   }
}