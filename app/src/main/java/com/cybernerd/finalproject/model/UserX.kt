package com.cybernerd.finalproject.model

data class UserX(
    val bio: String,
    val birth_date: Any,
    val course: CourseXX,
    val created_at: String,
    val department: DepartmentX,
    val email: String,
    val first_name: String,
    val gender: Int,
    val id: Int,
    val is_active: Boolean,
    val last_login: String,
    val last_name: String,
    val mobile: String,
    val permissions: List<List<PermissionXX>>,
    val prn_no: Any,
    val role: RoleX,
    val semester: SemesterXX,
    val skills: List<SkillX>,
    val slug: String,
    val username: String
)

