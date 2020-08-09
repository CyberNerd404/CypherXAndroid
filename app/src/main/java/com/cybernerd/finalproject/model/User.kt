package com.cybernerd.finalproject.model

data class User(
    val bio: String,
    val birth_date: Any,
    val course: Course,
    val created_at: String,
    val department: Department,
    val email: String,
    val first_name: String,
    val gender: Int,
    val id: Int,
    val is_active: Boolean,
    val last_login: String,
    val last_name: String,
    val mobile: String,
    val permissions: List<List<PermissionX>>,
    val prn_no: Any,
    val role: Role,
    val semester: Semester,
    val skills: List<Skill>,
    val slug: String,
    val username: String
)