# 🎬 Sinema Bilet Rezervasyon Sistemi

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Nesne Tabanlı Programlama Final Projesi - Güz 2025

## 📋 İçindekiler

- [Proje Hakkında](#proje-hakkında)
- [Özellikler](#özellikler)
- [Teknolojiler](#teknolojiler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Proje Yapısı](#proje-yapısı)
- [OOP Prensipleri](#oop-prensipleri)
- [Test Coverage](#test-coverage)
- [UML Diyagramları](#uml-diyagramları)
- [Geliştirici](#geliştirici)

## 🎯 Proje Hakkında

Bu proje, modern sinema işletmelerinin ihtiyaçlarına yönelik kapsamlı bir bilet rezervasyon sistemidir. Kullanıcılar film seçimi yapabilir, farklı film türlerine göre dinamik fiyatlandırma ile koltuk rezervasyonu gerçekleştirebilir.

Sistem, 2D ve 3D film formatları için farklılaştırılmış fiyatlandırma stratejileri içermekte olup, müsait koltukları görüntüleme, tercih edilen koltuğu seçme ve rezervasyon işlemlerini tamamlama özelliklerine sahiptir.

### 🎓 Proje Gereksinimleri

Bu proje aşağıdaki gereksinimleri karşılamaktadır:

- ✅ Nesne Yönelimli Programlama prensipleri
- ✅ UML diyagramları (Class & Use-Case)
- ✅ JUnit ile birim testleri
- ✅ Git & Github ile versiyon kontrolü
- ✅ Github Projects ile Kanban board
- ✅ Javadoc dokümantasyonu

## ✨ Özellikler

### Temel Özellikler

- 🎥 **Film Seçimi**: 2D ve 3D film formatları
- 💺 **Koltuk Rezervasyonu**: İnteraktif koltuk seçimi
- 👤 **Müşteri Yönetimi**: Müşteri bilgilerinin kaydı ve yönetimi
- 📅 **Seans Yönetimi**: Farklı tarih ve saatlerde seanslar
- 💰 **Dinamik Fiyatlandırma**: Film türüne göre otomatik fiyat hesaplama
- ❌ **Rezervasyon İptali**: Mevcut rezervasyonları iptal etme

### Teknik Özellikler

- 🔒 **Veri Güvenliği**: Encapsulation ile korunan veriler
- 🔄 **Genişletilebilirlik**: Interface ve abstract class kullanımı
- 🧪 **Test Edilebilirlik**: Kapsamlı JUnit testleri
- 📝 **Dokümantasyon**: Javadoc ile detaylı kod dokümantasyonu

## 🛠️ Teknolojiler

- **Dil**: Java 17+
- **Test Framework**: JUnit 5
- **Versiyon Kontrol**: Git & Github
- **Proje Yönetimi**: Github Projects (Kanban)
- **IDE**: IntelliJ IDEA

## 📥 Kurulum

### Gereksinimler

- Java Development Kit (JDK) 17 veya üzeri
- Git
- IntelliJ IDEA veya başka bir Java IDE

### Adımlar

1. **Projeyi klonlayın**
```bash
git clone https://github.com/yigitsunar/cinema-reservation-system.git
cd cinema-reservation-system
```

2. **Projeyi IDE'de açın**

IntelliJ IDEA ile projeyi açın ve bağımlılıkların yüklenmesini bekleyin.

3. **Projeyi çalıştırın**

Main.java dosyasını çalıştırarak uygulamayı başlatın.

## 🚀 Kullanım

### Programa Başlama

1. Programı çalıştırdığınızda karşılama ekranı görünecektir
2. İsim, email ve telefon bilgilerinizi girin
3. Film seçin (2D veya 3D)
4. Seans saati seçin
5. Müsait koltukları görüntüleyin
6. Koltuk seçin ve rezervasyonu onaylayın

### Örnek Kullanım
```
🎬 Sinema Rezervasyon Sistemine Hoş Geldiniz
Adınız: Ahmet Yılmaz
Email: ahmet@gmail.com
Telefon: 05551234567

Film Seçiniz:
1 - Inception (2D)
2 - Avatar (3D)
Seçiminiz: 2

Saat Seçiniz:
1 - 18:00
2 - 21:00
Seçiminiz: 1

🎟 Dolu Koltuklar: [A1, A2, B5, C3]
Koltuk sırası (A/B/C): B
Koltuk numarası (1-10): 3

✅ Rezervasyon Tamamlandı!
Müşteri: Ahmet Yılmaz
Film: Avatar
Saat: 18:00
Koltuk: B3
Ücret: 150.0 TL
```

## 📂 Proje Yapısı
```
cinema-reservation-system/
│
├── src/
│   └── cinema/
│       ├── interfacepkg/
│       │   └── Bookable.java          # Rezervasyon interface'i
│       │
│       ├── model/
│       │   ├── Movie.java             # Abstract film sınıfı
│       │   ├── Movie2D.java           # 2D film sınıfı
│       │   ├── Movie3D.java           # 3D film sınıfı
│       │   ├── Customer.java          # Müşteri sınıfı
│       │   ├── Seat.java              # Koltuk sınıfı
│       │   ├── ShowTime.java          # Seans sınıfı
│       │   ├── Booking.java           # Rezervasyon sınıfı
│       │   ├── MoviePriceTest.java    # Film fiyat testleri
│       │   ├── SeatTest.java          # Koltuk testleri
│       │   ├── BookingTest.java       # Rezervasyon testleri
│       │   └── CustomerTest.java      # Müşteri testleri
│       │
│       ├── service/
│       │   ├── CinemaService.java     # Servis sınıfı
│       │   └── CinemaServiceTest.java # Servis testleri
│       │
│       └── main/
│           └── Main.java              # Ana program
│
├── .gitignore
├── LICENSE
└── README.md
```

## 🎨 OOP Prensipleri

### Encapsulation (Kapsülleme)

Tüm sınıflarda değişkenler `private` olarak tanımlanmış ve getter/setter metodları ile kontrollü erişim sağlanmıştır.
```java
public class Customer {
    private int id;
    private String name;
    private String email;
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### Inheritance (Kalıtım)

`Movie` abstract sınıfı, `Movie2D` ve `Movie3D` sınıfları tarafından miras alınmıştır.
```java
public abstract class Movie {
    public abstract double calculatePrice();
}

public class Movie2D extends Movie {
    @Override
    public double calculatePrice() { return basePrice; }
}
```

### Polymorphism (Çok Biçimlilik)

`calculatePrice()` metodu her film türü için farklı davranış gösterir.
```java
Movie movie1 = new Movie2D("Inception", "Sci-Fi", 148, 100);
Movie movie2 = new Movie3D("Avatar", "Fantasy", 162, 120, 30);

System.out.println(movie1.calculatePrice()); // 100.0
System.out.println(movie2.calculatePrice()); // 150.0
```

### Interface

`Bookable` interface'i, rezervasyon operasyonları için sözleşme tanımlar.
```java
public interface Bookable {
    void bookSeat(Seat seat);
    void cancelBooking(Booking booking);
}
```

## 🧪 Test Coverage

Proje, JUnit 5 kullanılarak kapsamlı birim testleri ile desteklenmiştir.

### Test Edilen Sınıflar

| Test Sınıfı | Test Sayısı | Açıklama |
|-------------|-------------|----------|
| MoviePriceTest | 2 | 2D ve 3D film fiyat hesaplamaları |
| SeatTest | 3 | Koltuk oluşturma ve rezervasyon |
| BookingTest | 3 | Rezervasyon işlemleri |
| CustomerTest | 4 | Müşteri bilgileri yönetimi |
| CinemaServiceTest | 2 | Servis katmanı işlevleri |

**Toplam: 14 test**

### Testleri Çalıştırma

IntelliJ IDEA'da test klasörüne sağ tıklayıp "Run Tests" seçeneğini kullanarak tüm testleri çalıştırabilirsiniz.

## 📊 UML Diyagramları

### Class Diagram

Sistemin sınıf yapısını ve ilişkilerini gösterir:
- Abstract sınıflar
- Inheritance hiyerarşisi
- Interface implementasyonları
- Association ve Composition ilişkileri

### Use-Case Diagram

Sistemin fonksiyonel gereksinimlerini gösterir:
- Aktörler (Customer, Cinema Staff)
- Use case'ler (View Movies, Make Reservation, vb.)
- İlişkiler (include, extend)

## 📈 Proje Yönetimi

Proje geliştirme süreci Github Projects kullanılarak Kanban board ile yönetilmiştir.

**Kanban Board**: [Cinema Reservation System Development](https://github.com/users/yigitsunar/projects/1)

### Sprint Planı

- **Sprint 1**: Temel sınıflar ve model katmanı
- **Sprint 2**: Servis katmanı ve business logic
- **Sprint 3**: Testler ve dokümantasyon

## 📝 Commit Geçmişi

Proje, 3 haftalık süreçte 30+ commit ile geliştirilmiştir.

## 👨‍💻 Geliştirici

**Ahmet Yiğit Sunar**
- Öğrenci ID: 240312004
- Github: [@yigitsunar](https://github.com/yigitsunar)

**Nesne Tabanlı Programlama - Final Projesi**  
*Aralık 2024 - Ocak 2025*
