package com.fuentezuelas.AulaEmprendimiento.mail.infrastructure.repository;

import com.fuentezuelas.AulaEmprendimiento.mail.domain.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.UUID;

@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {

}
