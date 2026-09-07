package com.moloco.sdk.internal.publisher.nativead.model;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {
    public static final int g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6237a;
    public final List<a> b;
    public final c c;
    public final List<String> d;
    public final List<C0550b> e;
    public final String f;

    public static abstract class a {
        public static final int c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6238a;
        public final boolean b;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.b$a$a, reason: collision with other inner class name */
        public static final class C0548a extends a {
            public static final int g = 0;
            public final Integer d;
            public final Integer e;
            public final String f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0548a(int i, boolean z, Integer num, Integer num2, String value) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.d = num;
                this.e = num2;
                this.f = value;
            }

            public final Integer c() {
                return this.e;
            }

            public final Integer d() {
                return this.d;
            }

            public final String e() {
                return this.f;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.b$a$b, reason: collision with other inner class name */
        public static final class C0549b extends a {
            public static final int h = 0;
            public final Integer d;
            public final String e;
            public final Integer f;
            public final Integer g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0549b(int i, boolean z, Integer num, String url, Integer num2, Integer num3) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.d = num;
                this.e = url;
                this.f = num2;
                this.g = num3;
            }

            public final Integer c() {
                return this.g;
            }

            public final Integer d() {
                return this.d;
            }

            public final String e() {
                return this.e;
            }

            public final Integer f() {
                return this.f;
            }
        }

        public static final class c extends a {
            public static final int f = 0;
            public final String d;
            public final Integer e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(int i, boolean z, String text, Integer num) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.d = text;
                this.e = num;
            }

            public final Integer c() {
                return this.e;
            }

            public final String d() {
                return this.d;
            }
        }

        public static final class d extends a {
            public static final int e = 0;
            public final String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(int i, boolean z, String vastTag) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(vastTag, "vastTag");
                this.d = vastTag;
            }

            public final String c() {
                return this.d;
            }
        }

        public /* synthetic */ a(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z);
        }

        public final int a() {
            return this.f6238a;
        }

        public final boolean b() {
            return this.b;
        }

        public a(int i, boolean z) {
            this.f6238a = i;
            this.b = z;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.model.b$b, reason: collision with other inner class name */
    public static final class C0550b {
        public static final int d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6239a;
        public final int b;
        public final String c;

        public C0550b(int i, int i2, String str) {
            this.f6239a = i;
            this.b = i2;
            this.c = str;
        }

        public final int a() {
            return this.f6239a;
        }

        public final int b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }
    }

    public static final class c {
        public static final int d = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6240a;
        public final List<String> b;
        public final String c;

        public c(String url, List<String> clickTrackerUrls, String str) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(clickTrackerUrls, "clickTrackerUrls");
            this.f6240a = url;
            this.b = clickTrackerUrls;
            this.c = str;
        }

        public final List<String> a() {
            return this.b;
        }

        public final String b() {
            return this.c;
        }

        public final String c() {
            return this.f6240a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String str, List<? extends a> assets, c cVar, List<String> impressionTrackerUrls, List<C0550b> eventTrackers, String str2) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(impressionTrackerUrls, "impressionTrackerUrls");
        Intrinsics.checkNotNullParameter(eventTrackers, "eventTrackers");
        this.f6237a = str;
        this.b = assets;
        this.c = cVar;
        this.d = impressionTrackerUrls;
        this.e = eventTrackers;
        this.f = str2;
    }

    public final List<a> a() {
        return this.b;
    }

    public final List<C0550b> b() {
        return this.e;
    }

    public final List<String> c() {
        return this.d;
    }

    public final c d() {
        return this.c;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.f6237a;
    }
}
