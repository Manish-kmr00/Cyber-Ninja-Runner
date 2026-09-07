package com.five_corp.ad.internal.parser;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c {
    public static com.five_corp.ad.internal.i a(String str) throws JSONException {
        try {
            return new com.five_corp.ad.internal.i(h.a(new JSONObject(str).getJSONObject("mcfg")));
        } catch (NullPointerException e) {
            throw new JSONException(e.getMessage());
        }
    }
}
