package io.hexlet.hexletcorrection.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.hexlet.hexletcorrection.domain.enumerator.TypoStatus;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@Entity
public class Typo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typo_seq")
    @SequenceGenerator(name = "typo_seq", sequenceName = "typo_seq", allocationSize = 3)
    @ToString.Include
    private Long id;

    @NotBlank
    private String pageUrl;

    @NotBlank
    @Size(max = 50)
    private String reporterName;

    @Size(max = 1000)
    private String reporterRemark;

    @Size(max = 100)
    private String textBeforeTypo;

    @NotNull
    @Size(max = 1000)
    private String textTypo;

    @Size(max = 100)
    private String textAfterTypo;

    @Enumerated(EnumType.STRING)
    @ToString.Include
    private TypoStatus typoStatus = TypoStatus.REPORTED;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("typos")
    private Account account;

    @OneToMany(mappedBy = "typo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("typo")
    private Set<Comment> comments = new HashSet<>();

    public Typo addComment(final Comment comment) {
        comments.add(comment);
        comment.setTypo(this);
        return this;
    }

    public Typo removeComment(final Comment comment) {
        comments.remove(comment);
        comment.setTypo(null);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || id != null && obj instanceof Typo other && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
