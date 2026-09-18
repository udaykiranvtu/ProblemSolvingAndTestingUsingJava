import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        
        for (int grade : grades) {
            // If grade is less than 38, rounding won't change a failing grade
            if (grade < 38) {
                roundedGrades.add(grade);
            } else {
                int nextMultiple = ((grade / 5) + 1) * 5;
                // If the difference is less than 3, round up
                if (nextMultiple - grade < 3) {
                    roundedGrades.add(nextMultiple);
                } else {
                    roundedGrades.add(grade);
                }
            }
        }
        
        return roundedGrades;
    }

}
