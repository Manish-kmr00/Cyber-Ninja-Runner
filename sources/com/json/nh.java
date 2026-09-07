package com.json;

import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import io.ktor.http.ContentDisposition;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class nh extends File {
    public nh(String str) {
        super(str);
    }

    public nh(String str, String str2) {
        super(str, str2);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        jSONObjectJsonObjectInit.put("name", getName());
        jSONObjectJsonObjectInit.put("path", getPath());
        jSONObjectJsonObjectInit.put("lastModified", lastModified());
        if (isFile()) {
            jSONObjectJsonObjectInit.put(ContentDisposition.Parameters.Size, length());
        }
        return jSONObjectJsonObjectInit;
    }

    @Override // java.io.File
    public String toString() {
        return "ISNFile(name: " + getName() + ", path: " + getPath() + ", isFile: " + isFile() + ", isDirectory: " + isDirectory() + ", lastModified: " + lastModified() + ", length: " + length() + ")";
    }
}
