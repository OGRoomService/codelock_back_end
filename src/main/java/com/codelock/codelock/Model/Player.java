package com.codelock.codelock.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "player")
public class Player implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    private String username;

    @ManyToOne
    @NotNull
    @NonNull
    @JoinColumn(name = "server_id")
    private Server server;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "authd_locks",
        joinColumns = {@JoinColumn(name = "player_id")},
        inverseJoinColumns = {@JoinColumn(name = "codelock_id")}
    )
    Set<CodeLock> setAuthdLocks = new HashSet<>();
}
