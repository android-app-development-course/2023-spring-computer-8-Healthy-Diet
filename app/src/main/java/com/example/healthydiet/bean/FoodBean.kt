package com.example.healthydiet.bean

import java.io.Serializable

class FoodBean : Serializable {
    var title: String? = null
    var notmatch: String? = null
    var desc: String? = null
    var picId = 0

    constructor(title: String?, notmatch: String?, desc: String?, picId: Int) {
        this.title = title
        this.notmatch = notmatch
        this.desc = desc
        this.picId = picId
    }

    constructor() {}
}