package com.cybernerd.finalproject.model

data class MemberItem(
    val bio: String,
    val birth_date: String,
    val course: CourseXXXX,
    val created_at: String,
    val department: DepartmentXXX,
    val email: String,
    val first_name: String,
    val gender: Int,
    val id: Int,
    val is_active: Boolean,
    val last_login: String,
    val last_name: String,
    val mobile: String,
    val permissions: List<List<PermissionXXXX>>,
    val prn_no: String,
    val skills: List<Any>,
    val slug: String,
    val username: String
)