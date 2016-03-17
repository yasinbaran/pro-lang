#Verilen aðacýn en sol dip düðümünü bulan programý/iþlevi yazýnýz.
def sol_endip(root):
  dip=root.key
  if root.left!None:
    dip=sol_endip(root.left)
  return dip