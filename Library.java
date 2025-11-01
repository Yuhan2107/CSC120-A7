/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;
  private String status;

    /*
     * constructor of the library
     * @param name Name of library
     * @param address Address of library
     * @param nFloors Number of floors in the library
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      String status = "unavailable";
      System.out.println("You have built a library: 📖");
    }
    
    @Override
    public void addTitle(String title){
      collection.put(title, true);
    }

    @Override
    public String removeTitle(String title){
      collection.remove(title);
      return title; // return the title that we removed
    }

    @Override
    public void checkOut(String title){
      collection.replace(title,false);
    }

    @Override
    public void returnBook(String title){
      collection.replace(title, true);
    }

    @Override// returns true if the title appears as a key in the Libary's collection, false otherwise
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    @Override // returns true if the title is currently available, false otherwise
    public boolean isAvailable(String title){
      return collection.getOrDefault(title, false);
    }

    @Override // prints out the entire collection in an easy-to-read way (including checkout status
    public void printCollection(){
      for(String title : collection.keySet()){
        if (collection.get(title)){
          status = "available";
        }else{
          status = "chacked out";
        }
        System.out.println(" - " + title + " [ " + status + " ];");
      }
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4);
      neilson.addTitle("Harry Potter");
      neilson.addTitle("To Kill a Mocking Bird");
      neilson.printCollection();
      neilson.checkOut("Harry Potter");
      System.out.println("After checked out Harry Potter:");
      neilson.printCollection();
    }
}