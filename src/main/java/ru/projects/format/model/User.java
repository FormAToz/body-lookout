package ru.projects.format.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import ru.projects.format.model.enums.Gender;
import ru.projects.format.model.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static ru.projects.format.util.DateTimeUtil.DATE_LONG_SPACED;
import static ru.projects.format.util.DateTimeUtil.DATE_LONG_TIME_SHORT;
import static ru.projects.format.util.DateTimeUtil.DATE_SHORT_DASH_PATTERN;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @DateTimeFormat(pattern = DATE_SHORT_DASH_PATTERN)
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @Column(name = "reg_date")
    @CreationTimestamp
    private LocalDateTime regDate;

    @NonNull
    public String getBirthdayPretty() {
        return birthday != null ? birthday.format(DATE_LONG_SPACED) : StringUtils.EMPTY;
    }

    @NonNull
    public String getRegDatePretty() {
        return regDate != null ? regDate.format(DATE_LONG_TIME_SHORT) : StringUtils.EMPTY;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}