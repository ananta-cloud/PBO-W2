
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Karyawan {
    private String id;
    private String nama;
    private String jabatan;
    private String divisi;

    // Constructor
    public Karyawan(String id, String nama, String jabatan, String divisi) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.divisi = divisi;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getDivisi() {
        return divisi;
    }

    // Setter
    public void setId(String newId) {
        this.id = newId;
    }

    public void setNama(String newNama) {
        this.nama = newNama;
    }

    public void setJabatan(String newJabatan) {
        this.jabatan = newJabatan;
    }

    public void setDivisi(String newDivisi) {
        this.divisi = newDivisi;
    }

    @Override // agar bisa menampilkan karyawan sebagai string
    public String toString() {
        return "  ID      : " + id + "\n" +
               "  Nama    : " + nama + "\n" +
               "  Jabatan : " + jabatan + "\n" +
               "  Divisi  : " + divisi ;
    }
}

class Kantor {
    private List<Karyawan> daftarKaryawan; // Menggunakan ArrayList untuk menyimpan daftar karyawan secara dinamis.

    // Constructor
    public Kantor() {
        this.daftarKaryawan = new ArrayList<>();
    }

    // Input karyawan
    public void tambahKaryawan(Karyawan karyawan) {
        daftarKaryawan.add(karyawan);
        System.out.println("-> Berhasil menambahkan karyawan: " + karyawan.getNama());
    }

    // tampilkan karyawan
    public void tampilkanSemuaKaryawan() {
        System.out.println("\n--- Daftar Karyawan ---");
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
        } else {
            for (Karyawan karyawan : daftarKaryawan) {
                System.out.println(karyawan);
            }
        }
        System.out.println("-----------------------");
    }

    public void hapusKaryawan(String id) {
        // Mencari karyawan dengan ID yang sesuai, dan menghapusnya jika ditemukan.
        boolean isRemoved = daftarKaryawan.removeIf(karyawan -> karyawan.getId().equalsIgnoreCase(id));

        if (isRemoved) {
            System.out.println("-> Karyawan dengan ID " + id + " berhasil dihapus.");
        } else {
            System.out.println("-> Karyawan dengan ID " + id + " tidak ditemukan.");
        }
    }
}

public class perkantoran {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kantor kantor = new Kantor();
        int pilihan = 0;

        // Loop utama aplikasi
        while (pilihan != 4) {
            // Menampilkan menu
            System.out.println("===== SISTEM MANAJEMEN KANTOR =====");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Tampilkan Semua Karyawan");
            System.out.println("3. Hapus Karyawan");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt(); // Membaca input pilihan dari pengguna
            scanner.nextLine();
            System.out.println("");

            switch (pilihan) {// Menggunakan switch untuk menentukan aksi berdasarkan pilihan
                case 1:
                    System.out.print("Masukkan ID Karyawan   : ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama Karyawan : ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jabatan       : ");
                    String jabatan = scanner.nextLine();
                    System.out.print("Masukkan Divisi        : ");
                    String divisi = scanner.nextLine();

                    // Membuat objek Karyawan baru dan menambahkannya ke kantor
                    kantor.tambahKaryawan(new Karyawan(id, nama, jabatan, divisi));
                    break;
                case 2:
                    kantor.tampilkanSemuaKaryawan();
                    break;
                case 3:
                    System.out.print("Masukkan ID Karyawan yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    kantor.hapusKaryawan(idHapus);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem ini. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        scanner.close();
    }
}
