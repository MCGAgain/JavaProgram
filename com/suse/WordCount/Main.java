//package com.suse.WordCount;

import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            LinkedList<String> merge = new LinkedList<>();

            String lineA = sc.nextLine().trim();
            String nodeA[] = lineA.split(" ");
            if (nodeA[0].equals("0")) break;
            String lineB = sc.nextLine().trim();
            String nodeB[] = lineB.split(" ");

            String node[][] = {nodeA, nodeB};
            int p[] = {0, 0};
            char judge[] = {'a', 'b'};
            int cnt = 1;

            while (p[0] < nodeA.length || p[1] < nodeB.length) {
                cnt = 1 - cnt;
                if (p[cnt] >= node[cnt].length) cnt = 1 - cnt;
                if (node[cnt][p[cnt]].charAt(0) != judge[cnt]) merge.add(node[cnt][p[cnt]]);
                p[cnt]++;
            }

            int idx = 0;
            for (var x : merge) System.out.printf("%d-%s,", idx++, x);
            System.out.println("");

            var it = merge.iterator();

            idx = 0;
            while (it.hasNext()) {
                it.next();
                if (idx != 0 && idx % 3 == 0) it.remove();
                idx++;
            }

            idx = 0;
            for (var x : merge) System.out.printf("%d-%s,", idx++, x);
            System.out.println("");

            Map<String, Integer> map = new LinkedHashMap<
            >();

            for (var x : merge) {
                if (x.length() == 2) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                    System.out.printf("%s-%d,", x, map.get(x));
                }
            }
            System.out.println("");

            for (var kv : map.entrySet()) {
                System.out.printf("%s=%d,", kv.getKey(), kv.getValue());
            }
            System.out.println("");
        }
    }
}
