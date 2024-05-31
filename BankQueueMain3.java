package TUBES.TUBES2;

public class BankQueueMain3 {
    public static void main(String[] args) {
        StrukturQueue queue = new StrukturQueue();
        BankQueueGUI bankQueueGUI = new BankQueueGUI(queue);
        bankQueueGUI.displayGUI();
    }
}
