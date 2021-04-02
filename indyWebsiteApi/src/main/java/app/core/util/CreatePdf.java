package app.core.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import app.core.entities.Purchase;

public class CreatePdf {


	public CreatePdf() {

	}

	public static void makeFile(Purchase purchase) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ASHER\\git\\indyWebsiteApi\\indyWebsiteApi\\src\\main\\resources\\confirm.pdf"));
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			document.add(new Chunk("ID: "+String.valueOf(purchase.getId()) , font));
			document.add(new Chunk("User Details: "+purchase.getUser().toString(), font));
			document.add(new Chunk("Shipping Address : "+purchase.getShipping(), font));
			document.add(new Chunk("Order status : "+purchase.getStatus(), font));
			document.add(new Chunk("Your account reference : "+purchase.getAcc(), font));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

}
