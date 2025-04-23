package org.example

interface Printer {
    fun printDocument()
}

class InkPrinter : Printer {
    override fun printDocument() {
        println("Ink")
    }
}

class LaserPrinter : Printer {
    override fun printDocument() {
        println("Laser")
    }
}

class MixedPrinter : Printer {
    override fun printDocument() {
        println("Mixed")
    }
}

class MixedUltraPrinter : Printer {
    override fun printDocument() {
        println("MixedUltra")
    }
}

class DocumentPrinter(printerType: PrinterType) {
    private val printer = when (printerType) {
        PrinterType.INK -> InkPrinter()
        PrinterType.LASER -> LaserPrinter()
        PrinterType.MIXED -> MixedPrinter()
        PrinterType.MIXEDULTRA -> MixedUltraPrinter()
    }

    fun printDocument() {
        printer.printDocument()
    }
}

class DocumentPrinterD(printer: Printer) : Printer by printer

enum class PrinterType {
    INK, LASER, MIXED, MIXEDULTRA
}

fun main() {
    val inkPrinter = DocumentPrinter(PrinterType.INK)
    inkPrinter.printDocument()

    val laserPrinter = DocumentPrinter(PrinterType.LASER)
    laserPrinter.printDocument()

    val mixedPrinter = DocumentPrinter(PrinterType.MIXED)
    mixedPrinter.printDocument()

    val documentInkPrinter = DocumentPrinterD(InkPrinter())
    documentInkPrinter.printDocument()

    val documentLaserPrinter = DocumentPrinterD(LaserPrinter())
    documentLaserPrinter.printDocument()

    val documentMixedPrinter = DocumentPrinterD(MixedPrinter())
    documentMixedPrinter.printDocument()

    val documentMixedUltraPrinter = DocumentPrinterD(MixedUltraPrinter())
    documentMixedUltraPrinter.printDocument()

}