package org.example

interface Printer {
    fun printDocument()
    fun changeColor()
}

interface Scanner {
    fun scan()
}

class FancyScanner : Scanner {
    override fun scan() {}
}

class InkPrinter : Printer {
    override fun printDocument() {
        println("Ink")
    }

    override fun changeColor() {
        TODO("Not yet implemented")
    }
}

class LaserPrinter : Printer {
    override fun printDocument() {
        println("Laser")
    }

    override fun changeColor() {
        TODO("Not yet implemented")
    }
}

class MixedPrinter : Printer {
    override fun printDocument() {
        println("Mixed")
    }

    override fun changeColor() {
        TODO("Not yet implemented")
    }
}

class MixedUltraPrinter : Printer {
    override fun printDocument() {
        println("MixedUltra")
    }

    override fun changeColor() {
        TODO("Not yet implemented")
    }
}

class DocumentPrinterManual(private val printer: Printer, private val scanner: Scanner) {
    fun printDocument() {
        printer.printDocument()
    }

    fun changeColor() {
        printer.changeColor()
    }

    fun scan() {
        scanner.scan()
    }
}

class DocumentPrinterDelegation(printer: Printer, scanner: Scanner) : Printer by printer, Scanner by scanner

fun main() {
    val inkPrinter = InkPrinter()
    inkPrinter.printDocument()

    val scanner = FancyScanner()
    val documentInkPrinterManuel = DocumentPrinterManual(inkPrinter, scanner)
    documentInkPrinterManuel.printDocument()
    documentInkPrinterManuel.changeColor()

    val documentInkPrinterDelegation = DocumentPrinterDelegation(inkPrinter, scanner)
    documentInkPrinterDelegation.printDocument()

    val laserPrinter = LaserPrinter()
    val documentLaserPrinterManuel = DocumentPrinterManual(laserPrinter, scanner)
    documentLaserPrinterManuel.printDocument()

    val documentLaserPrinterDelegation = DocumentPrinterDelegation(laserPrinter, scanner)
    documentLaserPrinterDelegation.printDocument()

    val mixedPrinter = MixedPrinter()
    val documentMixedPrinterManuel = DocumentPrinterManual(mixedPrinter, scanner)
    documentMixedPrinterManuel.printDocument()

    val documentMixedPrinterDelegation = DocumentPrinterDelegation(mixedPrinter, scanner)
    documentMixedPrinterDelegation.printDocument()

    val mixedUltraUltraPrinter = MixedUltraPrinter()
    val documentMixedUltraPrinterManuel = DocumentPrinterManual(mixedUltraUltraPrinter, scanner)
    documentMixedUltraPrinterManuel.printDocument()

    val documentMixedUltraPrinterDelegation = DocumentPrinterDelegation(mixedUltraUltraPrinter, scanner)
    documentMixedUltraPrinterDelegation.printDocument()
}