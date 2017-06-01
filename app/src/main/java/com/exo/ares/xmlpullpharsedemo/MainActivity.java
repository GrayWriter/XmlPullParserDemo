package com.exo.ares.xmlpullpharsedemo;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private XmlPullParser mParser;
//    private AttributeSet mAttrSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XmlPullParseUtils xmlPullParseUtils = new XmlPullParseUtils(this,R.layout.activity_main);
        mParser = xmlPullParseUtils.getXmlParser();
        final AttributeSet mAttrSet = xmlPullParseUtils.getAttrSet();
//        Resources resources = getResources();
//        XmlResourceParser  parser0 = resources.getXml(R.xml.test);
//        XmlResourceParser  parser1 = resources.getLayout(R.layout.activity_main);
//        XmlResourceParser  parser2 = resources.getAnimation(R.anim.test);
//        Xml.asAttributeSet(parser0);
        /**
         * 解析最开始并非位于START_DOCUMENT,多次调用next，会依次位于
         * START_DOCUMENT
         * START_TAG（XML节点属性解析只能在该事件类型中进行解析）
         * TEXT(无Text部分“Hello World”则跳过该事件类型)
         * END_TAG
         * End document
         */
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mParser.next();
                    printEventType(mParser.getEventType());
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int count = mAttrSet.getAttributeCount();
                Log.d("666","count:"+count);
                for (int i =0;i<count;i++){
                    Log.d("666",mAttrSet.getAttributeName(i)+"****"+mAttrSet.getAttributeValue(i));
                }
            }
        });
        try {
            XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


    }
    private void printEventType(int eventType){
        switch (eventType){
            case XmlResourceParser.START_DOCUMENT:
                Log.d("6666","start document");
                break;
            case XmlPullParser.START_TAG:
                Log.d("6666","start tag");
                break;
            case XmlPullParser.TEXT:
                Log.d("6666","text");
                break;
            case XmlPullParser.END_TAG:
                Log.d("6666","end tag");
                break;
            case XmlPullParser.END_DOCUMENT:
                Log.d("6666","end document");
                break;
            default:
        }
    }


}
