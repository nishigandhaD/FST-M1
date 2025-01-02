user1_Name=input("Enter first users name:")
user2_Name=input("Enter second users name:")
choice=1
while(choice==1):
    user1_choice=input(user1_Name+" What you want to choose rock,paper or scissors? :").lower()
    user2_choice=input(user2_Name+" What you want to choose rock,paper or scissors? :").lower()

    if user1_choice == user2_choice:
        print("its a tie!!")
    elif user1_choice == "rock" and user2_choice == "scissors":
        print (user1_Name + " won!") #rock win
    elif user1_choice == "scissors" and user2_choice =="rock":
        print (user2_Name + " won!")
    elif user1_choice == "scissors" and user2_choice =="paper":
        print (user1_Name + " won!")#scissors wins
    elif user2_choice == "scissors" and user1_choice =="paper":
        print (user2_Name + " won!")
    elif user1_choice == "paper" and user2_choice =="rock":
        print (user1_Name + " won!")#paper wins
    elif user2_choice == "paper" and user1_choice =="rock":
        print (user2_Name + " won!")
    else:
        print("Invalid input ....Please choose any of rock , paper or scissors..")
    again=input("Do you want to play again Y/N?:")
    if again == 'Y':
        choice = 1
        print("play one more time...chose you options...")
    elif again == 'N':
        choice = 0
        print("Thank You!!")