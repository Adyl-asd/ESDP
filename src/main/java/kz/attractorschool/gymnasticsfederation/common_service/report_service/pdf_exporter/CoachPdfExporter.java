package kz.attractorschool.gymnasticsfederation.common_service.report_service.pdf_exporter;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import kz.attractorschool.gymnasticsfederation.common_service.report_service.liberation.Liberation;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Coach;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@AllArgsConstructor
public class CoachPdfExporter {
    private Coach coach;

    private void writeString(Integer number, String info, String answer, PdfPTable table) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);

        cell.setPhrase(new Phrase(number.toString(), Liberation.SANS_ITALIC.create()));
        table.addCell(cell);

        cell.setPhrase(new Phrase(info, Liberation.SANS_ITALIC.create()));
        table.addCell(cell);

        cell.setPhrase(new Phrase(answer, Liberation.SANS_ITALIC.create()));
        table.addCell(cell);
    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.WHITE);
        font.setSize(18);

        Paragraph title = new Paragraph("Свидетельство о регистрации спортсмена", Liberation.SANS_ITALIC.create());
        document.add(new Paragraph(title));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[]{1f, 5f, 5f});

//        writeString(1, "Фамилия", athlete.getPerson().getSurname(), table);
//        writeString(2, "Имя", athlete.getPerson().getName(), table);
//        if (athlete.getPerson().getMiddleName() != null){
//            writeString(3, "Отчество (при наличии)", athlete.getPerson().getMiddleName(), table);
//        }
//        writeString(4, "Дата рождения", athlete.getPerson().getBirthday().toString(), table);
//        writeString(5, "Пол", athlete.getPerson().getGender(), table);
//        writeString(6, "Вид спорта", athlete.getDiscipline().getName(), table);
//        writeString(7, "Регистрационный номер свидетельства о регистрации спортсмена", athlete.getRegistryNumber(), table);
//        writeString(8, "Дата присвоения регистрационного номера свидетельства о регистрации спортсмена", athlete.getRegistryDate().toString(), table);
//        writeString(9, "Наименование спортивной регистрации, осуществившей регистрацию", athlete.getSchool().getName(), table);
//        writeString(10, "Сведения о присвоении спортивных разрядов, категорий", athlete.getRank().getName(), table);
//        writeString(11, "Сведения о прохождении медицинских осмотров", isMedicalFile(), table);
//        writeString(12, "Результаты, достигнутые на соревнованиях", isMedicalFile(), table);
//        writeString(13, "Сведения о дисквалификации", isDisqualified(), table);
//        writeString(14, "Сведения о допинге", isDopingFile(), table);
//        writeString(15, "ФИО тренера", coaches(), table);

        document.add(table);

        document.close();
    }
}
