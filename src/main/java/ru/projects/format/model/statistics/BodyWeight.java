package ru.projects.format.model.statistics;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;
import ru.projects.format.model.user.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

import static ru.projects.format.util.DateTimeUtil.DATE_LONG_SPACED;
import static ru.projects.format.util.DateTimeUtil.DATE_SHORT_DASH_PATTERN;

@ToString
@Getter
@Setter
@Entity
@Table(name = "body_weights")
public class BodyWeight implements ModelAttribute {
    @EmbeddedId
    private BodyWeightKey key;

    private float weight;

    @NonNull
    public String getDatePretty() {
        return key.date != null ? key.date.format(DATE_LONG_SPACED) : StringUtils.EMPTY;
    }

    @Override
    public @NonNull String getAttributeName() {
        return AttributeName.BODY_WEIGHT;
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    @Embeddable
    public static class BodyWeightKey implements Serializable {
        static final long serialVersionUID = 1L;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
        private User user;

        @DateTimeFormat(pattern = DATE_SHORT_DASH_PATTERN)
        @CreationTimestamp
        @Column(updatable = false, insertable = false)
        private LocalDate date;
    }
}