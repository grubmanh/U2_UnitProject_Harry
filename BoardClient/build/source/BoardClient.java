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
String data[];
int number = 0;
String stage = "initialize";
String player0 = "BOB";
String player1 = "BOB1";
String player2 = "BOB3";
String player3 = "NED";
String player4 = "NOTNED";
String player5 = "NOTJOE";

public void setup()
{
  
  background(0);
  fill(255);
  textAlign(CENTER, CENTER);
  textSize(25);
  text("Connecting...", width/2, height/2);
  frameRate(10); // Slow it down a little
  // Connect to the server's IP address and port
  c = new Client(this, "139.59.36.37", 12345); // Replace with your server's IP and port
  // while (c.available() <= 0)
  // {
  //     text("Connecting...", width/2, height/2);
  // }
}

public void draw()
{
  if (stage == "initialize")
  {
    background(0);
    c.write("initialize" + ' ' + player0 + ' ' + player1 + ' ' + player2 + ' ' + player3 + ' ' + player4 + ' ' + player5 + "\n");
    // stage = "startup";
  }
  // if (stage == "startup")
  // {
  //   background(255);
  //   fill(0);
  //   textAlign(CENTER, CENTER);
  //   textSize(25);
  //   text("Press any key to begin", width/2, height/2);
  //   if (keyPressed == true)
  //   {
  //     stage = "counter";
  //   }
  // }
  // if (stage == "counter")
  // {
  //   background(255);
  //   fill(0);
  //   textAlign(CENTER, CENTER);
  //   text(number, width/2, height/2);
  //     // void keyPressed()
  //     // {
  //     c.write("initialize" + ' ' + "BOB" + ' ' + "BILL" + ' ' + "JOE" + ' ' + "JEFF" +' ' + "QUEEN" + ' ' + "BEEF" + "\n");
  //       if (key == 'w')
  //       {
  //         c.write("points" + ' ' + 0 + ' ' + 150+ "\n");
  //       }
  //       if (key == 's')
  //       {
  //         c.write("points" + ' ' + 0 + ' ' + -150 + "\n");
  //       }
  //       if (key == 'e')
  //       {
  //         c.write("points" + ' ' + 1 + ' ' + 150+ "\n");
  //       }
  //       if (key == 'd')
  //       {
  //         c.write("points" + ' ' + 1 + ' ' + -150 + "\n");
  //       }
  //     // }
  // }
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

// void userInput(String variable, int maxLength)
// {
//   // if (keyPressed()) // Adapted from Amnon.p5
//   // {
//   //   if (keyCode == BACKSPACE)
//   //   {
//   //     if (variable.length() > 0)
//   //     {
//   //       variable = variable.substring(0, variable.length()-1);
//   //     }
//   //   }
//   //   else if (keyCode == DELETE)
//   //   {
//   //     variable = "";
//   //   }
//   //   else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT && variable.length() < maxLength)
//   //   {
//   //     variable = variable + key;
//   //   }
//   // }
// }
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
