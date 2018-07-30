package com.chasel.girl.controller;

import com.chasel.girl.domain.Girl;
import com.chasel.girl.domain.Result;
import com.chasel.girl.repository.GirlRepository;
import com.chasel.girl.service.GirlService;
import com.chasel.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author XieLongzhen
 * @date 2018/7/11 9:45
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            return null;
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
//        Java8 新特性，防止空指针异常
        return girlRepository.findById(id).get();
    }

    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
