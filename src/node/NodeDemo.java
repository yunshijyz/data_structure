package node;




public class NodeDemo {

    private Node head;

    private Node last;

    private int size;


    /**
     * 插入
     * @param data
     * @param index
     */
    public void insert(int index, int data){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出节点范围");
        }

        Node insertNode = new Node(data);

        if(size == 0){
            head = insertNode;
            last = insertNode;
        } else if (index == 0){
            insertNode.next = head;
            head = insertNode;
        } else if (size == index){
            last.next = insertNode;
            last = insertNode;
        } else {
            Node prevNode = get(index-1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }

        size++;

    }

    public Node get(int index){
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException("超出节点范围");
        }

        Node temp = head;
        for (int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void output(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }



    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        NodeDemo nodeDemo = new NodeDemo();
        nodeDemo.insert(0,3);
        nodeDemo.insert(1,7);
        nodeDemo.insert(2,9);
        nodeDemo.insert(3,5);

        nodeDemo.output();
    }

}
