import pandas as pd
df=pd.read_csv("Credentials.csv")

print("fulldata in file: ")
print(df)

print("=======")
print("usernames: ")
print(df["usernames"])

print("========")
print("Username: ", df["usernames"][1], " | ", "Password: ", df["passwords"][1])


print("==============")
print("usernames in ascending order: ")
print(df.sort_values("usernames"))

print("==============")
print("passwords in descending order: ")
print(df.sort_values("passwords",ascending=False))