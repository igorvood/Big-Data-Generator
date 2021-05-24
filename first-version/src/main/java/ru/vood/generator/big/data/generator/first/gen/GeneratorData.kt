package ru.vood.generator.big.data.generator.first.gen

interface GeneratorData<T> {

    fun gen(): T

    fun gen(t: T, mutationFun: (T) -> T): T {
        return mutationFun.invoke(t)
    }

}
