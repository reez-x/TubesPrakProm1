package TUBES;

import java.util.Scanner;

public class BankQueueMain {
    public static void main(String[] args) {
        StrukturQueue queue = new StrukturQueue();
        Scanner scanner = new Scanner(System.in);
        int pilihan, number;
        String nama, noTelp, email;

        do {
            System.out.println("===== Sistem Antrian Bank =====");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Antrian");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer setelah nextInt()

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nomor antrian: ");
                    number = scanner.nextInt();
                    scanner.nextLine();  // Membersihkan buffer setelah nextInt()
                    System.out.print("Masukkan nama nasabah: ");
                    nama = scanner.nextLine();  // Membaca seluruh baris input untuk nama nasabah
                    System.out.print("Masukkan nomor telepon: ");
                    noTelp = scanner.nextLine();  // Membaca seluruh baris input untuk nomor telepon
                    System.out.print("Masukkan email: ");
                    email = scanner.nextLine();  // Membaca seluruh baris input untuk email
                    queue.enqueue(number, nama, noTelp, email);
                    break;
                case 2:
                    NodeQueue servedCustomer = queue.dequeue();
                    if (servedCustomer != null) {
                        System.out.println("Melayani nasabah dengan nomor antrian: " + servedCustomer.getData() +
                                           ", Nama: " + servedCustomer.getnamaCustomer() +
                                           ", Nomor Telepon: " + servedCustomer.getnoTelp() +
                                           ", Email: " + servedCustomer.getEmail());
                    }
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Terima kasih! Sistem antrian ditutup.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();  // Menutup objek Scanner setelah selesai digunakan
    }
}