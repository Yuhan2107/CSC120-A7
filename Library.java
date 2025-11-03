/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;
  private String status;

    /**
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
    
    /**
     * add a book into the library
     * @param title The title of the new book 
     */
    @Override
    public void addTitle(String title){
      collection.put(title, true);
    }

    /**
     * remove a book from the library
     * @param title The name of the removal book
     * @return The title of the book that's been removed
     */
    @Override
    public String removeTitle(String title){
      collection.remove(title);
      return title; // return the title that we removed
    }

    /**
     * checkout the book from the library
     * @param title The title of the book being checked out
     */
    @Override
    public void checkOut(String title){
      collection.replace(title,false);
    }

    /**
     * return a book to the library
     * @param title The returning book's title
     */
    @Override
    public void returnBook(String title){
      collection.replace(title, true);
    }

    /**
     * returns true if the title appears as a key in the Libary's collection, false otherwise
     * @param title The title of the book that is being checked
     * @return Whether the book is in the library
     */
    @Override
    public boolean containsTitle(String title){
      return collection.containsKey(title);
    }

    /**
     * returns true if the title is currently available, false otherwise
     * @param title The title of the book is being checked
     * @return The status of the book -- whether it is available now
     */
    @Override 
    public boolean isAvailable(String title){
      return collection.getOrDefault(title, false);
    }

    /**
     * prints out the entire collection in an easy-to-read way (including checkout status
     */
    @Override 
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