import java.util.*;
class Solution {
    class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb])
                parent[pa] = pb;
            else if (rank[pb] < rank[pa])
                parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }
    public int maxStability(int n, int[][] edges, int k) {
        int left = 0;
        int right = 200000;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    boolean canBuild(int n, int[][] edges, int k, int minStrength) {
        DSU dsu = new DSU(n);
        int upgrades = 0;
        int usedEdges = 0;
        List<int[]> optional = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];
            if (must == 1) {
                if (s < minStrength)
                    return false;
                if (!dsu.union(u, v))
                    return false;
                usedEdges++;
            } else {
                optional.add(e);
            }
        }
        optional.sort((a, b) -> b[2] - a[2]);
        for (int[] e : optional) {
            int u = e[0];
            int v = e[1];
            int s = e[2];
            if (dsu.find(u) == dsu.find(v))
                continue;
            if (s >= minStrength) {
                dsu.union(u, v);
                usedEdges++;
            } else if (s * 2 >= minStrength && upgrades < k) {
                dsu.union(u, v);
                upgrades++;
                usedEdges++;
            }
            if (usedEdges == n - 1)
                break;
        }
        return usedEdges == n - 1;
    }
}