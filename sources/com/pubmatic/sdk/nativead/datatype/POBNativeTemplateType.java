package com.pubmatic.sdk.nativead.datatype;

/* JADX INFO: loaded from: classes11.dex */
public enum POBNativeTemplateType {
    SMALL(0),
    MEDIUM(1),
    CUSTOM(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7695a;

    POBNativeTemplateType(int i) {
        this.f7695a = i;
    }

    public int getTemplateType() {
        return this.f7695a;
    }
}
