package com.rot.app;

import com.rot.app.category.Category;
import com.rot.app.question.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public static List<Category> getCategoryListFromCsv() {
        List<Category> categoryList = new ArrayList<>();

        Resource resource = new ClassPathResource("Teil 3 Masterdatei RoT-Modell Interviews.csv");
        try {
            File file = resource.getFile();
            List<String> lines = Files.readAllLines(file.toPath());
            List<String> distinctLines = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length < 3) {
                    continue;
                }
                if (distinctLines.contains(parts[2])) {
                    continue;
                }
                distinctLines.add(parts[2]);
                System.out.println(parts[2]);
                //Category category = createCategoryFromCsvLine(line.split(";"));
                //categoryList.add(category);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return categoryList;
    }

    private static Category createCategoryFromCsvLine(String[] parts) {
        return new Category(parts[0]);
    }

    private Question createQuestionFromCsvLine(String[] parts) {
        List<String> sb = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (List<Integer> ln : Arrays.asList(
                Arrays.asList(7, 8, 9, 46, 10, 47, 16),
                Arrays.asList(1, 2, 13, 3, 44),
                Arrays.asList(5, 45, 11, 48, 14, 49),
                Arrays.asList(33, 54, 34, 55, 35, 56),
                Arrays.asList(22),
                Arrays.asList(51),
                Arrays.asList(23),
                Arrays.asList(24, 25),
                Arrays.asList(26, 27, 28, 29, 30)
        )) {
            for (int n : ln) {
                temp.add(parts.length <= n ? "" : parts[n]);
            }
            sb.add(String.join(", ", temp));
            temp.clear();
        }

        return new Question(sb.get(0));
    }
}
