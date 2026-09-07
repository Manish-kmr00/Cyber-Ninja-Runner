package com.pubmatic.sdk.common.network;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class POBHttpRequest implements Cloneable {
    private String d;
    private String e;
    private String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7590a = 5000;
    private int b = 0;
    private float c = 1.0f;
    private HTTP_METHOD h = HTTP_METHOD.GET;
    private Map g = new HashMap();

    public enum HTTP_METHOD {
        GET,
        POST,
        PUT,
        DELETE
    }

    public Map<String, String> getHeaders() {
        return this.g;
    }

    public String getPostData() {
        return this.f;
    }

    public HTTP_METHOD getRequestMethod() {
        return this.h;
    }

    public String getRequestTag() {
        return this.d;
    }

    public float getRetryBackoffMultiplier() {
        return this.c;
    }

    public int getRetryCount() {
        return this.b;
    }

    public int getTimeout() {
        return this.f7590a;
    }

    public String getUrl() {
        return this.e;
    }

    public void setHeaders(Map<String, String> map) {
        this.g = map;
    }

    public void setPostData(String str) {
        this.f = str;
    }

    public void setRequestMethod(HTTP_METHOD http_method) {
        this.h = http_method;
    }

    public void setRequestTag(String str) {
        this.d = str;
    }

    public void setRetryBackoffMultiplier(float f) {
        this.c = f;
    }

    public void setRetryCount(int i) {
        this.b = i;
    }

    public void setTimeout(int i) {
        this.f7590a = i;
    }

    public void setUrl(String str) {
        this.e = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getUrl());
        if (getRequestMethod() == HTTP_METHOD.POST) {
            sb.append("\nPOST Data : ").append(getPostData());
        } else {
            sb.append(getPostData());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public POBHttpRequest m5492clone() throws CloneNotSupportedException {
        return (POBHttpRequest) super.clone();
    }
}
