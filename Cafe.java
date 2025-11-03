/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
    * Contructor of the Cafe
    * @Param name Name of Cafe
    * @param address Address of Cafe
    * @param nFloors Number of floors the Cafe has
    * @param nCoffeeOunce The initial number of coffee ounce
    * @param nSugarPacket The initial number of sugar packet
    * @param nCreams The initial quantity of cream
    * @param nCups The initial numbers of cups
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
     * subtract the gradient amount as a cup of coffee is sold out
     * @param size The ounce number of the cup of coffee that been sold
     * @param nSugarPackets The number of sugar packet this cup of coffee is comsuming
     * @param nCreams The amount of cream this cup of coffee is consuming
     */
    @Override 
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
    }

    /**
     * this method is to restock the ingredients and cups
     * @param nCoffeeOunce New number of coffee ounce
     * @param nSugarPacket New number of sugar packet
     * @param nCreams New quantity of cream
     * @param nCups New numbers of cups
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
        System.out.println("Ingradients left: ");
        System.out.println("Coffee: " + compass.nCoffeeOunces);
        System.out.println("Sugar: " + compass.nSugarPackets);
        System.out.println("Creams: " + compass.nCreams);
    }
    
}
