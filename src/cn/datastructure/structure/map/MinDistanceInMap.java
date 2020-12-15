package cn.datastructure.structure.map;

import java.util.ArrayList;

/**
 * @author 悠一木碧
 * 给定起始点和终点, 以及边的数组, 给出最短距离
 */
public class MinDistanceInMap {
    static class Node{
        public int serialNumber;
        public int theDistanceToThisNode;
        public Node forwardNode;

        public Node(){

        }
        public Node(int num, Node forward){
            this.serialNumber = num;
            this.forwardNode = forward;
        }
    }

    static class UndirectedEdge{
        public int startNodeIndex;
        public int endNodeIndex;
        public int sideLength;

        public UndirectedEdge(){

        }
        public UndirectedEdge(int start, int end, int len){
            this.startNodeIndex = start;
            this.endNodeIndex = end;
            this.sideLength = len;
        }
    }

    private static Node[] nodes = null;
    private static ArrayList<Node> markedPoints = new ArrayList<>();

    /**
     * 中心方法, 传入起始点和终点, 结点总个数, 边数组, 返回从起始点到终点的最短距离
     * @param totalNumberOfNodes 总结点个数
     * @param start 起始点
     * @param end 终点
     * @param edges 边数组
     * @return 从起始点到达该终点所需的最短距离
     */
    public static int getMinDistance(int totalNumberOfNodes, int start, int end,
                                                         UndirectedEdge[] edges){
        nodes = getInitializedNodes(start, totalNumberOfNodes);
        Node currentNode = nodes[start - 1];
        do {
            markNode(currentNode);
            findValidEdgesAndUpdateDistance(edges, currentNode);
            currentNode = getNodeThatNeedToBeAdded();
        } while (currentNode != nodes[end - 1]);

        return nodes[end - 1].theDistanceToThisNode;
    }

    /**
     * 给定起始点以及总结点个数, 对结点进行初始化, 起始点的distance为0, 其他均为Integer.MAX_VALUE
     * @param startNodeIndex 起始点的索引
     * @param nodeNum 总结点的个数
     * @return 结点数组
     */
    private static Node[] getInitializedNodes(int startNodeIndex, int nodeNum){
        Node[] nodes = new Node[nodeNum];
        for (int j = 0; j < nodes.length; j++) {
            nodes[j] = new Node();
            nodes[j].theDistanceToThisNode = Integer.MAX_VALUE;
            nodes[j].serialNumber = j + 1;
        }
        nodes[startNodeIndex - 1].theDistanceToThisNode = 0;
        return nodes;
    }

    /**
     * 将指定的结点标记为永久结点(到达该结点的路程已经是最短的了)
     * 当前被标记的结点将会变为下一个起始结点, 在选边时将不会再考虑包含永久结点的边
     * @param nodeToBeMarked 需要被标记的结点
     */
    private static void markNode(Node nodeToBeMarked) {
        markedPoints.add(nodeToBeMarked);
    }

    /**
     * 寻找与currentNode相关的边, 寻找与currentNode相连的结点, 并对它们进行以下操作:
     * 获取前置结点的距离和当前边的长度计算可得当前路径的总长度, 将计算所得的和与此结点之前已有的距离进行比较
     * 两者取小的那一方, 并对结点的forward指向进行更改
     * @param edges 边数组
     * @param currentNode 当前结点
     */
    private static void findValidEdgesAndUpdateDistance(UndirectedEdge[] edges,
                                                        Node currentNode) {
        for (UndirectedEdge edge : edges) {
            if(isEdgeValid(edge, currentNode)){
                updateDistance(edge, currentNode);
            }
        }
    }

    /**
     * 通过向此方法传递一个edge, 此方法将if判断逻辑进行了封装, 对可以使用的边进行判断
     * 只有当边edge包含当前结点且不包含另一个永久结点(被标记过的结点)
     * @param edge 边
     * @param currentLocation 当前结点
     * @return 是否可以使用这条边
     */
    private static boolean isEdgeValid(UndirectedEdge edge, Node currentLocation){
        Node node = getTheDestinationNode(edge, currentLocation);
        return null != node && isUnmarked(node);
    }

