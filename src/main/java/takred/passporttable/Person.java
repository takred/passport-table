package takred.passporttable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {
    private String name;
    private String surname;
    private String patronymic;
//    private boolean gender;
    private Gender gender;
    private Integer age;
    @Id
    private UUID id = UUID.randomUUID();
    private Long numberPass;
    private Integer dateIssue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public Long getNumberPass() {
        return numberPass;
    }

    public void setNumberPass(Long numberPass) {
        this.numberPass = numberPass;
    }

    public Integer getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Integer dateIssue) {
        this.dateIssue = dateIssue;
    }
}
