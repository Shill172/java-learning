//Students class is to help me remember data structures

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Students {
    ArrayList<String> names = new ArrayList<>();
    HashMap<String, String> grades = new HashMap<>();

    // getNames asks the user to enter 5 names
    public ArrayList<String> getNames() {
        String name;

        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter student " + (i+1) + " name: ");
            name = sc.nextLine();
            names.add(name);
        }
        System.out.println(names);
        return names;
    }

    // getGrades asks the user to enter grades for existing students and stores them in a HashMap
    // If no Students are found in names ArrayList, getNames is called to populate it
    public HashMap<String, String> getGrades() {
        Scanner sc = new Scanner(System.in);
        if (names.isEmpty()) {
            System.out.println("No students found, calling getNames");
            getNames();
        }
        for (String name : names) {
            System.out.println("Please enter the grade for " + name + " (A, B, C, D, F)");
            String grade = sc.nextLine();
            grade = validateGrade(grade);
            grades.put(name, grade);

        }
        System.out.println(grades);
        return grades;
    }

    private String validateGrade(String grade) {
        Scanner validateScanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            if (grade.equals("A" ) || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F")) {
                System.out.println("Grade '" + grade + "' validated!");
                valid = true;
            } else {
                System.out.println("Grade '" + grade + "' not validated! Please enter a valid grade: (A, B, C, D, F)");
                grade = validateScanner.nextLine();
            }

        }
        return grade;
    }



}
