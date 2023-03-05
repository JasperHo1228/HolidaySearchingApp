package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@Entity
@Table(name="Vevent")
public class Vevent {

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uid;

    @Column(name = "start_date")
    private LocalDate dtstart;

    @Column(name = "end_date")
    private LocalDate dtend;

    private String transp;

    private String summary;



    public Vevent(){}

    public LocalDate getDtstart() {
        return dtstart;
    }

    public void setDtstart(Object[] dtstart) {
        this.dtstart = LocalDate.parse(dtstart[0].toString(), DateTimeFormatter.BASIC_ISO_DATE);
    }

    public LocalDate getDtend() {
        return dtend;
    }

    public void setDtend(Object[] dtend) {
        this.dtend = LocalDate.parse(dtend[0].toString(), DateTimeFormatter.BASIC_ISO_DATE);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTransp() {
        return transp;
    }

    public void setTransp(String transp) {
        this.transp = transp;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

