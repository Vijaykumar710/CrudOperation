package com.curdoperation.repository;

import com.curdoperation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //predefined class import here...

/*
    @Query("select mail_id from customer_profile where tenant_uid = ?1 AND uuid=?2 limit 1", nativeQuery = true)
public
    public  getEmailByUid(tenantUid: String, uuid: String): String?*/
}