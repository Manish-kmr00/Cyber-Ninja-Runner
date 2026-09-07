package com.fyber.inneractive.sdk.flow.storepromo.loader;

import com.facebook.internal.NativeProtocol;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1819a = b("app_screen_%d");
    public static final String b = "document.getElementById(\"app_screen_%d\").src = app_screen_%d;\n";
    public static final String c = b("app_video_url_%d");
    public static final String d = "document.getElementById(\"app_video_url_%d\").src = app_video_url_%d;\n";
    public static final String e = b("app_icon");
    public static final String f = "document.getElementById(\"app_icon\").src = app_icon;\n";
    public static final String g = b(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
    public static final String h = a(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
    public static final String i = b("app_pub_name");
    public static final String j = a("app_pub_name");
    public static final String k = b("app_label");
    public static final String l = a("app_label");
    public static final String m = b(CampaignEx.JSON_KEY_APP_SIZE);
    public static final String n = a(CampaignEx.JSON_KEY_APP_SIZE);
    public static final String o = b("app_rating");
    public static final String p = a("app_rating");
    public static final String q = b("app_rating_icon");
    public static final String r = "document.getElementById(\"app_rating_icon\").src = app_rating_icon;\n";

    public static String a(String str) {
        return "document.getElementById(\"" + str + "\").innerHTML = `${" + str + "}`;\n";
    }

    public static String b(String str) {
        return "var " + str + " = `%s`;\n";
    }

    public static String a(boolean z, String str) {
        return "document.getElementById(\"" + str + "\").style.display = " + (z ? "'block'" : "'none'") + ";\n";
    }
}
