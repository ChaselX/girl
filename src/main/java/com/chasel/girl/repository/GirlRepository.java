package com.chasel.girl.repository;

import com.chasel.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author XieLongzhen
 * @date 2018/7/11 9:47
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    public List<Girl> findByAge(Integer age);
}
