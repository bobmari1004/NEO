package com.neo.back.service.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Game {
    public Game(String gameName, String version, int defaultPort, String dockerImage, GameServerSetting serverSetting) {
        this.gameName = gameName;
        this.version = version;
        this.defaultPort = defaultPort;
        this.dockerImage = dockerImage;
        this.defaultSetting = serverSetting;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;
    private String version;

    private int defaultPort;

    private String dockerImage;

    @ManyToOne
    @JoinColumn
    private GameServerSetting defaultSetting;

    @OneToMany(mappedBy = "game")
    private List<GameDockerAPICMD> gameDockerAPICMDs = new ArrayList<>();

}
