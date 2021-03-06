package com.cartola.group.Entity;

import com.cartola.group.DTO.Enum.AccessPermission;
import com.cartola.group.DTO.Enum.StatusChampionship;
import com.cartola.group.DTO.Enum.TypeChampionship;
import jdk.jfr.Description;

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
    @Description("Nome do campeonato")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Description("Tipo do campeonato")
    private TypeChampionship type;

//    @Enumerated(value = EnumType.STRING)
//    private AccessPermission access_permission;

    @NotNull(message = "O admin não pode ser NULL.")
    @NotEmpty(message = "O admin não pode estar em branco.")
    @Description("Usuario do admin/criador do campeonato")
    private String admin_user;

    @NotNull(message = "O admin ID não pode ser NULL.")
    @NotEmpty(message = "O admin ID não pode estar em branco.")
    @Description("ID do admin/criador do campeonato")
    private String admin_id;

    @Description("Campeonato já iniciado ou não")
    private Boolean started;

    @Description("Imagem do campeonato")
    private String image;

    @Description("Descrição do campeonato")
    private String description;

    @Description("ID da liga que o campeonato esta atrelado")
    private long id_league;

    @Description("Nome da liga que o campeonato esta atrelado")
    private String name_league;

    @Enumerated(value = EnumType.STRING)
    @Description("Status do campeonato - Ativo/Inativo")
    private StatusChampionship status_championship;

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

    public StatusChampionship getStatus_championship() {
        return status_championship;
    }

    public void setStatus_championship(StatusChampionship status_championship) {
        this.status_championship = status_championship;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public ChampionshipEntity(long id, String name, TypeChampionship type, String admin_user, String admin_id, Boolean started, String image, String description, long id_league, String name_league, StatusChampionship status_championship) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.admin_user = admin_user;
        this.admin_id = admin_id;
        this.started = started;
        this.image = image;
        this.description = description;
        this.id_league = id_league;
        this.name_league = name_league;
        this.status_championship = status_championship;
    }

    public ChampionshipEntity() {}

    //    public ChampionshipEntity(String name, TypeChampionship type, AccessPermission access_permission, String admin_user, String admin_id, Boolean started, byte[] image, String description, long id_league, String name_league, StatusChampionship status_championship) {
//        this.name = name;
//        this.type = type;
//        this.access_permission = access_permission;
//        this.admin_user = admin_user;
//        this.admin_id = admin_id;
//        this.started = started;
//        this.image = image;
//        this.description = description;
//        this.id_league = id_league;
//        this.name_league = name_league;
//        this.status_championship = status_championship;
//    }
}
