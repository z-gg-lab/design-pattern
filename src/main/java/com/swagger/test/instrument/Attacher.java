package com.swagger.test.instrument;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Attach API 的作用是提供JVM进程间通信的能力
 * 我们将通过Attach API的loadAgent()方法，将打包好的 jar包动态Attach到目标JVM上。
 */
public class Attacher {

    public static void main(String[] args) throws AttachNotSupportedException, IOException,
            AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("12476");
        vm.loadAgent("C:\\projects\\design-pattern\\target\\agent.jar");
    }
}
