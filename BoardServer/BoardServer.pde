/**
 * Shared Drawing Canvas (Server)
 * by Alexander R. Galloway.
 *
 * A server that shares a drawing canvas between two computers.
 * In order to open a socket connection, a server must select a
 * port on which to listen for incoming clients and through which
 * to communicate. Once the socket is established, a client may
 * connect to the server and send or receive commands and data.
 * Get this program running and then start the Shared Drawing
 * Canvas (Client) program so see how they interact.
 */


import processing.net.*;

Server s;
Client c;
String input;
String data[];
int number;
Player[] players = new Player[6];

void setup()
{
  fullScreen();
  background(0);
  stroke(255);
  // frameRate(5); // Slow it down a little
  s = new Server(this, 12345); // Start a simple server on a port
  for (int i = 0; i < 6; i++)
  players[i] = new Player(i);
}

void draw()
{
  background(0);
  scoreBoardLayout();
  // Receive data from client
  c = s.available();
  if (c != null) {
    input = c.readString();
    input = input.substring(0, input.indexOf("\n")); // Only up to the newline
    data = (split(input, ' ')); // Split values into an array
    // Draw line using received coords
    if (data[0] == "initialize")
      {
        for (int i = 0; i < 6; i++)
        {
          players[i].name = data[i];
        }
      }
    else if (data[0] == "points")
      {
        int playerNo = int(data[1]);
        int pointChange = int(data[2]);
        players[playerNo].updateScore(pointChange);
      }
  }
  // ranker();
  scoreBoardFill();
}

void scoreBoardLayout()
{
  textAlign(CENTER);
  textSize(100);
  fill(255);
  text("Scoreboard", width/2, 100);
  line(0, 110, width, 110); // will replace with f() later
  rect(0, 110, width, 100);
  line(0, 210, width, 210);
  line(0, 310, width, 310);
  line(0, 410, width, 410);
  line(0, 510, width, 510);
  line(0, 610, width, 610);
  line(0, 710, width, 710);
  line(0, 810, width, 810);
  line(0, 910, width, 910);
  line(width/5, 110, width/5, height);
  line(3*(width/5), 110, 3*(width/5), height);
  fill(0);
  textSize(50);
  textAlign(CENTER, CENTER);
  text("Rank", width/10, 160);
  text("Name", 2*(width/5), 160);
  text("Score", 4*(width/5), 160);
  fill(255);
  text("1", width/10, 260);
  text("2", width/10, 360);
  text("3", width/10, 460);
  text("4", width/10, 560);
  text("5", width/10, 660);
  text("6", width/10, 760);
}

void scoreBoardFill()
{
  fill(255);
  textAlign(CENTER, CENTER);
  text(players[0].name, 2*(width/5), 260);
  text(players[1].name, 2*(width/5), 360);
  text(players[2].name, 2*(width/5), 460);
  text(players[3].name, 2*(width/5), 560);
  text(players[4].name, 2*(width/5), 660);
  text(players[5].name, 2*(width/5), 760);
  text(players[0].score, 4*(width/5), 260);
  text(players[1].score, 4*(width/5), 360);
  text(players[2].score, 4*(width/5), 460);
  text(players[3].score, 4*(width/5), 560);
  text(players[4].score, 4*(width/5), 660);
  text(players[5].score, 4*(width/5), 760);
}
class Player
{
    String name = "- NOT JOINED -";
    int score = 0;
    int rank = 0;

    Player(int rank)
    {
      this.rank = rank;
    }

    void updateScore(int scoreChange)
    {
      this.score += scoreChange;
    }
}

void ranker()
{
  for (int i = 0, j = 1; i > -1; i++, j++)
  {
    if (players[i].score > players[j].score)
    {
      players[i].rank += 1;
      players[i].rank -= 1;
    }
    else if (players[i].score < players[j].score)
    {
      players[i].rank -= 1;
      players[i].rank += 1;
    }
    if (i == 3)
    i = 0;
    if (j == 4)
    j = 1;
  }
}
