package com.chasel.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author XieLongzhen
 * @date 2018/7/11 9:40
 */
@Entity
public class Girl implements Serializable{

    private static final long serialVersionUID = 32516964651231L;

    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    @Min(value = 18,message = "未成年少女禁止入内！")
    private Integer age;

    @NotNull(message = "金额必传")
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
