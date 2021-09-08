package ru.vood.generator.datamodel.clu


class CluFunctionalDto(
    val scoreId: String,
    val id: String,

    ) {
    val verId: String by lazy { id }

}