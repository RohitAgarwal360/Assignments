#input a string and check it is pallindrome or not
#enter a word in a input and submit..!!

s=input("Enter the string that is to be checked:")
print(s)
a=s
t=False
lnth=len(a)
z=lnth-1
for i in range(len(a)):
 if a[z]!=a[i] or z<0:
     print("given string is not pallindrome")
     t=True
     break
 z=z-1
if t==False: 
  print("Given string is pallindrome..!!") 
