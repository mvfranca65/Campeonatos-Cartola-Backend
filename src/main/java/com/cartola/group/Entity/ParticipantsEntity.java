package com.cartola.group.Entity;

import com.cartola.group.DTO.Enum.DisputePermission;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "participants")
public class ParticipantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "O nome não pode ser NULL.")
    @NotEmpty(message = "O nome não pode estar em branco.")
    private String name;

    @NotNull(message = "O usuário não pode ser NULL.")
    @NotEmpty(message = "O usuário não pode estar em branco.")
    private String user;

    private long id_championship;

    @NotNull(message = "O nome do campeonato não pode ser NULL.")
    @NotEmpty(message = "O nome do campeonato não pode estar em branco.")
    private String name_championship;

    @Enumerated(value = EnumType.STRING)
    private DisputePermission dispute_permission;

    private String id_user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getId_championship() {
        return id_championship;
    }

    public void setId_championship(long id_championship) {
        this.id_championship = id_championship;
    }

    public DisputePermission getDispute_permission() {
        return dispute_permission;
    }

    public void setDispute_permission(DisputePermission dispute_permission) {
        this.dispute_permission = dispute_permission;
    }

    public String getName_championship() {
        return name_championship;
    }

    public void setName_championship(String name_championship) {
        this.name_championship = name_championship;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public ParticipantsEntity(String name, String user, long id_championship, String name_championship, DisputePermission dispute_permission, String id_user) {
        this.name = name;
        this.user = user;
        this.id_championship = id_championship;
        this.name_championship = name_championship;
        this.dispute_permission = dispute_permission;
        this.id_user = id_user;
    }

    public ParticipantsEntity(long id, String name, String user, long id_championship, String name_championship, DisputePermission dispute_permission, String id_user) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.id_championship = id_championship;
        this.name_championship = name_championship;
        this.dispute_permission = dispute_permission;
        this.id_user = id_user;
    }

    public ParticipantsEntity(){}
}
