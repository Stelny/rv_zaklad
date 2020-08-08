package com.example.vosmik.Models

class Notes {

    var id: Int = 0
    var heading: String = ""
    var content: String = ""

    constructor(heading:String, content: String) {
        this.heading = heading
        this.content = content
    }
}