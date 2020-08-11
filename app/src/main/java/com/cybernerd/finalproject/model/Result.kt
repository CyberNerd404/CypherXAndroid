package com.cybernerd.finalproject.model

data class Result(
    val bio: Any,
    val birth_date: Any,
    val course: CourseXXXXX,
    val created_at: String,
    val department: DepartmentXXXX?,
    val email: String,
    val first_name: String,
    val gender: Any,
    val id: Int,
    val is_active: Boolean,
    val last_login: Any,
    val last_name: String,
    val mobile: Any,
    val permissions: Any,
    val prn_no: String,
    val role: RoleXXX?,
    val semester: SemesterXXXX,
    val skills: List<SkillXX>,
    val slug: String,
    val username: String
)