import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        // Parse the input strings into LocalDate objects
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);

        // Use ChronoUnit to calculate the difference in days
        return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }
}
