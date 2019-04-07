void main() {
  for (var i = 0; i <= 10; i++) {
    print(i);
  }
  ;

  var ogrenciler = ["Yasin", "Ege", "Baran"];
  for (var ogrenci in ogrenciler) {
    print(ogrenci);
  }

  var sayi = 3;
  while (sayi <= 5) {
    print(sayi);
    sayi++;
  }

  var sayi2 = 15;
  do {
    print(sayi2);
    sayi++;
  } while (sayi2 <= 10); //şart sağlanmasa bile bir kere çalışır, ekrana 15'i yazar. Genelde bağlantı vs yapıldığında kullanılır.
}
