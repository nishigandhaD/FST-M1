def adder(num):
    if num:
        return num+adder(num-1)
        
    else:
        return  0   
    
sum=adder(10)
print("addition is=",sum)