package com.marko.LoginAndRegistration.Repository;

import com.marko.LoginAndRegistration.AppUser.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional()
@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findByEmail(String email);
}

