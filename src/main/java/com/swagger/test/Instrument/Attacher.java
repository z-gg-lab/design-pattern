package com.swagger.test.Instrument;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

public class Attacher {

    public static void main(String[] args) throws AttachNotSupportedException, IOException,
            AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("19916");
        vm.loadAgent("C:\\projects\\design-pattern.jar");
    }
}
