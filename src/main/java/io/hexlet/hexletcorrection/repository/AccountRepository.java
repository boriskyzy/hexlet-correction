package io.hexlet.hexletcorrection.repository;

import io.hexlet.hexletcorrection.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
