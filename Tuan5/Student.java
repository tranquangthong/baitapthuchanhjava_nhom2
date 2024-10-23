public class Student {
    private Student[] students = new Student[100]; // Assuming max 100 students
    private int studentCount = 0;

    public void addStudent(String studentId, String name, double gpa) {
        students[studentCount++] = new Student(studentId, name, gpa);
    }

    public void removeStudent(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null;
                System.out.println("Student with ID " + studentId + " removed.");
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public Student searchStudent(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(studentId)) {
                return students[i];
            }
        }
        return null;
    }

    public void sortStudentsByGpa() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - 1 - i; j++) {
                if (students[j].getGpa() > students[j + 1].getGpa()) {
                    // Swap
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by GPA.");
    }

    public void displayAllStudents() {
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }
}

