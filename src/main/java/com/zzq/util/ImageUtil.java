package com.zzq.util;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageUtil {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(100);
        File baseFile = new File("D:\\Camera");
        for (File f: baseFile.listFiles()) {
            if( f.getName()!=null && !f.getName().endsWith("mp4") ){
                service.submit(new ImageCompress(f, new File("D:\\Camera2" , f.getName()) ));
            }
        }
        service.shutdown();
    }

}
class ImageCompress implements Runnable{

    private File file;

    private File toFile;

    public ImageCompress(File file, File toFile) {
        this.file = file;
        this.toFile = toFile;
    }

    public File getToFile() {
        return toFile;
    }

    public void setToFile(File toFile) {
        this.toFile = toFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            Thumbnails
                    .of( this.file )
                    .scale(1f)
                    .outputQuality(0.1f)
                    .toFile( toFile );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
