package TeacherAppointmentJava;

class JobLetter {

  void showAppointment(String name, String id, String clgnm, String depart, double basic, boolean b) {
    if (b) {
      System.out.println("Congratulations " + name + " you have been appointed to serve for the " + depart
          + " department at " + clgnm + " \nID: " + id + "\nBase Pay: " + basic);
    } else {
      System.out.println("Congratulations " + name + " you have been appointed to serve as a " + depart
          + " department at " + clgnm + " \nID: " + id + "\nBase Pay: " + basic);
    }
  }

  void showAllService(String name, String job, String c) {
    if (c.equalsIgnoreCase("F"))
      System.out.print(name + " is a" + job + " faculty, ");
    else
      System.out.println(name + " is doing " + job + "'s job ");
  }

  public void showDetailFaculty(Faculty[] y, int w) {
    System.out.println(w + " details found");
    for (int x = 0; x < w; x++) {
      System.out.println("The name of Faculty is: " + y[x].getName());
      System.out.println("ID: " + y[x].getID());
      System.out.println("Basic Pay: " + y[x].getBasicPay());
      System.out.println("Works in: " + y[x].getCollegeName());
      System.out.println("Department: " + y[x].getDepartment());
    }
  }

  public void showDetailOfficeStaff(OfficeStaff[] y, int v) {
    System.out.println(v + " details found");
    for (int x = 0; x < v; x++) {
      System.out.println("The name of Faculty is: " + y[x].getName());
      System.out.println("ID: " + y[x].getID());
      System.out.println("Basic Pay: " + y[x].getBasicPay());
      System.out.println("Works in: " + y[x].getCollegeName());
      System.out.println("Department: " + y[x].getDesignation());
    }
  }

  public void showNameFaculty(Faculty f) {
    System.out.println("Detail Found");
    System.out.println("The name of Faculty is: " + f.getName());
    System.out.println("ID: " + f.getID());
    System.out.println("Basic Pay: " + f.getBasicPay());
    System.out.println("Works in: " + f.getCollegeName());
    System.out.println("Department: " + f.getDepartment());
  }

  public void showNameOfficeStaff(OfficeStaff of) {
    System.out.println("Detail Found");
    System.out.println("The name of Faculty is: " + of.getName());
    System.out.println("ID: " + of.getID());
    System.out.println("Basic Pay: " + of.getBasicPay());
    System.out.println("Works in: " + of.getCollegeName());
    System.out.println("Department: " + of.getDesignation());
  }

}