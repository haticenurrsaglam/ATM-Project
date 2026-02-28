# ATM-Project
Java ile yazılmış ATM uygulaması - OOP yapısı, dosya işlemleri ve temel bankacılık işlemleri içerir.


## 🚀 Özellikler
- Login sistemi (3 hak, PIN kontrolü)
- Para yatırma ve çekme
- Transfer
- PIN değiştirme
- Günlük limit kontrolü (5000 TL)
- Hata yönetimi

## 📂 Proje Yapısı 
Proje, kodun okunabilirliğini ve yönetilebilirliğini artırmak için 4 ana sınıfa ayrılmıştır:
| Sınıf | Görevi |
| :--- | :--- |
| **Account.java** | Hesap bilgilerini (Bakiye, PIN, Limit) tutan Model sınıfı. |
| **AccountService.java** | Para çekme, yatırma, transfer ve login gibi tüm mantıksal işlemlerin yapıldığı katman. |
| **Menu.java** | Kullanıcı etkileşimini yöneten, girişleri (Scanner) kontrol eden ve çıktıları formatlayan sınıf. |
| **ATMApp.java** | Uygulamanın başladığı, verilerin başlatıldığı ve ana döngünün döndüğü giriş noktası. |

## 🛠️ Nasıl Çalıştırılır?
1.  Bilgisayarınızda Java JDK'nın yüklü olduğundan emin olun.
2.  Projeyi klonlayın:
    ```bash
    git clone [https://github.com/KULLANICI_ADINIZ/Java-OOP-ATM-System.git](https://github.com/KULLANICI_ADINIZ/Java-OOP-ATM-System.git)
    ```
3.  Terminal veya IDE'niz üzerinden `ATMApp.java` dosyasını çalıştırın.

### Örnek Giriş Bilgileri
Sistemde ön tanımlı olarak şu hesaplar bulunmaktadır:
- **Account Number:** `TR001` | **PIN:** `4579`
- **Account Number:** `TR002` | **PIN:** `3658`
