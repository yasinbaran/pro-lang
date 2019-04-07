void main() {
  var sozluk = {"book": "kitap", "table": "masa", "pencil": "kalem"};
  sozluk["teacher"] = "ogretmen";
  sozluk["book"] =
      "Kitap 2"; //listede olan bir key ise value'sunu değiştirir, yeni elemean eklemez.

  print(sozluk);
  print(sozluk["book"]); //book keyine karşılık gelen value'yu verir.
  print("sözlüğün eleman sayısı: " + sozluk.length.toString());
  print(sozluk.remove("book")); //sözlükteki book key value'sunu siler.

  sozluk.containsKey("book"); //sözlükte book var mı? true veya false döner.
  sozluk.clear(); // listeyi temizler.

  print("************Keyler****************");

  for (var key in sozluk.keys) {
    print(key);
  }

  print("************Valuelar***************");

  for (var value in sozluk.values) {
    print(value);
  }

  print("***************for each ile keyleri yazdırmak***********");

  sozluk.forEach((k, v) => print(k));

  sozluk.forEach((k, v) => {
        //burada her key veya value için istediğimizi yaptırabiliriz.
      });
}
