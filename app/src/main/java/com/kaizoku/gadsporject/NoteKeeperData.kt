package com.kaizoku.gadsporject

data class Courseinfo (val courseId: String,
val title: String)  {
    override fun toString(): String {
        return title
    }
}

class NoteInfo (var course: Courseinfo? = null,
                var title:String? = null, var text:String? = null)