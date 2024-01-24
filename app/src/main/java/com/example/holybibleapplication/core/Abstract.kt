package com.example.holybibleapplication.core

abstract class Abstract {

    abstract class Object<T, M : Mapper> {

        abstract fun map(mapper: M): T
    }

    interface Mapper {
        class FinalEmpty : Mapper
    }
}