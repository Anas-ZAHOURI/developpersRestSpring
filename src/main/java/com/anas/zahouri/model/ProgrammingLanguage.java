package com.anas.zahouri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by azahouri on 13/03/2017.
 */
@Entity
@Table(name = "PROGRAMMING_LANGUAGE")
public class ProgrammingLanguage {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "LANGUAGE_NAME", nullable = false)
    private String languageName;

    @ManyToMany (targetEntity=Developper.class, mappedBy = "programmingLanguages")
    private List<Developper> developpers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<Developper> getDeveloppers() {
        return developpers;
    }

    public void setDeveloppers(List<Developper> developpers) {
        this.developpers = developpers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgrammingLanguage that = (ProgrammingLanguage) o;

        if (id != that.id) return false;
        if (languageName != null ? !languageName.equals(that.languageName) : that.languageName != null) return false;
        return developpers != null ? developpers.equals(that.developpers) : that.developpers == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (languageName != null ? languageName.hashCode() : 0);
        result = 31 * result + (developpers != null ? developpers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProgrammingLanguage{" +
                "id=" + id +
                ", languageName='" + languageName + '\'' +
                ", developpers=" + developpers +
                '}';
    }
}