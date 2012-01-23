package com.github.inside;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.RepeatingReleasedEventsFixer;

class Pong extends JFrame
{
    public Pong()
    {
        new RepeatingReleasedEventsFixer().install();
        JPanel boardContainer = new JPanel();
        boardContainer.setLayout(null);
        boardContainer.setBounds(Config.BOARD_CONTAINER_LEFT_MARGIN,
                                 Config.BOARD_CONTAINER_TOP_MARGIN,
                                 Config.BOARD_WIDTH,
                                 Config.BOARD_HEIGHT);
        boardContainer.add(new Board());
        this.getContentPane().setBackground(Color.decode("#f5f5f5"));
        this.setLayout(null);
        this.setTitle("Pong");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(Config.BOARD_CONTAINER_LEFT_MARGIN + Config.BOARD_WIDTH + Config.BOARD_CONTAINER_RIGHT_MARGIN,
                     Config.BOARD_CONTAINER_TOP_MARGIN + Config.BOARD_HEIGHT + Config.BOARD_CONTAINER_BOTTOM_MARGIN);
        this.add(boardContainer);
    }

    public static void main(String[] args)
    {
        new Pong();
    }
}
