package com.example.demo.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.entity.User
import com.example.demo.mapper.UserMapper
import com.example.demo.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService, ServiceImpl<UserMapper, User>() {
}