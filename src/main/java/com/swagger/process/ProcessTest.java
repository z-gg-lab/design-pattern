package com.swagger.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhuwei
 */
public class ProcessTest {
    /**
     * 在控制台输入命令 *
     * @param command 代表要执行的命令
     */
    public static void writeCommand(String command) {
        Process pro = null;
        try {
            pro = Runtime.getRuntime().exec(command);

            /**
             *  虽然cmd命令可以直接输出，但是通过IO流技术可以保证对数据进行一个缓冲。
             */
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream(),"GBK"));
            String msg = null;

            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //logger.error("IOException",e);
        }
    }

    public static void main(String[] args) {
        ProcessTest.writeCommand("ipconfig");
    }
}
