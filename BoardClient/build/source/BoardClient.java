import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.net.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class BoardClient extends PApplet {

/**
 * Shared Drawing Canvas (Client)
 * by Alexander R. Galloway.
 *
 * The Processing Client class is instantiated by specifying a remote
 * address and port number to which the socket connection should be made.
 * Once the connection is made, the client may read (or write) data to the server.
 * Before running this program, start the Shared Drawing Canvas (Server) program.
 */




Client c;
String input;
int data[];
int number = 0;
String stage = "startup";
String player1 = "Bob";
String player2 = "- NOT JOINED -";
String player3 = "- NOT JOINED -";
String player4 = "- NOT JOINED -";
String player5 = "- NOT JOINED -";
Boolean initialized = false;

public void setup()
{
  
  background(0);
  fill(255);
  textAlign(CENTER, CENTER);
  textSize(25);
  text("Connecting...", width/2, height/2);
  //frameRate(10); // Slow it down a little
  // Connect to the server's IP address and port
  c = new Client(this, "127.0.0.1", 12345); // Replace with your server's IP and port
}

public void draw()
{
  if (initialized == false)
  {
    background(0);
    c.write("initialize" + ' ' + player1 + ' ' + player2 + ' ' + player3 + ' ' + player4 + ' ' + player5 + "\n");
    initialized = true;
  }
  if (stage == "startup")
  {
    background(255);
    fill(0);
    textAlign(CENTER, CENTER);
    textSize(25);
    text("Press any key to begin", width/2, height/2);
    if (keyPressed == true)
    {
      stage = "counter";
      println(stage);
    }
    if (!keyPressed)
    {
      println(stage);
    }
  }
  if (stage == "counter")
  {
    background(255);
    fill(0);
    textAlign(CENTER, CENTER);
    text(number, width/2, height/2);
    //if (keyPressed == true) {
      // Draw our line
      if (key == 'w')
      {
        number ++;
      }
      if (key == 's')
      {
        number --;
      }
      // Send command to other person
      // c.write(number + "\n");
  }
    // Receive data from server
    //if (c.available() > 0) {
    //  input = c.readString();
    //  input = input.substring(0, input.indexOf("\n")); // Only up to the newline
    //  data = int(split(input, ' ')); // Split values into an array
    //  // Draw line using received coords
    //  stroke(0);
    //  line(data[0], data[1], data[2], data[3]);
    //}
  }
//}
  public void settings() {  size(450, 255); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BoardClient" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
