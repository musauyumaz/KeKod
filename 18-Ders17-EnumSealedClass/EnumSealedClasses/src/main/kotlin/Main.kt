package org.example

fun main() {
    val fenerbahce = "FENERBAHÇE"
    val galatasaray = "GALATASARAY"
    val besiktas = "BEŞİKTAŞ"
    val trabzonspor = "TRABZONSPOR"
    val sivasspor = "SİVASSPOR"
    val tokatspor = "TOKATSPOR"
    val yozgatspor = "YOZGATSPOR"

//    val userType = student, teacher, manager, parent
    val isStudent = false
    val isTeacher = false
    val isManager = false
    val isParent = false

    val studentType = 0
    val teacherType = 1
    val managerType = 2
    val parentType = 3

    val userType = teacherType

    when(userType){
        0 -> println("student")
        1 -> println("teacher")
        2 -> println("manager")
        3 -> println("parent")
    }
}