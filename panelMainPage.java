import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class panelMainPage extends JPanel{
  JLabel lblHostName ;
  JLabel lblPortNumber ;
  JButton btnConnect ;
  JTextField txtHostName ;
  JTextField txtPortNumber ;

  public panelMainPage(){
    lblHostName = new JLabel();
    lblHostName.setText("Host Name    : ");
    lblHostName.setFont(new Font("Avenir Next", 1, 14));

    lblPortNumber = new JLabel();
    lblPortNumber.setText("Port Number : ");
    lblPortNumber.setFont(new Font("Avenir Next", 1, 14));

    txtHostName = new JTextField();
    txtHostName.setFont(new Font("Avenir", 0, 14));

    txtPortNumber = new JTextField();
    txtPortNumber.setFont(new Font("Avenir", 0, 14));

    btnConnect = new JButton();
    btnConnect.setText("CONNECT");
    btnConnect.setFont(new Font("Avenir Next", 1, 14));
    btnConnect.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnConnect.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent eventBtnConnect) {
            btnConnectActionPerformed(eventBtnConnect);
        }
      }
    );

    add(lblHostName);
    add(lblPortNumber);
    add(btnConnect);
    add(txtHostName);
    add(txtPortNumber);
    add(btnConnect);


//To make layout in mainPage Panel using GroupLayout.
    GroupLayout glMainPage = new GroupLayout(this);
    glMainPage.setAutoCreateContainerGaps(true);

/* --- All grouping in this section is based on Horizontal view. --- */
    glMainPage.setHorizontalGroup(
      glMainPage.createSequentialGroup()

/* --- Group up to all component to become column 1 --- */
      .addGroup(
        glMainPage.createParallelGroup()

/* --- Group up lblHostName,lblPortNumber with txtPortNumber,txtHostName (ROW 1). --- */
        .addGroup(
          glMainPage.createSequentialGroup()
          .addGap(206, 206, 206)
          .addGroup(
            glMainPage.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lblHostName)
            .addComponent(lblPortNumber)
          )
          .addGroup(
            glMainPage.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(txtHostName, GroupLayout.PREFERRED_SIZE, 287,GroupLayout.PREFERRED_SIZE)
            .addComponent(txtPortNumber, GroupLayout.PREFERRED_SIZE, 287,GroupLayout.PREFERRED_SIZE)
          )
        )

/* --- Add btnConnect as (ROW 2). --- */
        .addGroup(
          glMainPage.createSequentialGroup()
          .addGap(206, 206, 206)
          .addComponent(btnConnect,  GroupLayout.PREFERRED_SIZE, 387,GroupLayout.PREFERRED_SIZE)
        )
      )
    );

/* --- All grouping in this section is based on Horizontal view. --- */
    glMainPage.setVerticalGroup(
          glMainPage.createSequentialGroup()
          .addGap(100, 100, 100)
          .addGroup(
            glMainPage.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(lblHostName)
            .addComponent(txtHostName, GroupLayout.PREFERRED_SIZE, 35,GroupLayout.PREFERRED_SIZE)
            )
          .addGap(40, 40, 40)

        .addGroup(
          glMainPage.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(lblPortNumber)
          .addComponent(txtPortNumber, GroupLayout.PREFERRED_SIZE, 35,GroupLayout.PREFERRED_SIZE)
        )
        .addGap(93, 93, 93)
        .addComponent(btnConnect, GroupLayout.PREFERRED_SIZE, 40,GroupLayout.PREFERRED_SIZE)
    );

    setBackground(Color.decode("#FFFFFF"));
    setLayout(glMainPage);
    setVisible(true);
  } /* end of panelMainPage constructor */

  private void btnConnectActionPerformed(java.awt.event.ActionEvent eventBtnConnect){
    ImageIcon terms = new ImageIcon(panelDlSuccess.class.getResource("/terms.png"));
      JOptionPane.showConfirmDialog(null, " Hello! \n Here are the terms of references. \n Do you accept?", "Terms of References", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, terms);
  }

}
