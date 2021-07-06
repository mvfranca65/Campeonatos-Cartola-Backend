package com.cartola.group.Entity;

import com.cartola.group.DTO.Enum.AccessPermission;
import com.cartola.group.DTO.Enum.TypeChampionship;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "championship")
public class ChampionshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "O nome não pode ser NULL.")
    @NotEmpty(message = "O nome não pode estar em branco.")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private TypeChampionship type;

    @Enumerated(value = EnumType.STRING)
    private AccessPermission access_permission;

    @NotNull(message = "O admin não pode ser NULL.")
    @NotEmpty(message = "O admin não pode estar em branco.")
    private String admin_user;

    private Boolean started;

    private String image;
    private String description;

    private long id_league;
    private String name_league;

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

    public TypeChampionship getType() {
        return type;
    }

    public void setType(TypeChampionship type) {
        this.type = type;
    }

    public AccessPermission getAccess_permission() {
        return access_permission;
    }

    public void setAccess_permission(AccessPermission access_permission) {
        this.access_permission = access_permission;
    }

    public String getAdmin_user() {
        return admin_user;
    }

    public void setAdmin_user(String admin_user) {
        this.admin_user = admin_user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId_league() {
        return id_league;
    }

    public void setId_league(long id_league) {
        this.id_league = id_league;
    }

    public String getName_league() {
        return name_league;
    }

    public void setName_league(String name_league) {
        this.name_league = name_league;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }
}
