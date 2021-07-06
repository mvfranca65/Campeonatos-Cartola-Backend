package com.cartola.group.DTO.Response;

import com.cartola.group.DTO.Enum.TypeChampionship;

import javax.persistence.Id;

public class ChampionshipLinkedLeagueDTO {

    private long id;
    private String name;
    private TypeChampionship type;
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ChampionshipLinkedLeagueDTO() {
    }

    public ChampionshipLinkedLeagueDTO(long id, String name, TypeChampionship type, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.image = image;
    }
}
