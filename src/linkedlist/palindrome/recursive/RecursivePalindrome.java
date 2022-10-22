package linkedlist.palindrome.recursive;

class RecursivePalindrome {

    public static void main(String[] args) {
        Tree tree = new Tree(0);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(3);
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(0);
        int len = lenOfNodes(tree.root);
        Result result = palindrome(tree.root, len);
        System.out.println(result.isPalindrome);

    }
    static Result palindrome(Node head, int len){
        if(head == null || len <= 0){
            return new Result(head , true);
        }else if(len == 1){
            return new Result(head.next, true);
        }

        Result result = palindrome(head.next, len - 2);
        boolean palindrome = result.node.data == head.data;

        return new Result(result.node.next, palindrome);
    }
    static int lenOfNodes(Node head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}
class Result{
    Node node;
    boolean isPalindrome;

    public Result(Node node, boolean isPalindrome) {
        this.node = node;
        this.isPalindrome = isPalindrome;
    }
}