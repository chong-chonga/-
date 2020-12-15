package cn.leetcode.tree;

import cn.leetcode.tree.domain.TreeNode;
import org.junit.Test;

import java.security.KeyManagementException;
import java.util.*;

/**
 * @author 悠一木碧
 * 题目编号: 107
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        addNodeIfExist(root, nodes);
        traversal(nodes, ans);
        return ans;
    }

    private void addNodeIfExist(TreeNode node, List<TreeNode> nodes){
        if(null != node){
            nodes.add(node);
        }
    }

    private void traversal(List<TreeNode> nodesGroup, List<List<Integer>> ans){
        if(existNodesIn(nodesGroup)){
            List<TreeNode> newNodes = new ArrayList<>();
            List<Integer> oneAnswer = new ArrayList<>();

            for(TreeNode node : nodesGroup){
                oneAnswer.add(node.val);
                addNodeIfExist(node.left, newNodes);
                addNodeIfExist(node.right, newNodes);
            }
            traversal(newNodes, ans);
            ans.add(oneAnswer);
        }
    }

    private boolean existNodesIn(List<TreeNode> nodes){
        return null != nodes && 0 != nodes.size();

    }

    /**
     * 编号:5516
     * @param keyName
     * @param keyTime
     * @return
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> persons = new HashMap<>();
        List<String> times;
        for (int i = 0; i < keyName.length; i++) {
            if(!persons.containsKey(keyName[i])){
                times = new ArrayList<>();

            } else{
                times = persons.get(keyName[i]);
            }
            times.add(keyTime[i]);
            persons.put(keyName[i], times);
        }
        Set<String> names = persons.keySet();
        List<String> ans = new ArrayList<>();

        for (String name : names) {
            if(warning(persons.get(name))){
                ans.add(name);
            }
        }
        ans.sort(String::compareTo);
        return ans;
    }

    private boolean warning(List<String> times){
        if(times.size() < 3){
            return false;
        }
        int[] arr = new int[times.size()];
        int index = 0;
        for (int i = 0; i < times.size(); i++) {
            String s = times.get(i);
            String[] split = s.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            arr[index++] = hour * 60 + minute;
        }
        Arrays.sort(arr);
        int flag = 1;
        int startIndex = 0;
        for(int i = 0; i < arr.length - 2; i++){
            flag = 1;
            for(int j = i + 1; j <= i + 2; j++){
                if(arr[j] - arr[i] <= 60){
                    flag++;
                } else{
                    break;
                }
                if(3 == flag){
                    return true;
                }
            }

        }
        return false;
    }

}
