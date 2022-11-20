package com.github.seonwoo960000.intellijobjectgraphplugin.components

class MyField(
    val name: String,
    val memo: String,
    var belongedClass: MyClass? = null,
    val connectedFields: MutableSet<MyField> = HashSet()
) {

    // uni-directional
    fun connectField(field: MyField) {
        this.connectedFields.add(field)
    }

    fun disconnectField(field: MyField) {
        this.connectedFields.remove(field)
    }

    fun setClass(myClass: MyClass) {
        this.belongedClass = myClass
    }

    fun unsetClass() {
        this.belongedClass = null
    }

    override fun toString(): String {
        return """
            Name: $name, 
            Memo: $memo, 
            Class: ${belongedClass?.name},
            Linked fields: ${connectedFields.map { it.name }.joinToString(", ")}
        """.trimIndent()
    }
}