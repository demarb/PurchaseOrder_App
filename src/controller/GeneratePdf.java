package controller;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class GeneratePdf {
	public static String po_id = "";
	public static String approving_emp = "";
	public static String dateTime = "";
	public static String req_id = "";
	public static String item_id = "";
	public static String item_name = "";
	public static String quantity = "";
	public static String unit_price = "";
	public static String total_price = "";
	public static String supplier_name = "";
	public static String supplier_tel = "";
	public static String supplier_email = "";
	public static String associated_emp = "";
	
	//Document Name
	public static String document_name = "./generated-pdfs/test.pdf";

	public static void createPDF() throws IOException {
		
		PDDocument document = new PDDocument();
		
		PDPage first_page = new PDPage();
		first_page.setTrimBox(PDRectangle.LETTER);
		document.addPage(first_page);
		
		PDPageContentStream contentStream = new PDPageContentStream(document, first_page);
		contentStream.beginText();
		
		contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 40);
		contentStream.setLeading(20.0f);
		contentStream.newLineAtOffset(50, first_page.getTrimBox().getHeight()-50);
		
		String titleText = "Purchase Order #: " + po_id;		
		contentStream.showText(titleText);
		contentStream.newLine();
		
		
		contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 16);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(approving_emp);
		contentStream.newLine();
		contentStream.showText(dateTime);
		contentStream.newLine();
		contentStream.showText(req_id);
		contentStream.newLine();
		contentStream.showText(item_id);
		contentStream.newLine();
		contentStream.showText(item_name);
		contentStream.newLine();
		contentStream.showText(quantity);
		contentStream.newLine();
		contentStream.showText(unit_price);
		contentStream.newLine();
		contentStream.showText(total_price);
		contentStream.newLine();
		contentStream.showText(supplier_name);
		contentStream.newLine();
		contentStream.showText(supplier_tel);
		contentStream.newLine();
		contentStream.showText(supplier_email);
		contentStream.newLine();
		contentStream.showText(associated_emp);
		contentStream.newLine();
		
		contentStream.newLine();
		contentStream.newLine();
		contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 18);
		String companyStamp = "Company Stamp";		
		contentStream.showText(companyStamp);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		String sigLine = "_________________________________________";		
		contentStream.showText(sigLine);
		contentStream.newLine();
		String supplierStamp = "Supplier Stamp";		
		contentStream.showText(supplierStamp);
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.newLine();
		contentStream.showText(sigLine);
		
		contentStream.endText();
		contentStream.close();
		
		
		
		document.save(document_name);
		System.out.println("PDF Created");
		document.close();
	}

}
