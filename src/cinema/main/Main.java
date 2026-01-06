package cinema.main;

import cinema.model.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Sinema rezervasyon sisteminin ana sinifi.
 * Kullanici etkilesimi ve rezervasyon akisini yonetir.
 *
 * @author [Ahmet Yiğit Sunar]
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== DOLU KOLTUKLAR =====
        Set<String> reservedSeats = new HashSet<>();
        reservedSeats.add("A1");
        reservedSeats.add("A2");
        reservedSeats.add("B5");
        reservedSeats.add("C3");

        System.out.println("🎬 Sinema Rezervasyon Sistemine Hoş Geldiniz");

        // ===== KULLANICI BİLGİLERİ =====

        String name;
        while (true) {
            System.out.print("Adınız: ");
            name = scanner.nextLine().trim();
            if (name.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]{3,}")) break;
            System.out.println("❌ İsim en az 3 harf olmalıdır.");
        }

        String email;
        while (true) {
            System.out.print("Email (gmail.com veya email.com): ");
            email = scanner.nextLine().trim();
            if ((email.endsWith("@gmail.com") || email.endsWith("@email.com"))
                    && email.indexOf("@") > 0) break;
            System.out.println("❌ Geçersiz email.");
        }

        String phone;
        while (true) {
            System.out.print("Telefon (05XXXXXXXXX): ");
            phone = scanner.nextLine().trim();
            if (phone.matches("05\\d{9}")) break;
            System.out.println("❌ Geçersiz telefon.");
        }

        // ===== FİLM & SEANS =====

        System.out.println("\nFilm Seçiniz:");
        System.out.println("1 - Inception (2D)");
        System.out.println("2 - Avatar (3D)");
        int filmChoice;
        while (true) {
            System.out.print("Seçiminiz (1-2): ");
            if (scanner.hasNextInt()) {
                filmChoice = scanner.nextInt();
                if (filmChoice == 1 || filmChoice == 2) break;
            } else {
                scanner.next();
            }
            System.out.println("❌ Geçersiz seçim. Lütfen 1 veya 2 girin.");
        }

        Movie selectedMovie = (filmChoice == 1)
                ? new Movie2D("Inception", "Sci-Fi", 148, 100)
                : new Movie3D("Avatar", "Fantasy", 162, 120, 30);

        System.out.println("\nSaat Seçiniz:");
        System.out.println("1 - 18:00");
        System.out.println("2 - 21:00");
        int timeChoice;
        while (true) {
            System.out.print("Seçiminiz (1-2): ");
            if (scanner.hasNextInt()) {
                timeChoice = scanner.nextInt();
                if (timeChoice == 1 || timeChoice == 2) break;
            } else {
                scanner.next();
            }
            System.out.println("❌ Geçersiz seçim. Lütfen 1 veya 2 girin.");
        }

        String time = (timeChoice == 1) ? "18:00" : "21:00";
        ShowTime showTime = new ShowTime(selectedMovie, "2025-01-01", time);

        // ===== KOLTUK SEÇİMİ =====

        String row;
        int seatNumber;
        String seatKey;

        while (true) {
            System.out.println("\n🎟 Dolu Koltuklar: " + reservedSeats);

            System.out.print("Koltuk sırası (A/B/C): ");
            row = scanner.next().toUpperCase();

            System.out.print("Koltuk numarası (1-10): ");
            seatNumber = scanner.nextInt();

            seatKey = row + seatNumber;

            if (!row.matches("[ABC]") || seatNumber < 1 || seatNumber > 10) {
                System.out.println("❌ Geçersiz koltuk aralığı.");
                continue;
            }

            if (reservedSeats.contains(seatKey)) {
                System.out.println("❌ Bu koltuk dolu.");
                continue;
            }

            break;
        }

        Seat seat = new Seat(seatNumber, row, true);
        scanner.nextLine();

        // ===== DÜZELTME + ONAY MENÜSÜ =====

        while (true) {

            System.out.println("\n📋 GİRİLEN BİLGİLER");
            System.out.println("1 - İsim: " + name);
            System.out.println("2 - Email: " + email);
            System.out.println("3 - Telefon: " + phone);
            System.out.println("4 - Film: " + selectedMovie.getTitle());
            System.out.println("5 - Saat: " + showTime.getTime());
            System.out.println("6 - Koltuk: " + seat.getRow() + seat.getSeatNumber());
            System.out.println("0 - ONAYLA VE DEVAM ET");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            if (choice == 6) {
                while (true) {
                    System.out.println("🎟 Dolu Koltuklar: " + reservedSeats);
                    System.out.print("Yeni koltuk sırası: ");
                    row = scanner.next().toUpperCase();
                    System.out.print("Yeni koltuk numarası: ");
                    seatNumber = scanner.nextInt();

                    seatKey = row + seatNumber;

                    if (!row.matches("[ABC]") || seatNumber < 1 || seatNumber > 10) {
                        System.out.println("❌ Geçersiz koltuk.");
                        continue;
                    }

                    if (reservedSeats.contains(seatKey)) {
                        System.out.println("❌ Bu koltuk dolu.");
                        continue;
                    }

                    seat = new Seat(seatNumber, row, true);
                    break;
                }
            }
        }

        reservedSeats.add(seat.getRow() + seat.getSeatNumber());

        // ===== REZERVASYON ONAY =====

        Customer customer = new Customer(1, name, email, phone);
        Booking booking = new Booking(1, customer, showTime, seat);

        System.out.println("\n📋 REZERVASYON ÖZETİ");
        System.out.println("Müşteri: " + customer.getName());
        System.out.println("Film: " + selectedMovie.getTitle());
        System.out.println("Saat: " + showTime.getTime());
        System.out.println("Koltuk: " + seat.getRow() + seat.getSeatNumber());
        System.out.println("Ücret: " + selectedMovie.calculatePrice() + " TL");

        String confirmation;
        while (true) {
            System.out.print("\nRezervasyon onaylansın mı? (Y/N): ");
            confirmation = scanner.nextLine().trim().toUpperCase();
            if (confirmation.equals("Y") || confirmation.equals("N")) break;
            System.out.println("❌ Lütfen Y veya N girin.");
        }

        if (confirmation.equals("Y")) {
            System.out.println("\n✅ Rezervasyon Tamamlandı!");
            System.out.println("İyi seyirler!");
        } else {
            System.out.println("\n❌ Rezervasyon iptal edildi.");
        }
    }
}