package com.edoup.base.objects;


import cn.hutool.extra.qrcode.QrCodeUtil;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/6/22 0:12
 */
public class test {
    public static void main(String[] args) {
        QrCodeUtil.generate("https://hutool.cn/", 300, 300);
    }
}
