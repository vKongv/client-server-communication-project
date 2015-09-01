import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.lang.*;

public class panelResources extends JPanel{
  JLabel lblWelcome ;
  JLabel lblSelectMsg ;
  JLabel lblResource ;
  JComboBox cbCollection ;
  String[] fileSelection = { "iTune", "ZoneAlarm", "WinRar", "Audacity" };
  JButton btnConfirm ;

  public panelResources () {
    lblWelcome = new JLabel();
    lblWelcome.setText("Welcome !");
    lblWelcome.setFont(new Font("Avenir Next", 0, 50));


    lblSelectMsg = new JLabel();
    lblSelectMsg.setText("Select a resource you desired for downloading.");
    lblSelectMsg.setFont(new Font("Avenir Next", 1, 14));

    lblResource = new JLabel();
    lblResource.setText("Resources: ");
    lblResource.setFont(new Font("Avenir Next", 1, 14));

    cbCollection = new JComboBox(fileSelection);
    cbCollection.setSelectedIndex(0);
  //  cbCollection.addActionListener(this);

    btnConfirm = new JButton();
    btnConfirm.setText("CONFIRM");
    btnConfirm.setFont(new Font("Avenir Next", 1, 14));
    btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnConfirm.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent eventBtnConfirm) {
            btnConfirmActionPerformed(eventBtnConfirm);
        }
      }
    );

    add(lblWelcome);
    add(lblSelectMsg);
    add(lblResource);
    add(btnConfirm);
    add(cbCollection);

//To make layout in mainPage Panel using GroupLayout.
    GroupLayout glResources = new GroupLayout(this);
    glResources.setAutoCreateContainerGaps(true);

/* --- All grouping in this section is based on Horizontal view. --- */
    glResources.setHorizontalGroup(
      glResources.createSequentialGroup()
      .addGap(206, 206, 206)
          /* --- Group up to all component to become column 1 --- */
      .addGroup(
        glResources.createParallelGroup()
          /* --- Group up lblHostName,lblPortNumber with txtPortNumber,txtHostName (ROW 1). --- */
        .addGroup(
          glResources.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(
            glResources.createSequentialGroup()
            .addGap(50,50,50)
            .addComponent(lblWelcome))
            .addGroup(
              glResources.createSequentialGroup()
              .addGap(25,25,25)
              .addComponent(lblSelectMsg))
          .addGroup(
            glResources.createSequentialGroup()
            .addGap(80,80,80)
            .addComponent(lblResource)
            .addComponent(cbCollection, GroupLayout.PREFERRED_SIZE, 120,GroupLayout.PREFERRED_SIZE))
          .addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 387,GroupLayout.PREFERRED_SIZE))
      ));

    /* --- All grouping in this section is based on Horizontal view. --- */
    glResources.setVerticalGroup(
      glResources.createSequentialGroup()
      .addGap(80, 80, 80)
      .addComponent(lblWelcome)
      .addGap(40, 40, 40)
      .addComponent(lblSelectMsg)
      .addGap(40, 40, 40)
      .addGroup(
        glResources.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(lblResource)
        .addComponent(cbCollection))
      .addGap(93, 93, 93)
      .addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 40,GroupLayout.PREFERRED_SIZE));

      setLayout(glResources);
      setVisible(true);
    } /* end of panelMainPage constructor */

      private void btnConfirmActionPerformed(java.awt.event.ActionEvent eventBtnConfirm){
        ImageIcon icon = new ImageIcon(panelResources.class.getResource("/loading.gif"));

        JDialog dialog = new JDialog();

        Dimension dSize = new Dimension(600, 500);
        dialog.setSize(dSize);
        dialog.setMinimumSize(dSize);
        dialog.setMaximumSize(dSize);
        dialog.setResizable(false);

        JPanel panelTest = new JPanel ();

        JLabel lblImgLoading = new JLabel(icon);

        JLabel lblPercentage = new JLabel();
        lblPercentage.setFont(new Font("Avenir Next",1, 30));
        lblPercentage.setForeground(Color.decode("#7FFFD4"));

        GroupLayout glWait = new GroupLayout(panelTest);
        glWait.setAutoCreateContainerGaps(true);
        glWait.setHorizontalGroup(
          glWait.createSequentialGroup()
          .addGroup(
            glWait.createParallelGroup()
            .addComponent(lblImgLoading)
            .addGroup(
              glWait.createSequentialGroup()
              .addGap(250,250,250)
              .addComponent(lblPercentage))));
        glWait.setVerticalGroup(
        glWait.createSequentialGroup()
          .addComponent(lblImgLoading)
        //  .addGap(20,20,20)
          .addComponent(lblPercentage));

        panelTest.setLayout(glWait);
        panelTest.add(lblImgLoading);
        dialog.add(panelTest);
        dialog.pack();
        dialog.setVisible(true);

        for(int x = 0; x < 100; x = x + (int)(Math.ceil((Math.random() * 5))))
        {
          try{
          lblPercentage.setText(Integer.toString(x)+"%");
          Thread.sleep(200);}
          catch(InterruptedException e){JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.INFORMATION_MESSAGE); }
        };
      }}
