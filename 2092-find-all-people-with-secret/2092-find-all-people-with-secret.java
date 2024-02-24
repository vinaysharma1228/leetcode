class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        
        PriorityQueue<int[]> known = new PriorityQueue<>((p0, p1) -> p0[1] - p1[1]);
        known.offer(new int[]{0, 0});
        known.offer(new int[]{firstPerson, 0});
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] meeting : meetings) {
            map.putIfAbsent(meeting[0], new ArrayList<>());
            map.putIfAbsent(meeting[1], new ArrayList<>());
            
            map.get(meeting[0]).add(new int[]{meeting[1], meeting[2]});
            map.get(meeting[1]).add(new int[]{meeting[0], meeting[2]});
        }
        
        while (!known.isEmpty()) {
            int[] p = known.poll();
            
            if (!added.contains(p[0])) {
                added.add(p[0]);
                ans.add(p[0]);
            }
            
            if (!map.containsKey(p[0])) continue;
            
            List<int[]> meetAndTime = map.get(p[0]);
            for (int[] m : meetAndTime) {
                if (m[1] < p[1]) continue;
                
                known.offer(new int[]{m[0], m[1]});
            }
            
            map.remove(p[0]);
        }

        return ans;
    }
}