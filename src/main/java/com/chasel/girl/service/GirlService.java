package com.chasel.girl.service;

import com.chasel.girl.domain.Girl;
import com.chasel.girl.enums.ResultEnum;
import com.chasel.girl.exception.StatusCodeRuntimeException;
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
                throw new StatusCodeRuntimeException(ResultEnum.PRIMARY_SCHOOL);
            } else if (age > 10 && age < 16) {
                throw new StatusCodeRuntimeException(ResultEnum.JUNIOR_HIGH_SCHOOL);
            }
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findById(id).get();
    }
}
