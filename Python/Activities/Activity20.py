import pandas as pd
df=pd.read_excel(r"C:\Users\PEPAKAYALARENUKADEVI\OneDrive - IBM\Desktop\FST Python Activities\list_of_names.xlsx",sheet_name="sheet1")
print("complete data in excel file: ")
print(df)

print("========================================================")
print("no of rows and coulmns: ")
print(df.shape)

print("========================================================")
print("email ids of users: ")
print(df["Email"])

print("=========================================================")
print("list in ascending order of firstname: ")
print(df.sort_values("FirstName"))