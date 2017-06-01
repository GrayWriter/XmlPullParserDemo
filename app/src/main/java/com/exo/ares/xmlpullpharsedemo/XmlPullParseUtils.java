package com.exo.ares.xmlpullpharsedemo;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


/**
 * Created by guofeng.wu on 2017/5/23.
 */


public class XmlPullParseUtils {
    private XmlPullParser mParser;

    /**
     * 解析layout布局文件，XmlParser为XmlResourceParser：实现类为Parser
     * 已读入layout Xml 文件
     * @param context
     * @param layoutResId layout布局文件的id
     */
    public XmlPullParseUtils(Context context,int layoutResId) {
        mParser = context.getResources().getLayout(layoutResId);
    }

    /**
     * XmlParser为KXmlParser
     * 注意：只能读取UTF-8编码的xml文件,支持命名空间
     * @param file
     */
    public XmlPullParseUtils(File file){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            mParser = factory.newPullParser();
            mParser.setInput(new FileInputStream(file),"utf-8");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public AttributeSet getAttrSet(){
        return Xml.asAttributeSet(mParser);
    }
    public XmlPullParser getXmlParser(){
        return mParser;
    }
    /*XmlSerializer xml的序列化与反序列*/
}
