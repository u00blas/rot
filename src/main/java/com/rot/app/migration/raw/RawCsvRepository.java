package com.rot.app.migration.raw;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RawCsvRepository extends JpaRepository<RawCsv, Long> {
}
