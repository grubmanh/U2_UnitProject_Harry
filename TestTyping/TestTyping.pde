String typing = "no";

void setup()
{
  size(500,500);
}

void draw()
{
  background(0);
  fill(255);
  textSize(50);
  textAlign(CENTER, CENTER);
  text(typing, width/2, height/2);
}

void keyPressed() // Adapted from Amnon.p5
{
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
