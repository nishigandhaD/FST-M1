def list_sum(n):
    total_list_sum= sum(n)
    print("sum of all the elements in a list: " , total_list_sum )

numbers_list = list(map(int,input("enter a list of numbers to be added: ").split(",")))
list_sum(numbers_list)
