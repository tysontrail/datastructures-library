package mylib;

public class TNode {

  private int data;
  private TNode left;
  private TNode right;
  private TNode parent;
  private int balance;

  public TNode() {
    setData(0);
    setBalance(0);
    setParent(null);
    setLeft(null);
    setRight(null);
  }

  public TNode(int data, int balance, TNode P, TNode L, TNode R) {
    setData(data);
    setBalance(balance);
    setParent(P);
    setLeft(L);
    setRight(R);
  }

  public void setParent(TNode parent) {
    this.parent = parent;
  }

  public TNode getParent() {
    return parent;
  }

  public TNode getLeft() {
    return left;
  }

  public void setLeft(TNode left) {
    this.left = left;
  }

  public TNode getRight() {
    return right;
  }

  public void setRight(TNode right) {
    this.right = right;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void print() {
    System.out.println(toString());
  }

  @Override
  public String toString() {
    return getData() + " " + getBalance();
  }

  public void decrementBalance() {
    this.balance--;
  }

  public void incrementBalance() {
    this.balance++;
  }
}
