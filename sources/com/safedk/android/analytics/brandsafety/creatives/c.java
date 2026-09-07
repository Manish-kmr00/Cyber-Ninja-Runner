package com.safedk.android.analytics.brandsafety.creatives;

import com.safedk.android.utils.Logger;
import com.safedk.android.utils.n;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class c {
    private static final String b = "MraidParser";
    private static final String c = "markup";
    private static final String d = "advDomain";
    private static final String e = "creativeId";
    private static final String f = "content";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected JSONObject f8062a;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8063a;
        public String b;
        public String c;
        public String d;
        public String e;

        public a() {
        }
    }

    public c(JSONObject jSONObject) {
        this.f8062a = jSONObject;
    }

    public a a() {
        a aVar = new a();
        if (this.f8062a != null) {
            try {
                String string = this.f8062a.getString("content");
                aVar.f8063a = this.f8062a.getString("creativeId");
                aVar.c = this.f8062a.optString(d, null);
                aVar.d = a(new JSONObject(string));
                Logger.d(b, "mraid Markup (url encoded)=" + aVar.d);
                aVar.b = a(aVar.d);
                Logger.d(b, "mraid clickURL = " + aVar.b);
                aVar.e = b(aVar.d);
                Logger.d(b, "mraid videoUrl = " + aVar.e);
            } catch (JSONException e2) {
                Logger.d(b, "mraid error " + e2.getMessage() + " parsing" + this.f8062a.toString());
            }
        }
        return aVar;
    }

    protected String a(JSONObject jSONObject) throws JSONException {
        return jSONObject.getString(c);
    }

    private String a(String str) {
        Matcher matcher = com.safedk.android.utils.g.aB().matcher(str);
        if (matcher.find()) {
            return c(matcher.group(0));
        }
        return null;
    }

    private String b(String str) {
        Matcher matcher = com.safedk.android.utils.g.aD().matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String c(String str) {
        String strE = n.e(com.safedk.android.utils.g.aE(), str);
        Logger.d(b, "found click url: " + strE);
        return strE;
    }
}
