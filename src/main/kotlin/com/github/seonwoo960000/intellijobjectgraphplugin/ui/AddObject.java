package com.github.seonwoo960000.intellijobjectgraphplugin.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

public class AddObject {
    private JFormattedTextField enterTheClassFileFormattedTextField;
    private JButton add;

    public AddObject() {
        enterTheClassFileFormattedTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("key typed:" + e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println("key pressed: " + e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                System.out.println("key released: " + e);
            }
        });
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 JFileChooser fc = new JFileChooser();
                 fc.showDialog(null, "select");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
