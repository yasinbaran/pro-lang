#Argüman olarak sýrasýz bir liste kabul eden, sýralamaksýzýn ortanca (median, medyan) deðerini enaz maliyetle hesaplayan #programý yazýnýz.
import random
def median(list,a):
    pivot=random.choice(list)
    right_list=[]
    left_list=[]
    if a == len(list):
       return max(list)
    for i in list:
        if pivot < i:
            right_list.append(i)
        elif pivot >= i:
            left_list.append(i)
    if len(left_list) >= a:
        return (median(left_list,a))
    elif len(left_list) < a:
        return (median(right_list,(a - len(left_list))))
    if len(left_list)+1==a:
        return pivot
list = [1,2,3,4,5,6,7,8]
x = int(len(list)/2)
if len(list)%2 == 0:
    a = median(list, x)
    b = median(list, x+1)
    print (float((a+b)/2))
else:
    mid_value = median(list,x+1)
    print (mid_value)