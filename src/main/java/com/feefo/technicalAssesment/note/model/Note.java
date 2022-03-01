package com.feefo.technicalAssesment.note.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Note {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private @Id @GeneratedValue Long id;
    private String title;
    private String body;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Calendar createdAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Calendar updatedAt;
  
    Note() {
      this.createdAt = Calendar.getInstance();
      this.updatedAt = Calendar.getInstance();
    }
  
    Note(String title, String body) {
      this.title = title;
      this.body = body;
      this.createdAt = Calendar.getInstance();
      this.updatedAt = Calendar.getInstance();
    }

    public Long getId() {
      return id;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getBody() {
      return body;
    }

    public void setBody(String body) {
      this.body = body;
    }

    public Calendar getCreatedAt() {
      return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
      this.createdAt = createdAt;
    }

    public Calendar getUpdatedAt() {
      return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
      this.updatedAt = updatedAt;
    }    
    
}