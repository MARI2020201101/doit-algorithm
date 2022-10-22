package linkedlist.palindrome.stack;
import java.util.Stack;

class Palindrome {
    public static void main(String[] args) {
        Tree tree = new Tree(0);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(0);
        System.out.println(palindrome(tree.root));

    }
    static boolean palindrome(Node head){
        Node slow = head;
        Node fast = head;
        Stack<Node> stack = new Stack<>();
        while(fast != null && fast.next != null){
            stack.push(slow);

            slow = slow.next;
            fast = fast.next.next;

        }
        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            Node node = stack.pop();
            if(node.data != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
