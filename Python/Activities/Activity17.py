import pandas as pd
data= {
   "usernames" : [ "admin" ,  "Charles" , "Deku"],
   "passwords": ["password",  "Charl13", "AllMight"]
}

df = pd.DataFrame(data)

print(df)

df.to_csv("Credentials.csv", index=False)