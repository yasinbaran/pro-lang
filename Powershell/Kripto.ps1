#Verilerin bulundu�u yolu path de�i�kenine at�yoruz.
$Path = Read-Host "Kriptolu Verilerin Bulundu�u Yolu Giriniz:"

#Csv t�r�nde kriptolanm�� verileri, veriler de�i�kenine at�yoruz.
$Veriler = Import-CSV $Path

#��z�mledi�imiz her karakteri s�rayla ekleyece�imiz array'i tan�ml�yoruz.
$CozumlenmisVeri = @()

#Her sat�rdaki verileri s�ras�yla okuyup, VeriAnalizi fonksiyonuna parametre olarak g�nderiyoruz.
foreach($Veri in $Veriler){

    #Verilerin ba��ndaki ve sonundaki tek t�rna�� kald�r�yoruz ve VeriAnalizi fonksiyonuna parametre olarak g�nderiyoruz.
    VeriAnalizi($Veri.KriptoVerileri.Substring(1,$Veri.KriptoVerileri.Length-2))     
}

Function VeriAnalizi($KriptolanmisVeri){

    #�lk karakter G ile ba�l�yorsa; veri "A,B,C"den birisiyle ba�lar.
    if($KriptolanmisVeri[0] -eq "G"){
        
        #�kinci karakter e�er ki "a" ise veri "B" ile ba�lar.
        if($KriptolanmisVeri[1] -eq "a"){
            $CozumlenmisVeri="B"    
        }
        
        #�kinci karakter e�er ki "q" ise veri "C" ile ba�lar.
        elseif($KriptolanmisVeri[1] -eq "q"){
            $CozumlenmisVeri="C"
        }
        
        #�kinci karakter "a veya q"dan farkl� ise veri "A" ile ba�lar.
        else{
            $CozumlenmisVeri="A"
        }    
    }    
    Write-Host $CozumlenmisVeri
}