package org.example.springboot.domain.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class MyTestTable {

    @Id
    private String reqNo;

    private String reqDealerId;
    private String dealerUserId;
    private String bizArea;

    @Builder
    public MyTestTable(String reqNo, String reqDealerId, String dealerUserId, String bizArea) {
        this.reqNo = reqNo;
        this.reqDealerId = reqDealerId;
        this.dealerUserId = dealerUserId;
        this.bizArea = bizArea;
    }


}
