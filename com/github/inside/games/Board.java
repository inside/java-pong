package com.github.inside.games;

import java.awt.Color;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Board extends JPanel
{
    public Board()
    {
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
        this.setBackground(Color.BLACK);
    }
}
