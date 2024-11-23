package com.rot.app.migration.proto;

import com.rot.app.migration.MigrateRawData;
import org.junit.jupiter.api.Test;

import java.util.List;

class MigratorTest {

    @Test
    void create_proto_proposals() {
        List<String> lines = MigrateRawData.getLinesFromCsv();
        List<ProtoProposal> proposals = Migrator.createProtoProposals(lines);
        System.out.println(proposals);
    }

    @Test
    void create_proto_subquestions() {
        List<String> lines = MigrateRawData.getLinesFromCsv();
        List<ProtoSubquestion> subquestions = Migrator.createProtoSubquestions(lines);
        System.out.println(subquestions);
    }

}