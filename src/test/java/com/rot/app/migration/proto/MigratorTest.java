package com.rot.app.migration.proto;

import org.junit.jupiter.api.Test;

import java.util.List;

class MigratorTest {

    @Test
    void create_proto_proposals() {
        List<String> lines = Migrator.getRawLines();
        List<ProtoProposal> proposals = Migrator.createProtoProposals(lines);
        System.out.println(proposals);
    }

    @Test
    void create_proto_subquestions() {
        List<String> lines = Migrator.getRawLines();
        List<ProtoSubquestion> subquestions = Migrator.createProtoSubquestions(lines);
        System.out.println(subquestions);
    }

}