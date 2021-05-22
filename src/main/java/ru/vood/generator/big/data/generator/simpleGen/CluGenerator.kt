package ru.vood.generator.big.data.generator.simpleGen

import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.data.Clu

@Service
class CluGenerator(private val strGen: GeneratorData<String>) : GeneratorData<Clu> {

    override fun gen(): Clu {
       return Clu(strGen.gen())
    }
}