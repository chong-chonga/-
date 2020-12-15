package cn.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 */
public class ThousandSeparator {
    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
            count++;
            if(count % 3 == 0 && i != s.length() - 1){
                result.append('.');
            }
        }
        return result.reverse().toString();
    }

    static class Element{
        List<Integer> reachableNodes;

        public Element(){
            reachableNodes = new ArrayList<>();
        }

    }
/*
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Element[] nodes = new Element[n];
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> list = edges.get(i);
            int node1 = list.get(0);
            int node2 = list.get(1);
            nodes[node1].reachableNodes.add(node2);
        }
    }
*/

}
