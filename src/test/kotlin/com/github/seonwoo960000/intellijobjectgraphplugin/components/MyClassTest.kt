package com.github.seonwoo960000.intellijobjectgraphplugin.components

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlin.test.assertContains


internal class MyClassTest: BasePlatformTestCase() {

    fun `test MyClass and MyField functionality`() {
        val field1_class1 = MyField("field1_class", "field1_class")
        val field2_class1 = MyField("field2_class1", "field2_class1")
        val field1_class2 = MyField("field1_class2", "field1_class2")
        val field2_class2 = MyField("field2_class2", "field2_class2")

        val class1 = MyClass("class1", "class1")
        val class2 = MyClass("class2", "class2")

        class1.addField(field1_class1)
        class1.addField(field2_class1)
        class2.addField(field1_class2)
        class2.addField(field2_class2)
        class1.connectClass(class2)

        class1.let {
            assertContains(it.fields, field1_class1)
            assertContains(it.fields, field2_class1)
            assertContains(it.connectedClasses, class2)
        }

        class2.let {
            assertContains(it.fields, field1_class2)
            assertContains(it.fields, field2_class2)
            assertContains(it.connectedClasses, class1)
        }
        
        field1_class1.connectField(field1_class2)
        assertEquals(field1_class1.belongedClass, class1)
        assertEquals(field1_class2.belongedClass, class2)
        assertContains(field1_class1.connectedFields, field1_class2)
    }
}