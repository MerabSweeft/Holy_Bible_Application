package com.example.holybibleapplication.core

import org.junit.Test
import java.io.IOException
import kotlin.test.assertTrue


class AbstractTest {

    @Test
    fun `test data success`() {
        val dataObject = TestDataObject.Success(textOne = "a", textTwo = "b")
        val mapper = DataToDomainMapper.Base()
        val domainObject = dataObject.map(mapper)
        assertTrue(domainObject is TestDomainObject.Success)
    }

    @Test
    fun `test data fail`() {
        val dataObject = TestDataObject.Fail(exception = IOException())
        val mapper = DataToDomainMapper.Base()
        val domainObject = dataObject.map(mapper)
        assertTrue(domainObject is TestDomainObject.Fail)
    }

    private sealed class TestDataObject : Abstract.Object<TestDomainObject, DataToDomainMapper>() {
        abstract override fun map(mapper: DataToDomainMapper): TestDomainObject

        class Success(private val textOne: String, private val textTwo: String) : TestDataObject() {
            override fun map(mapper: DataToDomainMapper): TestDomainObject {
                return mapper.map(textOne = textOne, textTwo = textTwo)
            }

        }

        class Fail(private val exception: Throwable) : TestDataObject() {
            override fun map(mapper: DataToDomainMapper): TestDomainObject {
                return mapper.map(exception = exception)
            }

        }
    }

    private interface DataToDomainMapper : Abstract.Mapper {
        fun map(textOne: String, textTwo: String): TestDomainObject
        fun map(exception: Throwable): TestDomainObject

        class Base : DataToDomainMapper {
            override fun map(textOne: String, textTwo: String): TestDomainObject {
                return TestDomainObject.Success(combinedText = "$textOne $textTwo")
            }

            override fun map(exception: Throwable): TestDomainObject {
                return TestDomainObject.Fail(exception)
            }

        }
    }

    private sealed class TestDomainObject :
        Abstract.Object<TestDomainObject.TestUiObject, TestDomainObject.DomainToUiMapper>() {
        class Success(private val combinedText: String) : TestDomainObject() {
            override fun map(mapper: DomainToUiMapper): TestUiObject {
                TODO("Not yet implemented")
            }
        }

        class Fail(private val exception: Throwable) : TestDomainObject() {
            override fun map(mapper: DomainToUiMapper): TestUiObject {
                TODO("Not yet implemented")
            }

        }

        private sealed class TestUiObject : Abstract.Object<Unit, Abstract.Mapper.FinalEmpty>()
        private interface DomainToUiMapper : Abstract.Mapper
    }
}