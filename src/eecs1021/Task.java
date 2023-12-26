package eecs1021;
//library
import org.firmata4j.ssd1306.MonochromeCanvas;
import org.firmata4j.ssd1306.SSD1306;
import java.io.IOException;
import org.firmata4j.Pin;
import java.util.TimerTask;
//Timer Task Class
public class Task extends TimerTask {
    private int duration;

    private final SSD1306 OLED_Screen;
    private final Pin MoistureSensor;
    private final Pin PumpPin;

    public Task(SSD1306 display, Pin pin, Pin PumpPin) {
        this.MoistureSensor = pin; //using this. method for MoistureSensor
        this.OLED_Screen = display;//using this. method for OLED_Screen
        this.PumpPin = PumpPin; //using this. method for PumpPin

    }

    @Override
    public void run() {
        //while loop to make the water plant system atraumatic system!
        while (true) {
            var Moisturevalue = MoistureSensor.getValue(); // it gets values  From moisture sensor
            var MoistureString = Long.toString(Moisturevalue);// to convert  values from moisture sensor (int) to string; so they can be shown on OLED screen or IntelliJ Console
            float max = 1023F; //Max range of moisture sensor (0 - 1023) as float point
            var i = (int) ((Moisturevalue / max) * 128); // to reduce length of horizontal line, so it can fit the screen and move proportionally to value getting form moisture sensor
            int reallyDryValue = 720; //Dry value
            int saturatedValue = 600; //Saturated value

            // conditional  statements
            if (Moisturevalue >= reallyDryValue) {
                // to print on the Intellj Console
                System.out.println("value : " + MoistureString);
                System.out.println("soil is really dry! -" + " needs a lot of water - " + "Pump On");
                // to show your strings on OLED screen
                OLED_Screen.getCanvas().drawString(0, 0, "Value: " + MoistureString + " Pump: ON" + "  Soil Status: Dry!"+ "    Needs water ");
                OLED_Screen.getCanvas().setTextsize(1);
                // to draw the Horizontal Line
                OLED_Screen.getCanvas().drawHorizontalLine(0, 40, 120, MonochromeCanvas.Color.DARK);
                if (i != 0) OLED_Screen.getCanvas().drawHorizontalLine(0, 28, (int) i, MonochromeCanvas.Color.BRIGHT);
                // to draw the Horizontal Lin
                // to display on OlED Screen

                OLED_Screen.display();
                // to turn the pump On .setValue(1)
                try {
                    PumpPin.setValue(1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (Moisturevalue == saturatedValue) {
                // to print on the Intellj Console
                System.out.println("value : " + MoistureString);
                System.out.println("soil is wet enough - No more water needed - " + "Pump Off");
                // to show your strings on OLED screen
                OLED_Screen.getCanvas().drawString(0, 0, "Value: " + MoistureString + " Pump: Off" + " Soil Status: Wet!"+ "    No More Water ");
                OLED_Screen.getCanvas().setTextsize(1);
                // to draw the Horizontal Line
                OLED_Screen.getCanvas().drawHorizontalLine(0, 40, 120, MonochromeCanvas.Color.DARK);
                if (i != 0) OLED_Screen.getCanvas().drawHorizontalLine(0, 28, (int) i, MonochromeCanvas.Color.BRIGHT);
                // to display on OlED Screen
                OLED_Screen.display();
                // to turn the pump On .setValue(1)
                try {
                    PumpPin.setValue(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                // to print on the Intellj Console
                System.out.println(MoistureString);
                System.out.println("Soil is wet enough - No more water needed - " + " Pump off");
                // to show your strings on OLED screen
                OLED_Screen.getCanvas().setTextsize(1);
                OLED_Screen.getCanvas().drawString(0, 0, "Value: " + MoistureString + " Pump: Off" + " Soil Status: Wet!"+ "    No More Water ");
                // to draw the Horizontal Line
                OLED_Screen.getCanvas().drawHorizontalLine(0, 40, 180, MonochromeCanvas.Color.DARK);
                if (i != 0) OLED_Screen.getCanvas().drawHorizontalLine(0, 28, (int) i, MonochromeCanvas.Color.BRIGHT);
                // to display on OLED screen
                OLED_Screen.display();
                // to turn the pump Off .setValue(0)
                try {
                    PumpPin.setValue(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}