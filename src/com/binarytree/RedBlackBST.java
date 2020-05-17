package com.binarytree;

/**
 * @description: 红黑查找二叉树
 * @author: Andy
 * @date: 2020/5/12 20:53
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * 二叉树的根节点
     */
    private Node root;

    /**
     * 二叉树的节点
     */
    private class Node {
        Key key;// 键
        Value value;// 值
        Node left, right;// 左右子树
        boolean color;// 由父节点指向本节点的颜色
        int N = 0;// 这颗树中的结点个数

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.N = n;
            this.color = color;
        }
    }

    /**
     * 判断当前节点和其父节点的链接是否为红色
     *
     * @param node 节点
     * @return 判断结果
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    /**
     * 符号中的键值对数
     *
     * @return 键值对数
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        // 判断当前节点为根节点的子树终结点的个数
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    /**
     * 將子树进行左旋转
     *
     * @param node 节点
     * @return 左璇后的子树根节点
     */
    private Node rotateLeft(Node node) {
        Node t = node.right;
        node.right = t.left;
        t.left = node;
        t.color = node.color;
        node.color = RED;
        // 旋转前后总结点数不变
        t.N = node.N;
        node.N = 1 + size(node.left) + size(node.right);
        return t;
    }

    /**
     * 將子树进行右旋转
     *
     * @param node 节点
     * @return 右璇后的子树根节点
     */
    private Node rotateRight(Node node) {
        Node t = node.left;
        node.left = t.right;
        t.right = node;
        t.color = node.color;
        node.color = RED;
        // 旋转前后总结点数不变
        t.N = node.N;
        node.N = 1 + size(node.right) + size(node.left);
        return t;
    }

    /**
     * 转换当前节点和其子节点的颜色
     *
     * @param node 当前节点
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 向符号表中插入键值对，如果键已经存在则更新其值
     *
     * @param key   键
     * @param value 值
     */
    public void put(Key key, Value value) {

    }

    private Node put(Node node, Key key, Value value) {
        // 插入结点，与父节点用红链接相连
        if (node == null) {
            return new Node(key, value, 1, RED);
        }
        int temp = key.compareTo(node.key);
        if (temp > 0) {
            node.right = put(node.right, key, value);
        } else if (temp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }

        // 对子树进行检查，并进行颜色转换
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        // 更新节点数量
        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }
}
