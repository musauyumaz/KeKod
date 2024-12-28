package basics.controlflow

fun main() {
    /*
    * switch case'lerin yerine gelmiştir.
    * when(karşılaştırılacak ifade)
    *       value -> {}
    *       value -> {}
    *       value -> {}
    * formatıyla kullanılır
    * Yine {} arasına tek satır kod yazılacaksa bu durumda {}'leri kullanmayabilirsiniz.
    * "tr", "az" gibi aynı kodu çalıştıracak case'ler varsa araya virgül koyarak kullanabiliriz.
    * Bu "veya" kullanımı yapmayı sağlar. "tr veya az" gibi
    * */

    val countryCode = readLine()!!
    when (countryCode.lowercase()) {
        "tr", "az" -> println("Türk Vatandaşı")
        "ar" -> println("Arap Vatandaşı")
        "fr" -> println("France Vatandaşı")
        "ru" -> println("Russian Vatandaşı")
        "uk" -> println("United Kingdom Vatandaşı")
    }

    when (countryCode.toInt()) {
        3.and(5) -> println("TC Vatandaşı")
        1 or 2 -> println("TC Vatandaşı")
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * when'in yanına karşılaştırma ifadesi eklemeden bunu case'lerin yanına da ekleyebilirsiniz
    * Bunun artısı && || and or xor gibi ifadeleri de kullanabilmemizi sağlar
    * */

    when {
        countryCode.lowercase() == "tr" && countryCode.lowercase() == "az" -> println("Türk Vatandaşı")
        countryCode.lowercase() == "ar" -> println("Arap Vatandaşı")
        countryCode.lowercase() == "fr" -> println("France Vatandaşı")
        countryCode.lowercase() == "ru" -> println("Russian Vatandaşı")
        countryCode.lowercase() == "uk" -> println("United Kingdom Vatandaşı")
    }

    //-------------------------------------------------------------------------------------------------------------------

    /*
    * Expression kulllanımı if else'lerde olduğu gibi whenlerde de yapabilirsiniz.
    * */

    var countryCode2: String = if (countryCode.lowercase() == "tr" || countryCode.lowercase() == "az") {
        println("Türk Vatandaşı")
        "90"
    } else if (countryCode.lowercase() == "ar") {
        println("Arap Vatandaşı")
        "80"
    } else if (countryCode.lowercase() == "fr") {
        println("France Vatandaşı")
        "70"
    } else if (countryCode.lowercase() == "ru") {
        println("Russian Vatandaşı")
        "60"
    } else if (countryCode.lowercase() == "uk") {
        println("United Kingdom Vatandaşı")
        "50"
    } else {
        "30"
    }

    countryCode2 = when (countryCode2.lowercase()) {
        "tr", "az" -> {
            println("Türk Vatandaşı")
            "90"
        }

        "ar" -> {
            println("Arap Vatandaşı")
            "80"
        }

        "fr" -> {
            println("France Vatandaşı")
            "70"
        }

        "ru" -> {
            println("Russian Vatandaşı")
            "60"
        }

        "uk" -> {
            println("United Kingdom Vatandaşı")
            "50"
        }

        else -> {
            "40"
        }
    }

    countryCode2 = when {
        countryCode2.lowercase() == "tr" || countryCode2.lowercase() == "az" -> {
            println("Türk Vatandaşı")
            "90"
        }

        countryCode2.lowercase() == "ar" -> {
            println("Arap Vatandaşı")
            "80"
        }

        countryCode2.lowercase() == "fr" -> {
            println("France Vatandaşı")
            "70"
        }

        countryCode2.lowercase() == "ru" -> {
            println("Russian Vatandaşı")
            "60"
        }

        countryCode2.lowercase() == "uk" -> {
            println("United Kingdom Vatandaşı")
            "50"
        }

        else -> {
            "40"
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Karşılaştırılacak şey "deger" yerine "degisken" de olabilir
    val trCode = "tr"
    val arCode = "ar"
    val frCode = "fr"
    val ruCode = "ru"
    val ukCode = "uk"
    when (countryCode.lowercase()) {
        trCode, "az" -> println("Türk Vatandaşı")
        arCode -> println("Arap Vatandaşı")
        frCode -> println("France Vatandaşı")
        ruCode -> println("Russian Vatandaşı")
        ukCode -> println("United Kingdom Vatandaşı")
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //is !is ile bir class'ın referansı olunup olunmadığı kontrolü yapılabilir.
    val phoneNumber: Long = 5316266922
    when (phoneNumber) {
        is Long -> {
            println("Long Value")
        }

        !is Long -> {
            println("Not Long Value")
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // range'leri in !in şeklinde kontrolü yapılabilir.
    val number = 3
    when (number) {
        in 0..10 -> {
            println("0 - 10 arasında")
        }

        in 11..20 -> {
            println("10 - 20 arasında")
        }

        !in 11..20 -> {
            println("10 - 20 arasında")
        }
    }

}