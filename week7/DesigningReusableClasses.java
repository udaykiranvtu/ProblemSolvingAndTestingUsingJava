import java.util.*;

class ThroneInheritance {
    private String kingName;
    private Map<String, List<String>> familyTree;
    private Set<String> deadSet;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        this.familyTree = new HashMap<>();
        this.deadSet = new HashSet<>();
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        familyTree.putIfAbsent(parentName, new ArrayList<>());
        familyTree.get(parentName).add(childName);
        familyTree.putIfAbsent(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        deadSet.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(kingName, order);
        return order;
    }
    
    private void dfs(String current, List<String> order) {
        // If the person is alive, add them to the inheritance order
        if (!deadSet.contains(current)) {
            order.add(current);
        }
        
        // Recursively visit all children in birth order
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_getInheritanceOrder = obj.getInheritanceOrder();
 */
