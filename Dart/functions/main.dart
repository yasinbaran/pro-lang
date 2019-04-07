void main() {
  selamVer("Ege");
  print(kareAl(3));

  optionalParameters("Yasin", "Ege");
  namedParameter("Yasin",c:"Ege",b:"Baran");
}

void selamVer(String isim) {
  print("Merhaba " + isim);
}

int kareAl(int sayi) {
  return sayi * sayi;
}

void optionalParameters(a, [b, c]) {
  //a zorunlu b ve c isteğe bağlıdır.
  print(a);
  print(b);
  print(c); //değer atanmamışsa null yazar ekrana
}

void namedParameter(a, {b, c}) {// üstteki kullanımdan farkı optional olan b ve c'yi çağırırken belirtmemizi ister.
  print(a);
  print(b);
  print(c);
}
