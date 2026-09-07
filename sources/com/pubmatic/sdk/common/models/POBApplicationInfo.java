package com.pubmatic.sdk.common.models;

import java.net.URL;

/* JADX INFO: loaded from: classes8.dex */
public class POBApplicationInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7576a;
    private URL b;
    private Boolean c;
    private String d;
    private String e;

    public String getCategories() {
        return this.d;
    }

    public String getDomain() {
        return this.f7576a;
    }

    public String getKeywords() {
        return this.e;
    }

    public URL getStoreURL() {
        return this.b;
    }

    public Boolean isPaid() {
        return this.c;
    }

    public void setCategories(String str) {
        this.d = str;
    }

    public void setDomain(String str) {
        this.f7576a = str;
    }

    public void setKeywords(String str) {
        this.e = str;
    }

    public void setPaid(boolean z) {
        this.c = Boolean.valueOf(z);
    }

    public void setStoreURL(URL url) {
        this.b = url;
    }
}
