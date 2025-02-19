import pandas as pd

data = {
    "FirstName" : ["Satvik","Avinash","Lahri"],
    "LastName" : ["Shah","Kati","Rath"],
    "Email" : ["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    "PhoneNumber" :["4537829158","5892184058","4528727830"]
}

df = pd.DataFrame(data)
file_path = r"C:\Users\PEPAKAYALARENUKADEVI\OneDrive - IBM\Desktop\FST Python Activities\list_of_names.xlsx"

with pd.ExcelWriter(file_path) as writer:
    df.to_excel(writer,"sheet1", index=False)

print("Excel file created successfully!")

