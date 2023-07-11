package com.freek.imageai_m.common.utils;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@SpringBootApplication
public class ShellStarting {


    private static class StreamGobbler implements Runnable{
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler (InputStream inputStream, Consumer<String> consumer){
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run(){
            new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
        }
    }

    /*
    * function runtime shellscript started
    * */
    private static void runtime(boolean isWindows) throws IOException, InterruptedException {
        System.out.println(":: START :: Use Runtime ");
        String homeDirectory = System.getProperty("user.home"); // user.dir 현재 작업파일 imageAI_m 까지 하위까진안감
        System.out.println(":: Working Directory is " + homeDirectory);

        Process process;
        if (isWindows){
            process = Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s",homeDirectory));
        }else{
            process = Runtime.getRuntime().exec(String.format("sh -c ls -l %s",homeDirectory));
        }
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(),System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);

        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    /*
     * function ProcessBuilder shellscript started
     * */
    private static void processBuilder (boolean isWindows) throws IOException, InterruptedException{
        System.out.println(":: START :: Use Runtime ");
        String homeDirectory = System.getProperty("user.home"); // user.dir 현재 작업파일 imageAI_m 까지 하위까진안감
        System.out.println(":: Working Directory is " + homeDirectory);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(new File(homeDirectory));
        if(isWindows){
            builder.command("cmd.exe","/c","dir");
        }else{
            builder.command("sh","-c","ls -l | grep P");
        }
        Process process = builder.start();
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(),System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);

        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        System.out.println(":: OS is " + (isWindows ? "windows":"linux"));

//        ShellStarting.runtime(isWindows);
        ShellStarting.processBuilder(isWindows);
    }

}
