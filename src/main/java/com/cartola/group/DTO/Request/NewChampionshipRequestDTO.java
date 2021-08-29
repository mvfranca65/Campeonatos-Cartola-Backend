package com.cartola.group.DTO.Request;

import com.cartola.group.DTO.Enum.AccessPermission;
import com.cartola.group.DTO.Enum.TypeChampionship;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewChampionshipRequestDTO {

    @NotNull(message = "O nome não pode ser NULL.")
    @NotEmpty(message = "O nome não pode estar em branco.")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private TypeChampionship type;

    @Enumerated(value = EnumType.STRING)
    private AccessPermission access_permission;

    private byte[] image;

    private String description;

    private long id_league;

    private String name_league;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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
}
