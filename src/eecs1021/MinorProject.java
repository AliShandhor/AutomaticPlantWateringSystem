//Ali Shandhor - #218932178 - Minor Project - EECS 1021 - Prof. James Smith
//Resources:  Lab G & Lab H
package eecs1021;
//Mavens used:
//JSSC: io.github.java-native:jssc:2.9.4
//FFirmata4J: com.github.kurbatov:firmata4j:2.3.8
//SLF4J: org.slf4j:slf4j-jcl:1.7.3
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import java.io.IOException;
import java.util.Timer;
public class MinorProject {
    //pins:
    static final int A0 = 14; // declaring moisture sensor as (A0 = 14) not A1 = 15 because it's taken off from the board
    static final int D2 =  2; // declaring as PumpPin
    static final byte I2C0 = 0x3C; // declaring OLED Screen

    public static void main(String[] args)
            throws InterruptedException, IOException {
        var Board_Ali = new FirmataDevice("COM3"); // My Port
        //The Board
        Board_Ali.start(); // to make the board starts
        Board_Ali.ensureInitializationIsDone(); //to initialise the board
        var MoistureSensor = Board_Ali.getPin(A0);  // to get data from moisture sensor
        //The ports
        MoistureSensor.setMode(Pin.Mode.ANALOG);
        var PumpPin = Board_Ali.getPin(D2);
        PumpPin.setMode(Pin.Mode.OUTPUT);
        //The screen
        I2CDevice i2cObject = Board_Ali.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 OlED = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515 and  Set up the OLED  display (type, size ...)
        // to create timer task:
        var task = new Task(OlED, MoistureSensor,  PumpPin); // to define  a TimerTask object with  my variables
        new Timer().schedule(task, 0, 1000);// the timer

    }
}