#Verilerin bulunduðu yolu path deðiþkenine atýyoruz.
$Path = Read-Host "Kriptolu Verilerin Bulunduðu Yolu Giriniz:"

#Csv türünde kriptolanmýþ verileri, veriler deðiþkenine atýyoruz.
$Veriler = Import-CSV $Path

#Çözümlediðimiz her karakteri sýrayla ekleyeceðimiz array'i tanýmlýyoruz.
$CozumlenmisVeri = @()

#Her satýrdaki verileri sýrasýyla okuyup, VeriAnalizi fonksiyonuna parametre olarak gönderiyoruz.
foreach($Veri in $Veriler){

    #Verilerin baþýndaki ve sonundaki tek týrnaðý kaldýrýyoruz ve VeriAnalizi fonksiyonuna parametre olarak gönderiyoruz.
    VeriAnalizi($Veri.KriptoVerileri.Substring(1,$Veri.KriptoVerileri.Length-2))     
}

Function VeriAnalizi($KriptolanmisVeri){

    #Ýlk karakter G ile baþlýyorsa; veri "A,B,C"den birisiyle baþlar.
    if($KriptolanmisVeri[0] -eq "G"){
        
        #Ýkinci karakter eðer ki "a" ise veri "B" ile baþlar.
        if($KriptolanmisVeri[1] -eq "a"){
            $CozumlenmisVeri="B"    
        }
        
        #Ýkinci karakter eðer ki "q" ise veri "C" ile baþlar.
        elseif($KriptolanmisVeri[1] -eq "q"){
            $CozumlenmisVeri="C"
        }
        
        #Ýkinci karakter "a veya q"dan farklý ise veri "A" ile baþlar.
        else{
            $CozumlenmisVeri="A"
        }    
    }    
    Write-Host $CozumlenmisVeri
}