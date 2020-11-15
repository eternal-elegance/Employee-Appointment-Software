package TeacherAppointmentJava;

class Employer {
  int n = 10;
  private static OfficeStaff[] os = new OfficeStaff[10];
  private static Faculty[] f = new Faculty[10];
  static int i = 0;
  static int j = 0; // for 2 arrays
  private double basicPay = 0.0;
  private String college;

  JobLetter jl = new JobLetter();

  /* Getter and setter */
  void setFaculty(Faculty fa) {
    if (Employer.i < n) {

      f[Employer.i] = fa;
      Employer.i++;
      // System.out.println(Employer.i);

    } else {
      System.out.print("Out of bound");
    }
  }

  Faculty getFaculty(int i) {
    if (i > 0 && i <= Employer.i) {
      return f[i];
    } else
      return null;
  }

  void setOfficeStaff(OfficeStaff of) {
    if (Employer.j < n) {

      os[Employer.j] = of;
      Employer.j++;
      // System.out.println(Employer.j);

    } else {
      System.out.print("Out of bound");
    }
  }

  OfficeStaff getOfficeStaff(int j) {
    if (j > 0 && j <= Employer.j) {
      return os[j];
    } else
      return null;
  }

  void setInfoF(double basicPay, String s, Faculty f) {
    this.basicPay = basicPay;
    this.college = s;
    f.basicPay = this.basicPay;
    f.collegeName = this.college;

    /* calling the view class */
    jl.showAppointment(f.getName(), f.getID(), f.getCollegeName(), f.getDepartment(), f.getBasicPay(), true);
  }

  void setInfoOF(double basicPay, String s, OfficeStaff of) {
    this.basicPay = basicPay;
    this.college = s;
    of.basicPay = this.basicPay;
    of.collegeName = this.college;

    /* VIEW */
    jl.showAppointment(of.getName(), of.getID(), of.getCollegeName(), of.getDesignation(), of.getBasicPay(), false);
  }

  void showService(String c) {
    {
      if (c.equalsIgnoreCase("F")) {
        for (int k = 0; k < Employer.i; k++) {
          jl.showAllService(f[k].getName(), f[k].getDepartment(), c);
          f[k].service();
        }
      } else if (c.equalsIgnoreCase("O")) {
        for (int m = 0; m < Employer.j; m++)
          jl.showAllService(os[m].getName(), os[m].getDesignation(), c);
      } else
        System.out.println("NO RECORD FOUND");
    }
  }

  public void searchByCollegeName(String readLine, char c) {

    boolean bool = false;
    if (c == 'F') {
      int w = 0;
      Faculty[] temp = new Faculty[5];
      for (int iter = 0; iter < Employer.i; iter++) {
        if (f[iter].getCollegeName().equalsIgnoreCase(readLine)) {
          bool = true;
          temp[w] = f[iter];
          w++;
        }
      }
      jl.showDetailFaculty(temp, w);
    }

    else if (c == 'O') {
      OfficeStaff[] temp1 = new OfficeStaff[5];
      int v = 0;
      for (int twtr = 0; twtr < Employer.j; twtr++) {
        if ((os[twtr].getCollegeName()).equalsIgnoreCase(readLine)) {
          bool = true;
          temp1[v] = os[twtr];
          v++;
        }
      }
      jl.showDetailOfficeStaff(temp1, v);
    }

    if (!bool)
      System.out.println("No Details of " + readLine + " college found.");
  }

  public void searchByName(String readLine, char c) {
    boolean bool = false;

    if (c == 'F') {

      for (int iter = 0; iter < Employer.i; iter++) {
        if (f[iter].getName().equalsIgnoreCase(readLine)) {
          bool = true;
          jl.showNameFaculty(f[iter]);
          break;
        }
      }

    }

    else if (c == 'O') {

      for (int twtr = 0; twtr < Employer.j; twtr++) {
        if ((os[twtr].getName()).equalsIgnoreCase(readLine)) {
          bool = true;
          jl.showNameOfficeStaff(os[twtr]);
          break;
        }
      }

    }

    if (!bool)
      System.out.println("No Details of " + readLine + " were found.");
  }

