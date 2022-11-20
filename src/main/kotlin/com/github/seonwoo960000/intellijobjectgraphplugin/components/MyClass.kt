package com.github.seonwoo960000.intellijobjectgraphplugin.components

class MyClass(
    val name: String,
    val memo: String,
    val fields: MutableSet<MyField> = HashSet(),
    val connectedClasses: MutableSet<MyClass> = HashSet()
) {

    fun addField(field: MyField) {
        this.fields.add(field)
        field.setClass(this)
    }

    fun deleteField(field: MyField) {
        this.fields.remove(field)
        field.unsetClass()
    }

    fun connectClass(myClass: MyClass, recursive: Boolean = true) {
        connectedClasses.add(myClass)
        if (recursive) myClass.connectClass(this, false)
    }

    override fun toString(): String {
        return """
            Name: $name,
            Memo: $memo,
            Included fields: ${fields.map { it.name }.joinToString(", ")}
            Linked classes: ${connectedClasses.map { it.name }.joinToString(", ")}
        """.trimIndent()
    }
}