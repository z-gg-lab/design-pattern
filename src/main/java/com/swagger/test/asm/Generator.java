package com.swagger.test.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generator {

    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("com/swagger/test/asm/Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        // 处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        // 输出
        File f = new File("C:\\projects\\design-pattern\\target\\classes\\com\\swagger\\test\\asm\\Base.class");
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        fileOutputStream.write(data);
        fileOutputStream.close();
        System.out.println("now generator cc success!!!!!");
    }

}
