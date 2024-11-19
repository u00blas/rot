package com.rot.app.migration;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import com.rot.app.question.Question;
import com.rot.app.topic.Topic;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

//0: 1
//1: Sheet
//2: Zielgruppe
//3: Thema
//4: Empty 0
//5: Unipark Seiten
//6: Empty 1
//7: Seite neues Layout
//8: Nummer neues Layout
//9: eigene Nummer
//10: lfd Nummer
//11: Trust 1 v1
//12: Empty 2
//13: Zielgruppe2
//14: Unipark
//15: Empty 3
//16: INESkey
//17: Empty 4
//18: Match
//19: Scorecard
//20: KI
//21: Seite
//22: Frage
//23: Fragetyp
//24: Skala min
//25: Skala max
//26: Wert1
//27: Wert2
//28: Wert3
//29: Wert4
//30: Wert5
//31: Empty 5
//32: Code1Bemerkung
//33: Codierung2
//34: Codeierung3
//35: Schluessel
//36: Empty 6
//37: MGT
//38: Empty 7
//39: Empty 8
//40: Empty 9
//41: Empty 10
//42: Vignette
//43: Empty 11
//44: ScheetE
//45: Unipark SeitenE
//46: eigene NummerE
//47: lfd NummerE
//48: Trust 1 v1E
//49: UniparkE
//50: EE
//51: FrageEnglisch
//52: Empty 12
//53: Codierung1E
//54: Codierung2E
//55: Codierung3E
//56: SchluesselE
//57: VignE
//58: MA
//Seite neues Layout (7), Nummer neues Layout (8), eigene Nummer (9), lfd Nummer (10), eigene NummerE (46), lfd NummerE (47), INESkey (16)
//->  1, , 1, 1, 1, 1, 0
//Sheet (1), Zielgruppe (2), Zielgruppe2 (13), Thema (3), ScheetE (44)
//->  Fragen Vertrauen Stand 30112022, Mitar0, MA, Vertrauen, Fragen Vertrauen Stand 3011 eng
//Unipark Seiten (5), Unipark SeitenE (45), Trust 1 v1 (11), Trust 1 v1E (48), Unipark (14), UniparkE (49)
//->  Trust 1, Trust 1, v1, v1, v_1, v_1
//Codierung2 (33), Codierung2E (54), Codeierung3 (34), Codierung3E (55), Schluessel (35), SchluesselE (56)
//->  1.3, 1.3, 1.3.1, 1.3.1, TNO_1, TNO_1
//Frage (22)
//->  Haben Sie regelmäßige Kontakte zu anderen Mitarbeitenden im Unternehmen?
//FrageEnglisch (51)
//->  Do you have regular contacts to other people in the company?
//Fragetyp (23), Skala min (24), Skala max (25), Wert1 (26), Wert2 (27), Wert3 (28), Wert4 (29), Wert5 (30)
//->  1, Nie, Sehr häufig, asdf1, asdf, sdaf, sadf, asdf
//--------------------------------------------------------------------------------

public class MigrateData {

    private static Map<String, Integer> columns;
    private static List<Category> categoryList;
    private static List<String[]> questionParts;

    public static Map<String, Integer> getColumns() {
        if (columns == null) {
            columns = new HashMap<>();
            columns.put("A", 0);
            columns.put("B", 1);
            columns.put("C", 2);
            columns.put("D", 3);
            columns.put("E", 4);
            columns.put("F", 5);
            columns.put("G", 6);
            columns.put("I", 7);
            columns.put("J", 8);
            columns.put("K", 9);
            columns.put("L", 10);
            columns.put("M", 11);
            columns.put("N", 12);
            columns.put("O", 13);
            columns.put("P", 14);
            columns.put("Q", 15);
            columns.put("R", 16);
            columns.put("S", 17);
            columns.put("T", 18);
            columns.put("U", 19);
            columns.put("V", 20);
            columns.put("W", 21);
            columns.put("X", 22);
            columns.put("Y", 23);
            columns.put("Z", 24);
            columns.put("AA", 25);
            columns.put("AB", 26);
            columns.put("AC", 27);
            columns.put("AD", 28);
            columns.put("AE", 29);
            columns.put("AF", 30);
            columns.put("AG", 31);
            columns.put("AH", 32);
            columns.put("AI", 33);
            columns.put("AJ", 34);
            columns.put("AK", 35);
            columns.put("AL", 36);
            columns.put("AM", 37);
            columns.put("AN", 38);
            columns.put("AO", 39);
            columns.put("AP", 40);
            columns.put("AQ", 41);
            columns.put("AR", 42);
            columns.put("AS", 43);
            columns.put("AT", 44);
            columns.put("AU", 45);
            columns.put("AV", 46);
            columns.put("AW", 47);
            columns.put("AX", 48);
            columns.put("AY", 49);
            columns.put("AZ", 50);
            columns.put("BA", 51);
            columns.put("BB", 52);
            columns.put("BC", 53);
            columns.put("BD", 54);
            columns.put("BE", 55);
            columns.put("BF", 56);
            columns.put("BG", 57);
            columns.put("BH", 58);
        }
        return columns;
    }

    public static int getColumnIndex(String column) {
        return getColumns().get(column) + 1;
    }

    public static List<String> getPartsFromCsvLine(String[] parts, int startColumn, int endColumn) {
        return Arrays.asList(parts).subList(startColumn, endColumn);
    }

    public static List<List<String>> getPartsFromCsvLines(List<String> lines, int starRow, int endRow) {
        List<List<String>> parts = new ArrayList<>();
        for (int i = starRow; i < endRow; i++) {
            parts.add(Arrays.asList(lines.get(i).split(";")));
        }
        return parts;
    }

