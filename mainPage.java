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


//********************************************************************
//Example for GroupLayout
//********************************************************************
    //  glMainPage.createParallelGroup(GroupLayout.Alignment.LEADING)
    //  glMainPage.addComponent()
  /*.addComponent(c1)
  .addComponent(c2)
  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
       .addComponent(c3)
       .addComponent(c4))
);
layout.setVerticalGroup(
layout.createSequentialGroup()
  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       .addComponent(c1)
       .addComponent(c2)
       .addComponent(c3))
  .addComponent(c4)
);*/

//********************************************************************
    /*public class message extends JPanel {
        public message(){
          setLayout(new GridLayout(20,3,10,10));
          JLabel lblHostName = new JLabel ("Host Name: ");
          JLabel lblPortNumber = new JLabel ("Port Number: ");
          JButton btnConnect = new JButton ("CONNECT");
          add(lblPortNumber2);
          add(lblHostName);
          add(lblPortNumber);
          add(btnConnect);

        //  JOptionPane.showMessageDialog(null, "djdjdj", "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
          setVisible(true);
        }
    }*/
//********************************************************************
