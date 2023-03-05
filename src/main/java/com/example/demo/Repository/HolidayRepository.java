package com.example.demo.Repository;

import com.example.demo.Entity.Vevent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<Vevent,String> {
    @Query(value = "SELECT * FROM Vevent v WHERE v.start_date BETWEEN :dtstart AND :dtend", nativeQuery = true)
    List<Vevent> findByStartDateAfter(@Param("dtstart") LocalDate dtstart, @Param("dtend") LocalDate dtend);

    @Query(value = "SELECT * FROM Vevent v WHERE v.end_date BETWEEN :dtstart AND :dtend", nativeQuery = true)
    List<Vevent> findByStartDateBefore(@Param("dtstart") LocalDate dtstart, @Param("dtend") LocalDate dtend);
}
