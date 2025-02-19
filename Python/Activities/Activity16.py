class Car:
    def __init__(self,manufacturer,model,transmission,make,color):
        self.manufacturer=manufacturer
        self.model=model
        self.transmission=transmission
        self.make=make
        self.color=color
    
    def accelerate(self):
        print(f"{self.manufacturer} {self.model} is moving")
    def stop(self):
        print(f"{self.manufacturer} {self.model} has stopped")

Car1 =  Car("Suzuki","Swift","Automatic",2024,"Red")
Car2 = Car("Benz","Sweety","Automatic",2023,"white")
Car3 = Car("Toyota","Corolla" , "Manual",2021,"Black")

Car1.accelerate()
Car2.stop()
Car3.accelerate()
