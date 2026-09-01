class Solution {
    public int dayOfYear(String date) {
        // Split the input date string into year, month, and day
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Days in each month for a non-leap year
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 
                              31, 31, 30, 31, 30, 31};

        // Check if the year is a leap year
        if (isLeapYear(year)) {
            daysInMonths[1] = 29; // February has 29 days in leap years
        }

        // Sum days of all previous months + current day
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }

        return dayOfYear;
    }

    // Helper function to check leap year
    private boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
