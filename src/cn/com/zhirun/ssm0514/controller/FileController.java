package cn.com.zhirun.ssm0514.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RequestMapping("/load")
@Controller
public class FileController {

    /**
     * 单个文件上传
     * @param request
     * @return
     */
    @RequestMapping(value="/upload1",produces="text/html;charset=utf-8")
    @ResponseBody
    private String upload2(@RequestParam("file")CommonsMultipartFile partFile, HttpServletRequest request) {
        try {
            String path = request.getServletContext().getRealPath("/upload");
            String name = request.getParameter("name");
            System.out.println("其他的参数:"+name);
            System.out.println("upload1---------------start---------------------");
            System.out.println("这个临时文件的路径是:"+path);
            String filename = partFile.getOriginalFilename();
            System.out.println("文件的名字："+filename);
            File file = new File(path+"/"+filename);
            InputStream inputStream = partFile.getInputStream();
            FileUtils.copyInputStreamToFile(inputStream, file);
            if(inputStream!=null){
                inputStream.close();
            }
            return "文件上传成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败！";
        }
    }

    /**
     * 文件下载
     * 单个文件下载
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/down2")
    private void down(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        File file = new File(path);
        File[] files = file.listFiles();
        String name = files[0].getName();//随机获取一个文件，实际中按需编写代码
        System.out.println("文件的名字："+name);
        response.addHeader("content-disposition", "attachment;filename="+name);
        FileUtils.copyFile(files[0], response.getOutputStream());
    }


    /**
     * 多个文件上载
     * @param request
     * @return
     */
    @RequestMapping(value="/upload3",produces="text/html;charset=utf-8")
    @ResponseBody
    private String upload3(@RequestParam("file")CommonsMultipartFile[] partFiles,HttpServletRequest request) {
        InputStream inputStream = null;
        try {
            String path = request.getServletContext().getRealPath("/upload");
            String name = request.getParameter("name");
            System.out.println("其他的参数:"+name);
            System.out.println("upload3---------------start---------------------");
            System.out.println("这个临时文件的路径是:"+path);
            for (int i = 0; i < partFiles.length; i++) {
                String filename = partFiles[i].getOriginalFilename();
                System.out.println("文件的名字：" + filename);
                File file = new File(path+"/"+filename);
                inputStream = partFiles[i].getInputStream();
                FileUtils.copyInputStreamToFile(inputStream, file);
            }
            if(inputStream!=null){
                inputStream.close();
            }
            return "文件上传成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败！";
        }
    }

    /**
     * 文件下载，一下次下载多个文件
     * 思路：先将多个文件压缩到一个压缩包里去，然后传到前台
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/down4")
    private void down2(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        String path = request.getServletContext().getRealPath("/upload");
        String path = "D:\\day01";
        File file = new File(path);
        File[] files = file.listFiles();
        File zipFile =new File("D:\\day01\\test.zip");
        if(!zipFile.exists()){
            zipFile.createNewFile();
        }
        String zipName = zipFile.getName();
        System.out.println("压缩文件的名字："+zipName);
        response.addHeader("Content-Disposition", "attachment;filename="+zipName);
        //定义输出类型
//        response.setContentType("application/zip");
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile));
        BufferedInputStream in  =null;
        System.out.println("文件的个数:"+files.length);
        for(int i = 0;i<files.length;i++){
            String name = files[i].getName();
            System.out.println("文件的名字："+name);
            ZipEntry zipEntry = new ZipEntry(name);
            zip.putNextEntry(zipEntry);
            in = new BufferedInputStream(new FileInputStream(files[i]));
            int len = 0;
            long downloadLength = 0 ;
            long fileLength = files[i].length();
            byte [] btyes = new byte[1024*4];
            while((len=in.read(btyes))!=-1){
                downloadLength += len;
                zip.write(btyes, 0, len);
                if(fileLength == downloadLength){		//防止最后一次读取的时候，一直阻塞
                    break;
                }
            }
        }
        zip.flush();
        zip.close();
        in.close();
        FileUtils.copyFile(zipFile, response.getOutputStream());
        if(zipFile.exists()){
            if(zipFile.delete()){
                System.out.println("压缩包删成功！！");
            }else{
                System.out.println("压缩包产出失败！！");
            }

        }
    }
}
