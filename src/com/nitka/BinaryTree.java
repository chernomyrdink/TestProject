package com.nitka;

import java.util.Random;

public class BinaryTree {
    BinaryTreeNode root;

    public Integer getHeight(){
        return height(root);
    }

    private Integer height(BinaryTreeNode node){
        int leftHeight, rightHeight;
        if(node==null){
            return 0;
        }
        leftHeight = height(node.getLeft());
        rightHeight = height(node.getRight());
        if(leftHeight>rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;

    }

    public void addNode(int number){
        if(root==null){
            root = new BinaryTreeNode();
            root.setItem(number);
            return;
        }
        addNode(number, root);
    }

    public void addNode(int number, BinaryTreeNode node){
        if(number < node.getItem()){
            if(node.getRight() != null) {
                addNode(number, node.getRight());
                return;
            }
            BinaryTreeNode nodeToAdd = new BinaryTreeNode();
            nodeToAdd.setItem(number);
            node.setRight(nodeToAdd);
        }
        else {
            if (node.getLeft() != null) {
                addNode(number, node.getLeft());
                return;
            }
            BinaryTreeNode nodeToAdd = new BinaryTreeNode();
            nodeToAdd.setItem(number);
            node.setLeft(nodeToAdd);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < 10; i++) {
            binaryTree.addNode(new Random().nextInt(10));
        }
        System.out.print(binaryTree.getHeight());
    }
}
