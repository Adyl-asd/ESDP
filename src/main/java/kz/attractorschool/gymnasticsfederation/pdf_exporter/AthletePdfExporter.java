package kz.attractorschool.gymnasticsfederation.pdf_exporter;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import kz.attractorschool.gymnasticsfederation.enumm.Status;
import kz.attractorschool.gymnasticsfederation.liberation.Liberation;
import kz.attractorschool.gymnasticsfederation.model.Athlete;
import kz.attractorschool.gymnasticsfederation.model.Coach;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AthletePdfExporter {
    private Athlete athlete;

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

//    private void writeTableData(PdfPTable table) throws IOException {
//        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(Color.BLUE);
//        cell.setPadding(5);
//
//        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//        font.setColor(Color.RED);
//
//        cell.setPhrase(new Phrase(person.getName(), Liberation.SANS_ITALIC.create()));
//        table.addCell(cell);
//
//        table.addCell(person.getId().toString());
//
//        table.addCell(person.getEmail());
//
//        cell.setPhrase(new Phrase(person.getMiddleName(), Liberation.SANS_ITALIC.create()));
//        table.addCell(cell);
//
//        table.addCell(person.getPhone());
//    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(Color.WHITE);
        font.setSize(18);

        Paragraph title = new Paragraph("Свидетельство о регистрации спортсмена", Liberation.SANS_ITALIC.create());
        document.add(new Paragraph(title));

        Paragraph photo = new Paragraph(athlete.getPerson().getPhoto().getFilePath(), Liberation.SANS_ITALIC.create());
        document.add(new Paragraph(photo));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[]{1f, 5f, 5f});

        writeString(1, "Фамилия", athlete.getPerson().getSurname(), table);
        writeString(2, "Имя", athlete.getPerson().getName(), table);
        if (athlete.getPerson().getMiddleName() != null){
            writeString(3, "Отчество (при наличии)", athlete.getPerson().getMiddleName(), table);
        }
        writeString(4, "Дата рождения", athlete.getPerson().getBirthday().toString(), table);
        writeString(5, "Пол", athlete.getPerson().getGender(), table);
        writeString(6, "Вид спорта", athlete.getDiscipline().getName(), table);
        writeString(7, "Регистрационный номер свидетельства о регистрации спортсмена", athlete.getRegistryNumber(), table);
        writeString(8, "Дата присвоения регистрационного номера свидетельства о регистрации спортсмена", athlete.getRegistryDate().toString(), table);
        writeString(9, "Наименование спортивной регистрации, осуществившей регистрацию", athlete.getSchool().getName(), table);
        writeString(10, "Сведения о присвоении спортивных разрядов, категорий", athlete.getRank().getName(), table);
        writeString(11, "Сведения о прохождении медицинских осмотров", isMedicalFile(), table);
        writeString(12, "Результаты, достигнутые на соревнованиях", isMedicalFile(), table);
        writeString(13, "Сведения о дисквалификации", isDisqualified(), table);
        writeString(14, "Сведения о допинге", isDopingFile(), table);
        writeString(15, "ФИО тренера", coaches(), table);

        document.add(table);

        document.close();
    }

    private String isMedicalFile(){
       if(this.athlete.getMedicalFile() != null){
            return "Медицинский осмотр пройден";
       }
       return "Медицинский осмотр не пройден";
    }

    private String isDisqualified(){
        if (athlete.getStatus().equals(Status.ДИСКВАЛИФИЦИРОВАН.toString())){
            return "Дисквалифицирован";
        }
        return "Данных о дисквалификации нет";
    }

    private String isDopingFile(){
        if(this.athlete.getDopingFile() != null){
            return "Данных о допинге нет";
        }
        return "Данных об отсутствии допинга нет";
    }

    private String coaches(){
        List<Coach> coaches = athlete.getCoaches();
        String result = "";
        for (int i = 0; i < coaches.size(); i ++){
            result += coaches.get(i).getPerson().getSurname();
            result += " ";
            result += coaches.get(i).getPerson().getName();
        }
        return result;
    }
}
