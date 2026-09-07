package com.inmobi.media;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class D1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3045a;

    public D1(String tableName, String tableSchema) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(tableSchema, "tableSchema");
        this.f3045a = tableName;
        try {
            C3309b3.f3272a.a(tableName, tableSchema);
        } catch (Exception unused) {
        }
    }

    public abstract Object a(ContentValues contentValues);

    public final void a(Object obj) {
        try {
            C3309b3.a(this.f3045a, b(obj));
            Intrinsics.checkNotNullExpressionValue("D1", "TAG");
            Objects.toString(obj);
        } catch (Exception unused) {
        }
    }

    public abstract ContentValues b(Object obj);

    public final void b(Object obj, String str, String[] strArr) {
        try {
            C3309b3.b(this.f3045a, b(obj), str, strArr);
            Intrinsics.checkNotNullExpressionValue("D1", "TAG");
            Objects.toString(obj);
        } catch (Exception unused) {
        }
    }

    public final void a(Object obj, String str, String[] strArr) {
        try {
            C3309b3.a(this.f3045a, b(obj), str, strArr);
            Intrinsics.checkNotNullExpressionValue("D1", "TAG");
            Objects.toString(obj);
        } catch (Exception unused) {
        }
    }

    public final Object b(String str, String[] strArr) {
        try {
            List<ContentValues> listB = C3309b3.b(this.f3045a, null, str, strArr, null, null, null, null);
            if (listB.isEmpty()) {
                return null;
            }
            return a(listB.get(0));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ArrayList a(D1 d1, String str, String[] strArr, String str2, String str3, String str4, Integer num, int i) {
        String str5 = (i & 1) != 0 ? null : str;
        String[] strArr2 = (i & 2) != 0 ? null : strArr;
        String str6 = (i & 4) != 0 ? null : str2;
        String str7 = (i & 8) != 0 ? null : str3;
        String str8 = (i & 16) != 0 ? null : str4;
        Integer num2 = (i & 32) != 0 ? null : num;
        d1.getClass();
        try {
            ArrayList arrayList = new ArrayList();
            List<ContentValues> listB = C3309b3.b(d1.f3045a, null, str5, strArr2, str6, str7, str8, num2 != null ? num2.toString() : null);
            if (listB.isEmpty()) {
                return arrayList;
            }
            Iterator<ContentValues> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(d1.a(it.next()));
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static int a(D1 d1) {
        d1.getClass();
        try {
            return C3309b3.a(d1.f3045a, null, null, null, null, null, null, null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int a(String str, String[] strArr) {
        try {
            return C3309b3.a(this.f3045a, str, strArr);
        } catch (Exception unused) {
            return 0;
        }
    }
}
