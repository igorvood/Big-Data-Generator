package ru.vood.generator.datamodel.clu


data class CluFunctionalDto(
    val scoreId: String,
    val id: String,

    ) {
    val verId: String by lazy { id }

}