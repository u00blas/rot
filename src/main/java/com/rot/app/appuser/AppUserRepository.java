package com.rot.app.appuser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    public AppUser findByEmail(String email);
}
