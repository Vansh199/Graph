import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Question2 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        // Build the graph from the tickets
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        
        List<String> itinerary = new ArrayList<>();
        dfs("JFK", graph, itinerary);
        Collections.reverse(itinerary);
        return itinerary;
    }
    
    private void dfs(String node, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> neighbors = graph.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            String nextNode = neighbors.poll();
            dfs(nextNode, graph, itinerary);
        }
        itinerary.add(node);
    }
}
