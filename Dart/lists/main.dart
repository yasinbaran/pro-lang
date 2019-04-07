void main() {
  var ogrenciler = new List(3);

  ogrenciler[1] = "Yasin";
  ogrenciler[2] = "Ege";
  ogrenciler[0] = "Baran";

  var sehirler = ["Yozgat", "Samsun", "Ankara"];
  sehirler.add("Kocaeli"); //listenin sonuna eleman ekleme
  sehirler.insert(
      1, "İstanbul"); //listede Yozgattan sonra(0. elaman Yozgat) eleman ekleme

  print(ogrenciler);
  print(sehirler);
  print(sehirler.length); // listenin boyutu
  print(sehirler.first); //ilk eleman
  print(sehirler.last); // son eleman
  print(sehirler.firstWhere((s) => s.contains("u"))); //içerisinde u harfi geçen ilk elemanı bulur. (s) ifadesi her bir şehire denk gelir.
  //print(sehirler.firstWhere((s) => s.contains("y"))); //hata alır case sensitive olduğundan y'yi bulamaz.

}
