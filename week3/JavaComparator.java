import java.util.*;

// Player class is already provided in the editor
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        // First compare by score (descending)
        if (a.score != b.score) {
            return Integer.compare(b.score, a.score);
        }
        // If scores are equal, compare by name (ascending)
        return a.name.compareTo(b.name);
    }
}
