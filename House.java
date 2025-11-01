/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /*
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

  @Override
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  } 

  @Override
  public int nResidents(){
    return residents.size();
  }

  @Override
  public void moveIn(Student s){
    residents.add(s);
  }

  @Override
  public Student moveOut(Student s){
    residents.remove(s);
    return s; // return the Student who moved out
  }
   
  @Override
  public boolean isResident(Student s){
    return residents.contains(s);
  }
    
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