package com.cartola.group.DTO.Request;

import com.cartola.group.DTO.Enum.TypeChampionship;
import jdk.jfr.Description;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewChampionshipRequestDTO {

    @NotNull(message = "O nome não pode ser NULL.")
    @NotEmpty(message = "O nome não pode estar em branco.")
    @Description("Nome do campeonato")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Description("Tipo do campeonato")
    private TypeChampionship type;

    @Description("Imagem do campeonato")
    private String image;

    @Description("Descrição do campeonato")
    private String description;

    @Description("ID da liga que o campeonato esta atrelado")
    private long id_league;

    @Description("Nome da liga que o campeonato esta atrelado")
    private String name_league;

    @NotNull(message = "Condição de participação do campeonato não pode ser NULL")
    @Description("Se o criador do campeonato vai participar ou não")
    private boolean must_add_creator_to_players;

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

    public boolean isMust_add_creator_to_players() {
        return must_add_creator_to_players;
    }

    public void setMust_add_creator_to_players(boolean must_add_creator_to_players) {
        this.must_add_creator_to_players = must_add_creator_to_players;
    }
}
