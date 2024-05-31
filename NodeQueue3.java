

public class NodeQueue3 {
    private int data;
    private NodeQueue next;
    private String namaCustomer;
    private String noTelp;
    private String email;

    public NodeQueue3(int data, String namaCustomer, String noTelp, String email) {
        this.data = data;
        this.namaCustomer = namaCustomer;
        this.noTelp = noTelp;
        this.email = email;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public String getnamaCustomer() {
        return namaCustomer;
    }

    public String getnoTelp() {
        return noTelp;
    }

    public String getEmail() {
        return email;
    }

    public NodeQueue getNext() {
        return next;
    }

    public void setNext(NodeQueue next) {
        this.next = next;
    }
}
