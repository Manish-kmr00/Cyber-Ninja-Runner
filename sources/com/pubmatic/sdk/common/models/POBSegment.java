package com.pubmatic.sdk.common.models;

/* JADX INFO: loaded from: classes5.dex */
public class POBSegment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7587a;
    private String b;
    private String c;

    public POBSegment(String str) {
        this.f7587a = str;
    }

    public String getName() {
        return this.b;
    }

    public String getSegId() {
        return this.f7587a;
    }

    public String getValue() {
        return this.c;
    }

    public void setValue(String str) {
        this.c = str;
    }

    public POBSegment(String str, String str2) {
        this.f7587a = str;
        this.b = str2;
    }
}
