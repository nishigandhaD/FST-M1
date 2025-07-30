tuple=tuple(input("Enter 6 Numbers:").split(" "))

for i in tuple:
    if int(i) % 5 == 0:
        print(i)