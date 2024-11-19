package com.rot.app.migration;

import com.rot.app.category.Category;
import com.rot.app.proposal.Proposal;
import com.rot.app.proposal.ProposalRepository;
import com.rot.app.proposal.replayoption.ReplayOption;
import com.rot.app.proposal.replayoption.ReplayOptionRepository;
import com.rot.app.question.Question;
import com.rot.app.question.QuestionRepository;
import com.rot.app.question.subquestion.Subquestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MigrationService {

    private final ReplayOptionRepository replayOptionRepository;
    private final ProposalRepository proposalRepository;
    private final QuestionRepository questionRepository;

    public MigrationService(ReplayOptionRepository replayOptionRepository, ProposalRepository proposalRepository, QuestionRepository questionRepository) {
        this.replayOptionRepository = replayOptionRepository;
        this.proposalRepository = proposalRepository;
        this.questionRepository = questionRepository;
    }


    public List<Category> getCategoriesFromCsv() {

        return null;
    }

    private List<ReplayOption> createReplayOptions() {

        List<String> lines = MigrateRawData.getLinesFromCsv();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 2; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");
            if (parts.length >= 30) {
                System.out.println("ooo".repeat(80));
                if (!parts[24].isEmpty() && !parts[25].isEmpty()) {
                    map.put(parts[24] + " " + parts[25], List.of(parts[24], parts[25], parts[26], parts[27], parts[28], parts[29], parts[30]));
                } else {
                    System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            } else {
                if (parts.length >= 27) {
                    System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            }
        }

        map.forEach((key, value) -> {
            Proposal proposal = new Proposal();
            proposal.setName(key);
            proposal.setMinScale(value.get(0));
            proposal.setMaxScale(value.get(1));
            proposal.setDescription1(value.get(2));
            proposal.setDescription2(value.get(3));
            proposal.setDescription3(value.get(4));
            proposal.setDescription4(value.get(5));
            proposal.setDescription5(value.get(6));
            List<ReplayOption> list = new ArrayList<>();

            for (int i = 2; i < value.size(); i++) {
                if (value.get(i).isEmpty()) {
                    continue;
                }
                if (replayOptionRepository.findByName(value.get(i)) == null) {
                    ReplayOption replayOption = new ReplayOption(null, value.get(i));
                    try {
                        replayOptionRepository.save(replayOption);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                list.add(replayOptionRepository.findByName(value.get(i)));
            }
            proposal.setReplayOptions(list);
            proposalRepository.save(proposal);
        });
        return replayOptionRepository.findAll();

    }

    public List<Proposal> createProposals() {
        List<String> lines = MigrateRawData.getLinesFromCsv();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 2; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";");
            if (parts.length >= 30) {
                System.out.println("ooo".repeat(80));
                if (!parts[24].isEmpty() && !parts[25].isEmpty()) {
                    map.put(parts[24] + " " + parts[25], List.of(parts[24], parts[25], parts[26], parts[27], parts[28], parts[29], parts[30]));
                } else {
                    System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            } else {
                if (parts.length >= 27) {
                    System.out.println("+-+".repeat(80));
                    if (parts[24].isEmpty() && parts[25].isEmpty()
                            && !parts[26].isEmpty() && !parts[27].isEmpty()
                            && parts[26].equals("ja") && parts[27].equals("nein")
                    ) {
                        map.put(parts[26] + " " + parts[27], List.of(parts[26], parts[27], parts[26], parts[27], "", "", ""));
                    }
                }
            }
        }

        map.forEach((key, value) -> {
            Proposal proposal = new Proposal();
            proposal.setName(key);
            proposal.setMinScale(value.get(0));
            proposal.setMaxScale(value.get(1));
            proposal.setDescription1(value.get(2));
            proposal.setDescription2(value.get(3));
            proposal.setDescription3(value.get(4));
            proposal.setDescription4(value.get(5));
            proposal.setDescription5(value.get(6));
            List<ReplayOption> list = new ArrayList<>();

            for (int i = 2; i < value.size(); i++) {
                if (value.get(i).isEmpty()) {
                    continue;
                }
                if (replayOptionRepository.findByName(value.get(i)) == null) {
                    ReplayOption replayOption = new ReplayOption(null, value.get(i));
                    try {
                        replayOptionRepository.save(replayOption);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                list.add(replayOptionRepository.findByName(value.get(i)));
            }
            proposal.setReplayOptions(list);
            proposalRepository.save(proposal);
        });
        return proposalRepository.findAll();
    }

    public void createQuestions() {
        List<String> lines = MigrateRawData.getLinesFromCsv();
        Question question = null;
        Question remQuestion = null;

        String j_rem = null;
        for (int i = 2; i <= 143; i++) {
            String[] parts = lines.get(i).split(";");
            //Check for subquestion
            String j = parts[8];
            if (j_rem != null && j_rem.equals(j)) {
                System.out.println("Subquestion found at " + i + ". -> Question: " + parts[22]);
            } else {
                System.out.println("Question found at " + i + ". -> Question: " + parts[22]);
            }
            j_rem = j;

            if (parts.length >= 30) {
                System.out.println("---question---".repeat(10));

                if (!parts[8].isEmpty() && !parts[24].isEmpty()) {
                    if (question != null) {
                        questionRepository.save(question);
                    }
                    question = new Question(parts[22]);

                    Subquestion subquestion = new Subquestion();
                    subquestion.setQuestion(parts[22]);
                    subquestion.setProposal(proposalRepository.findByName(parts[24] + " " + parts[25]));
                    //question.setSubquestion(subquestion);

                    System.out.println(i + ". -> Question: " + parts[22]);
                }
                if (parts[8].isEmpty()) {

                    if (question != null) {

                    }

                    System.out.println("  " + i + ". -> Subquestion: " + parts[22]);
                }

            }
        }
    }
}
