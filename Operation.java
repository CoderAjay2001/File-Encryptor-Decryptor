import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.TreeMap;;

public class Operation {
   public static void operate(int key)
   {
     JFileChooser filechooser=new JFileChooser();
     filechooser.showOpenDialog(null);
     File file=filechooser.getSelectedFile();

     //file input stream reader
     try{
      FileInputStream file1=new FileInputStream(file);
      byte[] data=new byte[file1.available()];
      file1.read(data);
      int i=0;
      for(byte b:data)
      {
         System.out.println(b);
         data[i]=(byte)(b^key);
         i++;
      }
      FileOutputStream fos=new FileOutputStream(file);
      fos.write(data);
      fos.close();
      file1.close();
      JOptionPane.showMessageDialog(null,"Done");

     }catch(Exception e)
     {
       e.printStackTrace();
     }
   }
   public static void main(String[] args) {
      System.out.println("This is Testing");
      JFrame f = new JFrame();
      f.setTitle("Image Encryptor");
      f.setSize(400, 400);
      f.setLocationRelativeTo(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Font
      Font font = new Font("Roboto", Font.BOLD, 25);
      // Creating button
      JButton button = new JButton();
      button.setText("Open Image");
      button.setFont(font);

      // Creating a text field

      JTextField textField = new JTextField(10);
      textField.setFont(font);
      button.addActionListener(e -> {
         System.out.println("button clicked");
         String text = textField.getText();
         int temp = Integer.parseInt(text);
         operate(temp);
      });
      f.setLayout(new FlowLayout());

      f.add(button);
      f.add(textField);

      f.setVisible(true);

   }
}
