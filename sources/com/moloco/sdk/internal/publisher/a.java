package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements r {
    public static final C0540a d = new C0540a(null);
    public static final String e = "AdCreateLoadTimeoutManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdFormatType f6162a;
    public final long b;
    public long c;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.a$a, reason: collision with other inner class name */
    public static final class C0540a {
        public /* synthetic */ C0540a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0540a() {
        }
    }

    public /* synthetic */ a(AdFormatType adFormatType, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(adFormatType, j);
    }

    public final long a(long j) {
        long createAdObjectStartTime = j - getCreateAdObjectStartTime();
        long duration = DurationKt.toDuration(Duration.m9250getInWholeMillisecondsimpl(this.b) - createAdObjectStartTime, DurationUnit.MILLISECONDS);
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, e, this.f6162a + " timeout: " + ((Object) Duration.m9281toStringimpl(this.b)) + " , create ad duration: " + createAdObjectStartTime + " ms (createTime: " + getCreateAdObjectStartTime() + " ms, loadStartTime: " + j + " ms). Return value: " + ((Object) Duration.m9281toStringimpl(duration)), false, 4, null);
        return duration;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.c;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.c = j;
    }

    public a(AdFormatType adFormatType, long j) {
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        this.f6162a = adFormatType;
        this.b = j;
    }
}
