@file:Suppress("unused")

package becode.sec.common.cli.converter

import becode.sec.common.BinaryEncoding
import becode.sec.common.io.IOSource
import picocli.CommandLine.ITypeConverter


object InputSourceConverter : ITypeConverter<IOSource.Input> {
    override fun convert(value: String?): IOSource.Input = IOSource.Input.fromString(requireNotNull(value))
}

object OutputSourceConverter : ITypeConverter<IOSource.Output> {
    override fun convert(value: String?): IOSource.Output = IOSource.Output.fromString(requireNotNull(value))
}

object CommaSeparatedListConverter : ITypeConverter<List<String>> {
    override fun convert(value: String?): List<String> {
        return when (value) {
            null -> emptyList()
            else -> value.splitToSequence(",").toList()
        }
    }
}

object BinaryEncodingConverter : ITypeConverter<BinaryEncoding> {
    override fun convert(value: String): BinaryEncoding {
        return BinaryEncoding.fromName(value)
    }
}

