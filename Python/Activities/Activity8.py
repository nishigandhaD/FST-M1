myList=list(input("Enter the numbers:").split(" "))

last_element=len(myList)-1
first_element=myList[0]

if myList[last_element]==first_element:
    print("True")
else:
    print("False")