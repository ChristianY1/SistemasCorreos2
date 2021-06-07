/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import java.util.Optional;

/**
 *
 * @author cy190
 */
public class Node {
     private Integer value;
    private Node left;
    private Node right;
 
    public Node(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    
    public void add(Integer value) {
    if (value < this.value) {
        if (left != null) {
            left.add(value);
        } else {
            left = new Node(value);
        }
    } else {
        if (right != null) {
            right.add(value);
        } else {
            right = new Node(value);
        }
    }
}
    public Optional<Node> find(Integer value) {
    if (value == this.value) {
        return Optional.of(this);
    } else if (value < this.value) {
        if (this.left != null) {
            return this.left.find(value);
        } else {
            return Optional.empty();
        }
    } else {
        if (this.right != null) {
            return this.right.find(value);
        } else {
            return Optional.empty();
        }
    }
}
    
}
