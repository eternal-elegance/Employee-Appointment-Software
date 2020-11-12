package TeacherAppointmentJava;

class OfficeStaff extends Employee implements GetternSetters {

  String designation;

  OfficeStaff(String name, String id, String designation) {
    super(name, id);
    this.designation = designation;
  }

  /* G E T T E R A N D S E T T E R FUNCTIONS */

  public void setName(String s) {
    this.name = s;
  }

  public String getName() {
    return this.name;
  }

  public void setID(String id) {
    this.id = id;
  }

  public String getID() {
    return this.id;
  }

  public void setCollegeName(String name) {
    this.collegeName = name;
  }

  public String getCollegeName() {
    return collegeName;
  }
  public String getDesignation(){
    return this.designation;
  }

  /* Inherired from employee class */
  void service() {
    System.out.println("Doing some work");
  }

}