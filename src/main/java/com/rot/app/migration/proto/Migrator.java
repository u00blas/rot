package com.rot.app.migration.proto;

import com.rot.app.question.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Migrator {

    public static List<ProtoProposal> createProtoProposals(List<String> rawData) { //
        List<ProtoProposal> proposals = new ArrayList<>();
        for (String row : rawData) {
            String[] columns = row.split(";");
            if (columns.length >= 30) {
                if (!columns[24].isEmpty() || !columns[25].isEmpty()) {
                    List.of(26, 27, 28, 29, 30).forEach(i -> {
                        if (!columns[i].isEmpty()) {
                            ProtoProposal proposal = new ProtoProposal();
                            proposal.setMinScale(columns[24]);
                            proposal.setMaxScale(columns[25]);
                            proposal.setQuestion(columns[i]);
                            if (!proposals.contains(proposal)) {
                                proposals.add(proposal);
                            }
                        }
                    });
                }
            }
        }
        return proposals;
    }

        public static List<ProtoSubquestion> createProtoSubquestions(List<String> lines) {
        List<ProtoSubquestion> subquestions = new ArrayList<>();
        for (int i = 2; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(";");
            if (parts.length >= 22 && parts[8].isEmpty() && !parts[22].isEmpty()) {
                ProtoSubquestion subquestion = new ProtoSubquestion();
                subquestion.setQuestion(parts[22]);
                subquestion.setNumberI(parts[8]);
                subquestion.setNumberJ(parts[9]);
                subquestion.setNumberK(parts[10]);
                subquestion.setPage(parts[7]);
                if (!subquestions.contains(subquestion)) {
                    subquestions.add(subquestion);
                }
            }
        }
        return subquestions;
    }

    public static List<Question> createQuestions(List<String> lines) {
        List<Question> questions = new ArrayList<>();
        for (int i = 2; i <= 143; i++) {
            String line = lines.get(i);

            String[] parts = line.split(";");
            if (parts.length >= 30
                    && !parts[8].isEmpty()
                    && !parts[9].isEmpty()
                    && !parts[10].isEmpty()
                    && !parts[23].isEmpty()
                    && !parts[22].isEmpty()) {
                Question question = new Question();
                question.setQuestionDe(parts[22]);
                if(parts.length >= 51) {
                    question.setQuestionEn(parts[51]);
                }
                question.setPage(parts[7]);
                question.setNewNumber(parts[8]);
                question.setOwnNumber(parts[9]);
                question.setSequenceNumber(parts[10]);


                questions.add(question);

            }
        }

        return questions;
    }
}
