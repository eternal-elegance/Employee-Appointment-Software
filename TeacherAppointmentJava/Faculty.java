package TeacherAppointmentJava;

public class Faculty extends Employee implements GetternSetters {

  /* Class variables */
  String department;

  Faculty(String name, String id, String department) {
    super(name, id);
    this.department = department;
  }

  /* GE TT ER AND SE TT ERS */

  public void setName(String name) {
    this.name = name; // assigned to the local inherited copy
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

  /* public void setCollegeName(String s) {
    this.collegeName = s;

  } */

  public String getCollegeName() {
    return this.collegeName;
  }

  // specific to class faculty

  /* public void setDepartment(String department) {
    this.department = department;
  } */

  public String getDepartment() {
    return this.department;
  }

  // inherited method service

  void service() {
    System.out.println("teaching " + this.department + " students.");
  }

}