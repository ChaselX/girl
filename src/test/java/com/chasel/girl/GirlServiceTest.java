package com.chasel.girl;

import com.chasel.girl.domain.Girl;
import com.chasel.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XieLongzhen
 * @date 2018/7/30 14:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(9);
        Assert.assertEquals(new Integer(13), girl.getAge());
    }
}
