class Solution {
    int[] parents;
    private int find(int x){
        if(x !=parents[x])
            parents[x]=find(parents[x]);
        return parents[x];
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n =vals.length;
        if(n==1) return 1;
        parents=new int[n];
        List<Integer> ids=new ArrayList<>();
        for(int i =0;i<n;i++){
            parents[i]=i;
            ids.add(i);
        }
        Map<Integer,Set<Integer>> graph=new HashMap<>();
        for(int[] edge:edges){
            int u =edge[0];
            int v=edge[1];

            graph.putIfAbsent(u,new HashSet<>());
            graph.putIfAbsent(v,new HashSet<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Collections.sort(ids,(a,b)->(vals[a]-vals[b]));

        int ret=0;
        for(int i=0;i<n;i++){
            int j=i+1;
            while(j<n && vals[ids.get(j)] == vals[ids.get(i)]) j++;

            for(int k=i;k<j;k++){
                int x=ids.get(k);
                for(int neighbor:graph.get(x)){
                    if(vals[x]>=vals[neighbor]){
                        parents[find(x)]=find(neighbor);
                    }
                }
            }
            Map<Integer,Integer> temp=new HashMap<>();
            for(int k=i;k<j;k++){
                int root=find(ids.get(k));
                temp.put(root,temp.getOrDefault(root,0)+1);
            }
            for(int v:temp.values()){
                ret+=v*(v+1)/2;
            }
            i=j-1;
        }
        return ret;
    }
}