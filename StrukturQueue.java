package TUBES;

public class StrukturQueue {
    private NodeQueue FRONT;
    private NodeQueue REAR;
    private int size;
    private int currentNumber;

    public StrukturQueue() {
        this.FRONT = null;
        this.REAR = null;
        this.size = 0;
        this.currentNumber = 1;
    }

    public boolean isEmpty() {
        return FRONT == null;
    }

    public void enqueue(String namaCustomer, String noTelp, String email) {
        NodeQueue newNode = new NodeQueue(currentNumber, namaCustomer, noTelp, email);
        if (isEmpty()) {
            FRONT = newNode;
            REAR = newNode;
        } else {
            REAR.setNext(newNode);
            REAR = newNode;
        }
        size++;
        currentNumber++;
    }

    public NodeQueue dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong");
            return null;
        } else {
            NodeQueue temp = FRONT;
            FRONT = FRONT.getNext();
            size--;
            if (FRONT == null) {
                REAR = null;
            }
            return temp;
        }
    }

    public int size() {
        return size;
    }

    public NodeQueue front() {
        return FRONT;
    }

    public NodeQueue rear() {
        return REAR;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Element queue : Element Kosong");
        } else {
            System.out.println();
            System.out.println("Elemen queue : ");
            System.out.println();
            NodeQueue curNode = FRONT;
            while (curNode != null) {
                System.out.println("No Antrian : " + curNode.getData());
                System.out.println("Nama Nasabah : " + curNode.getnamaCustomer());
                System.out.println("Nomor Telepon : " + curNode.getnoTelp());
                System.out.println("Email : " + curNode.getEmail());
                curNode = curNode.getNext();
                System.out.println();
            }
        }
    }
}
