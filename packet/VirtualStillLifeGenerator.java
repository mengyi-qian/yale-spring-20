/* * * * * * * * * * * * 
 * Name : Mengyi Qian  *
 * NetID : mq74        *
 * * * * * * * * * * * */ 
 
public class StampSketch {
   public static void main(String[] args) {
      // is this the first time through the animation loop?
      boolean firstTime = true;
      PennDraw.enableAnimation(10);
      
      double[] orangeX = new double[5];
      double[] orangeY = new double[5];
      double[] orangedX = new double[5];
      double[] orangedY = new double[5];
      
      double vaseX;
      double vaseY;
      double vasedX;
      double vasedY;
      
      double[] r = new double[5];
      double[] endAngle = new double[5];
   
      while (true) {
         // redraw background both when it's the first time through loop and
         // when a key is pressed
         if (PennDraw.hasNextKeyTyped() && PennDraw.nextKeyTyped() == 'n') {
            // TODO - draw a random background/
            PennDraw.clear();
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            // top
            PennDraw.setPenColor(red, green, blue);
            PennDraw.filledRectangle(0.5, 0.7, 0.5, 0.3);
            // bottom
            PennDraw.setPenColor(green, blue, red);
            PennDraw.filledRectangle(0.5, 0.2, 0.5, 0.2);
            // some aspect of the background must involve a loop.
            // 5 oranges
            for (int i = 0; i < 5; i++) {
               PennDraw.setPenColor(255, 128, 0);
               orangeX[i] = .1 + .8 * Math.random();
               orangeY[i] = .25 + .15 * Math.random();
               orangedY[i] = 0.1 * (1 - orangeY[i]);
               orangedX[i] = 1.2 * orangedY[i];
               PennDraw.filledEllipse(orangeX[i], orangeY[i], orangedX[i], orangedY[i]);
            }
            // a plant
            vaseX = .1 + .8 * Math.random();
            vaseY = .25 + .15 * Math.random();
            for (int i = 0; i < 5; i++) {
               r[i] = .1 + .2 * Math.random();
               endAngle[i] = 60 + 60 * Math.random();
               PennDraw.setPenColor(blue, red, green);
               PennDraw.setPenRadius(0.005);
               PennDraw.arc(vaseX - r[i] + 0.01, vaseY + 0.08, r[i], -10, endAngle[i]);
            }
            PennDraw.setPenColor(253, 245, 206);
            PennDraw.filledCircle(vaseX, vaseY, 0.065);
            PennDraw.filledRectangle(vaseX, vaseY, 0.035, 0.125);
         }
         
         if (firstTime) {
            firstTime = false;
            // TODO - draw a random background/
            PennDraw.clear();
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            // top
            PennDraw.setPenColor(red, green, blue);
            PennDraw.filledRectangle(0.5, 0.7, 0.5, 0.3);
            // bottom
            PennDraw.setPenColor(green, blue, red);
            PennDraw.filledRectangle(0.5, 0.2, 0.5, 0.2);
            // some aspect of the background must involve a loop.
            // 5 oranges
            for (int i = 0; i < 5; i++) {
               PennDraw.setPenColor(255, 128, 0);
               orangeX[i] = .1 + .8 * Math.random();
               orangeY[i] = .25 + .15 * Math.random();
               orangedY[i] = 0.15 * (0.8 - orangeY[i]);
               orangedX[i] = 1.25 * orangedY[i];
               PennDraw.filledEllipse(orangeX[i], orangeY[i], orangedX[i], orangedY[i]);
               PennDraw.filledEllipse(orangeX[i], orangeY[i], orangedX[i], orangedY[i]);
            }
            // a plant
            vaseX = .1 + .8 * Math.random();
            vaseY = .25 + .15 * Math.random();
            for (int i = 0; i < 5; i++) {
               r[i] = .1 + .2 * Math.random();
               endAngle[i] = 60 + 60 * Math.random();
               PennDraw.setPenColor(blue, red, green);
               PennDraw.setPenRadius(0.005);
               PennDraw.arc(vaseX - r[i] + 0.01, vaseY + 0.08, r[i], -10, endAngle[i]);
            }
            PennDraw.setPenColor(253, 245, 206);
            PennDraw.filledCircle(vaseX, vaseY, 0.065);
            PennDraw.filledRectangle(vaseX, vaseY, 0.035, 0.125);
         }
      
         // if the mouse is clicked
         if (PennDraw.mousePressed()) {
            // get the coordinates of the mouse cursor
            double x = PennDraw.mouseX();
            double y = PennDraw.mouseY();
             
            // TODO - check which region the mouse click was in
            // draw a scaled shape
         
            if (y < 0.4) {
               PennDraw.setPenColor(PennDraw.WHITE);
               PennDraw.setFontSize((0.8 - y) * 100);
               PennDraw.text(x, y, ".");
            }
            if (y > 0.4) {
               PennDraw.setPenColor(PennDraw.WHITE);
               PennDraw.setFontSize((y - 0.2) * 100);
               PennDraw.text(x, y, "*");
            }
         }
         PennDraw.advance();
      }
   }
}