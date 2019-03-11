package com.hry.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @Description: 文件工具类, 提供文件读取写存储的方法
 * @Author: lish
 * @Date: 2018/7/25 20:16
 */
@Slf4j
public class FileUtil {

    /**
     *@description: 读取文件内容
     *@params: [file -文件全路径(String)]
     *@return: java.lang.String
     */
    public static String getContent(String file) {
        File f = new File(file);
        Reader reader = null;
        try {
            reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            log.error("文件不存在:" + file);
            return null;
        } catch (IOException e) {
            log.error("读取文件时发生异常");
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("关闭文件失败!");//日了狗代码才会走到这里
                }
            }
        }
    }

    /**
     * @description: 写文件,保存到硬盘
     * @params: [content-待保存的内容, fullTargetName-文件名全路径,如C:\Result\hello.java]
     * @return: void
     */
    public static void saveContent(String content, String fullTargetName) {

        File file = new File(fullTargetName);

        //判断文件父目录是否存在,不存在的话,则创建
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            file.createNewFile();
        } catch (IOException e1) {
            log.error("创建文件失败");
        }

        Writer writer = null;

        try {
            writer = new FileWriter(file);
            writer.write(content);
        } catch (IOException e) {
            log.error("写文件失败!");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 给文件最后一个} 前添加内容
     * @param path 文件全路径
     * @param  content 添加内容
     * */
    public static void addContainsToFile(String path,String content){
        String oldpath= path;
        String newPath = path.replace(".java","1.java");
        File file = new File(oldpath);
        int num = 0;
        try {
            num = getTotalLines(file);
            BufferedReader in=new BufferedReader(new FileReader(oldpath));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newPath)));
            String line;
            int count=1;

            String newMethod = content;
            while((line=in.readLine())!=null){
                if(count==num){
                    out.println(newMethod + "\r\n" + "}");  //替换,结尾必须加（\r\n}）
                }else{
                    out.println(line);
                }
                count++;
            }
            in.close();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        deleteFile(oldpath);
        updateFileName(newPath, oldpath);

    }

    // 文件内容的总行数。
    public static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    /**
     * 修改文件名字
     * @param oldFilePath 文件路径
     * @param newFilePath 新的文件名
     * @return
     */
    public static boolean updateFileName(String oldFilePath , String newFilePath) {
        File f = new File(oldFilePath);
        File mm = new File(newFilePath);
        if (f.renameTo(mm)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 删除文件
     * @param filePath  文件路径
     */
    public static void deleteFile(String filePath) {
        StringBuffer sb = new StringBuffer(filePath);
        File f = new File(sb.toString());
        if (f.exists())
            f.delete();

    }





}
