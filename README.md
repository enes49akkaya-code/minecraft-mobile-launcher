# Minecraft Java Mobile Launcher

Bu proje, Android için Java Edition Minecraft launcher arayüzü ve başlatma mantığı örneğidir. Bu uygulama, `Mojo Launcher` ve `PojavLauncher` gibi projelerin çalışma mantığından esinlenerek hazırlanmıştır.

Not: Bu repo sadece başlangıç / örnek uygulama yapısıdır. Gerçek mobil Java Edition çalıştırma için Android cihazda özel Java runtime (ör. PojavLauncher tarzı çözümler), Minecraft JAR dosyaları ve uygun uygulama düzeni gerekir.

## 📥 İndir

### APK İndirme
Son versiyonu buradan indirebilirsiniz:
- **[Releases sayfasına git](https://github.com/enes49akkaya-code/minecraft-mobile-launcher/releases)** - Burada en son APK dosyası bulunur

### Manuel Derleme
1. Android Studio'yu [buradan](https://developer.android.com/studio) indirin
2. Projeyi klonlayın:
   ```bash
   git clone https://github.com/enes49akkaya-code/minecraft-mobile-launcher.git
   cd minecraft-mobile-launcher
   ```
3. Android Studio'da projeyi açın
4. Gradle sync'i tamamlayın
5. **Build → Build APK(s)** seçeneğine tıklayın
6. APK dosyası `app/build/outputs/apk/debug/app-debug.apk` klasöründe oluşur

## ✨ Özellikler
- Mojo benzeri ana ekran
- Oyna butonu
- Ayarlar ekranı
- Kayıtlı oyuncu adı, Java yolu, RAM, sunucu bilgileri
- Java başlatma komutunun üretimi
- Tek tıkla launch akışı

## 📖 Kullanım
1. Android Studio ile projeyi açın.
2. Gradle sync edin.
3. Emulator veya cihazda çalıştırın.
4. Ayarlar ekranından Java yolu ve sunucu bilgilerini girin.
5. Oyna butonuna basın.

## ⚠️ Dikkat
- Bu örnek, gerçek Minecraft Java istemcisini Android cihazda doğrudan çalıştırmak için bir tam runtime değildir.
- Gerçek üretim kullanımında PojavLauncher / MojoLauncher tabanlı sistemler ve uygun Java runtime gereklidir.

## 📁 Yapı
- `app/src/main/java/...` - Kotlin kaynakları
- `app/src/main/res/layout` - UI tasarımları
- `app/src/main/res/values` - metinler ve renkler

## 🔗 Bağlantılar
- [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher)
- [Mojo Launcher](https://github.com/MojoLauncher/MojoLauncher)
- [Android Studio](https://developer.android.com/studio)

## 📝 Lisans
LGPL-3.0
