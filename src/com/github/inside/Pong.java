package com.github.inside;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.RepeatingReleasedEventsFixer;

public class Pong
{
    public Pong(boolean isApplet)
    {
        new RepeatingReleasedEventsFixer().install();
        JPanel boardContainer = new JPanel();
        Player leftPlayer = new Player("left");
        Player rightPlayer = new Player("right");
        Board board = new Board();
        board.leftPlayer = leftPlayer;
        board.rightPlayer = rightPlayer;
        boardContainer.setLayout(null);
        boardContainer.setBounds(Config.BOARD_CONTAINER_LEFT_MARGIN,
                                 Config.BOARD_CONTAINER_TOP_MARGIN,
                                 Config.BOARD_WIDTH,
                                 Config.BOARD_HEIGHT);
        boardContainer.add(board);

        JFrame frame = new JFrame();
        frame.add(leftPlayer);
        frame.add(rightPlayer);
        frame.getContentPane().setBackground(Color.decode("#f5f5f5"));
        frame.setLayout(null);
        frame.setTitle("Pong");
        frame.setLocationRelativeTo(null);

        if (!isApplet)
        {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        frame.setResizable(false);
        frame.setSize(Config.BOARD_CONTAINER_LEFT_MARGIN + Config.BOARD_WIDTH + Config.BOARD_CONTAINER_RIGHT_MARGIN,
                     Config.BOARD_CONTAINER_TOP_MARGIN + Config.BOARD_HEIGHT + Config.BOARD_CONTAINER_BOTTOM_MARGIN);
        frame.add(boardContainer);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Pong(false);
    }
}
