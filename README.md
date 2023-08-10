# Automatic Watering Plant System - Report
## Abstract
This project involves the creation of an automatic watering plant system that waters plants based on their moisture state (dry or wet). The system is programmed in Java using IntelliJ IDE and utilizes an Arduino board with main components like a pump, MOSFET, and a moisture sensor.

## Introduction
The primary objective of this project is to design and implement an automatic watering plant system. The system uses an Arduino board and key hardware components to enable the automation of plant watering. The core of the system is built using Java programming language on the IntelliJ IDE. The program utilizes a moisture sensor to determine the soil's moisture level and controls a pump to water the plant accordingly.

## Context
The project requires the use of an Arduino board kit, IntelliJ IDE, and various external components (plant, two spill trays, water). The program reads voltage data from the moisture sensor to assess the soil's moisture status. The user can monitor the soil status, pump operation, and water requirements on both the IntelliJ console and an OLED screen. A dynamic horizontal line on the OLED screen corresponds to voltage readings from the moisture sensor, providing real-time feedback.

## Technical Requirements / Specifications
The project follows a well-planned approach with a flowchart guiding the development process. The program is divided into two classes: a main class responsible for initializing hardware components (Grove board, pump, moisture sensor, OLED screen), and an event-driven task class that controls the watering process using while loops, conditional statements, and graphical outputs.

## Components List
### Hardware Components
- Arduino Grove Board: Facilitates hardware-software interaction.
- Pump: Dispenses water.
- Pipe: Transfers water from the pump.
- Battery V9: Supplies power to the pump.
- MOISFIT: Connects the pump to Battery V9.
- Moisture Sensor: Measures soil moisture levels.
- Spill Trays: Collect water and house the pump.
- OLED Screen: Displays information from the program.
- ![image](https://github.com/AliShandhor/AutomaticPlantWateringSystem/assets/132630605/7418cce4-c723-4521-b497-07e6a9f4ca10)
### Software Components
- Arduino (Standard Firmata): Connects Arduino board to IntelliJ for Java programming.
- Firmata4j Library: Provides commands to interface with Arduino using IntelliJ.
- IntelliJ IDE: Development environment for coding the program.

## Procedure
The experiment involves utilizing the standard firmata to connect the Arduino board to IntelliJ IDE for Java programming. Hardware connections include linking the pump to D2 and the moisture sensor to A0 on the Grove board. The program is developed using Java on IntelliJ, featuring two classes within the "eecs1021" package. The main class initializes hardware, and a timer task controls the process at 1-second intervals. The "Task" class handles moisture sensor values, pump control, and visual feedback.

## Testing
Initial testing was crucial, especially regarding pump and moisture sensor functionality. Separate projects were created to isolate and verify these components. Only after confirming their reliability were they integrated into the main project. Similar testing was conducted for the OLED screen's data display. Combined testing and modifications of conditional statements based on soil moisture readings ensured smooth pump control.
Project Video Link: https://www.youtube.com/watch?v=PnX_cs5WN2o
## Learning Outcomes
The project effectively demonstrates key learning outcomes. It showcases the ability to debug and execute ideas, formulate strategies, and solve defined problems. Firmata4j and Java are employed to establish Arduino-IntelliJ integration. An event-driven application effectively manages the pump and sensor, responding to moisture levels. The project employs object-oriented programming principles, applies engineering concepts, and has applications in agricultural engineering.

## Conclusion
This project concludes with successful integration of an Arduino board with Java programming to automate plant watering. It highlights the significance of event-driven tasks in coding, providing clarity and minimizing errors. The project demonstrates creating a professional program for soil moisture assessment and automation. The system's use of a while loop ensures automatic watering, and the OLED screen visualizes changing moisture levels. The project enhances coding skills by applying course knowledge to a practical scenario.
