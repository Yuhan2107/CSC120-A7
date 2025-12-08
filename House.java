/**
 * Represents a House building that can track student residents and whether it has a dining room.
 */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /**
   * Constructs a House.
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors the house has
   * @param hasDiningRoom whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Returns whether this house has a dining room.
   * @return {@code true} if this house has a dining room; {@code false} otherwise
   */
  @Override
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  } 

  /**
   * Returns the number of current residents in this house.
   * @return the number of residents
   */
  @Override
  public int nResidents(){
    return residents.size();
  }

  /**
   * Adds a student to this house's residents list.
   * @param s the student who moves in
   */
  @Override
  public void moveIn(Student s){
    if (residents.contains(s)){
      System.out.println("This student is already in this house.");
    }else{
      residents.add(s);
    }
  }

  /**
   * Removes the student from this house when they move out.
   * @param s the student moving out
   * @return the student who moved out
   * @throws IllegalArgumentException if the student is not a resident of this house
   */
  @Override
  public Student moveOut(Student s){
    if (!residents.contains(s)) {
      throw new IllegalArgumentException("This student is not in this house.");
    }
    residents.remove(s);
    return s; // return the Student who moved out
  }
  
  /**
   * Checks whether the given student is a resident of this house.
   * @param s the student to check
   * @return {@code true} if the student is a resident; {@code false} otherwise
   */
  @Override
  public boolean isResident(Student s){
    return residents.contains(s);
  }
  
  /**
   * Simple smoke test for `House` methods.
   */
  public static void main(String[] args) {
    House haven = new House("haven", "110ElmSt", 3, false);
    Student maggie = new Student("maggie", "1024", 2029);
    haven.moveIn(maggie);
    System.out.println(haven.getName() + " has " + haven.nResidents() + " residents.");
    System.out.println(haven.getName() + " has dining room: " + haven.hasDiningRoom());
    haven.moveOut(maggie);
    System.out.println(haven.getName() + " has " + haven.nResidents() + " residents.");
  }

}