package com.shawnclake.morgencore.core.component.events;

import com.shawnclake.morgencore.core.component.terminal.Output;

public class TestListener implements Listener {

    public void onTestEvent(TestEvent e)
    {
        Output.pln("in testevent handler");
    }

    public void onTestEvent2(TestEvent2 e)
    {
        Output.pln("in testevent2 handler");
    }

    public void onTestEventAgain(TestEvent e)
    {
        Output.pln("in testevent handler again");
    }

    public void onTestEventAgain(TestEvent e, boolean crap)
    {
        Output.pln("in testevent handler again");
    }

}
