package com.ofud.ofud.pdf;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.ofud.ofud.estudiante.EstudianteDAO;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PDFService {
    private final EstudianteDAO dao;
    

    public void export(HttpServletResponse response) throws IOException {
        List<String[]> dataList = dao.viaticos();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("Viaticos Estudiantes.", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        document.add(paragraph);

        // Agregar los elementos de la lista al documento
        StringBuilder builder = new StringBuilder();
        String header = "Codigo  Nombre  Apellido  Horas Totales";
        Paragraph pHeader = new Paragraph(header, fontParagraph);
        pHeader.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(pHeader);
        for (String[] data : dataList) {
            for (String value : data) {
                builder.append(value+"  ");
                
            }
            Paragraph paragraphData = new Paragraph(builder.toString(), fontParagraph);
            paragraphData.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(paragraphData);
            builder.setLength(0);
        }

        document.close();
    }
}

