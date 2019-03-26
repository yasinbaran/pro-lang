//Yasin BARAN

void main() {
  var sayi = 3;
  if (sayi > 3) {
    print("Sayi 3'ten büyüktür.");
  } else if (sayi == 3) {
    print("Sayi 3'tür.");
  } else {
    print("Sayi 3'ten küçüktür.");
  }

  var plakaKodu = 66;

  switch (plakaKodu) {
    case 01:
      print("Adana");
      break;
    case 55:
      print("Samsun");
      break;
    case 66:
      print("YOZGAT");
      break;
    default:
      print("Bilinmiyor.");
  }
}
