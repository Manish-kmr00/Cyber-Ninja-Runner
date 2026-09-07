package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Comparator;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0001 B-\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0014\b\u0002\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110$0#¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J'\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u001b\u0010*R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001d¨\u00060"}, d2 = {"Lcom/chartboost/sdk/impl/v2;", "Lcom/google/android/exoplayer2/upstream/cache/CacheEvictor;", "", "requiresCacheSpanTouches", "()Z", "", "onCacheInitialized", "()V", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", Reporting.EventType.CACHE, "", "key", "", com.ironsource.b9.h.L, SessionDescription.ATTR_LENGTH, "onStartFile", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;Ljava/lang/String;JJ)V", "Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;", "span", "onSpanAdded", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;)V", "onSpanRemoved", "oldSpan", "newSpan", "onSpanTouched", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;)V", "requiredSpace", "a", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;J)V", "J", "maxBytes", "Lcom/chartboost/sdk/impl/v2$b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/v2$b;", "evictUrlCallback", "Lkotlin/Function0;", "Ljava/util/TreeSet;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lkotlin/jvm/functions/Function0;", "treeSetFactory", "d", "Lkotlin/Lazy;", "()Ljava/util/TreeSet;", "leastRecentlyUsed", "e", "currentSize", "<init>", "(JLcom/chartboost/sdk/impl/v2$b;Lkotlin/jvm/functions/Function0;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class v2 implements CacheEvictor {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long maxBytes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final b evictUrlCallback;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function0<TreeSet<CacheSpan>> treeSetFactory;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy leastRecentlyUsed;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public long currentSize;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/chartboost/sdk/impl/v2$b;", "", "", "url", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public interface b {
        void c(String url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v2(long j, b evictUrlCallback, Function0<? extends TreeSet<CacheSpan>> treeSetFactory) {
        Intrinsics.checkNotNullParameter(evictUrlCallback, "evictUrlCallback");
        Intrinsics.checkNotNullParameter(treeSetFactory, "treeSetFactory");
        this.maxBytes = j;
        this.evictUrlCallback = evictUrlCallback;
        this.treeSetFactory = treeSetFactory;
        this.leastRecentlyUsed = LazyKt.lazy(new c());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan span) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(span, "span");
        a().add(span);
        this.currentSize += span.length;
        a(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan span) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(span, "span");
        a().remove(span);
        this.currentSize -= span.length;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan oldSpan, CacheSpan newSpan) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(oldSpan, "oldSpan");
        Intrinsics.checkNotNullParameter(newSpan, "newSpan");
        onSpanRemoved(cache, oldSpan);
        onSpanAdded(cache, newSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(Cache cache, String key, long position, long length) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(key, "key");
        if (length != -1) {
            a(cache, length);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public boolean requiresCacheSpanTouches() {
        return true;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/TreeSet;", "Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;", "a", "()Ljava/util/TreeSet;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<TreeSet<CacheSpan>> {
        public static final a b = new a();

        /* JADX INFO: renamed from: com.chartboost.sdk.impl.v2$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class C0264a extends FunctionReferenceImpl implements Function2<CacheSpan, CacheSpan, Integer> {
            public static final C0264a b = new C0264a();

            public C0264a() {
                super(2, w2.class, "compare", "compare(Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;)I", 1);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(CacheSpan p0, CacheSpan p1) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                return Integer.valueOf(w2.b(p0, p1));
            }
        }

        public a() {
            super(0);
        }

        public static final int a(Function2 tmp0, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Number) tmp0.invoke(obj, obj2)).intValue();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TreeSet<CacheSpan> invoke() {
            final C0264a c0264a = C0264a.b;
            return new TreeSet<>(new Comparator() { // from class: com.chartboost.sdk.impl.v2$a$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return v2.a.a(c0264a, obj, obj2);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljava/util/TreeSet;", "Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;", "a", "()Ljava/util/TreeSet;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function0<TreeSet<CacheSpan>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TreeSet<CacheSpan> invoke() {
            return (TreeSet) v2.this.treeSetFactory.invoke();
        }
    }

    public /* synthetic */ v2(long j, b bVar, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, bVar, (i & 4) != 0 ? a.b : function0);
    }

    public final void a(Cache cache, long requiredSpace) {
        while (this.currentSize + requiredSpace > this.maxBytes && !a().isEmpty()) {
            CacheSpan cacheSpanFirst = a().first();
            b7.a("evictCache() - " + cacheSpanFirst.key, (Throwable) null, 2, (Object) null);
            cache.removeSpan(cacheSpanFirst);
            b bVar = this.evictUrlCallback;
            String str = cacheSpanFirst.key;
            Intrinsics.checkNotNullExpressionValue(str, "cacheSpanToEvict.key");
            bVar.c(str);
        }
    }

    public final TreeSet<CacheSpan> a() {
        return (TreeSet) this.leastRecentlyUsed.getValue();
    }
}
