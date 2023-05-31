package com.ofud.ofud.pdf;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
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
        dao.setCalendariosInactivos();
    
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
    
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
    
        Paragraph paragraph = new Paragraph("Viaticos Estudiantes.", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
    
        Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontHeader.setSize(12);
    
        Font fontData = FontFactory.getFont(FontFactory.HELVETICA);
        fontData.setSize(12);
    
        document.add(paragraph);
    
        // Crear la tabla
        PdfPTable table = new PdfPTable(4); // 4 columnas
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
    
        // Agregar encabezados de la tabla
        String[] headers = { "Codigo", "Nombre", "Apellido", "Horas Totales" };
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, fontHeader));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
    
        // Agregar los registros a la tabla
        for (String[] data : dataList) {
            for (String value : data) {
                PdfPCell cell = new PdfPCell(new Phrase(value, fontData));
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            }
        }
    
        // Agregar la tabla al documento
        document.add(table);
        document.close();
    }
}

