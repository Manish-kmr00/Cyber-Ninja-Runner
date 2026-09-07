package com.bytedance.sdk.openadsdk.ZZv.pA;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes13.dex */
public class ML implements com.bytedance.sdk.openadsdk.multipro.pA {
    private final com.bytedance.sdk.component.JG.pA.Og.Og.Og pA;

    public ML(com.bytedance.sdk.component.JG.pA.Og.Og.Og og) {
        this.pA = og;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA() {
        com.bytedance.sdk.component.JG.pA.Og.Og.Og og = this.pA;
        if (og != null) {
            return og.KZx();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public String pA(Uri uri) {
        com.bytedance.sdk.component.JG.pA.Og.Og.Og og = this.pA;
        if (og != null) {
            return og.pA(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Cursor pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.JG.pA.Og.Og.Og og = this.pA;
        if (og != null) {
            return og.pA(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public Uri pA(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.JG.pA.Og.Og.Og og = this.pA;
        if (og != null) {
            return og.pA(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.JG.pA.Og.Og.Og og = this.pA;
        if (og != null) {
            return og.pA(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.pA
    public int pA(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.JG.pA.Og.Og.Og og = this.pA;
        if (og != null) {
            return og.pA(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