  /* =========SEARCHING BY ID FUNCTION=============== */
  public void searchByID(String readLine, char c) {
    boolean bool = false;

    if (c == 'F') {

      for (int iter = 0; iter < Employer.i; iter++) {
        if (f[iter].getID().equalsIgnoreCase(readLine)) {
          bool = true;
          jl.showNameFaculty(f[iter]);
          break;
        }
      }

    }

    else if (c == 'O') {

      for (int twtr = 0; twtr < Employer.j; twtr++) {
        if ((os[twtr].getID()).equalsIgnoreCase(readLine)) {
          bool = true;
          jl.showNameOfficeStaff(os[twtr]);
          break;
        }
      }

    }

    if (!bool)
      System.out.println("No Details of " + readLine + " were found.");

  }

  /* =====NAME FILTER FUNCTION==== */
  void filterNames(String s, char c) {

    if (c == 'F') {

      int w = 0;
      Faculty[] t = new Faculty[10];
      for (int iter = 0; iter < Employer.i; iter++) {
        String current = f[iter].getName();

        if (current.equalsIgnoreCase(s)) {
          t[w++] = f[iter];
        }

        else {

          current = current + "$";

          String sub = "";
          boolean flag = false;

          int j = 0;
          while (j < current.length()) {

            while ((current.charAt(j) != ' ') && (current.charAt(j) != '$')) {
              sub = sub + current.charAt(j);
              j++;
            }
            // System.out.println("substring->" + sub);
            if (s.equalsIgnoreCase(sub)) {
              t[w++] = f[iter];
              flag = true;
              break;
            }
            if (current.charAt(j) == '$' || flag == true)
              break;
            else {
              sub = "";
              j++;
            }

          }
        }
      }
      jl.showDetailFaculty(t, w);
    }

    else if (c == 'O') {

      int w = 0;
      OfficeStaff[] o = new OfficeStaff[10];
      for (int iter = 0; iter < Employer.j; iter++) {
        String current = os[iter].getName();

        if (current.equalsIgnoreCase(s)) {
          o[w++] = os[iter];
        }

        else {

          current = current + "$";

          String sub = "";
          boolean flag = false;

          int j = 0;
          while (j < current.length()) {

            while ((current.charAt(j) != ' ') && (current.charAt(j) != '$')) {
              sub = sub + current.charAt(j);
              j++;
            }

            if (s.equalsIgnoreCase(sub)) {
              o[w++] = os[iter];
              flag = true;
              break;
            }
            if (current.charAt(j) == '$' || flag == true)
              break;
            else {
              sub = "";
              j++;
            }

          }
        }
      }
      jl.showDetailOfficeStaff(o, w);
    }

    else System.out.println("No Details of " + s + " were found.");

  }

  public void searchBy(String readLine, char c) {

    boolean bool = false;
    if (c == 'F') {
      int w = 0;
      Faculty[] temp = new Faculty[5];
      for (int iter = 0; iter < Employer.i; iter++) {
        if (f[iter].getDepartment().equalsIgnoreCase(readLine)) {
          bool = true;
          temp[w] = f[iter];
          w++;
        }
      }
      jl.showDetailFaculty(temp, w);
    }

    else if (c == 'O') {
      OfficeStaff[] temp1 = new OfficeStaff[5];
      int v = 0;
      for (int twtr = 0; twtr < Employer.j; twtr++) {
        if ((os[twtr].getDesignation()).equalsIgnoreCase(readLine)) {
          bool = true;
          temp1[v] = os[twtr];
          v++;
        }
      }
      jl.showDetailOfficeStaff(temp1, v);
    }

    if (!bool)
      System.out.println("No Details of " + readLine + " college found.");
  }

}