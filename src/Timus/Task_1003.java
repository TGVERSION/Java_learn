package Timus;

import java.util.*;
import java.io.*;

public class Task_1003 {

    static int[] parent, rank, dist;

    static void init(int n) {
        parent = new int[n];
        rank   = new int[n];
        dist   = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        int root = find(parent[x]);
        dist[x] ^= dist[parent[x]];
        parent[x] = root;
        return root;
    }

    static boolean unite(int x, int y, int w) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return (dist[x] ^ dist[y]) == w;
        int newDist = dist[x] ^ dist[y] ^ w;
        if (rank[rx] < rank[ry]) { parent[rx] = ry; dist[rx] = newDist; }
        else if (rank[rx] > rank[ry]) { parent[ry] = rx; dist[ry] = newDist; }
        else { parent[ry] = rx; dist[ry] = newDist; rank[rx]++; }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("-1")) break;

            int q = Integer.parseInt(br.readLine().trim());
            int[] L = new int[q], R = new int[q], par = new int[q];

            Set<Integer> coordSet = new TreeSet<>();
            coordSet.add(0);
            for (int i = 0; i < q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                L[i]   = Integer.parseInt(st.nextToken());
                R[i]   = Integer.parseInt(st.nextToken());
                par[i] = st.nextToken().equals("odd") ? 1 : 0;
                coordSet.add(L[i] - 1);
                coordSet.add(R[i]);
            }

            List<Integer> coords = new ArrayList<>(coordSet);
            Map<Integer, Integer> compress = new HashMap<>();
            for (int i = 0; i < coords.size(); i++) compress.put(coords.get(i), i);

            init(coords.size());

            int firstBad = q;
            for (int i = 0; i < q; i++) {
                if (!unite(compress.get(L[i] - 1), compress.get(R[i]), par[i])) {
                    firstBad = i;
                    break;
                }
            }
            sb.append(firstBad).append('\n');
        }
        System.out.print(sb);
    }
}
