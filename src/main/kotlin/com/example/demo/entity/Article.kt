package com.example.demo.entity

import com.baomidou.mybatisplus.annotation.Version
import java.util.*

class Article {
    var id: Long = -1
    @Version
    var version: Long = 0
    var title: String = ""
    var content: String = ""
    var author: String = ""
    var gmtCreated: Date = Date()
    var gmtModified: Date = Date()
    var isDeleted: Int = 0 //1 Yes 0 No
    var deletedDate: Date = Date()

    constructor(id: Long, version: Long, title: String, content: String, author: String, gmtCreated: Date, gmtModified: Date, isDeleted: Int, deletedDate: Date) {
        this.id = id
        this.version = version
        this.title = title
        this.content = content
        this.author = author
        this.gmtCreated = gmtCreated
        this.gmtModified = gmtModified
        this.isDeleted = isDeleted
        this.deletedDate = deletedDate
    }

    override fun toString(): String {
        return "Article(id=$id, version=$version, title='$title', content='$content', author='$author', gmtCreated=$gmtCreated, gmtModified=$gmtModified, isDeleted=$isDeleted, deletedDate=$deletedDate)"
    }



}