#Verilen a�ac�n en sol dip d���m�n� bulan program�/i�levi yaz�n�z.
def sol_endip(root):
  dip=root.key
  if root.left!None:
    dip=sol_endip(root.left)
  return dip