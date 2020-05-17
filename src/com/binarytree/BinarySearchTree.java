package com.binarytree;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @description: 二叉查找树
 * @author: Andy
 * @date: 2020/5/9 22:22
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    /** 二叉树的根节点 */
    private Node root;

    /** 二叉树的节点内部类 */
    private class Node {
        private Key key; // 键
        private Value val; // 值
        private Node left, right; // 左子树和右子树
        private int n = 0; // 以该结点为根的树的结点数

        // 构造函数
        public Node(Key key, Value value, int n) {
            this.key = key;
            this.val = value;
            this.n = n;
        }
    }

    /**
     * 查询树所有的个节点数量
     *
     * @return 节点数量
     */
    public int size() {
        return size(root);
    }

    /**
     * 查询指定节点为根的子树所有的个节点数量
     *
     * @param node 指定节点
     * @return 节点数量
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 根据指定key找到对应的value
     *
     * @param key 目标键
     * @return 值
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 在以指定节点韦根的子树中查找指定键所对应的值
     *
     * @param x 指定节点
     * @param key 键
     * @return 值
     */
    private Value get(Node x, Key key) {
        // 如果节点的为空，则返回null
        if (x == null) {
            return null;
        }
        // 根据指定key与当前key的比较决定遍历树的方式
        int temp = key.compareTo(x.key);
        if (temp > 0) {
            return get(x.right, key);
        } else if (temp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    /**
     * 向树中添加一个节点，如果节点已经存在则更新它的值。
     *
     * @param key 键值
     * @param value 值
     */
    public void put(Key key, Value value) {
        // 查找key，找到则更新其值，否则为他新建一个节点
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        // 如果key存在于以x为节点的子树中则更新它的值
        // 否则插入新的节点
        if (x == null) {
            return new Node(key, value, 1);
        }
        int temp = key.compareTo(x.key);
        if (temp > 0) {
            x.right = put(x.right, key, value);
        } else if (temp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.val = value;
        }
        // 更新树的结点数
        x.n = size(x.right) + size(x.left) + 1;
        return x;
    }

    /**
     * 获取树中最小的键
     *
     * @return 键
     */
    public Key min() {
        return min(root).key;
    }

    private Node min(Node n) {
        // 如果子树的左节点为空则返回当前节点，否则向下遍历
        if (n.left == null) {
            return n;
        }
        return min(n.left);
    }

    /**
     * 找到小于等于指定key的最大键
     *
     * @param key 指定key
     * @return 键
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int temp = key.compareTo(x.key);
        if (temp == 0) {
            return x;
        } else if (temp < 0) {
            return floor(x.left, key);
        }
        // 如果要寻找的key在节点的右边，则遍历查找
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
     * 返回排名为k的键
     *
     * @param k 排名
     * @return 键
     */
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        // 比较结点数与k的大小，因为排名为k的节点为根的子树中共有k个节点
        int t = size(x.left);
        if (k > t) {
            return select(x.right, k - t - 1);
        } else if (k < t) {
            return select(x.left, k);
        }
        return x;
    }

    /**
     * 在符号表中小于key的键值的数量
     *
     * @param key 指定键
     * @return 数据量
     */
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        // 返回以x为节点的子树中小于x.key的键的数量
        if (x == null) {
            return 0;
        }
        int temp = key.compareTo(x.key);
        if (temp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else if (temp < 0) {
            return rank(x.left, key);
        } else {
            return size(x.left);
        }
    }

    /** 删除符号表中的最小的键和其对应的值 */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        // 更新节点的数量
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除符号表中的键值为key的键值对
     *
     * @param key 键值
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        // 比较当前节点的大小和指定key的大小，以决定遍历的方向
        int temp = key.compareTo(x.key);
        if (temp > 0) {
            // 遍历右子树
            x.right = delete(x.right, key);
        } else if (temp < 0) {
            // 遍历左子树
            x.left = delete(x.left, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node t = x;
            // 将节点指向右树中的最小节点
            x = min(x.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

    public static void main(String[] args) {
        BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>();
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);
        st.put("d", 4);
        st.put("e", 5);
        st.deleteMin();
        for (String s : st.levelOrder()) {
            StdOut.println(s + " " + st.get(s));
        }
        StdOut.println(st.min() + " " + st.floor("d") + st.select(3));
        StdOut.println("-------------");
        for (String s : st.levelOrder()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
