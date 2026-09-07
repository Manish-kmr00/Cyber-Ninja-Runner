package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class nf0 implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    private final String[] b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f9726a = new ArrayList(20);

        public final void a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f9726a.add(name);
            this.f9726a.add(StringsKt.trim((CharSequence) value).toString());
        }

        public final ArrayList b() {
            return this.f9726a;
        }

        public final a a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int i = 0;
            while (i < this.f9726a.size()) {
                if (StringsKt.equals(name, (String) this.f9726a.get(i), true)) {
                    this.f9726a.remove(i);
                    this.f9726a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final nf0 a() {
            return new nf0((String[]) this.f9726a.toArray(new String[0]), 0);
        }
    }

    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(y82.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        @JvmStatic
        public static nf0 a(Map map) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i = 0;
            int i2 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                String string = StringsKt.trim((CharSequence) str).toString();
                String string2 = StringsKt.trim((CharSequence) str2).toString();
                b(string);
                b(string2, string);
                strArr[i2] = string;
                strArr[i2 + 1] = string2;
                i2 += 2;
            }
            return new nf0(strArr, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    throw new IllegalArgumentException((y82.a("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2) + (y82.c(str2) ? "" : ": " + str)).toString());
                }
            }
        }

        @JvmStatic
        public static nf0 a(String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 == 0) {
                String[] strArr = (String[]) namesAndValues.clone();
                int length = strArr.length;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = strArr[i2];
                    if (str != null) {
                        strArr[i2] = StringsKt.trim((CharSequence) str).toString();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr.length - 1, 2);
                if (progressionLastElement >= 0) {
                    int i3 = 0;
                    while (true) {
                        String str2 = strArr[i3];
                        String str3 = strArr[i3 + 1];
                        b(str2);
                        b(str3, str2);
                        if (i3 == progressionLastElement) {
                            break;
                        }
                        i3 += 2;
                    }
                }
                return new nf0(strArr, i);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.b;
        int length = strArr.length - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement <= length) {
            while (!StringsKt.equals(name, strArr[length], true)) {
                if (length != progressionLastElement) {
                    length -= 2;
                }
            }
            return strArr[length + 1];
        }
        return null;
    }

    public final List d() {
        Intrinsics.checkNotNullParameter(HttpHeaders.SET_COOKIE, "name");
        int length = this.b.length / 2;
        ArrayList arrayList = null;
        for (int i = 0; i < length; i++) {
            if (StringsKt.equals(HttpHeaders.SET_COOKIE, this.b[i * 2], true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList == null) {
            return CollectionsKt.emptyList();
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNull(listUnmodifiableList);
        return listUnmodifiableList;
    }

    public final TreeMap c() {
        TreeMap treeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int length = this.b.length / 2;
        for (int i = 0; i < length; i++) {
            String str = this.b[i * 2];
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(b(i));
        }
        return treeMap;
    }

    @Override // java.lang.Iterable
    public final Iterator<Pair<? extends String, ? extends String>> iterator() {
        int length = this.b.length / 2;
        Pair[] pairArr = new Pair[length];
        for (int i = 0; i < length; i++) {
            pairArr[i] = TuplesKt.to(this.b[i * 2], b(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    private nf0(String[] strArr) {
        this.b = strArr;
    }

    public /* synthetic */ nf0(String[] strArr, int i) {
        this(strArr);
    }

    public final int size() {
        return this.b.length / 2;
    }

    public final String b(int i) {
        return this.b[(i * 2) + 1];
    }

    public final a b() {
        a aVar = new a();
        CollectionsKt.addAll(aVar.b(), this.b);
        return aVar;
    }

    public final String a(int i) {
        return this.b[i * 2];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof nf0) && Arrays.equals(this.b, ((nf0) obj).b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.b.length / 2;
        for (int i = 0; i < length; i++) {
            String str = this.b[i * 2];
            String strB = b(i);
            sb.append(str);
            sb.append(": ");
            if (y82.c(str)) {
                strB = "██";
            }
            sb.append(strB);
            sb.append("\n");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
