package com.github.inside;

import javax.swing.JApplet;
import com.github.inside.Pong;

public class PongApplet extends JApplet
{
    public void init()
    {
        new Pong(true);
    }
}
