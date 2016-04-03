## Proje Raporu

**Proje Adı:** Kredi Hesaplama(MyAppCredit)

**Projenin Amacı:** Kredi kullanmak isteyen kullanıcıların, alacakları krediye göre faiz oranlarını ve ödeyecekleri tutarı akıllı telefonlarından kolaylıkla öğrenmelerini sağlamak.

**Projede Kullanılan Programlar:** Proje Android Studio ortamında geliştirilmiştir.

##Projenin Sunumu

![Deneme](https://github.com/yasinbaran/pro-lang/tree/master/Android/KrediHesaplama/images/1.png")


Değişkenlerimizi tanımladık.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/2.png">
</figure>

Değişkenlerimizle xml’imizin bağlantısını kurduk.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/3.png">
</figure>

String.xml dosyamızda spinner’da gösterilecek kredi türlerini tanımladık.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/4.png">
</figure>

ArrayAdapter sayesinde String.xml’de tanımladığımız kredi türlerinin spinner’da
görüntülenmesini sağlıyoruz. Yani String.xml’de tanımladığımız verilerin
spinner’da kullanmaya uygun hale getiriyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/5.png">
</figure>

Spinner’i dinliyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/6.png">
</figure>


Spinner’da seçilecek verinin pozisyonundan switch-case yapısı ile faiz oranını Textview’e yazdırıyoruz ve seekBar’da seçilen kredi türüne göre kaça ay’a kadar vade yapılacağını tanımlıyoruz.



<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/7.png">
</figure>


Seekbar’da kullanıcının girdiği değeri vade TextView’ine atıyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/8.png">
</figure>


Hesapla butonunu dinliyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/9.png">
</figure>


Eğer spinner’da kredi türü seçilmeden hesapla butonuna basılırsa, kullanıcıya Toast ile kredi türünü seçmesi içini uyarı döndürüyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/10.png">
</figure>

Vade TextView’inden aldığımız değeri double’a çevirip, VadeSuresi değişkenimize atıyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/11.png">
</figure>

Faiz_oranı TextView’imizden aldığımız değerimizi double’a çevirip FaizOrani değişkenimize atıyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/12.png">
</figure>

Kredi miktarını alıyoruz. Eğer kredi miktarı girilmeden hesaplanmaya kalkarsa, programın durdurulmaması, hata vermemesi için try-catch ile kullanıcıya uyarı mesajı döndürüyoruz, kredi miktarını girmesi için.


<figure>
        <img src="https://github.com/yasinbaran/pro-lang/tree/master/Android/KrediHesaplama/images/13.png">
</figure>

Kullanıcın vade süresini girmeden, hesapla butonuna basması durumunda kullanıcıya vadeyi girmesi için uyarı döndürüyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/14.png">
</figure>

Aldığımız kredi miktarı, faiz oranı ve vade süresi değişkenlerinden taksit tutarını ve toplam tutarı hesaplıyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/15.png">
</figure>

Aylık tutar ve toplam tutarı formatlayarak Textview’e yazdırıyoruz.


<figure>
        <img src="pro-lang\Android\KrediHesaplama/images/16.png">
</figure>


Programımızın ikonunu değiştirmek için: File>New>Image Assets’ten ikonumuzu seçiyoruz ve tamam diyoruz.
Xml’lerimizi sürükle bırak mantığı ile yapıyoruz. Ekranın yan döndürülmesinde ki görüntüyü ayarlamak için ise; layout-land adında yeni bir klasör tanımlayıp, bu klasör içerisine de bir xml dosyası oluşturup, programın akıllı cihazda yan döndürüldüğünde, görünmesini istediğimiz şekilde ayarlıyoruz.