    /**
     * @param edge 无向边
     * @param currentNode 当前结点
     */
    private static void updateDistance(UndirectedEdge edge, Node currentNode){
        Node destinationNode = getTheDestinationNode(edge, currentNode);
        if(null != destinationNode){
            int distanceOfCurrentPath = getTheDistanceOfTheCurrentPath(
                    currentNode,
                    edge);
            if(destinationNode.theDistanceToThisNode > distanceOfCurrentPath){
                destinationNode.forwardNode = currentNode;
                destinationNode.theDistanceToThisNode = distanceOfCurrentPath;
            }
        }
    }

    /**
     * 从所有未被标记过的结点中, 找到到达该结点距离最短的结点并将其返回
     * @return 下一个要被永久标记的结点
     */
    private static Node getNodeThatNeedToBeAdded(){
        Node targetNode = null;
        boolean flag = true;
        for (Node node : nodes) {
            if(isUnmarked(node)){
                if(flag){
                    targetNode = node;
                    flag = false;
                }
                targetNode = getTheLessDistanceNode(node, targetNode);
            }
        }
        return targetNode;
    }

    private static void printAnswer(int start, int end){
        print(nodes[end - 1]);
        System.out.println("从" + start + "到" + end + "号结点的最短距离为" + nodes[end - 1].theDistanceToThisNode);
    }

    private static void print(Node node){
        if(null != node){
            print(node.forwardNode);
            System.out.println("在" + node.serialNumber + "号结点, 此时距出发点距离为" + node.theDistanceToThisNode);
        }

    }









    /**
     * 要到达的结点只会有两种情况, 一种是forward为null, 一种是非null
     * 两种情况下, 都是使用current结点的距离加上边的长度, 得到到达该destination结点的距离
     * @param currentNode 当前结点
     * @param edge 所使用的边
     * @return 走此条边到达目的结点的总距离
     */
    private static int getTheDistanceOfTheCurrentPath(Node currentNode,
                                                      UndirectedEdge edge){
            return currentNode.theDistanceToThisNode + edge.sideLength;
    }

    /**
     * 通过边和当前结点, 获取目标结点
     * @param edge 无向边
     * @param departureNode 当前结点
     * @return 获取使用该边能到达的结点, 如果没有能够到达的结点, 返回null
     */
    private static Node getTheDestinationNode(UndirectedEdge edge, Node departureNode) {
        if(edge.startNodeIndex == departureNode.serialNumber || edge.endNodeIndex == departureNode.serialNumber){
            return edge.startNodeIndex == departureNode.serialNumber ?
                    nodes[edge.endNodeIndex - 1] : nodes[edge.startNodeIndex - 1];
        } else{
            return null;
        }

    }



    /**
     * 传入结点, 判断该结点是否已经被标记过
     * @param node 要判断的结点
     * @return 返回该结点是否已经被标记过
     */
    private static boolean isUnmarked(Node node){
        return !markedPoints.contains(node);
    }

    private static Node getTheLessDistanceNode(Node node1, Node node2){
        return node1.theDistanceToThisNode < node2.theDistanceToThisNode ? node1 : node2;
    }

    public static void main(String[] args) {
        UndirectedEdge[] edges = new UndirectedEdge[7];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new UndirectedEdge();
        }
        edges[0].startNodeIndex = 1;
        edges[0].endNodeIndex = 2;
        edges[0].sideLength = 1;

        edges[1].startNodeIndex = 1;
        edges[1].endNodeIndex = 3;
        edges[1].sideLength = 2;

        edges[2].startNodeIndex = 2;
        edges[2].endNodeIndex = 4;
        edges[2].sideLength = 3;

        edges[3].startNodeIndex = 3;
        edges[3].endNodeIndex = 4;
        edges[3].sideLength = 1;

        edges[4].startNodeIndex = 3;
        edges[4].endNodeIndex = 5;
        edges[4].sideLength = 3;

        edges[5].startNodeIndex = 5;
        edges[5].endNodeIndex = 6;
        edges[5].sideLength = 2;

        edges[6].startNodeIndex = 4;
        edges[6].endNodeIndex = 6;
        edges[6].sideLength = 2;
        System.out.println(getMinDistance(6, 1, 6, edges));
        printAnswer(1, 6);
    }
}
