import java.util.ArrayList;

public class Cashier {
    private ArrayList<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayItems() {
        System.out.println("\nDaftar Item:");
        System.out.println("Kode\tNama\t\tHarga\tJumlah\tSubTotal");
        for (Item item : items) {
            System.out.println(item.getCode() + "\t" + item.getName() + "\t" + item.getPrice() +
                               "\t" + item.getQuantity() + "\t" + item.getSubTotal());
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getSubTotal();
        }
        return total;
    }

    public void processPayment(double total, double amountPaid) {
        if (amountPaid >= total) {
            double change = amountPaid - total;
            System.out.println("Pembayaran berhasil. Kembali: " + change);
        } else {
            System.out.println("Uang tidak cukup. Total: " + total);
        }
    }
}
