package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRGenerator {

	

	public static void main(String[] arg) {
		try {
			
			File file=new File("C:\\Users\\DELL\\Desktop\\QR.jpg");
			String content="DAKSHESH";
			ByteArrayOutputStream out=QRCode.from(content).to(ImageType.PNG).stream();
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(out.toByteArray());
			fos.close();
			System.out.print("QR code generated");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
