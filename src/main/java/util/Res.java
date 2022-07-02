package util;

import java.awt.image.BufferedImage;

public interface Res {
    BufferedImage UserImage = Resource.getImage("用户.png");
    BufferedImage ManageBackground = Resource.getImage("背景图.png");
    BufferedImage CostomerBackground = Resource.getImage("CostomerBackground.png");
    BufferedImage LoginBackground = Resource.getImage("LoginBackground.png");
}
