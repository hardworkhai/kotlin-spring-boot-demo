package com.example.demo.mapper

import com.example.demo.entity.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserMapperTests @Autowired constructor(val userMapper: UserMapper) {

    @Test
    fun testSelect() {
        println("----- selectAll method test ------")
        val userList: List<User> = userMapper.selectList(null)
        userList.forEach(System.out::println)
    }

}
