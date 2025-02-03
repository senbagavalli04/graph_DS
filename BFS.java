//Link : https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] vis = new int[V];
        bfs(adj,0,res,vis);
        return res;
    }
    public void bfs( ArrayList<ArrayList<Integer>> adj, int src ,ArrayList<Integer> res , int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = 1;
        while(!q.isEmpty()){
            int temp = q.poll();
            res.add(temp);
            List<Integer> al = adj.get(temp);
            for(int i: al){
                if(vis[i]==0){
                    q.add(i);
                    vis[i] = 1;
                }
            }
        }
    }
}
