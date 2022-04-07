package ru.projects.format.model.note;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;
import ru.projects.format.model.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static ru.projects.format.util.DateTimeUtil.DATE_LONG_SPACED;

@Setter
@Getter
@Entity
@Table(name = "notes")
public class Note implements ModelAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private NoteCategory category;

    private String text;

    @CreationTimestamp
    private LocalDateTime created;

    @NonNull
    public String getCreatedPretty() {
        return created != null ? created.format(DATE_LONG_SPACED) : StringUtils.EMPTY;
    }

    @Override
    public @lombok.NonNull String getAttributeName() {
        return AttributeName.NOTE;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", user=" + user +
                ", category=" + category +
                ", text='" + text + '\'' +
                ", created=" + created +
                '}';
    }
}