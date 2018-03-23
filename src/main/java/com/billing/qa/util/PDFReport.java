package com.billing.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PDFReport {

	
	public static void main(String[] args) {
		
	
	
	// step 1
    Document document = new Document();
    // step 2
    PdfWriter writer;
	try {
		writer = PdfWriter.getInstance(document, new FileOutputStream("report.pdf"));
		
		 document.open();
		    // step 4
		    XMLWorkerHelper.getInstance().parseXHtml(writer, document,new FileInputStream("A:/Workspace/Billing/test-output/emailable-report.html")); 
		    //step 5
		     document.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    // step 3
 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   

	
}
}
