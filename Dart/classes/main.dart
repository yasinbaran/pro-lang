void main() {
  Customer customer = new Customer();
  customer.name = "Ege";
  customer.lastName = "Baran";
  customer.id = 3;

  print("***********constructor'sız çağırım sonucu*********");
  CustomerManager customerManager = new CustomerManager();
  customerManager.Save(customer);
  customerManager.Delete(customer);
  customerManager.Update(customer);

  //Constructor yaptığımız için tek tek setleme işlemini constructor'a bıraktık. Çağırırken parametre olarak geçiyoruz.
  CustomerAndConstructor customerAndConstructor =
      new CustomerAndConstructor("Ege", "Baran", 3);

  print("***********constructor'lı çağırım sonucu*********");
  CustomerManagerConstructor customerManagerConstructor =
      new CustomerManagerConstructor();
  customerManagerConstructor.Save(customerAndConstructor);
  customerManagerConstructor.Delete(customerAndConstructor);
  customerManagerConstructor.Update(customerAndConstructor);

  //NamedConstructor'dan dolayı aşağıdaki şekilde iki çağırımı da yapabiliriz.
  CustomerNamedConstructor customerNamedConstructor =
      new CustomerNamedConstructor.namedCons("Ege", "Baran",
          3); // eğer cons olmasa bu şekilde kullanamzdık, parametrelere kızardı.
  customer.name = "Yasin Ege";
  customer.lastName = "Baran Baran";
  customer.id = 5;

  print("***********named constructor'lı çağırım sonucu*********");
  CustomerManagerNamedConstructor customerManagerNamedConstructor =
      new CustomerManagerNamedConstructor();
  customerManagerNamedConstructor.Save(customerNamedConstructor);
  customerManagerNamedConstructor.Delete(customerNamedConstructor);
  customerManagerNamedConstructor.Update(customerNamedConstructor);
}

// müşteri yönetimi yapan bir class yazdık ve parametre olak müşteri bilgilerini içeren class'ı verdik.
class CustomerManager {
  void Save(Customer customer) {
    print("Müşteri kaydedildi " + customer.name);
  }

  void Delete(Customer customer) {
    print("Müşteri silindi." + customer.name);
  }

  void Update(Customer customer) {
    print("Müşteri güncellendi " + customer.name);
  }
}

// Constructor kullanımını göstermek çokladım farklı parametre alıyor sadece.
class CustomerManagerConstructor {
  void Save(CustomerAndConstructor customer) {
    print("Müşteri kaydedildi " + customer.name);
  }

  void Delete(CustomerAndConstructor customer) {
    print("Müşteri silindi." + customer.name);
  }

  void Update(CustomerAndConstructor customer) {
    print("Müşteri güncellendi " + customer.name);
  }
}

class CustomerManagerNamedConstructor {
  void Save(CustomerNamedConstructor customer) {
    print("Müşteri kaydedildi " + customer.name);
  }

  void Delete(CustomerNamedConstructor customer) {
    print("Müşteri silindi." + customer.name);
  }

  void Update(CustomerNamedConstructor customer) {
    print("Müşteri güncellendi " + customer.name);
  }
}

// Müşteriye ait bilgileri içeren bir class yazdık ve bunu parametre olarak başka bir class'a verdik.
class Customer {
  String name;
  String lastName;
  int id;
}

// customer class'ını constructorlı yazalım.
class CustomerAndConstructor {
  String name;
  String lastName;
  int id;
  CustomerAndConstructor(String name, String lastName, int id) {
    this.name = name;
    this.lastName = lastName;
    this.id = id;
  }
}

//constructor'ı kullanmak için ayrı parametreden dolayı ayrı class yazmıştım bunun yerine namedConstructor kullanılabilir.
class CustomerNamedConstructor {
  String name;
  String lastName;
  int id;
  CustomerNamedConstructor.namedCons(String name, String lastName, int id) {
    this.name = name;
    this.lastName = lastName;
    this.id = id;
  }
}
