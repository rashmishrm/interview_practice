package com.practice.leetcode.facebook;

public class SecondDegree {
	public List<UndirectedGraphNode> findSecDegreeConnections(UndirectedGraphNode myself){
        List<UndirectedGraphNode> res = new ArrayList<UndirectedGraphNode>();
        
        Set<UndirectedGraphNode> myFriends = new HashSet<UndirectedGraphNode>();
        for (UndirectedGraphNode friend : myself.neighbors) {
            myFriends.add(friend);
        }
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        q.add(myself);
        visited.add(myself);
        int level = 0;
        while (!q.isEmpty() && level < 2) {
            level++;
            int size = q.size();
            while (size-- > 0) {
                UndirectedGraphNode node = q.poll();
                for (UndirectedGraphNode w : node.neighbors) {
                    if (!visited.contains(w)) {
                        q.offer(w);
                        visited.add(w);
                    }
                }
            }
        }
        Map<UndirectedGraphNode, Integer> counts = new HashMap<UndirectedGraphNode, Integer>();
        for (UndirectedGraphNode fof : q) {
            int count = 0;
            for (UndirectedGraphNode friend : fof.neighbors) {
                if (myFriends.contains(friend)) count++;
            }
            counts.put(fof, count);
        }
        Map<Integer, List<UndirectedGraphNode>> bucket = new HashMap<Integer, List<UndirectedGraphNode>>();
        for (UndirectedGraphNode n : counts.keySet()) {
            int count = counts.get(n);
            if (!bucket.containsKey(count)) bucket.put(count, new ArrayList<UndirectedGraphNode>());
            bucket.get(count).add(n);
        }
        for (int i = q.size(); i > 0; i--) {
            if (bucket.containsKey(i)) res.addAll(bucket.get(i));
        }
        return res;
    }
}
