package com.smaato.sdk.video.vast.parser;

import android.util.Xml;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes12.dex */
public final class XmlEncodingUtils {
    public static boolean isSupported(String str) {
        try {
            return Xml.findEncodingByName(str) != null;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }
}
