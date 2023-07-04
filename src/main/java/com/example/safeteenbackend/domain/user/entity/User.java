package com.example.safeteenbackend.domain.user.entity;

import com.example.safeteenbackend.domain.board.entity.Board;
import com.example.safeteenbackend.domain.shop.entity.Shop;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column(length = 999999999)
    private String profile_img;

    @Column
    private int reward;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Board> boardList;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Shop> shopList;

    public void editName(String nickname) {
        this.nickname = nickname;
    }
    public void editReward(int reward){
        this.reward = reward;
    }
}
