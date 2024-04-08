package com.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 生成随机验证码
 */
public class CaptchaUtil {

    // 默认验证码字符集
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    // 默认字符数量
    private final Integer SIZE;
    // 默认干扰线数量
    private final int LINES;
    // 默认宽度
    private final int WIDTH;
    // 默认高度
    private final int HEIGHT;
    // 默认字体大小
    private final int FONT_SIZE;
    // 默认字体倾斜
    private final boolean TILT;

    private final Color BACKGROUND_COLOR;

    /**
     * 初始化基础参数
     *
     * @param builder
     */
    private CaptchaUtil(Builder builder) {
        SIZE = builder.size;
        LINES = builder.lines;
        WIDTH = builder.width;
        HEIGHT = builder.height;
        FONT_SIZE = builder.fontSize;
        TILT = builder.tilt;
        BACKGROUND_COLOR = builder.backgroundColor;
    }

    /**
     * 实例化构造器对象
     *
     * @return
     */
    public static Builder newBuilder() {
        return new Builder();
    }



    /**
     * @return 生成随机验证码及图片
     * Object[0]：验证码字符串；
     * Object[1]：验证码图片。
     */
    public Object[] createImage() {

        // 在内存中创建图象
        int width = WIDTH, height = HEIGHT;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics g = image.getGraphics();

        //生成随机类
        Random random = new Random();

        // 设定背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);

        //设定字体
        g.setFont(new Font("Times New Roman", Font.PLAIN, FONT_SIZE));

        //画边框
        //g.setColor(new Color());
        //g.drawRect(0,0,width-1,height-1);


        // 随机产生100条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < LINES; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        // 取随机产生的认证码(4位数字)
        String sRand = "";
        for (int i = 0; i < SIZE; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            // 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(rand, 13 * i + 6, 16);
        }

        // 返回验证码和图片
        return new Object[]{sRand, image};
    }

    private Color getRandColor(int fc, int bc) {//给定范围获得随机颜色
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 构造器对象
     */
    public static class Builder {
        // 默认字符数量
        private int size = 4;
        // 默认干扰线数量
        private int lines = 100;
        // 默认宽度
        private int width = 60;
        // 默认高度
        private int height = 20;
        // 默认字体大小
        private int fontSize = 18;
        // 默认字体倾斜
        private boolean tilt = false;
        //背景颜色
        private Color backgroundColor = Color.LIGHT_GRAY;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setLines(int lines) {
            this.lines = lines;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setFontSize(int fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        public Builder setTilt(boolean tilt) {
            this.tilt = tilt;
            return this;
        }

        public Builder setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public CaptchaUtil build() {
            return new CaptchaUtil(this);
        }
    }
}
