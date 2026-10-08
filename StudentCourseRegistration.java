import java.util.Scanner;

class Student {
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return marks >= 50;
    }

    // Scholarship calculation
    public double calculateScholarship(double fee) {
        if (marks >= 85) {
            return fee * 0.20; // 20% scholarship
        } else if (marks >= 70) {
            return fee * 0.10; // 10% scholarship
        } else {
            return 0; // No scholarship
        }
    }

    // Final fee after scholarship
    public double calculateFinalFee(double fee, double scholarship) {
        return fee - scholarship;
    }

    // Display details
    public void displayDetails(double fee, double scholarship, double finalFee) {
        System.out.println("\n--- Student Course Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility: " + (checkEligibility() ? "Eligible" : "Not Eligible"));
        System.out.println("Total Fee: Rs. " + fee);
        System.out.println("Scholarship: Rs. " + scholarship);
        System.out.println("Final Fee (after scholarship): Rs. " + finalFee);
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read student and course details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine(); // consume newline
        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        // Create Student object
        Student student = new Student(name, roll, marks, course, credits);

        // Check eligibility
        if (student.checkEligibility()) {
            double fee = student.calculateFee();
            double scholarship = student.calculateScholarship(fee);
            double finalFee = student.calculateFinalFee(fee, scholarship);

            student.displayDetails(fee, scholarship, finalFee);
        } else {
            System.out.println("\nStudent is not eligible for course registration (marks below 50).");
        }

        sc.close();
    }
}
