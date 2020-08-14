package ind.vijay.tree.controller;

import ind.vijay.tree.entity.BinaryTree;
import ind.vijay.tree.service.BinaryTreeService;

import java.util.LinkedList;
import java.util.List;

public class MainRun {
    public static void main(String[] args) {
        BinaryTreeService service = new BinaryTreeService();

        BinaryTree root = new BinaryTree("a");   // 创建一个没有节点的根
        service.insertLeft(root, "b");
        service.insertRight(root, "c");

        BinaryTree node_b = root.getLeft();
        service.insertRight(node_b, "d");

        BinaryTree node_c = root.getRight();
        service.insertLeft(node_c, "e");
        service.insertRight(node_c, "f");

        BinaryTree node_d = node_b.getRight();
        BinaryTree node_e = node_c.getLeft();
        BinaryTree node_f = node_c.getRight();

        System.out.println("【node root(a) data】: " + root.getData());
        System.out.println("【node b data】: " + node_b.getData());
        System.out.println("【node c data】: " + node_c.getData());
        System.out.println("【node d data】: " + node_d.getData());
        System.out.println("【node e data】: " + node_e.getData());
        System.out.println("【node f data】: " + node_f.getData());

        List<String> result = new LinkedList<>();
        System.out.println("【DFS 先序遍历】: ");
        service.dfsPreOrder(root, result);
        result.stream().forEach(item -> {
            System.out.println("节点数据: " + item);
        });

        result.clear();
        System.out.println("【DFS 中序遍历】: ");
        service.dfsMidOrder(root, result);
        result.stream().forEach(item -> {
            System.out.println("节点数据: " + item);
        });

        result.clear();
        System.out.println("【DFS 后序遍历】: ");
        service.dfsPostOrder(root, result);
        result.stream().forEach(item -> {
            System.out.println("节点数据: " + item);
        });

        result.clear();
        System.out.println("【BFS 遍历】: ");
        result = service.bfsOrder(root);
        result.stream().forEach(item -> {
            System.out.println("节点数据: " + item);
        });
    }
}
