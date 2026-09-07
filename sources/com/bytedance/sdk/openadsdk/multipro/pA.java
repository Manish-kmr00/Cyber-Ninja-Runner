package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes13.dex */
public interface pA {
    int pA(Uri uri, ContentValues contentValues, String str, String[] strArr);

    int pA(Uri uri, String str, String[] strArr);

    Cursor pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    Uri pA(Uri uri, ContentValues contentValues);

    String pA();

    String pA(Uri uri);
}
