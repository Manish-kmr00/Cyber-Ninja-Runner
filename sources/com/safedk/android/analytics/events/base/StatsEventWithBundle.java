package com.safedk.android.analytics.events.base;

import android.util.Base64;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.utils.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class StatsEventWithBundle extends StatsEvent implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8127a = "CrashEvent";
    private static final String b = "report";
    protected static final String i = "metadata";
    private JSONObject c;

    public StatsEventWithBundle(String sdk, StatsCollector.EventType eventType, JSONObject report) {
        super(sdk, eventType);
        this.E = eventType;
        this.C = sdk;
        this.G = n.b(System.currentTimeMillis());
        this.c = report;
    }

    public JSONObject f() throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        n.b(f8127a, "report : " + this.c);
        jSONObject.put("report", a(this.c.toString().replace("\\/", RemoteSettings.FORWARD_SLASH_STRING)));
        return jSONObject;
    }

    private String a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return new String(Base64.encode(byteArray, 2));
    }
}
