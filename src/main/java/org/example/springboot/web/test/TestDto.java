package org.example.springboot.web.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.test.MyTestTable;

import javax.persistence.Id;

@Getter
public class TestDto {


    @Id
    private String reqNo;

    private String reqDealerId;
    private String dealerUserId;
    private String bizArea;

    public TestDto(MyTestTable testTable) {
        this.reqNo = testTable.getReqNo();
        this.reqDealerId = testTable.getReqDealerId();
        this.dealerUserId = testTable.getDealerUserId();
        this.bizArea = testTable.getBizArea();

    }


}
