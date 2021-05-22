package ru.vood.generator.big.data.generator.file

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.data.MetaGetter
import java.io.File

@Service
class CsvPutter : FilePutter {

    val logger = LoggerFactory.getLogger(CsvPutter::class.java)

    override fun <T : MetaGetter<T>> toFile(t: List<T>) {
        val t1 = t[0]
        val header = t1.header()
        val joinToString = header.joinToString(";")

        File(t1.javaClass.simpleName+".csv").bufferedWriter().use { out ->
            out.write(joinToString + "\n")
            t.map { it.data() }
                    .withIndex()
                    .map {
                        val index = it.index
                        if (index % 100 == 0)
                            logger.info("All ready put $index")
                        it.value
                    }
                    .forEach { data ->
                        val data = header.map { col -> data[col].toString() }
                                .joinToString(";")
                        out.write(data + "\n")
                    }
        }
    }
}