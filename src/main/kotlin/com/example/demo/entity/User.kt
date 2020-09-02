package com.example.demo.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

@TableName("user")
class User{
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    var id: Long = -1
    var name: String = ""
    var age: Int = 0
    var email: String = ""

    override fun toString(): String {
        return "User(id=$id, name='$name', age=$age, email='$email')"
    }
}