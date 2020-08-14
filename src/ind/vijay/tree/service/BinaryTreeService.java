package ind.vijay.tree.service;

import ind.vijay.tree.entity.BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeService {

    /**
     * 插入节点，如果当前的节点没有左节点，创建一个新节点，然后将其设置为当前节点的左节点
     * @param node
     * @param value
     */
    public void insertLeft(BinaryTree node, String value) {
        if(null != node) {
            if(null == node.getLeft()) {    // 如果当前节点的左节点为null, 根据输入的数据，创建一个节点并插入
                node.setLeft(new BinaryTree(value));
            } else {    // 如果当前节点有左节点，根据当前值，实例化一个节点，它的左节点赋值为当前节点的左节点，该实例化的节点将会替代当前节点的左节点位置
                BinaryTree newNode = new BinaryTree(value);
                newNode.setLeft(node.getLeft());
                node.setLeft(newNode);
            }
        }
    }

    /**
     *插入右节点，原理同插入左节点
     * @param node
     * @param value
     */
    public void insertRight(BinaryTree node, String value) {
        if(null != node) {
            if(null == node.getRight()) {
                node.setRight(new BinaryTree(value));
            } else {
                BinaryTree newNode = new BinaryTree(value);
                newNode.setRight(node.getRight());
                node.setRight(newNode);
            }
        }
    }

    /**
     * DFS 深度优先遍历，前序遍历，先使用本节点数据，然后遍历左节点，再遍历右节点，如果没有其中一个节点就会跳过，去遍历另一节点，如果左右节点都没有，回溯
     * @return
     */
    public void dfsPreOrder(BinaryTree node, List<String> result) {
        result.add(node.getData());
        if(null != node.getLeft()) dfsPreOrder(node.getLeft(), result);
        if(null != node.getRight()) dfsPreOrder(node.getRight(), result);
    }

    /**
     * DFS 深度优先遍历，中序遍历，先遍历左节点，然后使用本节点数据，再遍历右节点，如果没有其中一个节点就会跳过，去遍历另一节点，如果左右节点都没有，回溯
     * @return
     */
    public void dfsMidOrder(BinaryTree node, List<String> result) {
        if(null != node) {
            if(null != node.getLeft()) dfsMidOrder(node.getLeft(), result);
            result.add(node.getData());
            if(null != node.getRight()) dfsMidOrder(node.getRight(), result);
        }
    }

    /**
     * DFS 深度优先遍历，后序遍历，先遍历左节点，再遍历右节点，然后使用本节点数据，如果没有其中一个节点就会跳过，去遍历另一节点，如果左右节点都没有，回溯
     * @return
     */
    public void dfsPostOrder(BinaryTree node, List<String> result) {
        if(null != node) {
            if(null != node.getLeft()) dfsMidOrder(node.getLeft(), result);
            if(null != node.getRight()) dfsMidOrder(node.getRight(), result);
            result.add(node.getData());
        }
    }

    /**
     * BFS 广度优先遍历，初始化时，先输入根节点到队列，然后队列吐出最近的一个节点作为本次迭代的节点，本次节点获取数据，然后再吞入本次迭代的左右节点，完成一次迭代，等到队列没有任何节点时，才停止
     * @param node
     * @return
     */
    public List<String> bfsOrder(BinaryTree node) {
        List<String> result = new LinkedList<>();

        if(null != node) {
            Queue<BinaryTree> queue = new ArrayDeque<>();
            queue.add(node);    // 初始化遍历时，添加根节点

            while(!queue.isEmpty()) {
                BinaryTree currentNode = queue.poll();  // 队列吐出本次迭代节点，直至队列为空后，退出迭代循环
                result.add(currentNode.getData());

                if(null != currentNode.getLeft()) queue.add(currentNode.getLeft());     // 队列添加本节点的左右节点，作为下一次迭代的来源
                if(null != currentNode.getRight()) queue.add(currentNode.getRight());
            }
        }

        return result;
    }
}
