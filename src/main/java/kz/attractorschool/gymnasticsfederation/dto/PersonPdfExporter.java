package kz.attractorschool.gymnasticsfederation.dto;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import kz.attractorschool.gymnasticsfederation.liberation.Liberation;
import kz.attractorschool.gymnasticsfederation.model.Person;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;


@AllArgsConstructor
public class PersonPdfExporter {
    private Person person;

    private void writeTableHeader(PdfPTable table) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.COURIER);
        font.setColor(Color.RED);

        cell.setPhrase(new Phrase("Имя", Liberation.SANS_ITALIC.create()));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Фамилия", Liberation.SANS_ITALIC.create()));
        table.addCell(cell);

        cell.setPhrase(new Phrase("E-mail", Liberation.SANS_ITALIC.create()));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Middle Name", Liberation.SANS_ITALIC.create()));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Phone", Liberation.SANS_ITALIC.create()));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.RED);

        cell.setPhrase(new Phrase(person.getName(), Liberation.SANS_ITALIC.create()));
        table.addCell(cell);
        
        table.addCell(person.getId().toString());

        table.addCell(person.getEmail());

        cell.setPhrase(new Phrase(person.getMiddleName(), Liberation.SANS_ITALIC.create()));
        table.addCell(cell);

        table.addCell(person.getPhone());
    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.WHITE);
        font.setSize(18);

        Paragraph title = new Paragraph("Person", Liberation.SANS_ITALIC.create());
        document.add(new Paragraph(title));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f, 1.5f});

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }

    public boolean useUnicodeFont( String text ){
        if ( text != null ) {
            final StringCharacterIterator iterator = new StringCharacterIterator(text);
            char character = iterator.current();
            while (character != CharacterIterator.DONE) {
                if ( character != '\r' && Character.UnicodeBlock.of(character) != Character.UnicodeBlock.BASIC_LATIN) {
                    return true;
                }
                character = iterator.next();
            }
        }
        return false;
    }


}
