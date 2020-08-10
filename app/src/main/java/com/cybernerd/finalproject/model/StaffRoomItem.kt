package com.cybernerd.finalproject.model

data class StaffRoomItem(
    val bio: String,
    val birth_date: String,
    val course: CourseXXX,
    val created_at: String,
    val department: DepartmentXX,
    val email: String,
    val first_name: String,
    val gender: Int,
    val id: Int,
    val is_active: Boolean,
    val last_login: String,
    val last_name: String,
    val mobile: String,
    val permissions: List<List<PermissionXXX>>,
    val prn_no: String,
    val role: RoleXX,
    val semester: SemesterXXX,
    val skills: List<Any>,
    val slug: String,
    val username: String
)