package ind.vijay.tree.entity;

public class BinaryTree {
    private BinaryTree left;    // 左节点
    private BinaryTree right;   // 右节点

    private String data;    // 树的内容

    public BinaryTree() {}

    public BinaryTree(String data, BinaryTree left, BinaryTree right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTree(String data) {
        this(data, null, null);
    }

    public String getData() {return data;

    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
