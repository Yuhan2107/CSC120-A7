/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /**
   * constructor for the House
   * @param name Name of the house
   * @param adress Adress of the house
   * @param nFloors Number of floors the house has
   * @param hasDiningRoom Whether the house has dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * return whether the house has dining room
   * @return Whether the house has dining room
   */
  @Override
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  } 

  /**
   * return the number of residents in this house
   * @return The number of residents in this house
   */
  @Override
  public int nResidents(){
    return residents.size();
  }

  /**
   * add a new student into the arraylist as the student moves into the house
   * @param s The new student that moves in
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
   * delete the student from the arraylist when the students moves out
   * @param s The students moving out
   */
  @Override
  public Student moveOut(Student s){
    if(!residents.contains(s)){
      System.out.println("This student is not in this house originally.");
    }else{
      residents.remove(s);
    }
    return s; // return the Student who moved out
  }
  
  /**
   * check whether the student is living in this house
   * @param s The students checking
   * @return whether the student is living in this house (contains in the arraylist)
   */
  @Override
  public boolean isResident(Student s){
    return residents.contains(s);
  }
  
  /**
   * make up a house and a students to check methods written above
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