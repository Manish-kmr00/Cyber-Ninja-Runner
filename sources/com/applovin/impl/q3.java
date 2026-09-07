package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: loaded from: classes5.dex */
public class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f596a;
    private String b;

    public enum a {
        AD_UNIT_ID,
        AD_FORMAT,
        AD
    }

    protected q3(a aVar, String str) {
        this.f596a = aVar;
        this.b = str;
    }

    public a a() {
        return this.f596a;
    }

    public String b() {
        return this.b;
    }

    public static q3 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new q3(a.AD_UNIT_ID, str);
    }

    public static q3 a(MaxAdFormat maxAdFormat) {
        String label = maxAdFormat.getLabel();
        if (TextUtils.isEmpty(label)) {
            return null;
        }
        return new q3(a.AD_FORMAT, label);
    }

    public static q3 a(v2 v2Var) {
        String strP = v2Var.P();
        MaxAdFormat format = v2Var.getFormat();
        if (TextUtils.isEmpty(strP) || format == null) {
            return null;
        }
        return new n3(new g3(strP, format));
    }
}
