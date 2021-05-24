package ru.vood.generator.big.data.generator.second.gen

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File

@Service
class NewCsvFilePutterImpl : NewFilePutter {

    val logger = LoggerFactory.getLogger(NewCsvFilePutterImpl::class.java)
    override fun <T : MetaDataInterface> toFile(t: List<T>, a: MapGenerator<T>) {
        val t1 = t[0]
        val header = t1.headers()
        val headerStr = header.joinToString(";")
        File(t1.javaClass.simpleName + ".csv").bufferedWriter().use { out ->
            out.write(headerStr + "\n")
            t.withIndex()
                    .map {
                        val index = it.index
                        if (index % 10_000 == 0)
                            logger.info("All ready put $index")
                        it.value
                    }
                    .forEach { data1 ->
                        val dataMap = a.dataMap(data1)
                        val str = header.joinToString(";") { col -> dataMap[col].toString() }
                        out.write(str + "\n")
                    }

        }
    }
}