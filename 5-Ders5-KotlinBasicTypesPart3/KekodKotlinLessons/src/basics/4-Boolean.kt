package basics

fun main() {
    //8 bit alan kaplar.
    //true ya da false değer ataması için kullanılır. Nullable versiyonları null değer de alır.
    //0 ya da 1 Boolean olarak kullanılamaz.

    val isStudent: Boolean = true
    val isTeacher: Boolean = false
    val isFirstStudentMale: Boolean? = null

//    val isStudent2: Boolean = 1
//    val isTeacher2: Boolean = 0
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // ||(or) &&(and) !(not) gibi oparetörler ile beraber kullanılır.

    if (isStudent && isTeacher){

    }

    if (isStudent and isTeacher){

    }

    if (isStudent || isTeacher){

    }

    if (isStudent or isTeacher){

    }
    if (isStudent.or(isTeacher)){

    }
    if (isStudent.not()){

    }
    if (!isStudent){

    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Boolean değerin true olmasını kontrol ettirmek için == true şeklinde kontrole gerek yoktur. Zaten true ise süslü parantezler içerisine girecektir. Nullable ise bunu yapmak zorunlu.

    if(isStudent == true){

    }

    if (isStudent){

    }

//    if (isFirstStudentMale) {
//
//    }

    if (isFirstStudentMale == true){

    }

    // || ve && operatörleri lazily çalışma mekanizmasına sahiptir.
    // Eğer || operatörünün solu true ise sağdaki değere bakmaya gerek duymaz ve true kabul eder.
    // Eğer && operatörünün solu false ise sağdaki değer bakmaya gerek duymaz false kabul eder.


    // true  && true = true      -> İki değer de kontrol edilir.
    // true  && false = false    -> İki değer de kontrol edilir
    // false && true = false    -> soldaki değerin kontrol edilmesi yeterlidir.
    // false && false = false   -> soldaki değerin kontrol edilmesi yeterlidir.

    // true  || true = true     -> soldaki değerin kontrol edilmesi yeterlidir.
    // true  || false = true   -> soldaki değerin kontrol edilmesi yeterlidir.
    // false || true = true    -> İki değer de kontrol edilir
    // false || false = false   -> İki değer de kontrol edilir
}