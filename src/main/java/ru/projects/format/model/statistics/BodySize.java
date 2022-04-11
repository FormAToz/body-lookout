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
@Table(name = "body_sizes")
public class BodySize implements ModelAttribute {
    @EmbeddedId
    private BodySizeKey key;

    private int size;

    public String getCreatedPretty() {
        return key.created != null ? key.created.format(DATE_LONG_SPACED) : StringUtils.EMPTY;
    }

    @Override
    public @NonNull String getAttributeName() {
        return AttributeName.BODY_SIZE;
    }

    @ToString
    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class BodySizeKey implements Serializable {
        private static final long serialVersionUID = 1L;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "body_part_id")
        private BodyPart bodyPart;

        @DateTimeFormat(pattern = DATE_SHORT_DASH_PATTERN)
        @CreationTimestamp
        private LocalDate created;
    }
}