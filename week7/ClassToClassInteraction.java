import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    
    // Class to hold check-in details for an individual traveler
    private static class CheckInRecord {
        String stationName;
        int time;
        
        CheckInRecord(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    // Class to accumulate total travel time and trip count between a pair of stations
    private static class RouteStats {
        int totalTime;
        int tripCount;
        
        RouteStats(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    private Map<Integer, CheckInRecord> checkInMap;
    private Map<String, RouteStats> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInRecord(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInRecord record = checkInMap.get(id);
        String startStation = record.stationName;
        int startTime = record.time;
        
        // Form a unique key for the route
        String routeKey = startStation + "->" + stationName;
        int travelTime = t - startTime;
        
        RouteStats stats = routeMap.getOrDefault(routeKey, new RouteStats(0, 0));
        stats.totalTime += travelTime;
        stats.tripCount += 1;
        routeMap.put(routeKey, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = routeMap.get(routeKey);
        
        return (double) stats.totalTime / stats.tripCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id, stationName, t);
 * obj.checkOut(id, stationName, t);
 * double param_3 = obj.getAverageTime(startStation, endStation);
 */
