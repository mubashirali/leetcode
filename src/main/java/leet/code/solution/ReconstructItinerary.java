package leet.code.solution;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * <p>
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * <p>
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */
public class ReconstructItinerary {


    public static void main(String[] args) {
        System.out.println(findItinerary(asList(asList("JFK", "SFO"),
                asList("JFK", "ATL"), asList("SFO", "ATL"), asList("ATL", "JFK"), asList("ATL", "SFO"))));
    }

    /**
     * Runtime: 4 ms
     * 40.4 MB
     */
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        visit(map, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private static void visit(Map<String, PriorityQueue<String>> map, String airport, List<String> result) {
        final PriorityQueue<String> queue = map.get(airport);
        while (queue != null && !queue.isEmpty()) {
            visit(map, queue.poll(), result);
        }
        result.add(airport);
    }
    
   public List<String> findItinerarySimplified(List<List<String>> tickets) {
      if (tickets.isEmpty()) {
            return List.of();
        }
        Map<String, PriorityQueue<String>> adjacents = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        for (List<String> ticket : tickets) {
            adjacents.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adjacents.get(ticket.get(0)).add(ticket.get(1));
        }

        stack.push("JFK");
        while (!stack.isEmpty()) {
            String item = stack.peek();
            Queue<String> adjacent = adjacents.getOrDefault(item, new PriorityQueue<>());
            if (!adjacent.isEmpty()) {
                String poll = adjacent.poll();
                stack.add(poll);
            } else {
                list.addFirst(stack.pop());
            }
        }
        return list;
    }

}
