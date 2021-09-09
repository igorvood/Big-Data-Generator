package ru.vood.generator.datamodel.util

import kotlin.properties.ReadOnlyProperty

interface ReadOnlyPropertyMap<in T> : ReadOnlyProperty<T, Map<String, Any>>