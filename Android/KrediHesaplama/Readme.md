## Proje Raporu

**Proje Adı:** Kredi Hesaplama(MyAppCredit)

**Projenin Amacı:** Kredi kullanmak isteyen kullanıcıların, alacakları krediye göre faiz oranlarını ve ödeyecekleri tutarı akıllı telefonlarından kolaylıkla öğrenmelerini sağlamak.

**Projede Kullanılan Programlar:** Proje Android Studio ortamında geliştirilmiştir.

##Projenin Sunumu

![1](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/1.png)


Değişkenlerimizi tanımladık.


![2](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/2.png)

Değişkenlerimizle xml’imizin bağlantısını kurduk.


![3](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/3.png)

String.xml dosyamızda spinner’da gösterilecek kredi türlerini tanımladık.


![4](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/4.png)

ArrayAdapter sayesinde String.xml’de tanımladığımız kredi türlerinin spinner’da
görüntülenmesini sağlıyoruz. Yani String.xml’de tanımladığımız verilerin
spinner’da kullanmaya uygun hale getiriyoruz.


![5](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/5.png)

Spinner’i dinliyoruz.


![6](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/6.png)


Spinner’da seçilecek verinin pozisyonundan switch-case yapısı ile faiz oranını Textview’e yazdırıyoruz ve seekBar’da seçilen kredi türüne göre kaça ay’a kadar vade yapılacağını tanımlıyoruz.



![7](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/7.png)


Seekbar’da kullanıcının girdiği değeri vade TextView’ine atıyoruz.


![8](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/8.png)


Hesapla butonunu dinliyoruz.


![9](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/9.png)


Eğer spinner’da kredi türü seçilmeden hesapla butonuna basılırsa, kullanıcıya Toast ile kredi türünü seçmesi içini uyarı döndürüyoruz.


![10](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/10.png)

Vade TextView’inden aldığımız değeri double’a çevirip, VadeSuresi değişkenimize atıyoruz.


![11](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/11.png)

Faiz_oranı TextView’imizden aldığımız değerimizi double’a çevirip FaizOrani değişkenimize atıyoruz.


![12](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/12.png)

Kredi miktarını alıyoruz. Eğer kredi miktarı girilmeden hesaplanmaya kalkarsa, programın durdurulmaması, hata vermemesi için try-catch ile kullanıcıya uyarı mesajı döndürüyoruz, kredi miktarını girmesi için.


![13](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/13.png)

Kullanıcın vade süresini girmeden, hesapla butonuna basması durumunda kullanıcıya vadeyi girmesi için uyarı döndürüyoruz.


![14](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/14.png)

Aldığımız kredi miktarı, faiz oranı ve vade süresi değişkenlerinden taksit tutarını ve toplam tutarı hesaplıyoruz.


![15](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/15.png)

Aylık tutar ve toplam tutarı formatlayarak Textview’e yazdırıyoruz.


![16](https://github.com/yasinbaran/pro-lang/blob/master/Android/KrediHesaplama/images/16.png)


Programımızın ikonunu değiştirmek için: File>New>Image Assets’ten ikonumuzu seçiyoruz ve tamam diyoruz.
Xml’lerimizi sürükle bırak mantığı ile yapıyoruz. Ekranın yan döndürülmesinde ki görüntüyü ayarlamak için ise; layout-land adında yeni bir klasör tanımlayıp, bu klasör içerisine de bir xml dosyası oluşturup, programın akıllı cihazda yan döndürüldüğünde, görünmesini istediğimiz şekilde ayarlıyoruz.