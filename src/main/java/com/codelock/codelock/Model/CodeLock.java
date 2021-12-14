package com.codelock.codelock.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "codelock")
public class CodeLock implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    private String passcode;
    
    @ManyToOne
    @NotNull
    @NonNull
    @JoinColumn(name = "server_id")
    private Server server;

    @ManyToMany(mappedBy = "setAuthdLocks", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Player> setAuthd;
}
