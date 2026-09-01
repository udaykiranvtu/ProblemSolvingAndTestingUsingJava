import java.util.*;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();
        
        // Set the date (months in Calendar are 0-based, so subtract 1)
        calendar.set(year, month - 1, day);
        
        // Get the day of week (1 = Sunday, 2 = Monday, ..., 7 = Saturday)
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        
        // Map to corresponding day names
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        return days[dayOfWeek - 1];
    }
}
