package com.chasel.girl.service;

import com.chasel.girl.domain.Girl;
import com.chasel.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author XieLongzhen
 * @date 2018/7/11 16:30
 */
@Service
public class GirlService {
    @Autowired
    GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girl1 = new Girl();
        girl1.setCupSize("A");
        girl1.setAge(17);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setCupSize("D");
        girl2.setAge(19);
        girlRepository.save(girl2);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).get();
        if (girl != null) {
            Integer age = girl.getAge();
            if (age < 10) {
                throw new RuntimeException("你可能还在上小学");
            } else if (age > 10 && age < 16) {
                throw new RuntimeException("你可能还在上初中");
            }

//            如果>16岁，加钱
        }
    }
}
