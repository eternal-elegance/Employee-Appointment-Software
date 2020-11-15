package TeacherAppointmentJava;

import java.io.*;

public class Admin {
	public static void main(String[] args) throws IOException {
		Faculty f;
		OfficeStaff of;
		Employer e = new Employer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean b = true;

		System.out.println("\n=======WELCOME TO ADMIN LOGIN=======");
		System.out.print("Enter passcode and key to login: ");
		String passcode[] = br.readLine().split(" ");
		Integer real = Integer.valueOf(2070);

		if (!(Integer.parseInt(passcode[0]) == (real - Integer.parseInt(passcode[1]))))
			System.out.println("Sorry wrong password");
		else {
			while (b) {

				/*
				 * System.out.print(
				 * "\nEnter your choice\nPress 1 to recruit\n2 to Show service\n3 Search by college name\n4 to get details of an employee\n5 to exit: "
				 * ); byte choice = Byte.parseByte(br.readLine());
				 * 
				 * switch (choice) { case 1: System.out.
				 * print("\n1 to recruit Faculty Member or,\n2 to recruit an Office Staff: ");
				 * byte ch = Byte.parseByte(br.readLine());
				 * 
				 * if (ch == 1) { f = inputFacultyDetails(); e.setFaculty(f);
				 * e.setInfoF(privateInfoPay(), privateInfoClg(), f);
				 * 
				 * } else if (ch == 2) { of = inputOfficeStaffDetails(); e.setOfficeStaff(of);
				 * e.setInfoOF(privateInfoPay(), privateInfoClg(), of); }
				 * 
				 * else System.out.print("Invalid input!!");
				 * 
				 * break;
				 * 
				 * case 2: System.out.
				 * print("Enter 'F' to see service of faculty\n'O' to se service of Office Staff: "
				 * ); String inp = br.readLine(); e.showService(inp); break;
				 * 
				 * case 3: System.out.print("Enter College Name: ");
				 * e.searchByCollegeName(br.readLine()); break;
				 * 
				 * case 4: System.out.print("Enter name of employee: ");
				 * e.searchByName(br.readLine()); break;
				 * 
				 * case 5: b = false; break; default: System.err.println("Enter a valid case");
				 * }
				 */

				/* ANOTHER SWITCH */
				System.out.print(
						"========Press========\n1 for FACULTY MENU\n2 for OFFICESTAFF MENU\n3 to EXIT\nEnter Your Choice: ");
				int ch = Integer.parseInt(br.readLine());

				switch (ch) {
					case 1:

						boolean c = true;
						while (c) {

							System.out.println("=======FACULTY MENU======");
							System.out.print(
									"1 to Recruit\n2 to Search by Name\n3 to Search by College Name\n4 to Search by Department\n5 Show Service\n6 to search by ID\n7 to exit menu\nEnter Your Choice: ");
							int choicee = Integer.parseInt(br.readLine());

							switch (choicee) {
								case 1:
									f = inputFacultyDetails();
									e.setFaculty(f);
									e.setInfoF(privateInfoPay(), privateInfoClg(), f);
									break;

								case 2:
									System.out.print("Enter name of employee: ");
									e.filterNames(br.readLine(), 'F');
									break;

								case 3:
									System.out.print("Enter College Name: ");
									e.searchByCollegeName(br.readLine(), 'F');
									break;

								case 4:
									System.out.print("Enter Department: ");
									e.searchBy(br.readLine(), 'F');
									break;

								case 5:
									e.showService("F");
									break;

								case 6:
									System.out.print("Enter ID number: ");
									e.searchByID(br.readLine(), 'F');
									break;

								case 7:
									c = false;
									break;

								default:
									System.out.println("INVALID INPUT!!!");
							}
						}
						break;

					case 2:

						boolean n = true;
						while (n) {

							System.out.println("=======OFFICE STAFF MENU======");
							System.out.print(
									"1 to Recruit\n2 to Search by Name\n3 to Search by College Name\n4 to Search by Departmen\n5 Show Service\n6 to search by job\n7 to exit menu\nEnter Your Choice: ");
							int choicee = Integer.parseInt(br.readLine());

							switch (choicee) {
								case 1:
									of = inputOfficeStaffDetails();
									e.setOfficeStaff(of);
									e.setInfoOF(privateInfoPay(), privateInfoClg(), of);
									break;

								case 2:
									System.out.print("Enter name of employee: ");
									e.filterNames(br.readLine(), 'O');
									break;

								case 3:
									System.out.print("Enter College Name: ");
									e.searchByCollegeName(br.readLine(), 'O');
									break;

								case 4:
									System.out.println("Enter Designation: ");
									e.searchBy(br.readLine(), 'O');
									break;

								case 5:
									e.showService("O");
									break;

								case 6:
									System.out.print("Enter ID number: ");
									e.searchByID(br.readLine(), 'O');
									break;

								case 7:
									n = false;
									break;

								default:
									System.out.println("INVALID INPUT!!!");
							}
						}
						break;

					case 3:
						b = false;
						break;

					default:
						System.out.println("wrong choice");
				}
			}
		}
	}

	private static Faculty inputFacultyDetails() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter the name of the employee: ");
		String name = br.readLine();

		System.out.print("Assign ID: ");
		String id = br.readLine();

		/*
		 * System.out.print("Assign Basic Pay: "); double d = br.nextDouble();
		 * 
		 * System.out.print("Assign College: "); String cn = br.nextLine();
		 */

		System.out.print("Assign Department: ");
		String dept = br.readLine();

		Faculty f = new Faculty(name, id, dept);

		return f;
	}

	private static OfficeStaff inputOfficeStaffDetails() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the name of the employee: ");
		String name = br.readLine();

		System.out.print("Assign ID: ");
		String id = br.readLine();

		/*
		 * System.out.print("Assign Basic Pay: "); double d = br.nextDouble();
		 * 
		 * System.out.print("Assign College: "); String cn = br.nextLine();
		 */

		System.out.print("Assign Designation: ");
		String desig = br.readLine();

		OfficeStaff os = new OfficeStaff(name, id, desig);

		return os;
	}

	private static double privateInfoPay() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Assign Basic Pay: ");
		double pay = Double.parseDouble(br.readLine());
		return pay;
	}

	private static String privateInfoClg() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Assign college: ");
		String c = br.readLine();
		return c;
	}
}