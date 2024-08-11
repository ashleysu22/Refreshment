// A Java program to find maximal
// Bipartite matching.
import java.util.*;
import java.lang.*;
import java.io.*;
 
class GFG
{
    // M is number of children
    // and N is number of sweets
    static final int M = 6;
    static final int N = 6;
 
    // A DFS based recursive function that 
    // returns true if a matching for 
    // vertex u is possible
    boolean bpm(boolean bpGraph[][], int u, 
                boolean seen[], int matchR[])
    {
        // Try every job one by one
        for (int v = 0; v < N; v++)
        {
            // If children u is interested 
            // in sweet v and v is not visited
            if (bpGraph[u][v] && !seen[v])
            {
                 
                // Mark v as visited
                seen[v] = true; 
 
                // If sweet 'v' is not assigned to
                // a children OR previously
                // assigned children for sweet v (which
                // is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the 
                // above line, matchR[v] in the following
                // recursive call will not get job 'v' again
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                                         seen, matchR))
                {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
 
    // Returns maximum number 
    // of matching from M to N
    int maxBPM(boolean bpGraph[][])
    {
        // An array to keep track of the 
        // children assigned to sweets. 
        // The value of matchR[i] is the 
        // children number assigned to sweets i, 
        // the value -1 indicates nobody is assigned.
        int matchR[] = new int[N];
 
        // Initially all jobs are available
        for(int i = 0; i < N; ++i)
            matchR[i] = -1;
 
        // Count of sweets assigned to children
        int result = 0; 
        for (int u = 0; u < M; u++)
        {
            // Mark all sweets as not seen 
            // for next children.
            boolean seen[] =new boolean[N] ;
            for(int i = 0; i < N; ++i)
                seen[i] = false;
 
            // Find if the children 'u' can get a sweet
            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return result;
    }
 
    // Driver Code
    public static void main (String[] args) 
                       throws java.lang.Exception
    {
        // Let us create a bpGraph shown
        // in the above example
        boolean bpGraph[][] = new boolean[][]{
                              {false, true, true, 
                               false, false, false},
                              {true, false, false, 
                               true, false, false},
                              {false, false, true, 
                               false, false, false},
                              {false, false, true, 
                               true, false, false},
                              {false, false, false, 
                               false, false, false},
                              {false, false, false, 
                               false, false, true}};
        GFG m = new GFG();
        System.out.println( "Maximum number of children that can"+
                            " get sweet is "+m.maxBPM(bpGraph));
    }
}

//Maximum number of children to get a sweet is 5
