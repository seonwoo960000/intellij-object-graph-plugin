package com.github.seonwoo960000.intellijobjectgraphplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MyStartAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val result = Messages.showInputDialog("Object graph", "시작하시겠습니까", Messages.getQuestionIcon())
        println(result)
    }
}