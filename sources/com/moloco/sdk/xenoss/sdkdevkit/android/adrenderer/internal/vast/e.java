package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.common_adapter_internal.ScreenData;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.bidmachine.protobuf.EventTypeExtended;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRequestTimeoutException;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d {
    public static final c i = new c(null);
    public static final long j = 5000;
    public static final int k = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i f6801a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l d;
    public final u e;
    public final HttpClient f;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.o g;
    public final String h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> f6802a;
        public final List<String> b;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> impressions, List<String> errorUrls, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            this.f6802a = impressions;
            this.b = errorUrls;
            this.c = creativesPerWrapper;
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> a() {
            return this.f6802a;
        }

        public final List<String> b() {
            return this.b;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> c() {
            return this.c;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> d() {
            return this.c;
        }

        public final List<String> e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f6802a, aVar.f6802a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> f() {
            return this.f6802a;
        }

        public int hashCode() {
            return (((this.f6802a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AggregatedWrapperChainAdData(impressions=" + this.f6802a + ", errorUrls=" + this.b + ", creativesPerWrapper=" + this.c + ')';
        }

        public final a a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> impressions, List<String> errorUrls, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> creativesPerWrapper) {
            Intrinsics.checkNotNullParameter(impressions, "impressions");
            Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
            Intrinsics.checkNotNullParameter(creativesPerWrapper, "creativesPerWrapper");
            return new a(impressions, errorUrls, creativesPerWrapper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a a(a aVar, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = aVar.f6802a;
            }
            if ((i & 2) != 0) {
                list2 = aVar.b;
            }
            if ((i & 4) != 0) {
                list3 = aVar.c;
            }
            return aVar.a(list, list2, list3);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> f6803a;
        public final a0 b;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> c;
        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> linearTrackingList, a0 a0Var, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> iconsPerWrapper, List<? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> companionsPerWrapper) {
            Intrinsics.checkNotNullParameter(linearTrackingList, "linearTrackingList");
            Intrinsics.checkNotNullParameter(iconsPerWrapper, "iconsPerWrapper");
            Intrinsics.checkNotNullParameter(companionsPerWrapper, "companionsPerWrapper");
            this.f6803a = linearTrackingList;
            this.b = a0Var;
            this.c = iconsPerWrapper;
            this.d = companionsPerWrapper;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>> a() {
            return this.d;
        }

        public final List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>> b() {
            return this.c;
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> c() {
            return this.f6803a;
        }

        public final a0 d() {
            return this.b;
        }
    }

    public static final class c {
        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public c() {
        }

        public final boolean a(String str) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return Intrinsics.areEqual(lowerCase, "video/mp4") || Intrinsics.areEqual(lowerCase, "video/3gpp") || Intrinsics.areEqual(lowerCase, "video/webm");
        }

        public final List<String> a(Map<v, ? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> map, v vVar) {
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list = map.get(vVar);
            if (list != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) it.next()).f());
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g> a(Map<v, ? extends List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>> map) {
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list = map.get(v.Progress);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u uVar : list) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g gVar = uVar.e() == null ? null : new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.g(uVar.f(), uVar.e());
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final List<String> a(a0 a0Var) {
            List<z> listB;
            if (a0Var != null && (listB = a0Var.b()) != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
                Iterator<T> it = listB.iterator();
                while (it.hasNext()) {
                    arrayList.add(((z) it.next()).b());
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar) {
            String strG = gVar.g();
            return !(strG == null || StringsKt.isBlank(strG));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar) {
            String strC = eVar.c();
            return !(strC == null || StringsKt.isBlank(strC));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar) {
            String strA = qVar.a();
            return !(strA == null || StringsKt.isBlank(strA));
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar) {
            String strA = lVar.a();
            return !(strA == null || StringsKt.isBlank(strA));
        }

        public final <T> Set<T> a(Set<? extends T> set, T t) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                CollectionsKt.addAll(linkedHashSet, set);
            }
            if (t != null) {
                linkedHashSet.add(t);
            }
            return linkedHashSet;
        }

        public final <T> List<T> a(List<? extends T> list, List<? extends T> list2) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                CollectionsKt.addAll(arrayList, list);
            }
            if (list2 != null) {
                CollectionsKt.addAll(arrayList, list2);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> List<T> a(List<? extends T> list, T t) {
            List<T> listA;
            if (t == null || (listA = e.i.a((List) list, (List) CollectionsKt.listOf(t))) == null) {
                return list == 0 ? CollectionsKt.emptyList() : list;
            }
            return listA;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list, a0 a0Var) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                v vVarD = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) obj).d();
                Object arrayList = linkedHashMap.get(vVarD);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(vVarD, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.h(a(a0Var), a(linkedHashMap, v.CreativeView), a(linkedHashMap, v.Start), a(linkedHashMap, v.FirstQuartile), a(linkedHashMap, v.Midpoint), a(linkedHashMap, v.ThirdQuartile), a(linkedHashMap, v.Complete), a(linkedHashMap, v.Mute), a(linkedHashMap, v.UnMute), a(linkedHashMap, v.Pause), a(linkedHashMap, v.Resume), a(linkedHashMap, v.Rewind), a(linkedHashMap, v.Skip), a(linkedHashMap, v.CloseLinear), a(linkedHashMap));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6804a;
        public final Set<String> b;
        public final boolean c;
        public final a d;

        public d(int i, Set<String> usedVastAdTagUrls, boolean z, a aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            this.f6804a = i;
            this.b = usedVastAdTagUrls;
            this.c = z;
            this.d = aggregatedWrapperChainData;
        }

        public final int a() {
            return this.f6804a;
        }

        public final Set<String> b() {
            return this.b;
        }

        public final boolean c() {
            return this.c;
        }

        public final a d() {
            return this.d;
        }

        public final a e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f6804a == dVar.f6804a && Intrinsics.areEqual(this.b, dVar.b) && this.c == dVar.c && Intrinsics.areEqual(this.d, dVar.d);
        }

        public final boolean f() {
            return this.c;
        }

        public final Set<String> g() {
            return this.b;
        }

        public final int h() {
            return this.f6804a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.f6804a) * 31) + this.b.hashCode()) * 31;
            boolean z = this.c;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return ((iHashCode + r1) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "WrapperChainParams(wrapperDepth=" + this.f6804a + ", usedVastAdTagUrls=" + this.b + ", followAdditionalWrappers=" + this.c + ", aggregatedWrapperChainData=" + this.d + ')';
        }

        public final d a(int i, Set<String> usedVastAdTagUrls, boolean z, a aggregatedWrapperChainData) {
            Intrinsics.checkNotNullParameter(usedVastAdTagUrls, "usedVastAdTagUrls");
            Intrinsics.checkNotNullParameter(aggregatedWrapperChainData, "aggregatedWrapperChainData");
            return new d(i, usedVastAdTagUrls, z, aggregatedWrapperChainData);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ d a(d dVar, int i, Set set, boolean z, a aVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = dVar.f6804a;
            }
            if ((i2 & 2) != 0) {
                set = dVar.b;
            }
            if ((i2 & 4) != 0) {
                z = dVar.c;
            }
            if ((i2 & 8) != 0) {
                aVar = dVar.d;
            }
            return dVar.a(i, set, z, aVar);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$e, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0}, l = {152, 163}, m = "invoke", n = {"this", "mtid", "isStreamingEnabled"}, s = {"L$0", "L$1", "Z$0"})
    public static final class C0641e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6805a;
        public Object b;
        public boolean c;
        public /* synthetic */ Object d;
        public int f;

        public C0641e(Continuation<? super C0641e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return e.this.a((String) null, (String) null, false, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$invoke$renderAdResult$1", f = "VastAdLoader.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6806a;
        public final /* synthetic */ w c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(w wVar, boolean z, String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = wVar;
            this.d = z;
            this.e = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new f(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6806a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e eVar = e.this;
                w wVar = this.c;
                double dB = eVar.b();
                ScreenData screenDataInvoke = e.this.g.invoke();
                boolean z = this.d;
                String str = this.e;
                this.f6806a = 1;
                obj = eVar.a(wVar, (d) null, dB, screenDataInvoke, z, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 1, 1, 2, 2}, l = {EventTypeExtended.EVENT_TYPE_EXTENDED_NURL_VALUE, 356, 367}, m = "loadAndParseWrapperVastDocument", n = {"this", "vastErrorUrls", "this", "vastErrorUrls", "this", "vastErrorUrls"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6807a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((b0) null, (List<String>) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {418}, m = "tryLoadInLineRenderAd", n = {"this", POBCommonConstants.BANNER_PLACEMENT_TYPE, "aggregatedWrapperChainData", "screenData", "mtid", "aggregatedErrorUrls", "preparedWrapperDataForInline$delegate", "renderLinearNullable", "renderCompanion", "renderLinearError", Reporting.Key.CREATIVE, "targetLinearFileSizeInMegabytes", "isStreamingEnabled"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "D$0", "Z$0"})
    public static final class h extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6808a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public Object k;
        public Object l;
        public double m;
        public boolean n;
        public /* synthetic */ Object o;
        public int q;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.o = obj;
            this.q |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o) null, (a) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    public static final class i extends Lambda implements Function1<List<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c> {
        public final /* synthetic */ ScreenData b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(ScreenData screenData) {
            super(1);
            this.b = screenData;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c invoke(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return e.this.a(it, this.b);
        }
    }

    public static final class j extends Lambda implements Function1<List<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e invoke(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return e.this.a(it);
        }
    }

    public static final class k extends Lambda implements Function0<b> {
        public final /* synthetic */ a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a aVar) {
            super(0);
            this.b = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return e.this.a(this.b);
        }
    }

    public static final class l implements Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f6812a;
        public final /* synthetic */ e b;
        public final /* synthetic */ d c;
        public final /* synthetic */ double d;
        public final /* synthetic */ ScreenData e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Ref.ObjectRef h;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f6813a;
            public final /* synthetic */ e b;
            public final /* synthetic */ d c;
            public final /* synthetic */ double d;
            public final /* synthetic */ ScreenData e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ String g;
            public final /* synthetic */ Ref.ObjectRef h;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$l$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryLoadVastRenderAd$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", i = {0, 0, 1, 1}, l = {227, 238, 258}, m = "emit", n = {"this", "$this$mapNotNull_u24lambda_u246", "this", "$this$mapNotNull_u24lambda_u246"}, s = {"L$0", "L$1", "L$0", "L$1"})
            public static final class C0642a extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f6814a;
                public int b;
                public Object c;
                public Object e;

                public C0642a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6814a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, e eVar, d dVar, double d, ScreenData screenData, boolean z, String str, Ref.ObjectRef objectRef) {
                this.f6813a = flowCollector;
                this.b = eVar;
                this.c = dVar;
                this.d = d;
                this.e = screenData;
                this.f = z;
                this.g = str;
                this.h = objectRef;
            }

            /* JADX WARN: Code duplicated, block: B:38:0x0101  */
            /* JADX WARN: Code duplicated, block: B:39:0x0133  */
            /* JADX WARN: Code duplicated, block: B:41:0x0137  */
            /* JADX WARN: Code duplicated, block: B:43:0x0141  */
            /* JADX WARN: Code duplicated, block: B:45:0x014d A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:48:0x0151  */
            /* JADX WARN: Code duplicated, block: B:7:0x0017  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) throws Throwable {
                C0642a c0642a;
                a<T> aVar;
                FlowCollector flowCollector;
                com.moloco.sdk.internal.v vVar;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar2;
                if (continuation instanceof C0642a) {
                    c0642a = (C0642a) continuation;
                    int i = c0642a.b;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c0642a.b = i - Integer.MIN_VALUE;
                    } else {
                        c0642a = new C0642a(continuation);
                    }
                } else {
                    c0642a = new C0642a(continuation);
                }
                Object obj2 = c0642a.f6814a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = c0642a.b;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    FlowCollector flowCollector2 = this.f6813a;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b bVarA = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a) obj).a();
                    if (bVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b.C0645b) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.b.h, "Found Wrapper child element, trying load wrapper render Ad", null, false, 12, null);
                        e eVar = this.b;
                        b0 b0VarA = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b.C0645b) bVarA).a();
                        d dVar = this.c;
                        double d = this.d;
                        ScreenData screenData = this.e;
                        boolean z = this.f;
                        String str = this.g;
                        c0642a.c = this;
                        c0642a.e = flowCollector2;
                        c0642a.b = 1;
                        Object objA = eVar.a(b0VarA, dVar, d, screenData, z, str, c0642a);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = this;
                        flowCollector = flowCollector2;
                        obj2 = objA;
                        vVar = (com.moloco.sdk.internal.v) obj2;
                        if (vVar instanceof com.moloco.sdk.internal.v.a) {
                            com.moloco.sdk.internal.v.a aVar3 = (com.moloco.sdk.internal.v.a) vVar;
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, aVar.b.h, "Failed to load the ad with error: " + aVar3.a(), null, false, 12, null);
                            aVar.h.element = (T) aVar3.a();
                            aVar2 = null;
                        } else {
                            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                                throw new NoWhenBranchMatchedException();
                            }
                            aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar).a();
                        }
                        if (aVar2 != null) {
                            c0642a.c = null;
                            c0642a.e = null;
                            c0642a.b = 3;
                            if (flowCollector.emit(aVar2, c0642a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (!(bVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.b.h, "Found InLine child element, trying load render Ad", null, false, 12, null);
                        e eVar2 = this.b;
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o oVarA = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b.a) bVarA).a();
                        d dVar2 = this.c;
                        a aVarE = dVar2 != null ? dVar2.e() : null;
                        double d2 = this.d;
                        ScreenData screenData2 = this.e;
                        boolean z2 = this.f;
                        String str2 = this.g;
                        c0642a.c = this;
                        c0642a.e = flowCollector2;
                        c0642a.b = 2;
                        Object objA2 = eVar2.a(oVarA, aVarE, d2, screenData2, z2, str2, c0642a);
                        if (objA2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = this;
                        flowCollector = flowCollector2;
                        obj2 = objA2;
                        vVar = (com.moloco.sdk.internal.v) obj2;
                        if (vVar instanceof com.moloco.sdk.internal.v.a) {
                            com.moloco.sdk.internal.v.a aVar4 = (com.moloco.sdk.internal.v.a) vVar;
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, aVar.b.h, "Failed to load the ad with error: " + aVar4.a(), null, false, 12, null);
                            aVar.h.element = (T) aVar4.a();
                            aVar2 = null;
                        } else {
                            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                                throw new NoWhenBranchMatchedException();
                            }
                            aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar).a();
                        }
                        if (aVar2 != null) {
                            c0642a.c = null;
                            c0642a.e = null;
                            c0642a.b = 3;
                            if (flowCollector.emit(aVar2, c0642a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                } else if (i2 == 1) {
                    flowCollector = (FlowCollector) c0642a.e;
                    aVar = (a) c0642a.c;
                    ResultKt.throwOnFailure(obj2);
                    vVar = (com.moloco.sdk.internal.v) obj2;
                    if (vVar instanceof com.moloco.sdk.internal.v.a) {
                        com.moloco.sdk.internal.v.a aVar5 = (com.moloco.sdk.internal.v.a) vVar;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, aVar.b.h, "Failed to load the ad with error: " + aVar5.a(), null, false, 12, null);
                        aVar.h.element = (T) aVar5.a();
                        aVar2 = null;
                    } else {
                        if (vVar instanceof com.moloco.sdk.internal.v.b) {
                            throw new NoWhenBranchMatchedException();
                        }
                        aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar).a();
                    }
                    if (aVar2 != null) {
                        c0642a.c = null;
                        c0642a.e = null;
                        c0642a.b = 3;
                        if (flowCollector.emit(aVar2, c0642a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i2 == 2) {
                    flowCollector = (FlowCollector) c0642a.e;
                    aVar = (a) c0642a.c;
                    ResultKt.throwOnFailure(obj2);
                    vVar = (com.moloco.sdk.internal.v) obj2;
                    if (vVar instanceof com.moloco.sdk.internal.v.a) {
                        com.moloco.sdk.internal.v.a aVar6 = (com.moloco.sdk.internal.v.a) vVar;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, aVar.b.h, "Failed to load the ad with error: " + aVar6.a(), null, false, 12, null);
                        aVar.h.element = (T) aVar6.a();
                        aVar2 = null;
                    } else {
                        if (vVar instanceof com.moloco.sdk.internal.v.b) {
                            throw new NoWhenBranchMatchedException();
                        }
                        aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((com.moloco.sdk.internal.v.b) vVar).a();
                    }
                    if (aVar2 != null) {
                        c0642a.c = null;
                        c0642a.e = null;
                        c0642a.b = 3;
                        if (flowCollector.emit(aVar2, c0642a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj2);
                }
                return Unit.INSTANCE;
            }
        }

        public l(Flow flow, e eVar, d dVar, double d, ScreenData screenData, boolean z, String str, Ref.ObjectRef objectRef) {
            this.f6812a = flow;
            this.b = eVar;
            this.c = dVar;
            this.d = d;
            this.e = screenData;
            this.f = z;
            this.g = str;
            this.h = objectRef;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a> flowCollector, Continuation continuation) {
            Object objCollect = this.f6812a.collect(new a(flowCollector, this.b, this.c, this.d, this.e, this.f, this.g, this.h), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    public static final class m<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a) t).c(), ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a) t2).c());
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0}, l = {280}, m = "tryLoadVastRenderAd", n = {"this", "adLoadError"}, s = {"L$0", "L$1"})
    public static final class n extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6815a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public n(Continuation<? super n> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((w) null, (d) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {311, 328}, m = "tryLoadWrapperRenderAd", n = {"this", POBConstants.KEY_WRAPPER, "wrapperChainParams", "screenData", "mtid", "aggregatedErrorUrls", "targetLinearFileSizeInMegabytes", "isStreamingEnabled", "currentWrapperDepth"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "D$0", "Z$0", "I$0"})
    public static final class o extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6816a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public double g;
        public boolean h;
        public int i;
        public /* synthetic */ Object j;
        public int l;

        public o(Continuation<? super o> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return e.this.a((b0) null, (d) null, 0.0d, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    public static final class p implements Flow<Pair<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q, ? extends File>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f6817a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Ref.ObjectRef e;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f6818a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ e c;
            public final /* synthetic */ String d;
            public final /* synthetic */ Ref.ObjectRef e;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$p$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$tryPrepareInLineRenderLinear$$inlined$mapNotNull$1$2", f = "VastAdLoader.kt", i = {0, 0, 0, 1, 1, 1}, l = {226, 244, 252}, m = "emit", n = {"this", "$this$mapNotNull_u24lambda_u246", "vastMediaFile", "this", "$this$mapNotNull_u24lambda_u246", "vastMediaFile"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
            public static final class C0643a extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f6819a;
                public int b;
                public Object c;
                public Object e;
                public Object f;

                public C0643a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6819a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, boolean z, e eVar, String str, Ref.ObjectRef objectRef) {
                this.f6818a = flowCollector;
                this.b = z;
                this.c = eVar;
                this.d = str;
                this.e = objectRef;
            }

            /* JADX WARN: Code duplicated, block: B:26:0x0087  */
            /* JADX WARN: Code duplicated, block: B:27:0x0092  */
            /* JADX WARN: Code duplicated, block: B:29:0x0096  */
            /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
            /* JADX WARN: Code duplicated, block: B:32:0x00a5  */
            /* JADX WARN: Code duplicated, block: B:33:0x00b4  */
            /* JADX WARN: Code duplicated, block: B:41:0x00da  */
            /* JADX WARN: Code duplicated, block: B:42:0x00e5  */
            /* JADX WARN: Code duplicated, block: B:44:0x00e9  */
            /* JADX WARN: Code duplicated, block: B:47:0x00f6  */
            /* JADX WARN: Code duplicated, block: B:49:0x0104 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:52:0x0108  */
            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) throws Throwable {
                C0643a c0643a;
                FlowCollector flowCollector;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar;
                a<T> aVar;
                a<T> aVar2;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar;
                Pair pair;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a aVar3;
                if (continuation instanceof C0643a) {
                    c0643a = (C0643a) continuation;
                    int i = c0643a.b;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c0643a.b = i - Integer.MIN_VALUE;
                    } else {
                        c0643a = new C0643a(continuation);
                    }
                } else {
                    c0643a = new C0643a(continuation);
                }
                Object objA = c0643a.f6819a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = c0643a.b;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objA);
                    flowCollector = this.f6818a;
                    qVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) obj;
                    if (this.b) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i iVar = this.c.c;
                        String strG = qVar.g();
                        String str = this.d;
                        c0643a.c = this;
                        c0643a.e = flowCollector;
                        c0643a.f = qVar;
                        c0643a.b = 1;
                        objA = iVar.a(strG, str, c0643a);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar2 = this;
                        cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) objA;
                        if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) {
                            pair = TuplesKt.to(qVar, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) cVar).b());
                        } else if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) {
                            pair = TuplesKt.to(qVar, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) cVar).c());
                        } else {
                            if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b) {
                                throw new NoWhenBranchMatchedException();
                            }
                            aVar2.e.element = (T) com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b) cVar).b());
                            pair = null;
                        }
                        if (pair != null) {
                            c0643a.c = null;
                            c0643a.e = null;
                            c0643a.f = null;
                            c0643a.b = 3;
                            if (flowCollector.emit(pair, c0643a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i iVar2 = this.c.c;
                        String strG2 = qVar.g();
                        c0643a.c = this;
                        c0643a.e = flowCollector;
                        c0643a.f = qVar;
                        c0643a.b = 2;
                        objA = iVar2.a(strG2, c0643a);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = this;
                        aVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a) objA;
                        if (aVar3 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b) {
                            pair = TuplesKt.to(qVar, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b) aVar3).a());
                        } else {
                            if (aVar3 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a) {
                                throw new NoWhenBranchMatchedException();
                            }
                            aVar.e.element = (T) com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a) aVar3);
                            pair = null;
                        }
                        if (pair != null) {
                            c0643a.c = null;
                            c0643a.e = null;
                            c0643a.f = null;
                            c0643a.b = 3;
                            if (flowCollector.emit(pair, c0643a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                } else if (i2 == 1) {
                    qVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) c0643a.f;
                    flowCollector = (FlowCollector) c0643a.e;
                    aVar2 = (a) c0643a.c;
                    ResultKt.throwOnFailure(objA);
                    cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) objA;
                    if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) {
                        pair = TuplesKt.to(qVar, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) cVar).b());
                    } else if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) {
                        pair = TuplesKt.to(qVar, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) cVar).c());
                    } else {
                        if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b) {
                            throw new NoWhenBranchMatchedException();
                        }
                        aVar2.e.element = (T) com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b) cVar).b());
                        pair = null;
                    }
                    if (pair != null) {
                        c0643a.c = null;
                        c0643a.e = null;
                        c0643a.f = null;
                        c0643a.b = 3;
                        if (flowCollector.emit(pair, c0643a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i2 == 2) {
                    qVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) c0643a.f;
                    flowCollector = (FlowCollector) c0643a.e;
                    aVar = (a) c0643a.c;
                    ResultKt.throwOnFailure(objA);
                    aVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a) objA;
                    if (aVar3 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b) {
                        pair = TuplesKt.to(qVar, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b) aVar3).a());
                    } else {
                        if (aVar3 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a) {
                            throw new NoWhenBranchMatchedException();
                        }
                        aVar.e.element = (T) com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.AbstractC0600a) aVar3);
                        pair = null;
                    }
                    if (pair != null) {
                        c0643a.c = null;
                        c0643a.e = null;
                        c0643a.f = null;
                        c0643a.b = 3;
                        if (flowCollector.emit(pair, c0643a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objA);
                }
                return Unit.INSTANCE;
            }
        }

        public p(Flow flow, boolean z, e eVar, String str, Ref.ObjectRef objectRef) {
            this.f6817a = flow;
            this.b = z;
            this.c = eVar;
            this.d = str;
            this.e = objectRef;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super Pair<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q, ? extends File>> flowCollector, Continuation continuation) {
            Object objCollect = this.f6817a.collect(new a(flowCollector, this.b, this.c, this.d, this.e), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0, 0, 0, 0}, l = {565}, m = "tryPrepareInLineRenderLinear", n = {"this", "linear", "wrapperLinearTrackingList", "wrapperVideoClicks", "vastError"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class q extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6820a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int h;

        public q(Continuation<? super q> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p) null, (List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>) null, (a0) null, (List<String>) null, 0.0d, (Long) null, (ScreenData) null, false, (String) null, (Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl", f = "VastAdLoader.kt", i = {0, 0}, l = {95}, m = "waitForAdLoadToStart-8Mi8wO0", n = {"this", Reporting.Key.CLICK_SOURCE_TYPE_AD}, s = {"L$0", "L$1"})
    public static final class r extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6821a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public r(Continuation<? super r> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) null, 0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1", f = "VastAdLoader.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    public static final class s extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6822a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastAdLoaderImpl$waitForAdLoadToStart$streamStatus$1$1", f = "VastAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6823a;
            public /* synthetic */ Object b;
            public final /* synthetic */ e c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar, Continuation<? super Boolean> continuation) {
                return ((a) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.c, continuation);
                aVar.b = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6823a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) this.b;
                if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c c0605c = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.C0605c) cVar;
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, this.c.h, "Stream status: " + c0605c.d().c() + '/' + c0605c.d().d() + " bytes downloaded", null, false, 12, null);
                }
                return Boxing.boxBoolean((cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) || (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, Continuation<? super s> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((s) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new s(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6822a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowB = e.this.c.b(this.c.j().l());
                a aVar = new a(e.this, null);
                this.f6822a = 1;
                obj = FlowKt.firstOrNull(flowB, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i parseVast, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l mediaConfig, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i mediaCacheRepository, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l vastTracker, u connectivityService, HttpClient httpClient, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.o screenService) {
        Intrinsics.checkNotNullParameter(parseVast, "parseVast");
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(screenService, "screenService");
        this.f6801a = parseVast;
        this.b = mediaConfig;
        this.c = mediaCacheRepository;
        this.d = vastTracker;
        this.e = connectivityService;
        this.f = httpClient;
        this.g = screenService;
        this.h = "VastAdLoaderImpl";
    }

    public final double a(long j2, int i2) {
        return (j2 * ((long) 8)) / ((double) (i2 * 1000));
    }

    public final double b() {
        return !this.e.b() ? 10.0d : 2.0d;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    public Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, long j2, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) throws Throwable {
        r rVar;
        e eVar;
        if (continuation instanceof r) {
            rVar = (r) continuation;
            int i2 = rVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rVar.e = i2 - Integer.MIN_VALUE;
            } else {
                rVar = new r(continuation);
            }
        } else {
            rVar = new r(continuation);
        }
        Object objM9406withTimeoutOrNullKLykuaI = rVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = rVar.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objM9406withTimeoutOrNullKLykuaI);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Waiting for " + ((Object) Duration.m9281toStringimpl(j2)) + " to load the vast media file: " + this.c, null, false, 12, null);
            s sVar = new s(aVar, null);
            rVar.f6821a = this;
            rVar.b = aVar;
            rVar.e = 1;
            objM9406withTimeoutOrNullKLykuaI = TimeoutKt.m9406withTimeoutOrNullKLykuaI(j2, sVar, rVar);
            if (objM9406withTimeoutOrNullKLykuaI == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar = this;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) rVar.b;
            eVar = (e) rVar.f6821a;
            ResultKt.throwOnFailure(objM9406withTimeoutOrNullKLykuaI);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) objM9406withTimeoutOrNullKLykuaI;
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, eVar.h, "Either timeout occurred or media file streaming had terminal status", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, eVar.h, "Stream status: " + cVar + " on timeout", null, false, 12, null);
        if (cVar == null) {
            File fileJ = aVar.j().j();
            if (fileJ.exists() && fileJ.length() != 0) {
                MolocoLogger.info$default(molocoLogger, eVar.h, "Local vast media resource exists and has some content. Checking for bitrate information", null, false, 12, null);
                if (aVar.j().k() != null) {
                    MolocoLogger.info$default(molocoLogger, eVar.h, "Checking for playability of VAST ad with bitrate: " + aVar.j().k(), null, false, 12, null);
                    double dA = eVar.a(fileJ.length(), aVar.j().k().intValue());
                    MolocoLogger.info$default(molocoLogger, eVar.h, "VAST ad has playable duration: " + dA + " seconds", null, false, 12, null);
                    if (dA < eVar.b.g()) {
                        MolocoLogger.error$default(molocoLogger, eVar.h, "VAST does not have enough playable duration, so failing ", null, false, 12, null);
                        return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_TIMEOUT_NOT_ENOUGH_PLAYABLE_ERROR);
                    }
                } else {
                    MolocoLogger.info$default(molocoLogger, eVar.h, "VAST ad playable duration cannot be determined due to no bitrate information", null, false, 12, null);
                    return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_UNABLE_TO_DETERMINE_TIMEOUT_ERROR);
                }
            } else {
                MolocoLogger.error$default(molocoLogger, eVar.h, fileJ.getAbsolutePath() + " does not exist or is empty", null, false, 12, null);
                MolocoLogger.error$default(molocoLogger, eVar.h, "Failed to start streaming media file, reporting timeout error", null, false, 12, null);
                return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_TIMEOUT_ERROR);
            }
        } else {
            if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.a) {
                MolocoLogger.info$default(molocoLogger, eVar.h, "Streamed entire file successfully", null, false, 12, null);
                return new com.moloco.sdk.internal.v.b(aVar);
            }
            if (cVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b) {
                MolocoLogger.info$default(molocoLogger, eVar.h, "Failed to stream file", null, false, 12, null);
                return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.h.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c.b) cVar).b()));
            }
        }
        MolocoLogger.info$default(molocoLogger, eVar.h, "Media file partially exists and ready for streaming", null, false, 12, null);
        return new com.moloco.sdk.internal.v.b(aVar);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d
    public Object a(String str, String str2, boolean z, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) throws Throwable {
        C0641e c0641e;
        String str3;
        boolean z2;
        e eVar;
        com.moloco.sdk.internal.v vVar;
        if (continuation instanceof C0641e) {
            c0641e = (C0641e) continuation;
            int i2 = c0641e.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0641e.f = i2 - Integer.MIN_VALUE;
            } else {
                c0641e = new C0641e(continuation);
            }
        } else {
            c0641e = new C0641e(continuation);
        }
        Object objA = c0641e.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c0641e.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objA);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i iVar = this.f6801a;
            c0641e.f6805a = this;
            c0641e.b = str2;
            c0641e.c = z;
            c0641e.f = 1;
            objA = iVar.a(str, c0641e);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            str3 = str2;
            z2 = z;
            eVar = this;
        } else {
            if (i3 == 1) {
                boolean z3 = c0641e.c;
                String str4 = (String) c0641e.b;
                eVar = (e) c0641e.f6805a;
                ResultKt.throwOnFailure(objA);
                z2 = z3;
                str3 = str4;
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objA);
            }
            vVar = (com.moloco.sdk.internal.v) objA;
            if (vVar instanceof com.moloco.sdk.internal.v.a) {
                return new com.moloco.sdk.internal.v.a(((com.moloco.sdk.internal.v.a) vVar).a());
            }
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                return new com.moloco.sdk.internal.v.b(((com.moloco.sdk.internal.v.b) vVar).a());
            }
            throw new NoWhenBranchMatchedException();
        }
        com.moloco.sdk.internal.v vVar2 = (com.moloco.sdk.internal.v) objA;
        if (vVar2 instanceof com.moloco.sdk.internal.v.a) {
            com.moloco.sdk.internal.v.a aVar = (com.moloco.sdk.internal.v.a) vVar2;
            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to parse vast XML: " + aVar.a(), null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(aVar.a());
        }
        if (vVar2 instanceof com.moloco.sdk.internal.v.b) {
            w wVar = (w) ((com.moloco.sdk.internal.v.b) vVar2).a();
            CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
            f fVar = eVar.new f(wVar, z2, str3, null);
            c0641e.f6805a = null;
            c0641e.b = null;
            c0641e.f = 2;
            objA = BuildersKt.withContext(coroutineContext, fVar, c0641e);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            vVar = (com.moloco.sdk.internal.v) objA;
            if (vVar instanceof com.moloco.sdk.internal.v.a) {
                return new com.moloco.sdk.internal.v.a(((com.moloco.sdk.internal.v.a) vVar).a());
            }
            if (vVar instanceof com.moloco.sdk.internal.v.b) {
                return new com.moloco.sdk.internal.v.b(((com.moloco.sdk.internal.v.b) vVar).a());
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void a(e eVar, List list, x xVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            xVar = null;
        }
        eVar.a((List<String>) list, xVar);
    }

    public final void a(List<String> list, x xVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l.a.a(this.d, list, xVar, null, null, 12, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    public final Object a(w wVar, d dVar, double d2, ScreenData screenData, boolean z, String str, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) throws Throwable {
        n nVar;
        e eVar;
        Ref.ObjectRef objectRef;
        a aVarE;
        if (continuation instanceof n) {
            nVar = (n) continuation;
            int i2 = nVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nVar.e = i2 - Integer.MIN_VALUE;
            } else {
                nVar = new n(continuation);
            }
        } else {
            nVar = new n(continuation);
        }
        n nVar2 = nVar;
        Object objFirstOrNull = nVar2.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = nVar2.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Loading vast ad with wrapperChainParams: " + dVar, null, false, 12, null);
            List<String> listA = i.a((dVar == null || (aVarE = dVar.e()) == null) ? null : aVarE.e(), wVar.b());
            if (wVar.a().isEmpty()) {
                a(listA, dVar != null ? x.WrapperNoAds : null);
                return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_NO_ADS_ERROR);
            }
            d dVarA = dVar != null ? d.a(dVar, 0, null, false, a.a(dVar.e(), null, listA, null, 5, null), 7, null) : null;
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_RENDER_AD_LOAD_ERROR;
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a> listA2 = wVar.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listA2) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a) obj;
                if (aVar.c() == null || new IntRange(0, 1).contains(aVar.c().intValue())) {
                    arrayList.add(obj);
                }
            }
            l lVar = new l(FlowKt.cancellable(FlowKt.asFlow(CollectionsKt.sortedWith(arrayList, new m()))), this, dVarA, d2, screenData, z, str, objectRef2);
            nVar2.f6815a = this;
            nVar2.b = objectRef2;
            nVar2.e = 1;
            objFirstOrNull = FlowKt.firstOrNull(lVar, nVar2);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar = this;
            objectRef = objectRef2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) nVar2.b;
            eVar = (e) nVar2.f6815a;
            ResultKt.throwOnFailure(objFirstOrNull);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) objFirstOrNull;
        if (aVar2 == null) {
            com.moloco.sdk.internal.v.a aVar3 = new com.moloco.sdk.internal.v.a(objectRef.element);
            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to load linear: " + objectRef.element, null, false, 12, null);
            return aVar3;
        }
        return new com.moloco.sdk.internal.v.b(aVar2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object a(b0 b0Var, d dVar, double d2, ScreenData screenData, boolean z, String str, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) throws Throwable {
        o oVar;
        double d3;
        boolean z2;
        d dVar2;
        List<String> list;
        String str2;
        b0 b0Var2;
        int i2;
        e eVar;
        ScreenData screenData2;
        Set<String> setG;
        a aVarE;
        a aVarE2;
        a aVarE3;
        if (continuation instanceof o) {
            oVar = (o) continuation;
            int i3 = oVar.l;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                oVar.l = i3 - Integer.MIN_VALUE;
            } else {
                oVar = new o(continuation);
            }
        } else {
            oVar = new o(continuation);
        }
        o oVar2 = oVar;
        Object objA = oVar2.j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = oVar2.l;
        if (i4 != 0) {
            if (i4 == 1) {
                i2 = oVar2.i;
                boolean z3 = oVar2.h;
                d3 = oVar2.g;
                List<String> list2 = (List) oVar2.f;
                String str3 = (String) oVar2.e;
                screenData2 = (ScreenData) oVar2.d;
                dVar2 = (d) oVar2.c;
                b0Var2 = (b0) oVar2.b;
                e eVar2 = (e) oVar2.f6816a;
                ResultKt.throwOnFailure(objA);
                str2 = str3;
                z2 = z3;
                list = list2;
                eVar = eVar2;
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objA);
            }
        }
        ResultKt.throwOnFailure(objA);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, this.h, "Loading wrapper vast ad: " + b0Var.f(), null, false, 12, null);
        int iH = dVar != null ? dVar.h() + 1 : 0;
        List<String> listA = i.a((List) ((dVar == null || (aVarE = dVar.e()) == null) ? null : aVarE.e()), (List) b0Var.c());
        if (iH <= 4 && ((dVar == null || (setG = dVar.g()) == null || !setG.contains(b0Var.f())) && (dVar == null || dVar.f()))) {
            oVar2.f6816a = this;
            oVar2.b = b0Var;
            oVar2.c = dVar;
            oVar2.d = screenData;
            oVar2.e = str;
            oVar2.f = listA;
            d3 = d2;
            oVar2.g = d3;
            z2 = z;
            oVar2.h = z2;
            oVar2.i = iH;
            oVar2.l = 1;
            Object objA2 = a(b0Var, listA, oVar2);
            if (objA2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            dVar2 = dVar;
            list = listA;
            str2 = str;
            b0Var2 = b0Var;
            i2 = iH;
            eVar = this;
            screenData2 = screenData;
            objA = objA2;
        } else {
            a(listA, x.WrapperLimit);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k kVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_WRAPPER_LIMIT_ERROR;
            MolocoLogger.error$default(molocoLogger, this.h, "Failed to load wrapper vast ad: " + kVar, null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(kVar);
        }
        com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) objA;
        if (vVar instanceof com.moloco.sdk.internal.v.a) {
            com.moloco.sdk.internal.v.a aVar = (com.moloco.sdk.internal.v.a) vVar;
            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to load wrapper vast ad: " + aVar.a(), null, false, 12, null);
            return new com.moloco.sdk.internal.v.a(aVar.a());
        }
        if (vVar instanceof com.moloco.sdk.internal.v.b) {
            w wVar = (w) ((com.moloco.sdk.internal.v.b) vVar).a();
            c cVar = i;
            List listA2 = cVar.a((List) ((dVar2 == null || (aVarE3 = dVar2.e()) == null) ? null : aVarE3.f()), (List) b0Var2.e());
            List listA3 = cVar.a((List) ((dVar2 == null || (aVarE2 = dVar2.e()) == null) ? null : aVarE2.d()), CollectionsKt.listOf(b0Var2.b()));
            Set setA = cVar.a(dVar2 != null ? dVar2.g() : null, b0Var2.f());
            Boolean boolD = b0Var2.d();
            d dVar3 = new d(i2, setA, boolD != null ? boolD.booleanValue() : true, new a(listA2, list, listA3));
            oVar2.f6816a = null;
            oVar2.b = null;
            oVar2.c = null;
            oVar2.d = null;
            oVar2.e = null;
            oVar2.f = null;
            oVar2.l = 2;
            objA = eVar.a(wVar, dVar3, d3, screenData2, z2, str2, oVar2);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:50:0x0114  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e] */
    public final Object a(b0 b0Var, List<String> list, Continuation<? super com.moloco.sdk.internal.v<w, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) throws Throwable {
        g gVar;
        Exception exc;
        ?? r0;
        Object obj;
        HttpRequestTimeoutException httpRequestTimeoutException;
        ?? r1;
        Exception exc2;
        ?? r2;
        ?? r5;
        HttpRequestTimeoutException httpRequestTimeoutException2;
        ?? r3;
        ?? r6;
        Object obj2;
        e eVar;
        e eVar2;
        Object obj3;
        ?? r4;
        ?? r7;
        com.moloco.sdk.internal.v.b bVar;
        w wVar;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i2 = gVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gVar.e = i2 - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        Object objExecute = gVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r8 = gVar.e;
        try {
            try {
                if (r8 == 0) {
                    ResultKt.throwOnFailure(objExecute);
                    try {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Fetching wrapper vast tag url: " + b0Var.f(), null, false, 12, null);
                        HttpClient httpClient = this.f;
                        String strF = b0Var.f();
                        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                        HttpRequestKt.url(httpRequestBuilder, strF);
                        com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                        gVar.f6807a = this;
                        obj = list;
                        try {
                            gVar.b = obj;
                            gVar.e = 1;
                            objExecute = httpStatement.execute(gVar);
                            if (objExecute == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = obj;
                            eVar = this;
                        } catch (HttpRequestTimeoutException e) {
                            e = e;
                            httpRequestTimeoutException = e;
                            r1 = this;
                            httpRequestTimeoutException2 = httpRequestTimeoutException;
                            r3 = obj;
                            r6 = r1;
                            r6.a(r3, x.WrapperTimeout);
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, r6.h, "Fetching wrapper vast tag url timed out", httpRequestTimeoutException2, false, 8, null);
                            return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_WRAPPER_TIMEOUT_ERROR);
                        } catch (Exception e2) {
                            e = e2;
                            exc = e;
                            r0 = this;
                            exc2 = exc;
                            r2 = obj;
                            r5 = r0;
                            r5.a(r2, x.Wrapper);
                            MolocoLogger.error$default(MolocoLogger.INSTANCE, r5.h, "Fetching wrapper vast tag url fetch error", exc2, false, 8, null);
                            return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_WRAPPER_FETCH_ERROR);
                        }
                    } catch (HttpRequestTimeoutException e3) {
                        e = e3;
                        obj = list;
                    } catch (Exception e4) {
                        e = e4;
                        obj = list;
                    }
                } else {
                    if (r8 == 1) {
                        List list2 = (List) gVar.b;
                        e eVar3 = (e) gVar.f6807a;
                        ResultKt.throwOnFailure(objExecute);
                        obj2 = list2;
                        eVar = eVar3;
                    } else if (r8 == 2) {
                        List list3 = (List) gVar.b;
                        e eVar4 = (e) gVar.f6807a;
                        ResultKt.throwOnFailure(objExecute);
                        obj3 = list3;
                        eVar2 = eVar4;
                        String str = (String) objExecute;
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i iVar = eVar2.f6801a;
                        gVar.f6807a = eVar2;
                        gVar.b = obj3;
                        gVar.e = 3;
                        objExecute = iVar.a(str, gVar);
                        if (objExecute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r4 = eVar2;
                        r7 = obj3;
                    } else {
                        if (r8 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        List list4 = (List) gVar.b;
                        e eVar5 = (e) gVar.f6807a;
                        ResultKt.throwOnFailure(objExecute);
                        r7 = list4;
                        r4 = eVar5;
                    }
                    if (objExecute instanceof com.moloco.sdk.internal.v.b) {
                        bVar = (com.moloco.sdk.internal.v.b) objExecute;
                    } else {
                        bVar = null;
                    }
                    wVar = bVar != null ? (w) bVar.a() : null;
                    if (wVar == null) {
                        r4.a(r7, x.XmlParsing);
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, r4.h, "Failed to create VAST object from XML", null, false, 12, null);
                        return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_XML_PARSE_ERROR);
                    }
                    return new com.moloco.sdk.internal.v.b(wVar);
                }
                String str2 = (String) objExecute;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.i iVar2 = eVar2.f6801a;
                gVar.f6807a = eVar2;
                gVar.b = obj3;
                gVar.e = 3;
                objExecute = iVar2.a(str2, gVar);
                if (objExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r4 = eVar2;
                r7 = obj3;
                if (objExecute instanceof com.moloco.sdk.internal.v.b) {
                    bVar = (com.moloco.sdk.internal.v.b) objExecute;
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                }
                if (wVar == null) {
                    r4.a(r7, x.XmlParsing);
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, r4.h, "Failed to create VAST object from XML", null, false, 12, null);
                    return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_XML_PARSE_ERROR);
                }
                return new com.moloco.sdk.internal.v.b(wVar);
            } catch (HttpRequestTimeoutException e5) {
                httpRequestTimeoutException2 = e5;
                r3 = obj3;
                r6 = eVar2;
                r6.a(r3, x.WrapperTimeout);
                MolocoLogger.error$default(MolocoLogger.INSTANCE, r6.h, "Fetching wrapper vast tag url timed out", httpRequestTimeoutException2, false, 8, null);
                return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_WRAPPER_TIMEOUT_ERROR);
            } catch (Exception e6) {
                exc2 = e6;
                r2 = obj3;
                r5 = eVar2;
                r5.a(r2, x.Wrapper);
                MolocoLogger.error$default(MolocoLogger.INSTANCE, r5.h, "Fetching wrapper vast tag url fetch error", exc2, false, 8, null);
                return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_WRAPPER_FETCH_ERROR);
            }
            gVar.f6807a = eVar;
            gVar.b = obj2;
            gVar.e = 2;
            objExecute = HttpResponseKt.bodyAsText$default((HttpResponse) objExecute, null, gVar, 1, null);
            obj3 = obj2;
            eVar2 = eVar;
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (HttpRequestTimeoutException e7) {
            httpRequestTimeoutException = e7;
            r1 = r8;
            obj = "Fetching wrapper vast tag url: ";
        } catch (Exception e8) {
            exc = e8;
            r0 = r8;
            obj = "Fetching wrapper vast tag url: ";
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0100  */
    /* JADX WARN: Code duplicated, block: B:27:0x010c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:31:0x011a A[LOOP:0: B:23:0x00fa->B:31:0x011a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x0121  */
    /* JADX WARN: Code duplicated, block: B:46:0x0214  */
    /* JADX WARN: Code duplicated, block: B:48:0x0220  */
    /* JADX WARN: Code duplicated, block: B:50:0x0228  */
    /* JADX WARN: Code duplicated, block: B:74:0x011f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x018d -> B:39:0x019d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o r31, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a r32, double r33, com.moloco.sdk.common_adapter_internal.ScreenData r35, boolean r36, java.lang.String r37, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.e$a, double, com.moloco.sdk.common_adapter_internal.ScreenData, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final b a(Lazy<b> lazy) {
        return lazy.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k] */
    public final Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p pVar, List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list, a0 a0Var, List<String> list2, double d2, Long l2, ScreenData screenData, boolean z, String str, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) throws Throwable {
        q qVar;
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list3;
        a0 a0Var2;
        Object objFirstOrNull;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p pVar2;
        e eVar;
        Ref.ObjectRef objectRef;
        z zVarA;
        if (continuation instanceof q) {
            qVar = (q) continuation;
            int i2 = qVar.h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                qVar.h = i2 - Integer.MIN_VALUE;
            } else {
                qVar = new q(continuation);
            }
        } else {
            qVar = new q(continuation);
        }
        q qVar2 = qVar;
        Object obj = qVar2.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = qVar2.h;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.h, "Preparing InLine RenderLinear with target linear size: " + d2, null, false, 12, null);
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q> listD = pVar.d();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listD) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) obj2;
                c cVar = i;
                if (!cVar.a(qVar3) && qVar3.k() && cVar.a(qVar3.i())) {
                    arrayList.add(obj2);
                }
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a(d2, l2, Boxing.boxInt(screenData.getWidthPx()), Boxing.boxInt(screenData.getHeightPx())));
            if (listSortedWith.isEmpty()) {
                a(list2, x.LinearNotSupportedMedia);
                return new com.moloco.sdk.internal.v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_LINEAR_NOT_SUPPORTED_MEDIA_ERROR);
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_ERROR;
            p pVar3 = new p(FlowKt.cancellable(FlowKt.asFlow(listSortedWith)), z, this, str, objectRef2);
            qVar2.f6820a = this;
            qVar2.b = pVar;
            list3 = list;
            qVar2.c = list3;
            a0Var2 = a0Var;
            qVar2.d = a0Var2;
            qVar2.e = objectRef2;
            qVar2.h = 1;
            objFirstOrNull = FlowKt.firstOrNull(pVar3, qVar2);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            pVar2 = pVar;
            eVar = this;
            objectRef = objectRef2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) qVar2.e;
            a0 a0Var3 = (a0) qVar2.d;
            List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> list4 = (List) qVar2.c;
            pVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p) qVar2.b;
            eVar = (e) qVar2.f6820a;
            ResultKt.throwOnFailure(obj);
            a0Var2 = a0Var3;
            list3 = list4;
            objFirstOrNull = obj;
        }
        Pair pair = (Pair) objFirstOrNull;
        if (pair == null) {
            com.moloco.sdk.internal.v.a aVar = new com.moloco.sdk.internal.v.a(objectRef.element);
            MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar.h, "Failed to load media file: " + objectRef.element, null, false, 12, null);
            return aVar;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q qVar4 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q) pair.component1();
        File file = (File) pair.component2();
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, eVar.h, "Found a RenderLinear MediaFile: " + file.getAbsolutePath() + " for url: " + qVar4.g(), null, false, 12, null);
        a0 a0VarG = pVar2.g();
        String strB = (a0VarG == null || (zVarA = a0VarG.a()) == null) ? null : zVarA.b();
        c cVar2 = i;
        List listA = cVar2.a((List) pVar2.f(), (List) list3);
        a0 a0VarG2 = pVar2.g();
        z zVarA2 = a0VarG2 != null ? a0VarG2.a() : null;
        a0 a0VarG3 = pVar2.g();
        List listA2 = cVar2.a((List) (a0VarG3 != null ? a0VarG3.b() : null), (List) (a0Var2 != null ? a0Var2.b() : null));
        a0 a0VarG4 = pVar2.g();
        a0 a0Var4 = new a0(zVarA2, listA2, cVar2.a((List) (a0VarG4 != null ? a0VarG4.c() : null), (List) (a0Var2 != null ? a0Var2.c() : null)));
        MolocoLogger.info$default(molocoLogger, eVar.h, "Returning RenderLinear for url: " + qVar4.g() + ", with bitrate: " + qVar4.b() + ' ', null, false, 12, null);
        return new com.moloco.sdk.internal.v.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f(pVar2.e(), file, qVar4.b(), qVar4.g(), strB, cVar2.a((List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u>) listA, a0Var4), eVar.a(pVar2.c())));
    }

    public final b a(a aVar) {
        List<List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> listD;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (aVar != null && (listD = aVar.d()) != null) {
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> arrayList8 = new ArrayList();
                for (Object obj : list) {
                    if (!i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g) obj)) {
                        arrayList8.add(obj);
                    }
                }
                for (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g gVar : arrayList8) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h hVarH = gVar.h();
                    if (hVarH instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h.b) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p pVarA = ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h.b) gVar.h()).a();
                        CollectionsKt.addAll(arrayList, pVarA.f());
                        a0 a0VarG = pVarA.g();
                        if (a0VarG != null) {
                            CollectionsKt.addAll(arrayList2, a0VarG.b());
                            CollectionsKt.addAll(arrayList3, a0VarG.c());
                        }
                        CollectionsKt.addAll(arrayList6, pVarA.c());
                    } else if (hVarH instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h.a) {
                        CollectionsKt.addAll(arrayList7, ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.h.a) gVar.h()).a());
                    }
                }
                arrayList4.add(arrayList6);
                arrayList5.add(arrayList7);
            }
        }
        return new b(arrayList, new a0(null, arrayList2, arrayList3), arrayList4, arrayList5);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> list, ScreenData screenData) {
        List<String> listEmptyList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e) obj;
            if (!i.a(eVar) && !eVar.h().isEmpty()) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e eVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a(Integer.valueOf(screenData.getWidthPx()), Integer.valueOf(screenData.getHeightPx()))));
        if (eVar2 == null) {
            return null;
        }
        y yVar = (y) CollectionsKt.first(CollectionsKt.sortedWith(eVar2.h(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.b()));
        Integer numI = eVar2.i();
        int iIntValue = numI != null ? numI.intValue() : 0;
        Integer numF = eVar2.f();
        int iIntValue2 = numF != null ? numF.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f fVarD = eVar2.d();
        String strA = fVarD != null ? fVarD.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f fVarD2 = eVar2.d();
        if (fVarD2 == null || (listEmptyList = fVarD2.b()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<String> list2 = listEmptyList;
        List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> listE = eVar2.e();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList2.add(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u) it.next()).f());
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c(yVar, iIntValue, iIntValue2, strA, list2, arrayList2);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e a(List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> list) {
        List<String> listEmptyList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!i.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) obj)) {
                arrayList.add(obj);
            }
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l lVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(arrayList, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.g.a()));
        if (lVar == null) {
            return null;
        }
        y yVarG = lVar.g();
        Integer numI = lVar.i();
        int iIntValue = numI != null ? numI.intValue() : 0;
        Integer numD = lVar.d();
        int iIntValue2 = numD != null ? numD.intValue() : 0;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m mVarB = lVar.b();
        String strA = mVarB != null ? mVarB.a() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m mVarB2 = lVar.b();
        if (mVarB2 == null || (listEmptyList = mVarB2.b()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e(yVarG, iIntValue, iIntValue2, strA, listEmptyList, lVar.h(), lVar.c(), lVar.e());
    }
}
