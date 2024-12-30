package basics

fun main() {
    val bitValue =  0b00100101
    val bitValue2 = 0b10110011

    val resultAndBit = bitValue.and(bitValue2) //bitValue && bitValue2
    println("AND ~ Binary: ${resultAndBit.toString(2)}, decimal: $resultAndBit") //0b00100001

    val resultOrBit = bitValue.or(bitValue2) //bitValue && bitValue2
    println("OR ~ Binary: ${resultOrBit.toString(2)}, decimal: $resultOrBit") //10110111
}