

public class StrukturQueue3 {
    private NodeQueue FRONT;
    private NodeQueue REAR;
    private int size;
    private int nextNumber; // Menyimpan nomor antrian berikutnya

    public StrukturQueue3() {
        this.FRONT = null;
        this.REAR = null;
        this.size = 0;
        this.nextNumber = 1; // Mulai dari nomor antrian 1
    }

    public boolean isEmpty() {
        return FRONT == null;
    }

    public void enqueue(String namaCustomer, String noTelp, String email) {
        NodeQueue newNode = new NodeQueue(nextNumber++, namaCustomer, noTelp, email); // Otomatis mengisi nomor antrian
        if (isEmpty()) {
            FRONT = newNode;
            REAR = newNode;
        } else {
            REAR.setNext(newNode);
            REAR = newNode;
        }
        size++;
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

    public String getQueueDisplay() {
        StringBuilder display = new StringBuilder();
        if (isEmpty()) {
            display.append("Element queue : Element Kosong\n");
        } else {
            display.append("Elemen queue : \n");
            NodeQueue curNode = FRONT;
            while (curNode != null) {
                display.append("No Antrian : ").append(curNode.getData()).append("\n");
                display.append("Nama Nasabah : ").append(curNode.getnamaCustomer()).append("\n");
                display.append("Nomor Telepon : ").append(curNode.getnoTelp()).append("\n");
                display.append("Email : ").append(curNode.getEmail()).append("\n\n");
                curNode = curNode.getNext();
            }
        }
        return display.toString();
    }
}
