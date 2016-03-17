#Verilen aðacýn içerisindeki en küçük deðeri bulan programý/iþlevi yazýnýz.
def min_value(MyTree):
    x=MyTree[1]
    for i in MyTree[2:]:
        if i<x:
            x=i
    return i