import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class panelDlSuccess extends JPanel{
  JLabel lblGreat;
  JLabel lblSuccessfulMsg ;
  JLabel lblContinueMsg ;
  JButton btnYes ;
  JButton btnNo ;

  public panelDlSuccess() {
    lblGreat = new JLabel();
    lblGreat.setText("Great ! ");
    lblGreat.setFont(new Font("Avenir Next", 0, 50));

    lblSuccessfulMsg = new JLabel();
    lblSuccessfulMsg.setText("You have successfully downloaded.");
    lblSuccessfulMsg.setFont(new Font("Avenir Next", 0, 20));

    lblContinueMsg = new JLabel();
    lblContinueMsg.setText("Do you want to continue ? ");
    lblContinueMsg.setFont(new Font("Avenir Next", 0, 20));

    btnYes = new JButton();
    btnYes.setText("YES");
    btnYes.setFont(new Font("Avenir Next", 1, 14));
    btnYes.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnYes.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent eventBtnYes)
          {btnYesActionPerformed(eventBtnYes);}
      });

    btnNo = new JButton();
    btnNo.setText("NO");
    btnNo.setFont(new Font("Avenir Next", 1, 14));
    btnNo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnNo.addActionListener(
      new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent eventBtnNo)
        {btnNoActionPerformed(eventBtnNo);}
      });

    add(lblGreat);
    add(lblSuccessfulMsg);
    add(lblContinueMsg);
    add(btnYes);
    add(btnNo);

    GroupLayout glDlSuccess = new GroupLayout(this);
    glDlSuccess.setAutoCreateContainerGaps(true);
    glDlSuccess.setHorizontalGroup(
      glDlSuccess.createSequentialGroup()
      .addGap(206,206,206)
      .addGroup(
          glDlSuccess.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(
            glDlSuccess.createSequentialGroup()
            .addGap(100,100,100)
            .addComponent(lblGreat))
          .addGroup(
            glDlSuccess.createSequentialGroup()
            .addGap(20,20,20)
            .addComponent(lblSuccessfulMsg))
          .addGroup(
            glDlSuccess.createSequentialGroup()
            .addGap(60,60,60)
            .addComponent(lblContinueMsg))
          .addGroup(
            glDlSuccess.createSequentialGroup()
            .addGap(60,60,60)
            .addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 120,GroupLayout.PREFERRED_SIZE)
            .addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 120,GroupLayout.PREFERRED_SIZE)
          ))
    ); //end of setHorizontalGroup

    glDlSuccess.setVerticalGroup(
      glDlSuccess.createSequentialGroup()
      .addGap(90, 90, 90)
      .addComponent(lblGreat)
      .addGap(40, 40, 40)
      .addComponent(lblSuccessfulMsg)
      .addGap(60, 60, 60)
      .addComponent(lblContinueMsg)
      .addGap(30, 30, 30)
      .addGroup(
        glDlSuccess.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(btnYes, GroupLayout.PREFERRED_SIZE, 40,GroupLayout.PREFERRED_SIZE)
        .addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 40,GroupLayout.PREFERRED_SIZE)
      )); //end of setVerticalGroup
    setLayout(glDlSuccess);
    setVisible(true);
    setBackground(Color.decode("#FFFFFF"));
  } //end of panelDlSuccess's constructor

  private void btnYesActionPerformed(java.awt.event.ActionEvent eventBtnYes){
    //Write the code for Yes button. Perform action proceed to panelResources. 
  }
  private void btnNoActionPerformed(java.awt.event.ActionEvent eventBtnNo){
    ImageIcon bye = new ImageIcon(panelDlSuccess.class.getResource("/bye.png"));
    JOptionPane.showMessageDialog(null, "\n GOOD LUCK ! \n \n \t BYE! \n", "Exit", JOptionPane.INFORMATION_MESSAGE, bye);
    System.exit(0);
  }

}
