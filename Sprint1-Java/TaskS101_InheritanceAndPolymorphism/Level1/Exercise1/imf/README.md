# Sprint 5 Task 1 Level1

<br/>

## Exercise 1

<br/>

In a music group, there are different types of musical instruments. There are wind instruments, string instruments, and percussion instruments.

All instruments have as attributes their name and price. Additionally, they have a method called play(). This method is abstract in the Instrument class, and therefore, must be implemented in the child classes. If a wind instrument is being played, the method should display the message: "A wind instrument is playing" in the console; if a string instrument is being played: "A string instrument is playing"; and if a percussion instrument is being played: "A percussion instrument is playing."

The class loading process only occurs once. Demonstrate that the loading can be triggered either by creating the first instance of the class or by accessing a static member of the class.

Look up information about initialization blocks and static blocks in Java.

<br/>

## Exercise 2

<br/>

Create a class "Car" with the attributes: brand, model, and power. The brand should be static and final, the model should be static, and the power should be final. Demonstrate the difference between the three. Is there any that can be initialized in the class constructor?

Add two methods to the "Car" class: a static method called brake() and a non-static method called accelerate(). The accelerate() method should display in the console: "The vehicle is accelerating" and the brake() method should display: "The vehicle is braking".

Demonstrate how to invoke both the static and non-static methods from the main() method in the main class.