    public static List<List<String>> getBlockFromCsv(List<String> lines, int startRow, int endRow, int startColumn) {

        return getBlockFromCsv(lines, startRow, endRow, startColumn, startColumn + 1);
    }

    public static List<List<String>> getBlockFromCsv(List<String> lines, int startRow, int endRow, int startColumn, int endColumn) {
        List<List<String>> block = new ArrayList<>();
        for (int i = startRow - 1; i < endRow; i++) {
            block.add(Arrays.asList(lines.get(i).split(";")).subList(startColumn + 1, endColumn + 1));
        }
        return block;
    }

    public static List<String> getRowsFromCsv(int startRow, int endRow) {
        List<String> lines = new ArrayList<>();
        Resource resource = new ClassPathResource("Teil 3 Masterdatei RoT-Modell Interviews.csv");
        try {
            File file = resource.getFile();
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines.subList(startRow - 1, endRow);
    }

    public static List<List<String>> getColumnsFromCsv(List<String> lines, int startColumn) {
        return getColumnsFromCsv(lines, startColumn, startColumn + 1);
    }

    public static List<List<String>> getColumnsFromCsv(List<String> lines, int startColumn, int endColumn) {

        List<List<String>> columns = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            columns.add(Arrays.asList(lines.get(i).split(";")).subList(startColumn + 1, endColumn + 1));
        }
        return columns;
    }

    public static List<List<String>> getDistinctColumnsFromCsv(List<String> lines, int startColumn, int endColumn) {
        List<List<String>> columns = getColumnsFromCsv(lines, startColumn, endColumn);
        List<List<String>> distinctColumns = new ArrayList<>();
        for (List<String> column : columns) {
            if (!distinctColumns.contains(column)) {
                distinctColumns.add(column);
            }
        }
        return distinctColumns;
    }

    public static List<String> getLinesFromCsv() {
        List<String> lines = new ArrayList<>();
        Resource resource = new ClassPathResource("Teil 3 Masterdatei RoT-Modell Interviews.csv");
        try {
            File file = resource.getFile();
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static List<Proposal> getProposalsFromCsv() {
        List<Proposal> possibleAnswersList = new ArrayList<>();
        List<String> lines = getLinesFromCsv();
        List<String> distinctLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length < MigrateData.getColumnIndex("AE")) {
                continue;
            }
            int distinctColumnIndex = MigrateData.getColumnIndex("Y");
            if (distinctLines.contains(parts[distinctColumnIndex])) {
                continue;
            } else {
                if (parts[distinctColumnIndex].isEmpty() || parts[distinctColumnIndex].equals("Skala min")) {
                    continue;
                }
                distinctLines.add(parts[distinctColumnIndex]);
                possibleAnswersList.add(createProposalFromCsvLine(parts));
            }
        }
        return possibleAnswersList;
    }

    private static Proposal createProposalFromCsvLine(String[] parts) {
        return new Proposal(null, "", parts[MigrateData.getColumnIndex("Y")].trim(),
                parts[MigrateData.getColumnIndex("Z")].trim(), null,
                parts[MigrateData.getColumnIndex("AA")].trim(),
                parts[MigrateData.getColumnIndex("AB")].trim(),
                parts[MigrateData.getColumnIndex("AC")].trim(),
                parts[MigrateData.getColumnIndex("AD")].trim(),
                parts[MigrateData.getColumnIndex("AE")].trim());
    }


    public static List<Topic> getTopicListFromCsv() {
        List<Topic> topicList = new ArrayList<>();
        List<String> lines = getLinesFromCsv();
        List<String> distinctLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length < 4) {
                continue;
            }
            if (distinctLines.contains(parts[3])) {
                continue;
            } else {
                distinctLines.add(parts[3]);
                if (parts[3].isEmpty() || parts[3].equals("Thema")) {
                    continue;
                }
                topicList.add(createTopicFromCsvLine(parts));
            }
        }
        return topicList;
    }

    private static Topic createTopicFromCsvLine(String[] parts) {
        return new Topic(parts[3]);
    }

    public static List<Category> getCategoriesFromCsv() {
        if (categoryList == null) {
            categoryList = new ArrayList<>();

            List<String> lines = getLinesFromCsv();
            List<String> distinctLines = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length < getColumnIndex("D")) {
                    continue;
                }

                int distinctColumnIndex = getColumnIndex("D") - 1;
                if (distinctLines.contains(parts[distinctColumnIndex])) {
                    continue;
                }
                //System.out.println("parts");
                if (parts[distinctColumnIndex].isEmpty() || parts[distinctColumnIndex].equals("Thema")) {
                    continue;
                }
                distinctLines.add(parts[distinctColumnIndex]);
                //System.out.println(parts[distinctColumnIndex]);
                Category category = createCategoryFromCsvLine(parts);
                //System.out.println(category);
                categoryList.add(category);
            }
        }

        return categoryList;
    }

    private static Category createCategoryFromCsvLine(String[] parts) {
        return new Category(parts[MigrateData.getColumnIndex("D") - 1]);
    }

    public static Optional<Category> getCategoryByName(String name) {
        List<Category> categories = getCategoriesFromCsv();
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return Optional.of(category);
            }
        }
        return Optional.empty();
    }

    private static Question createQuestionFromCsvLine(String[] parts) {
        if (questionParts == null) {
            questionParts = new ArrayList<>();
        }
        questionParts.add(parts);
        return new Question(parts[getColumnIndex("W")].trim());
    }

    public static List<String[]> getQuestionParts() {
        return questionParts;
    }

}
