package com.bytedance.sdk.component.ML.KZx.KZx;

import java.io.Closeable;

/* JADX INFO: loaded from: classes4.dex */
public class Og {
    public static void pA(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
