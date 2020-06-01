package io.hexlet.hexletcorrection.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static javax.persistence.FetchType.LAZY;

/**
 * A Comment.
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@Entity
public class Comment extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq", allocationSize = 5)
    @ToString.Include
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String message;

    @ManyToOne(fetch = LAZY)
    @JsonIgnoreProperties({"comments", "typos"})
    private Account account;

    @ManyToOne(fetch = LAZY)
    @JsonIgnoreProperties({"comments", "account"})
    private Typo typo;

    @Override
    public boolean equals(Object obj) {
        return this == obj || id != null && obj instanceof Comment other && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
