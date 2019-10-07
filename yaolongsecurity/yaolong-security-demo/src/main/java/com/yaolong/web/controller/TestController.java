package com.yaolong.web.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.yaolong.dto.User;
import com.yaolong.exception.UserNotExistException;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoLong
 * @date 2019/9/14  13:29
 */
@RestController
@RequestMapping("/user")
public class TestController {

    @RequestMapping("/getIndex")
    public String getIndex() {
        return "asdasd";
    }

    @GetMapping
    public List<User> queryUser(Pageable pageable) {

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        System.out.println(pageable.getPageNumber());
        List<User> users = new ArrayList<>();

        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User userGetInfo(@PathVariable String id) {

//        throw new UserNotExistException(id);
        System.out.println("进入user_get_info 服务");
        User user = new User();
        user.setUsername("yao_long");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user/*, BindingResult errors*/) {

       /* if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach( error  -> System.out.println(error.getDefaultMessage()));
        }*/
//        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User userUpdate(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.toString());
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void userDelete(@PathVariable String id) {
        System.out.println(id);
    }


}
