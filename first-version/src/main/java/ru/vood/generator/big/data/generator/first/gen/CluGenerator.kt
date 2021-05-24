package ru.vood.generator.big.data.generator.first.gen

import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.first.dto.Clu

@Service
class CluGenerator(private val strGen: GeneratorData<String>) : GeneratorData<Clu> {

    override fun gen(): Clu {
        return Clu(strGen.gen(), strGen.gen())
    }
}