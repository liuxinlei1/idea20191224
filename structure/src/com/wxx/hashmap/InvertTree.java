package com.wxx.hashmap;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 14:02
 */
public class InvertTree {
    //树的结构
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     *反转二叉树
     *  * @param treeNode
     * @return
     */
    public static Node invert(Node root){
        //判断是否是叶子节点
        if (root==null){
            return null;
        }
        
        //翻转左子树的下的左右节点
        Node leftTree = invert(root.left);
        Node rightTree = invert(root.right);
        
        //左右节点下的二叉树进行翻转
        root.left=rightTree;
        root.right=leftTree;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        
        root.right.left=new Node(6);
        root.right.right=new Node(7);

         root = invert(root);

        printTree(root);
        
    }










    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }
    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
    
}
