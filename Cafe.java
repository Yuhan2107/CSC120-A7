/**
 * Represents a Cafe building that tracks simple inventory (coffee ounces, sugar packets,
 * creams, and cups) and can sell coffee when inventory is sufficient.
 */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
    * Constructs the Cafe with initial inventory quantities.
    * @param name the name of the Cafe
    * @param address the address of the Cafe
    * @param nFloors the number of floors the Cafe has
    * @param nCoffeeOunces the initial number of coffee ounces
    * @param nSugarPackets the initial number of sugar packets
    * @param nCreams the initial quantity of creams (splashes)
    * @param nCups the initial number of cups
    */    
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Processes the sale of a cup of coffee and decrements inventory if there is sufficient stock.
     * If any required ingredient is missing or insufficient, no inventory is changed and a message is printed.
     * @param size the cup size in ounces
     * @param nSugarPackets the number of sugar packets used
     * @param nCreams the number of cream splashes used
     */
    @Override 
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams && this.nCups > 0){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups--;
        }else{
            System.out.println("The recent stock is not enough to make this cup of coffee, please restock the inventory first.");
        }
        
    }

    /**
     * Restocks inventory quantities.
     * @param nCoffeeOunces new number of coffee ounces
     * @param nSugarPackets new number of sugar packets
     * @param nCreams new quantity of cream
     * @param nCups new number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * make up a cafe building and sell a coffee to check the previous methods
     */
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "7 Neilson Drive", 2, 1000, 100, 100, 100);
        compass.sellCoffee(16, 2, 3);
        System.out.println("Ingredients left: ");
        System.out.println("Coffee: " + compass.nCoffeeOunces);
        System.out.println("Sugar: " + compass.nSugarPackets);
        System.out.println("Creams: " + compass.nCreams);
    }
    
}
