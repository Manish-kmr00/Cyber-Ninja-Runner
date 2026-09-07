package com.moloco.sdk.internal.services.events;

import android.net.Uri;
import com.moloco.sdk.UserIntent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.a0;
import com.moloco.sdk.internal.services.b0;
import com.moloco.sdk.internal.services.e0;
import com.moloco.sdk.internal.services.f0;
import com.moloco.sdk.internal.services.j;
import com.moloco.sdk.internal.services.k;
import com.moloco.sdk.internal.services.usertracker.f;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.internal.services.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f6376a;
    public final b0 b;
    public final y c;
    public final f0 d;
    public final f e;
    public final com.moloco.sdk.internal.services.d f;
    public final com.moloco.sdk.internal.services.proto.a g;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c h;
    public final String i;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.events.a$a, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.services.events.CustomUserEventBuilderServiceImpl", f = "CustomUserEventBuilderServiceImpl.kt", i = {0, 0, 0, 0}, l = {67}, m = "userAdInteractionExt", n = {"this", "interaction", "$this$userAdInteractionExt_u24lambda_u240", "eventTimestamp"}, s = {"L$0", "L$1", "L$3", "J$0"})
    public static final class C0561a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6377a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public long f;
        public /* synthetic */ Object g;
        public int i;

        public C0561a(Continuation<? super C0561a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return a.this.a(0L, (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.events.CustomUserEventBuilderServiceImpl", f = "CustomUserEventBuilderServiceImpl.kt", i = {0}, l = {52}, m = "userAdInteractionExtAsQueryParameter", n = {"url"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6378a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return a.this.a(0L, (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a) null, (String) null, this);
        }
    }

    public a(k appInfoService, b0 networkInfoService, y deviceInfoService, f0 screenInfoService, f userIdentifierService, com.moloco.sdk.internal.services.d adDataService, com.moloco.sdk.internal.services.proto.a encoderService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c userEventConfigService, String sdkVersion) {
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        Intrinsics.checkNotNullParameter(networkInfoService, "networkInfoService");
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(screenInfoService, "screenInfoService");
        Intrinsics.checkNotNullParameter(userIdentifierService, "userIdentifierService");
        Intrinsics.checkNotNullParameter(adDataService, "adDataService");
        Intrinsics.checkNotNullParameter(encoderService, "encoderService");
        Intrinsics.checkNotNullParameter(userEventConfigService, "userEventConfigService");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        this.f6376a = appInfoService;
        this.b = networkInfoService;
        this.c = deviceInfoService;
        this.d = screenInfoService;
        this.e = userIdentifierService;
        this.f = adDataService;
        this.g = encoderService;
        this.h = userEventConfigService;
        this.i = sdkVersion;
    }

    public final k b() {
        return this.f6376a;
    }

    public final y c() {
        return this.c;
    }

    public final com.moloco.sdk.internal.services.proto.a d() {
        return this.g;
    }

    public final b0 e() {
        return this.b;
    }

    public final f0 f() {
        return this.d;
    }

    public final String g() {
        return this.i;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c h() {
        return this.h;
    }

    public final f i() {
        return this.e;
    }

    public final com.moloco.sdk.internal.services.d a() {
        return this.f;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a
    public Object a(long j, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a abstractC0705a, String str, Continuation<? super String> continuation) throws Throwable {
        b bVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objA = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            if (!this.h.c()) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, com.moloco.sdk.internal.services.events.b.f6379a, "Event reporting config disabled, UserAdInteractionExt not reporting", false, 4, null);
                return str;
            }
            bVar.f6378a = str;
            bVar.d = 1;
            objA = a(j, abstractC0705a, bVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) bVar.f6378a;
            ResultKt.throwOnFailure(objA);
        }
        String string = Uri.parse(str).buildUpon().appendQueryParameter(com.moloco.sdk.internal.services.events.b.b, (String) objA).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parse(\n            url\n …     ).build().toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0087  */
    /* JADX WARN: Code duplicated, block: B:25:0x0091  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(long j, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a abstractC0705a, Continuation<? super String> continuation) throws Throwable {
        C0561a c0561a;
        UserIntent.UserAdInteractionExt.Builder userAdInteractionExt$lambda$0;
        a aVar;
        UserIntent.UserAdInteractionExt.Builder builder;
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a abstractC0705a2;
        UserIntent.UserAdInteractionExt.Builder builder2;
        UserIntent.UserAdInteractionExt.Builder builder3;
        com.moloco.sdk.internal.services.c cVarA;
        if (continuation instanceof C0561a) {
            c0561a = (C0561a) continuation;
            int i = c0561a.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                c0561a.i = i - Integer.MIN_VALUE;
            } else {
                c0561a = new C0561a(continuation);
            }
        } else {
            c0561a = new C0561a(continuation);
        }
        Object obj = c0561a.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c0561a.i;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            userAdInteractionExt$lambda$0 = UserIntent.UserAdInteractionExt.newBuilder();
            if (this.h.b()) {
                f fVar = this.e;
                c0561a.f6377a = this;
                c0561a.b = abstractC0705a;
                c0561a.c = userAdInteractionExt$lambda$0;
                c0561a.d = userAdInteractionExt$lambda$0;
                c0561a.e = userAdInteractionExt$lambda$0;
                c0561a.f = j;
                c0561a.i = 1;
                Object objB = fVar.b(c0561a);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                abstractC0705a2 = abstractC0705a;
                builder2 = userAdInteractionExt$lambda$0;
                builder3 = builder2;
                builder = builder3;
                obj = objB;
                aVar = this;
            } else {
                aVar = this;
                builder = userAdInteractionExt$lambda$0;
            }
            cVarA = aVar.f.a();
            if (cVarA instanceof com.moloco.sdk.internal.services.c.a) {
                userAdInteractionExt$lambda$0.setAdvertisingId(((com.moloco.sdk.internal.services.c.a) cVarA).b());
            } else {
                boolean z = cVarA instanceof com.moloco.sdk.internal.services.c.b;
            }
            userAdInteractionExt$lambda$0.setClientTimestamp(j);
            Intrinsics.checkNotNullExpressionValue(userAdInteractionExt$lambda$0, "userAdInteractionExt$lambda$0");
            aVar.a(userAdInteractionExt$lambda$0);
            aVar.a(userAdInteractionExt$lambda$0, abstractC0705a, aVar.d.invoke());
            aVar.a(userAdInteractionExt$lambda$0, aVar.f6376a.invoke());
            aVar.a(userAdInteractionExt$lambda$0, aVar.c.invoke());
            aVar.a(userAdInteractionExt$lambda$0, aVar.b.invoke());
            UserIntent.UserAdInteractionExt userAdInteractionExt = builder.build();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, com.moloco.sdk.internal.services.events.b.f6379a, "Encoding protobuf UserAdInteractionExt: " + userAdInteractionExt, false, 4, null);
            com.moloco.sdk.internal.services.proto.a aVar2 = aVar.g;
            Intrinsics.checkNotNullExpressionValue(userAdInteractionExt, "userAdInteractionExt");
            String strA = com.moloco.sdk.internal.services.proto.a.C0562a.a(aVar2, userAdInteractionExt, 0, 2, null);
            MolocoLogger.debug$default(molocoLogger, com.moloco.sdk.internal.services.events.b.f6379a, "Successfully built userAdInteractionExt as base64 string: " + strA, false, 4, null);
            return strA;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j = c0561a.f;
        builder2 = (UserIntent.UserAdInteractionExt.Builder) c0561a.e;
        builder3 = (UserIntent.UserAdInteractionExt.Builder) c0561a.d;
        builder = (UserIntent.UserAdInteractionExt.Builder) c0561a.c;
        abstractC0705a2 = (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a) c0561a.b;
        aVar = (a) c0561a.f6377a;
        ResultKt.throwOnFailure(obj);
        builder2.setMref((String) obj);
        userAdInteractionExt$lambda$0 = builder3;
        abstractC0705a = abstractC0705a2;
        cVarA = aVar.f.a();
        if (cVarA instanceof com.moloco.sdk.internal.services.c.a) {
            userAdInteractionExt$lambda$0.setAdvertisingId(((com.moloco.sdk.internal.services.c.a) cVarA).b());
        } else {
            boolean z2 = cVarA instanceof com.moloco.sdk.internal.services.c.b;
        }
        userAdInteractionExt$lambda$0.setClientTimestamp(j);
        Intrinsics.checkNotNullExpressionValue(userAdInteractionExt$lambda$0, "userAdInteractionExt$lambda$0");
        aVar.a(userAdInteractionExt$lambda$0);
        aVar.a(userAdInteractionExt$lambda$0, abstractC0705a, aVar.d.invoke());
        aVar.a(userAdInteractionExt$lambda$0, aVar.f6376a.invoke());
        aVar.a(userAdInteractionExt$lambda$0, aVar.c.invoke());
        aVar.a(userAdInteractionExt$lambda$0, aVar.b.invoke());
        UserIntent.UserAdInteractionExt userAdInteractionExt2 = builder.build();
        MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger2, com.moloco.sdk.internal.services.events.b.f6379a, "Encoding protobuf UserAdInteractionExt: " + userAdInteractionExt2, false, 4, null);
        com.moloco.sdk.internal.services.proto.a aVar3 = aVar.g;
        Intrinsics.checkNotNullExpressionValue(userAdInteractionExt2, "userAdInteractionExt");
        String strA2 = com.moloco.sdk.internal.services.proto.a.C0562a.a(aVar3, userAdInteractionExt2, 0, 2, null);
        MolocoLogger.debug$default(molocoLogger2, com.moloco.sdk.internal.services.events.b.f6379a, "Successfully built userAdInteractionExt as base64 string: " + strA2, false, 4, null);
        return strA2;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder) {
        UserIntent.UserAdInteractionExt.MolocoSDK.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.MolocoSDK.newBuilder();
        builderNewBuilder.setCoreVer(this.i);
        builder.setSdk(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, x xVar) {
        UserIntent.UserAdInteractionExt.Device.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Device.newBuilder();
        builderNewBuilder.setOsVer(xVar.t());
        builderNewBuilder.setModel(xVar.r());
        builderNewBuilder.setOs(UserIntent.UserAdInteractionExt.Device.OsType.ANDROID);
        builderNewBuilder.setScreenScale(xVar.u());
        builder.setDevice(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, a0 a0Var) {
        UserIntent.UserAdInteractionExt.Network.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Network.newBuilder();
        if (a0Var instanceof a0.a) {
            builderNewBuilder.setConnectionType(UserIntent.UserAdInteractionExt.Network.ConnectionType.CELLULAR);
            builderNewBuilder.setCarrier(((a0.a) a0Var).a());
        } else if (Intrinsics.areEqual(a0Var, a0.b.f6300a)) {
            builderNewBuilder.setConnectionType(UserIntent.UserAdInteractionExt.Network.ConnectionType.UNKNOWN);
        } else if (Intrinsics.areEqual(a0Var, a0.c.f6301a)) {
            builderNewBuilder.setConnectionType(UserIntent.UserAdInteractionExt.Network.ConnectionType.WIFI);
        }
        builder.setNetwork(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, j jVar) {
        UserIntent.UserAdInteractionExt.App.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.App.newBuilder();
        builderNewBuilder.setId(jVar.b());
        builderNewBuilder.setVer(jVar.c());
        builder.setApp(builderNewBuilder.build());
        return builder;
    }

    public final UserIntent.UserAdInteractionExt.Builder a(UserIntent.UserAdInteractionExt.Builder builder, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a abstractC0705a, e0 e0Var) {
        if (abstractC0705a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.e) {
            builder.setImpInteraction(UserIntent.UserAdInteractionExt.ImpressionInteraction.newBuilder().build());
        } else if (abstractC0705a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.d) {
            UserIntent.UserAdInteractionExt.ClickInteraction.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.ClickInteraction.newBuilder();
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.d) abstractC0705a;
            builderNewBuilder.setClickPos(com.moloco.sdk.internal.services.events.b.a(dVar.b()));
            builderNewBuilder.setScreenSize(com.moloco.sdk.internal.services.events.b.a(e0Var));
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.g gVarD = dVar.d();
            if (gVarD != null) {
                builderNewBuilder.setViewSize(com.moloco.sdk.internal.services.events.b.a(gVarD));
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f fVarC = dVar.c();
            if (fVarC != null) {
                builderNewBuilder.setViewPos(com.moloco.sdk.internal.services.events.b.a(fVarC));
            }
            List<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> listA = dVar.a();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            for (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVar : listA) {
                UserIntent.UserAdInteractionExt.Button.Builder builderNewBuilder2 = UserIntent.UserAdInteractionExt.Button.newBuilder();
                builderNewBuilder2.setType(com.moloco.sdk.internal.services.events.b.a(cVar.d()));
                builderNewBuilder2.setPos(com.moloco.sdk.internal.services.events.b.a(cVar.e()));
                builderNewBuilder2.setSize(com.moloco.sdk.internal.services.events.b.a(cVar.f()));
                arrayList.add(builderNewBuilder2.build());
            }
            builderNewBuilder.addAllButtons(arrayList);
            builder.setClickInteraction((UserIntent.UserAdInteractionExt.ClickInteraction) builderNewBuilder.build());
        } else if (abstractC0705a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.b) {
            UserIntent.UserAdInteractionExt.AppForegroundingInteraction.Builder builderNewBuilder3 = UserIntent.UserAdInteractionExt.AppForegroundingInteraction.newBuilder();
            builderNewBuilder3.setBgTsMs(((com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.b) abstractC0705a).b());
            builder.setAppForegroundingInteraction(builderNewBuilder3.build());
        } else if (abstractC0705a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.C0706a) {
            builder.setAppBackgroundingInteraction(UserIntent.UserAdInteractionExt.AppBackgroundingInteraction.newBuilder().build());
        }
        return builder;
    }
}
