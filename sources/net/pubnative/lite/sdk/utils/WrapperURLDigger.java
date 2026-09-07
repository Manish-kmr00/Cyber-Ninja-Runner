package net.pubnative.lite.sdk.utils;

/* JADX INFO: loaded from: classes10.dex */
public class WrapperURLDigger {
    public String getURL(String str) {
        try {
            return (!str.contains("\n") || str.split("\n").length <= 0) ? str : str.split("\n")[0];
        } catch (RuntimeException unused) {
            return str;
        }
    }
}
