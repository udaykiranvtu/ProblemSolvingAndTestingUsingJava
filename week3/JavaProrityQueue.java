import java.util.*;

// Student class
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

// Priorities class
class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (s1, s2) -> {
                if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA()); // higher CGPA first
                } else if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName()); // alphabetical order
                } else {
                    return Integer.compare(s1.getID(), s2.getID()); // lower ID first
                }
            }
        );

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll(); // remove highest priority student
            }
        }

        List<Student> remaining = new ArrayList<>();
        while (!pq.isEmpty()) {
            remaining.add(pq.poll());
        }
        return remaining;
    }
}
