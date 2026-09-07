package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    public static final class a extends c {
        public static final int b = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f6614a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(null);
            Intrinsics.checkNotNullParameter(file, "file");
            this.f6614a = file;
        }

        public final File a() {
            return this.f6614a;
        }

        public final File b() {
            return this.f6614a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f6614a, ((a) obj).f6614a);
        }

        public int hashCode() {
            return this.f6614a.hashCode();
        }

        public String toString() {
            return "Complete(file=" + this.f6614a + ')';
        }

        public final a a(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new a(file);
        }

        public static /* synthetic */ a a(a aVar, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = aVar.f6614a;
            }
            return aVar.a(file);
        }
    }

    public static final class b extends c {
        public static final int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i.a.AbstractC0600a f6615a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i.a.AbstractC0600a failure) {
            super(null);
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.f6615a = failure;
        }

        public final i.a.AbstractC0600a a() {
            return this.f6615a;
        }

        public final i.a.AbstractC0600a b() {
            return this.f6615a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f6615a, ((b) obj).f6615a);
        }

        public int hashCode() {
            return this.f6615a.hashCode();
        }

        public String toString() {
            return "Failure(failure=" + this.f6615a + ')';
        }

        public final b a(i.a.AbstractC0600a failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new b(failure);
        }

        public static /* synthetic */ b a(b bVar, i.a.AbstractC0600a abstractC0600a, int i, Object obj) {
            if ((i & 1) != 0) {
                abstractC0600a = bVar.f6615a;
            }
            return bVar.a(abstractC0600a);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c$c, reason: collision with other inner class name */
    public static final class C0605c extends c {
        public static final int c = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f6616a;
        public final d b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0605c(File file, d progress) {
            super(null);
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.f6616a = file;
            this.b = progress;
        }

        public final File a() {
            return this.f6616a;
        }

        public final d b() {
            return this.b;
        }

        public final File c() {
            return this.f6616a;
        }

        public final d d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0605c)) {
                return false;
            }
            C0605c c0605c = (C0605c) obj;
            return Intrinsics.areEqual(this.f6616a, c0605c.f6616a) && Intrinsics.areEqual(this.b, c0605c.b);
        }

        public int hashCode() {
            return (this.f6616a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "InProgress(file=" + this.f6616a + ", progress=" + this.b + ')';
        }

        public final C0605c a(File file, d progress) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(progress, "progress");
            return new C0605c(file, progress);
        }

        public static /* synthetic */ C0605c a(C0605c c0605c, File file, d dVar, int i, Object obj) {
            if ((i & 1) != 0) {
                file = c0605c.f6616a;
            }
            if ((i & 2) != 0) {
                dVar = c0605c.b;
            }
            return c0605c.a(file, dVar);
        }
    }

    public static final class d {
        public static final int c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f6617a;
        public final long b;

        public d(long j, long j2) {
            this.f6617a = j;
            this.b = j2;
        }

        public final long a() {
            return this.f6617a;
        }

        public final long b() {
            return this.b;
        }

        public final long c() {
            return this.f6617a;
        }

        public final long d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f6617a == dVar.f6617a && this.b == dVar.b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f6617a) * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "Progress(bytesDownloaded=" + this.f6617a + ", totalBytes=" + this.b + ')';
        }

        public final d a(long j, long j2) {
            return new d(j, j2);
        }

        public static /* synthetic */ d a(d dVar, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = dVar.f6617a;
            }
            if ((i & 2) != 0) {
                j2 = dVar.b;
            }
            return dVar.a(j, j2);
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public c() {
    }
}
