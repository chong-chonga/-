package cn.leetcode.tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 悠一木碧
 */
public class HuffmanCode {
    static class Node{
        int weight;
        Node left;
        Node right;
        public Node(int weight){
            this.weight = weight;
        }
        public Node(){

        }
    }
    public static int getWeight(int[] weights){
        int numberOfWeights = weights.length;
        int weightOfTree = 0;
        Node[] nodes = new Node[numberOfWeights];

        for (int i = 0; i < numberOfWeights; i++) {
            Node node = new Node(weights[i]);
            nodes[i] = node;
        }
        Arrays.sort(nodes, Comparator.comparingInt((Node n) -> n.weight));
        Node temp = new Node(Integer.MAX_VALUE);
        for(int i = 0; i < numberOfWeights - 1; i++){
            Node newNode = new Node(nodes[0].weight + nodes[1].weight);
            weightOfTree += (nodes[0].weight + nodes[1].weight);
            newNode.left = nodes[0];
            newNode.right = nodes[1];
            nodes[0] = newNode;
            nodes[1] = temp;
            Arrays.sort(nodes, Comparator.comparingInt((Node n) -> n.weight));
        }
        return weightOfTree;

    }

    public static void main(String[] args) {
        int[] weights1 ={5,6,7,8,9,10};
        int[] weights2 ={4, 6, 7, 8, 8, 10};
        int[] weights3 ={3, 4, 5, 6, 7, 8, 9};
        int[] weights4 ={2, 2, 3, 3, 5};
        int[] weights5 ={7, 8, 9, 12, 16};
        int[] weights6 ={1, 3, 5, 6, 7, 8};
        int[] weights7 ={4, 6, 8, 9, 12, 17};
        printAnswer(weights1);
        printAnswer(weights2);
        printAnswer(weights3);
        printAnswer(weights4);
        printAnswer(weights5);
        printAnswer(weights6);
        printAnswer(weights7);
    }

    public static void printAnswer(int[] array){
        System.out.print("对于{" );
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println(" }的最优二叉树权值为" + getWeight(array));
    }
}
