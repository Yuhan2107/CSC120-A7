/**
 * Represents a Library with a collection of titles and availability tracking.
 * Each title is stored with a boolean: true means available, false means checked out.
 */
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;
  private String status;

    /**
     * Constructs a Library with the given name, address, and number of floors.
     * @param name the library name
     * @param address the library address
     * @param nFloors the number of floors in the library
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      this.status = "unavailable";
      System.out.println("You have built a library: 📖");
    }
    
    /**
     * Adds a title to the library collection and marks it available.
     * @param title the title to add
     */
    @Override
    public void addTitle(String title){
      collection.put(title, true);
    }

    /**
     * Removes a title from the collection.
     * @param title the title to remove
     * @return the removed title (same as {@code title})
     */
    @Override
    public String removeTitle(String title){
      collection.remove(title);
      return title; // return the title that we removed
    }

    /**
     * Checks out the given title (marks it unavailable).
     * If the title is not present, this method does nothing.
     * @param title the title to check out
     */
    @Override
    public void checkOut(String title){
      collection.replace(title,false);
    }

    /**
     * Returns a book to the library (marks it available).
     * If the title is not present, this method does nothing.
     * @param title the title to return
     */
    @Override
    public void returnBook(String title){
      collection.replace(title, true);
    }

    /**
     * Returns true if the given title exists in the collection and is available.
     * @param title the title to check
     * @return {@code true} if the title exists and is available; {@code false} if the title is not in the collection
     * @throws IllegalArgumentException if the title exists but is currently checked out
     */
    @Override
    public boolean containsTitle(String title){
      if (collection.containsKey(title)){
        if (collection.get(title)){
          return true;
        }else{
          throw new IllegalArgumentException("This book is already checked out.");
        }
      }else{
        return false;
      }
    }

    /**
     * Returns whether the given title is currently available.
     * @param title the title to check
     * @return {@code true} if the title exists and is available; {@code false} if it is absent or checked out
     */
    @Override 
    public boolean isAvailable(String title){
      return collection.getOrDefault(title, false);
    }

    /**
     * Prints the entire collection, showing each title and its availability status.
     */
    @Override 
    public void printCollection(){
      for(String title : collection.keySet()){
        if (collection.get(title)){
          status = "available";
        }else{
          status = "checked out";
        }
        System.out.println(" - " + title + " [ " + status + " ];");
      }
    }

    /**
     * make up a library and check the methods under this class 
     */
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