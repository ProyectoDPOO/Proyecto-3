package Modelo;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Facturar {
    public Facturar(String clientName, String idClient, String precioTotal) {
    	
    	Factura factura = new Factura();
    	factura.setItems(obtenerDetallesProductos()); // Implementa esta función según tus necesidades
    	factura.setTotalAmount(paymentInfo.getMonto());

    	// Llamada a la clase Facturar para generar el PDF
    	Facturar facturador = new Facturar();
    	facturador.Facturar(cardHolderName, cardNumber, Double.toString(paymentInfo.getMonto()));
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