package com.example.demo.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.demo.entity.User
import com.example.demo.mapper.UserMapper
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController @Autowired constructor(val userService: UserService) {

    @GetMapping("/list")
    fun queryAllUser(): List<User>? = userService.list(null)

    @PostMapping("/query")
    fun listPage(page: Page<User>, request: UserQuery): Page<User>? {
        val query: QueryWrapper<User> = QueryWrapper<User>();
        if (request.name !== "") {
            query.like("name", request.name)
        }
        if (request.age > 0) {
            query.eq("age", request.age)
        }
        return userService.page(page, query)
    }
}

class UserQuery {
    var age: Int = 0
    var name: String = ""
}
