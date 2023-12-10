package Modelo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Facturar {
    public void Facturar(String clientName, String idClient, String precioTotal) {
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(clientName + ".pdf"));
            document.open();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formatDateTime = now.format(formatter);
            document.add(new Paragraph("FACTURA DEL ALQUILER  " + formatDateTime));
            document.add(new Paragraph("------------------------------------------------------------ " ));
            document.add(new Paragraph("DATOS CLIENTE" ));
            document.add(new Paragraph("Client Name: " + clientName));
            document.add(new Paragraph("Client ID: " + idClient));
            document.add(new Paragraph("------------------------------------------------------------ " ));
             document.add(new Paragraph("total a pagar:" +precioTotal));
            document.add(new Paragraph("------------------------------------------------------------ " ));
             document.add(new Paragraph("FIRMA ADMINISTRADOR"));

            String imagePath = "FACTURAS/firma.jpg";
            Image image = Image.getInstance(imagePath);
            document.add(image);

            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}