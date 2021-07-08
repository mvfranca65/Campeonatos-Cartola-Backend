package com.cartola.group.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Confrontos")
@Data
public class ClashesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int round;

    private String team_one;
    private String name_user_team_one;
    private String slug_team_one;
    private String image_user_team_one;
    private String round_score_team_one;

    private String team_two;
    private String name_user_team_two;
    private String slug_team_two;
    private String image_user_team_two;
    private String round_score_team_two;

    public ClashesEntity() {
    }



    public ClashesEntity(int round, String team_one, String name_user_team_one, String slug_team_one, String image_user_team_one, String round_score_team_one, String team_two, String name_user_team_two, String slug_team_two, String image_user_team_two, String round_score_team_two) {
        this.round = round;
        this.team_one = team_one;
        this.name_user_team_one = name_user_team_one;
        this.slug_team_one = slug_team_one;
        this.image_user_team_one = image_user_team_one;
        this.round_score_team_one = round_score_team_one;
        this.team_two = team_two;
        this.name_user_team_two = name_user_team_two;
        this.slug_team_two = slug_team_two;
        this.image_user_team_two = image_user_team_two;
        this.round_score_team_two = round_score_team_two;
    }
}

