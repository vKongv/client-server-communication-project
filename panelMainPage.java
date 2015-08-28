import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class mainPage extends JFrame{
    public mainPage(int i){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Dimension wndSize = new Dimension(800, 500);
      setSize(wndSize);
      setMinimumSize(wndSize);
      setMaximumSize(wndSize);
      setResizable(false);
      pack();
      if(i == 0){
        add(new panelMainPage());
        setTitle("Main Page");
      }
      else if (i == 1){
        add(new panelResources());
        setTitle("Welcome");
      }

      setVisible(true);
    }

    public static void main(String[] args) {
       new mainPage(1);
   }
}
