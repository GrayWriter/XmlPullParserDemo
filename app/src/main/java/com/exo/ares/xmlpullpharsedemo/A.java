package com.exo.ares.xmlpullpharsedemo;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by guofeng.wu on 2017/5/23.
 *
 */

/**
 * AttributeSet与XmlPullParser的公共方法
 */
public interface A {
    int getAttributeCount();
    String getAttributeName(int index);
    String getAttributeValue(int index);
    String getAttributeValue(String namespace, String name);
    String getPositionDescription();
}
