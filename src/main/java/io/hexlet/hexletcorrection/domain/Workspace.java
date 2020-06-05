package io.hexlet.hexletcorrection.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Accessors(chain = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Workspace {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Size(min = 2, max = 50)
    @Column(unique = true)
    @ToString.Include
    private String name;

    @Size(max = 1000)
    private String description;

    private String token;

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Typo> typos = new HashSet<>();

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();

    public Workspace addTypo(final Typo typo) {
        typos.add(typo);
        typo.setWorkspace(this);
        return this;
    }

    public Workspace removeTypo(final Typo typo) {
        typos.remove(typo);
        typo.setWorkspace(null);
        return this;
    }

    public Workspace addAccount(final Account account) {
        accounts.add(account);
        account.setWorkspace(this);
        return this;
    }

    public Workspace removeAccount(final Account account) {
        accounts.remove(account);
        account.setWorkspace(null);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || id != null && obj instanceof Workspace other && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
