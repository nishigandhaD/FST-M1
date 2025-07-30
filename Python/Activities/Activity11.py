fruits={
    "apple": 240,
    "orange": 300,
    "papaya": 200,
    "banana": 100,
    "watermealon": 200,
    "graps":300

}
search_fruit=input("Which fruit you want? :")
flag=0
for i in fruits:
    if search_fruit==i:
        print("Great!!"+i+" is avalible!!")
        flag=1
        break
    
if flag==0:
     print("Sorry!!"+search_fruit+" is not avalible!!")
        