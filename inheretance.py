class Parent:
 def __init__(self,name,age):
  self.name=name
  self.age=age
 def add(self):
  return("Hello "+self.name+" !")
 
   

class Child(Parent):
 def __init__(self,name,age):
  self.name=name
  self.age=age


c=Child("child",10)
p=Parent("parent",50)

print(p.add())
  
