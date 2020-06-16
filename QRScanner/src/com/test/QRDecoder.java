package com.test;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRDecoder {

	public static void main(String[] args) {
		try {
			
			JFileChooser ch=new JFileChooser();
			ch.showOpenDialog(null);
			File file=ch.getSelectedFile();
			
			if(file==null) {
				throw new Exception("invalid file");
			}
			
			//File file=new File("C:\\Users\\DELL\\Desktop\\QR.jpg");
			Result r=new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));
		    //System.out.print(r.getText());
			//JOptionPane.showMessageDialog(null,r.getText());
			JOptionPane.showMessageDialog(null,r.getText(),"QR content",JOptionPane.INFORMATION_MESSAGE,new ImageIcon(file.getAbsolutePath()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
