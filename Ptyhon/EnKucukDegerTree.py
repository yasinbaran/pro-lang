#Verilen a�ac�n i�erisindeki en k���k de�eri bulan program�/i�levi yaz�n�z.
def min_value(MyTree):
    x=MyTree[1]
    for i in MyTree[2:]:
        if i<x:
            x=i
    return i