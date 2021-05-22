package ru.vood.generator.big.data.generator.data.gen

interface MapGenerator<T: DataInterface> {
    fun dataMap(s: T): Map<String, Any>{
        return s.headers()
                .map { it to keyValMapper(it, s) }
                .toMap()
        
    }
    
    fun keyValMapper(key:String, data: T): Any
    
}