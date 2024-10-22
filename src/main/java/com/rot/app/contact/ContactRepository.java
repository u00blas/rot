package com.rot.app.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByEmail(String email);
}
