first_list=[2,4,9,8,13,26,7,90]
second_list=[3,4,67,84,89,25,17,54]
third_list=[]

print("first list:",first_list)
print("second list:",second_list)

for no in first_list:
    if no % 2 != 0:
        third_list.append(no)
    
for no in second_list:
    if no % 2 == 0:
        third_list.append(no)  

print("Third list:",third_list)  