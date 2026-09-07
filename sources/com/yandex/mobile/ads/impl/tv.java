package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class tv {
    public static void a(qv qvVar) {
        if (qvVar != null) {
            try {
                qvVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
