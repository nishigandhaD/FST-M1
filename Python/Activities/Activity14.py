def rec_fibonacci(n):
    if n <= 1:
        return n
    else:
        return rec_fibonacci(n-1) + rec_fibonacci(n-2)
    

fibonacci_number = int(input("Enter the number of terms: "))
for i in range(fibonacci_number):
    print(rec_fibonacci(i), end=" ")