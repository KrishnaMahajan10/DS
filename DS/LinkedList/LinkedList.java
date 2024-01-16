public class LinkedList {

    private Node head;
     
    public Node getHead() {
        return head;
    }

    public LinkedList() {
        head = null;
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);//creating object of node
        if(newNode == null) {  //if node is null dont insert
            return false;
        }

        if(head == null) { //if head is null  assign new node to head
            head = newNode;
            return true;
        }

        Node last = head; //creating last node
        while(last.getNext() != null) {  //if last node refrence is not null dat means its not last node
            last = last.getNext();  //so find next node to it
        }

        last.setNext(newNode); // when you get last node set new node as its next

        return true;
    }

    public void display() {

        Node temp = head; //temperary variable heads value is assigned

        while(temp != null) { //till temperary variable is not null
            System.out.print(temp.getData() + " "); //print that variable
            temp = temp.getNext(); //print and get its next
        }
        System.out.println();//empty print to get it to the next line
    }

    public boolean insert(int data, int position) { //for inserting using position
        if(position <= 0) {    //position cant be equal or less then 0
            return false;
        }

        Node newNode = new Node(data);  //again defining new node
        if(newNode == null) {  //new node cant be null
            return false;
        }

        if(position == 1) {  //if the position is 1 
            newNode.setNext(head); //new node heads next
            head = newNode; //head is new node
            return true;
        }

        //if the position is not 1

        //locate the prev node
        Node prev = head;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            //if the position is invalid, prev will become null
            if(prev == null) {
                return false;
            }
        }

        //link the newnode to the prev node
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);

        return true;

    }

    // public void display(Node firstNode) {

    //     if(firstNode == null) {
    //         System.out.println();
    //         return;
    //     }

    //     System.out.print(firstNode.getData() + " ");
    //     display(firstNode.getNext());
    // }

    public void displayRev(Node firstNode) {

        if(firstNode == null) {
            System.out.println();
            return;
        }

        displayRev(firstNode.getNext());
        System.out.print(firstNode.getData() + " ");
    }

    public boolean deleteByVal(int data) {
        if(head == null) {
            return false;
        }

        if(head.getData() == data) {
            head = head.getNext();
            return true;
        }

        Node del = head, prev = head;

        while(del.getData() != data) {
            prev = del;
            del = del.getNext();
            if(del == null) {
                return false;
            }
        }

        prev.setNext(del.getNext());

        return true;
    }

    public boolean deleteByPosition(int position) {

        if(head == null || position <= 0) {
            return false;
        }

        if(position == 1) {
            head = head.getNext();
            return true;
        }

        Node prev = head;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev.getNext() == null) {
                return false;
            }
        }

        Node del = prev.getNext();
        prev.setNext(del.getNext());

        return true;

    }

    public void reverse() {
        if(head == null || head.getNext() == null) {
            return;
        }

        Node n1 = head, n2 = head.getNext();
        Node n3;

        while(n2 != null) {
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = n3;
        }

        head.setNext(null);
        head = n1;
    }
}








