package com.personapi.personapi.adapters.driven.jpa.mysql.repository;

import com.personapi.personapi.adapters.driven.jpa.mysql.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {
}
