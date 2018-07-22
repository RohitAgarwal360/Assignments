#input a word to search in a given string

para="this is a string to test the program hello hello is "
print(para)
para=para.split(" ")
count=0
z=input("Enter a word to search : ")

for i in para:
 if(i==z):
  count=count+1
print("***************************OUTPUT*****************************")
print("occurance of "+z+" is :")
print(count)


