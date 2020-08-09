package com.cybernerd.finalproject.model

data class Detail(
    val course: CourseX,
    val description: String,
    val id: Int,
    val is_active: Boolean,
    val name: String,
    val semester: SemesterX,
    val slug: String,
    val teacher: Teacher
)