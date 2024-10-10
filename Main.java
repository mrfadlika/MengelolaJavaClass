import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<Nasabah> nasabah;
    private int jumlahNasabah;

    public Bank() {
        nasabah = new ArrayList<>();
        jumlahNasabah = 0;
    }

    public void tambahNasabah(String nama) {
        nasabah.add(new Nasabah(nama));
        jumlahNasabah++;
    }

    public Nasabah getNasabah(int indeks) {
        if (indeks >= 0 && indeks < jumlahNasabah) {
            return nasabah.get(indeks);
        }
        return null;
    }

    public void printNasabahInfo() {
        System.out.println("Jumlah : " + jumlahNasabah);
        for (int i = 0; i < jumlahNasabah; i++) {
            nasabah.get(i).printInfo(i + 1); // Meminta Nasabah untuk mencetak informasi dirinya
        }
    }
}

class Nasabah {
    private String nama; // Hanya satu variabel untuk menyimpan nama lengkap
    private List<Tabungan> tabungan;

    public Nasabah(String nama) {
        this.nama = nama;
        this.tabungan = new ArrayList<>();
    }

    public void tambahTabungan(Tabungan tabungan) {
        this.tabungan.add(tabungan);
    }

    // Tambahkan metode ini untuk mencetak informasi nasabah
    public void printInfo(int nomorNasabah) {
        double totalSaldo = 0;
        for (Tabungan t : tabungan) {
            totalSaldo += t.getSaldo();
        }
        // Cetak nama lengkap sebagai bagian dari output
        System.out.printf("Nasabah %d : %s ; Saldo = %.2f\n",
                nomorNasabah, nama, totalSaldo);
    }
}

class Tabungan {
    private double saldo;

    public Tabungan(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.tambahNasabah("Raffi Fadlika");
        bank.tambahNasabah("Mayersi Putra");

        Nasabah nasabah1 = bank.getNasabah(0);
        nasabah1.tambahTabungan(new Tabungan(1000000));
        nasabah1.tambahTabungan(new Tabungan(500000));

        Nasabah nasabah2 = bank.getNasabah(1);
        nasabah2.tambahTabungan(new Tabungan(2000000));

        bank.printNasabahInfo();
    }
}