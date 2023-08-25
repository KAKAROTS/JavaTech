# 是否循环链表算法

```java
 
public class Node {
    
    private Node next;

    public  boolean cycle(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node step1 = node.next;
        Node step2 = node.next.next;
        while (true) {
            if (step2 == null || step2.next == null) {
                return false;
            }
            if (step1 == step2) {
                return true;
            }
            step1 = step1.next;
            step2 = step2.next.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        node1.next=node2;
        Node node3 = new Node();
        node2.next=node3;
        Node node4 = new Node();
        node3.next=node4;
        Node node5 = new Node();
        node4.next=node5;
        node5.next=node1;
        System.out.println("node is cycle = " + cycle(node1));
        
    }
}

```