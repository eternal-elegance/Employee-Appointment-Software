package TeacherAppointmentJava;

abstract class Employee {

  /* Class Attributes */
  protected String name;
  protected String id;
  protected double basicPay;
  protected String collegeName;

  Employee(String name, String id) {
    this.name = name;
    this.id = id;
    /* this.basicPay = basicPay;
    this.collegeName = collegeName; */
  }

  double getBasicPay() {
    return basicPay;
  }

  abstract void service();

  /* public abstract void getJob(); */
}