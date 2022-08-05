package com.example;

public class AVLNode extends StudentBNode {
  private int balance;
  private AVLNode left, right, parent;
  private Student student;

  // Constructor method to set balance to 0
  public AVLNode(Student student) {
    setBalance(0);
    setStudent(student);
    setParent(null);
    setLeft(null);
    setRight(null);
  }

  public AVLNode() {
    setBalance(0);
    setStudent(null);
    setParent(null);
    setLeft(null);
    setRight(null);
  }

  @Override
  public void print() {
    System.out.println(getStudent() + " " + Integer.toString(getBalance()));
  }

  public AVLNode getLeft() {
    return left;
  }

  public void setLeft(AVLNode left) {
    this.left = left;
  }

  public AVLNode getRight() {
    return right;
  }

  public void setRight(AVLNode right) {
    this.right = right;
  }

  public AVLNode getParent() {
    return parent;
  }

  public void setParent(AVLNode parent) {
    this.parent = parent;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void decrementBalance() {
    this.balance--;
  }

  public void incrementBalance() {
    this.balance++;
  }
}
