import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class TestTyping extends PApplet {

String typing = "no";

public void setup()
{
  
}

public void draw()
{
  background(0);
  fill(255);
  textSize(50);
  textAlign(CENTER, CENTER);
  text(typing, width/2, height/2);
}

public void keyPressed() {
  if (keyCode == BACKSPACE)
  {
    if (typing.length() > 0)
    {
      typing = typing.substring(0, typing.length()-1);
    }
  }
  else if (keyCode == DELETE)
  {
    typing = "";
  }
  else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT && typing.length() < 7)
  {
    typing = typing + key;
  }
}
  public void settings() {  size(500,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "TestTyping" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
