package util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 获取资源文件的工具类
 */
public class Resource {

    public static InputStream getStream(String name) {
        String path = "src/main/resources/" + name;
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(path);
        } catch (Exception e) {
            throw new RuntimeException("找不到资源" + name);
        }
//        InputStream inputStream = Resource.class.getResourceAsStream("/" + name);
//        if (inputStream == null) {
//            throw new RuntimeException("找不到资源:" + name);
//        }
        return inputStream;
    }

    public static BufferedImage getImage(String name) {
        InputStream inputStream = getStream(name);
        try {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("加载资源失败:" + name, e);
        }
    }

    public static ImageIcon getIcon(String name) {
        ImageIcon imageIcon = new ImageIcon();
        imageIcon.setImage(getImage(name));
        return imageIcon;
    }

}
