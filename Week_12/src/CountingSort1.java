import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private String name;
    private double cgpa;
    private int id;
    public Student(String name, double cgpa, int id){
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getCgpa() != s2.getCgpa()){
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        } else if (!s1.getName().equals(s2.getName())){
            return s1.getName().compareTo(s2.getName());
        } else {
            return Integer.compare(s1.getId(), s2.getId());
        }
    }
}
class Priorities {
    public List<Student> getStudents(List<String> events) {
        Queue<Student> pq = new PriorityQueue<>(events.size(), new StudentComparator());
        List<Student> result = new ArrayList<>();
        for(String event : events) {
            String[] parts = event.split(" ");
            String operation = parts[0];

            if(operation.equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                Student student = new Student(name, cgpa, id);
                pq.add(student);
            } else if (operation.equals("SERVED")) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}