package com.shawnclake.morgencore.core.component.events;

import com.shawnclake.morgencore.core.component.terminal.Output;

public class TestListener2 implements Listener {

    public void onTestEvent(TestEvent e)
    {
        Output.pln("2 in testevent handler");
    }

    public void onTestEvent2(TestEvent2 e)
    {
        Output.pln("2 in testevent2 handler");
    }

    public void onTestEventAgain(TestEvent e)
    {
        Output.pln("2 in testevent handler again");
    }

    public void onTestEventAgain(TestEvent e, boolean crap)
    {
        Output.pln("2 in testevent handler again");
    }

}
