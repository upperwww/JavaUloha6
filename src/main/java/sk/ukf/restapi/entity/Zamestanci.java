package sk.ukf.restapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class zamestanci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Meno je povinné")
    @Size(min = 2, max = 50, message = "Meno musí mať 2-50 znakov")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Priezvisko je povinné")
    @Size(min = 2, max = 50, message = "Priezvisko musí mať 2-50 znakov")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Dátum narodenia je povinný")
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Neplatný formát e-mailovej adresy."
    )
    @Column(name = "email", unique = true)
    private String email;

    @Pattern(
            regexp = "^\\+421\\d{9}$",
            message = "Telefónne číslo musí začínať +421 a obsahovať presne 9 číslic za ním."
    )
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Pracovná pozícia je povinná")
    @Column(name = "job_title")
    private String job_title;

    @Positive(message = "Plat musí byť kladné číslo")
    @Column(name = "salary")
    private Float salary;

    @Column(name = "full_time")
    private byte full_time;

    public zamestanci() {
    }

    public zamestanci(String firstName, String lastName, LocalDate birthDate, String email, String phone, String job_title, Float salary, byte full_time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.job_title = job_title;
        this.salary = salary;
        this.full_time = full_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public byte getFull_time() {
        return full_time;
    }

    public void setFull_time(byte full_time) {
        this.full_time = full_time;
    }
}
