package ru.vood.generator.big.data.generator.second.gen

interface MapGenerator<T : MetaDataInterface> {
    fun dataMap(s: T): Map<String, Any> {
        return s.headers()
                .map { it to keyValMapper(it, s) }
                .toMap()
    }

    fun keyValMapper(key: String, data: T): Any

}