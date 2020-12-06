//Zombie.java

public class Zombie extends Character {
   
   // Zombie types
   protected static final String COMMON_INFECTED = "CommonInfected";
   protected static final String TANK = "Tank";
   
   // ariables
   private String zType;
   

   public Zombie(String zType, int health, int attack) {
       super(Character.ZOMBIE, health, attack);
      
       // Set zombie type
       this.zType = zType;
   }
   
   
   @Override
   public String toString() {
       return zType;
   }
}

