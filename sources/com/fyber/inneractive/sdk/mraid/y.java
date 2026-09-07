package com.fyber.inneractive.sdk.mraid;

/* JADX INFO: loaded from: classes11.dex */
public abstract class y {
    public abstract String a();

    public final String toString() {
        String strA = a();
        return strA != null ? strA.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "") : "";
    }
}
