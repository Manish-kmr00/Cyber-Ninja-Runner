package com.unity3d.services.core.domain.task;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.safedk.android.utils.j;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.domain.ResultExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeSDK.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", i = {0, 1, 2, 2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 9, 10, 11}, l = {48, 53, TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER, 60, 65, 67, 71, 74, 89, 92, 100, 103, 106}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "$this$withContext", j.c, "resetResult", "$this$withContext", j.c, "$this$withContext", j.c, "configResult", "$this$withContext", j.c, "configResult", "loadCacheResult", "configResult", "configResult", "loadWebResult", "configResult", "configResult"}, s = {"L$0", "L$0", "L$0", "L$2", "L$0", "L$0", "L$2", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$1", "L$1", "L$2", "L$1", "L$1"})
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x028f A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0299 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:107:0x02df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:108:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:111:0x02e7 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x0307 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0330 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:120:0x0331  */
    /* JADX WARN: Code duplicated, block: B:123:0x033b A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:125:0x034d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:128:0x036c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x0377 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0394  */
    /* JADX WARN: Code duplicated, block: B:137:0x039b  */
    /* JADX WARN: Code duplicated, block: B:139:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x017a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x017b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0184 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ca A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01df A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e6 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01f4 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:79:0x020e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:80:0x020f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0218 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:85:0x022d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0250 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x0257 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:93:0x026f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x0276 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0284 A[Catch: all -> 0x0383, CancellationException -> 0x03b0, TryCatch #2 {CancellationException -> 0x03b0, all -> 0x0383, blocks: (B:6:0x0017, B:129:0x036d, B:9:0x0028, B:126:0x034e, B:12:0x0033, B:121:0x0335, B:123:0x033b, B:15:0x0046, B:114:0x02fc, B:117:0x030d, B:18:0x0051, B:109:0x02e1, B:111:0x02e7, B:21:0x0061, B:94:0x0270, B:96:0x0276, B:97:0x0283, B:24:0x0079, B:89:0x0251, B:91:0x0257, B:98:0x0284, B:100:0x028f, B:102:0x0299, B:104:0x029f, B:105:0x02bc, B:115:0x0307, B:130:0x0377, B:131:0x0382, B:27:0x0096, B:86:0x022e, B:30:0x00a7, B:81:0x0212, B:83:0x0218, B:33:0x00b8, B:73:0x01e0, B:75:0x01e6, B:76:0x01f3, B:36:0x00ce, B:68:0x01c4, B:70:0x01ca, B:77:0x01f4, B:39:0x00e4, B:58:0x017e, B:60:0x0184, B:61:0x0198, B:64:0x01a4, B:42:0x00f7, B:53:0x015a, B:54:0x015d, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7904constructorimpl;
        Throwable thM7907exceptionOrNullimpl;
        CoroutineScope coroutineScope;
        InitializeSDK initializeSDK;
        InitializeSDK initializeSDK2;
        Object obj2;
        InitializeSDK initializeSDK3;
        Object value;
        Throwable thM7907exceptionOrNullimpl2;
        Configuration configuration;
        Configuration configuration2;
        Object obj3;
        InitializeSDK initializeSDK4;
        Object value2;
        Object value3;
        CoroutineScope coroutineScope2;
        InitializeSDK initializeSDK5;
        Configuration configuration3;
        ErrorState errorState;
        Throwable thM7907exceptionOrNullimpl3;
        Throwable thM7907exceptionOrNullimpl4;
        InitializationException initializationExceptionOrThrow;
        Object value4;
        Object obj4;
        Object obj5;
        InitializeStateLoadCache.LoadCacheResult loadCacheResult;
        String webViewData;
        Object value5;
        Object obj6;
        ErrorState errorState2;
        Throwable thM7907exceptionOrNullimpl5;
        Throwable thM7907exceptionOrNullimpl6;
        InitializationException initializationExceptionOrThrow2;
        Object obj7;
        InitializeSDK initializeSDK6;
        Object obj8;
        Object value6;
        InitializationException initializationExceptionOrThrow3;
        Object value7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                    initializeSDK = this.this$0;
                    Result.Companion companion = Result.INSTANCE;
                    SdkProperties.setInitializationTime(Device.getElapsedRealtime());
                    SdkProperties.setInitializationTimeSinceEpoch(System.currentTimeMillis());
                    InitializeEventsMetricSender.getInstance().didInitStart();
                    String gameId = ClientProperties.getGameId();
                    if (gameId == null || StringsKt.toIntOrNull(gameId) == null) {
                        InitializationException initializationException = new InitializationException(ErrorState.InvalidGameId, new Exception("gameId \"" + gameId + "\" should be a number."), new Configuration());
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK;
                        this.label = 1;
                        if (initializeSDK.handleInitializationException(initializationException, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        initializeSDK2 = initializeSDK;
                        Unit unit = Unit.INSTANCE;
                        initializeSDK = initializeSDK2;
                    }
                    DeviceLog.debug("Unity Ads Init: Loading Config File From Local Storage");
                    ConfigFileFromLocalStorage configFileFromLocalStorage = initializeSDK.configFileFromLocalStorage;
                    ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params(null, 1, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK;
                    this.label = 2;
                    obj2 = configFileFromLocalStorage.mo5927invokegIAlus(params, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK3 = initializeSDK;
                    value = obj2;
                    thM7907exceptionOrNullimpl2 = Result.m7907exceptionOrNullimpl(value);
                    if (thM7907exceptionOrNullimpl2 != null) {
                        DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + thM7907exceptionOrNullimpl2.getMessage());
                    }
                    configuration = new Configuration();
                    if (Result.m7910isFailureimpl(value)) {
                        value = configuration;
                    }
                    configuration2 = (Configuration) value;
                    InitializeStateReset initializeStateReset = initializeSDK3.initializeStateReset;
                    InitializeStateReset.Params params2 = new InitializeStateReset.Params(configuration2);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK3;
                    this.L$2 = configuration2;
                    this.label = 3;
                    obj3 = initializeStateReset.mo5927invokegIAlus(params2, this);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK4 = initializeSDK3;
                    value2 = obj3;
                    if (Result.m7910isFailureimpl(value2)) {
                        InitializeStateConfig initializeStateConfig = initializeSDK4.initializeStateConfig;
                        InitializeStateConfig.Params params3 = new InitializeStateConfig.Params(configuration2);
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK4;
                        this.L$2 = configuration2;
                        this.label = 5;
                        value3 = initializeStateConfig.mo5927invokegIAlus(params3, this);
                        if (value3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        initializeSDK5 = initializeSDK4;
                        configuration3 = configuration2;
                        if (Result.m7910isFailureimpl(value3)) {
                            initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(value3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK5;
                            this.L$2 = configuration3;
                            this.L$3 = value3;
                            this.label = 6;
                            if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateLoadCache initializeStateLoadCache = initializeSDK5.initializeStateLoadCache;
                        ResultKt.throwOnFailure(value3);
                        InitializeStateLoadCache.Params params4 = new InitializeStateLoadCache.Params((Configuration) value3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK5;
                        this.L$2 = configuration3;
                        this.L$3 = value3;
                        this.label = 7;
                        value4 = initializeStateLoadCache.mo5927invokegIAlus(params4, this);
                        if (value4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        CoroutineScope coroutineScope3 = coroutineScope2;
                        Object obj9 = value3;
                        obj4 = value4;
                        obj5 = obj9;
                        if (Result.m7910isFailureimpl(obj4)) {
                            errorState2 = ErrorState.LoadCache;
                            thM7907exceptionOrNullimpl5 = Result.m7907exceptionOrNullimpl(obj4);
                            this.L$0 = obj4;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 8;
                            if (initializeSDK5.m5931executeErrorStateBWLJW6A(errorState2, thM7907exceptionOrNullimpl5, configuration3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                            if (thM7907exceptionOrNullimpl6 == null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw thM7907exceptionOrNullimpl6;
                        }
                        ResultKt.throwOnFailure(obj4);
                        loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj4;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (!configuration3.getExperiments().isWebViewAsyncDownloadEnabled() && loadCacheResult.getWebViewData() != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, new CoroutineName("LaunchLoadWeb"), null, new InitializeSDK$doWork$2$1$webViewData$1(initializeSDK5, obj5, null), 2, null);
                                webViewData = loadCacheResult.getWebViewData();
                            } else {
                                InitializeStateLoadWeb initializeStateLoadWeb = initializeSDK5.initializeStateLoadWeb;
                                ResultKt.throwOnFailure(obj5);
                                InitializeStateLoadWeb.Params params5 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                                this.L$0 = initializeSDK5;
                                this.L$1 = obj5;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 9;
                                value5 = initializeStateLoadWeb.mo5927invokegIAlus(params5, this);
                                if (value5 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj6 = obj5;
                                if (Result.m7910isFailureimpl(value5)) {
                                    initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                                    this.L$0 = initializeSDK5;
                                    this.L$1 = obj6;
                                    this.L$2 = value5;
                                    this.label = 10;
                                    if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                obj5 = obj6;
                                ResultKt.throwOnFailure(value5);
                                webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                            }
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        InitializeStateCreate initializeStateCreate = initializeSDK5.initializeStateCreate;
                        ResultKt.throwOnFailure(obj5);
                        InitializeStateCreate.Params params6 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj5;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        obj7 = initializeStateCreate.mo5927invokegIAlus(params6, this);
                        if (obj7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        initializeSDK6 = initializeSDK5;
                        obj8 = obj5;
                        value6 = obj7;
                        if (Result.m7910isFailureimpl(value6)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                            this.L$0 = initializeSDK6;
                            this.L$1 = obj8;
                            this.label = 12;
                            if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateComplete initializeStateComplete = initializeSDK6.initializeStateComplete;
                        ResultKt.throwOnFailure(obj8);
                        InitializeStateComplete.Params params7 = new InitializeStateComplete.Params((Configuration) obj8);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 13;
                        value7 = initializeStateComplete.mo5927invokegIAlus(params7, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value7);
                        objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                        if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                        } else {
                            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                            if (thM7907exceptionOrNullimpl != null) {
                                Result.Companion companion3 = Result.INSTANCE;
                                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                            }
                        }
                        return Result.m7903boximpl(objM7904constructorimpl);
                    }
                    errorState = ErrorState.ResetWebApp;
                    thM7907exceptionOrNullimpl3 = Result.m7907exceptionOrNullimpl(value2);
                    this.L$0 = value2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (initializeSDK4.m5931executeErrorStateBWLJW6A(errorState, thM7907exceptionOrNullimpl3, configuration2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    thM7907exceptionOrNullimpl4 = Result.m7907exceptionOrNullimpl(value2);
                    if (thM7907exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM7907exceptionOrNullimpl4;
                case 1:
                    initializeSDK2 = (InitializeSDK) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Unit unit2 = Unit.INSTANCE;
                    initializeSDK = initializeSDK2;
                    DeviceLog.debug("Unity Ads Init: Loading Config File From Local Storage");
                    ConfigFileFromLocalStorage configFileFromLocalStorage2 = initializeSDK.configFileFromLocalStorage;
                    ConfigFileFromLocalStorage.Params params8 = new ConfigFileFromLocalStorage.Params(null, 1, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK;
                    this.label = 2;
                    obj2 = configFileFromLocalStorage2.mo5927invokegIAlus(params8, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK3 = initializeSDK;
                    value = obj2;
                    thM7907exceptionOrNullimpl2 = Result.m7907exceptionOrNullimpl(value);
                    if (thM7907exceptionOrNullimpl2 != null) {
                        DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + thM7907exceptionOrNullimpl2.getMessage());
                    }
                    configuration = new Configuration();
                    if (Result.m7910isFailureimpl(value)) {
                        value = configuration;
                    }
                    configuration2 = (Configuration) value;
                    InitializeStateReset initializeStateReset2 = initializeSDK3.initializeStateReset;
                    InitializeStateReset.Params params9 = new InitializeStateReset.Params(configuration2);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK3;
                    this.L$2 = configuration2;
                    this.label = 3;
                    obj3 = initializeStateReset2.mo5927invokegIAlus(params9, this);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK4 = initializeSDK3;
                    value2 = obj3;
                    if (Result.m7910isFailureimpl(value2)) {
                        InitializeStateConfig initializeStateConfig2 = initializeSDK4.initializeStateConfig;
                        InitializeStateConfig.Params params10 = new InitializeStateConfig.Params(configuration2);
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK4;
                        this.L$2 = configuration2;
                        this.label = 5;
                        value3 = initializeStateConfig2.mo5927invokegIAlus(params10, this);
                        if (value3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        initializeSDK5 = initializeSDK4;
                        configuration3 = configuration2;
                        if (Result.m7910isFailureimpl(value3)) {
                            initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(value3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK5;
                            this.L$2 = configuration3;
                            this.L$3 = value3;
                            this.label = 6;
                            if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateLoadCache initializeStateLoadCache2 = initializeSDK5.initializeStateLoadCache;
                        ResultKt.throwOnFailure(value3);
                        InitializeStateLoadCache.Params params11 = new InitializeStateLoadCache.Params((Configuration) value3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK5;
                        this.L$2 = configuration3;
                        this.L$3 = value3;
                        this.label = 7;
                        value4 = initializeStateLoadCache2.mo5927invokegIAlus(params11, this);
                        if (value4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        CoroutineScope coroutineScope4 = coroutineScope2;
                        Object obj10 = value3;
                        obj4 = value4;
                        obj5 = obj10;
                        if (Result.m7910isFailureimpl(obj4)) {
                            errorState2 = ErrorState.LoadCache;
                            thM7907exceptionOrNullimpl5 = Result.m7907exceptionOrNullimpl(obj4);
                            this.L$0 = obj4;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 8;
                            if (initializeSDK5.m5931executeErrorStateBWLJW6A(errorState2, thM7907exceptionOrNullimpl5, configuration3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                            if (thM7907exceptionOrNullimpl6 == null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw thM7907exceptionOrNullimpl6;
                        }
                        ResultKt.throwOnFailure(obj4);
                        loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj4;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (!configuration3.getExperiments().isWebViewAsyncDownloadEnabled()) {
                            }
                            InitializeStateLoadWeb initializeStateLoadWeb2 = initializeSDK5.initializeStateLoadWeb;
                            ResultKt.throwOnFailure(obj5);
                            InitializeStateLoadWeb.Params params12 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                            this.L$0 = initializeSDK5;
                            this.L$1 = obj5;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 9;
                            value5 = initializeStateLoadWeb2.mo5927invokegIAlus(params12, this);
                            if (value5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj6 = obj5;
                            if (Result.m7910isFailureimpl(value5)) {
                                initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                                this.L$0 = initializeSDK5;
                                this.L$1 = obj6;
                                this.L$2 = value5;
                                this.label = 10;
                                if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            obj5 = obj6;
                            ResultKt.throwOnFailure(value5);
                            webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                            break;
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        InitializeStateCreate initializeStateCreate2 = initializeSDK5.initializeStateCreate;
                        ResultKt.throwOnFailure(obj5);
                        InitializeStateCreate.Params params13 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj5;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        obj7 = initializeStateCreate2.mo5927invokegIAlus(params13, this);
                        if (obj7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        initializeSDK6 = initializeSDK5;
                        obj8 = obj5;
                        value6 = obj7;
                        if (Result.m7910isFailureimpl(value6)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                            this.L$0 = initializeSDK6;
                            this.L$1 = obj8;
                            this.label = 12;
                            if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateComplete initializeStateComplete2 = initializeSDK6.initializeStateComplete;
                        ResultKt.throwOnFailure(obj8);
                        InitializeStateComplete.Params params14 = new InitializeStateComplete.Params((Configuration) obj8);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 13;
                        value7 = initializeStateComplete2.mo5927invokegIAlus(params14, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value7);
                        objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                        if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                        } else {
                            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                            if (thM7907exceptionOrNullimpl != null) {
                                Result.Companion companion5 = Result.INSTANCE;
                                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                            }
                        }
                        return Result.m7903boximpl(objM7904constructorimpl);
                    }
                    errorState = ErrorState.ResetWebApp;
                    thM7907exceptionOrNullimpl3 = Result.m7907exceptionOrNullimpl(value2);
                    this.L$0 = value2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (initializeSDK4.m5931executeErrorStateBWLJW6A(errorState, thM7907exceptionOrNullimpl3, configuration2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    thM7907exceptionOrNullimpl4 = Result.m7907exceptionOrNullimpl(value2);
                    if (thM7907exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM7907exceptionOrNullimpl4;
                case 2:
                    initializeSDK3 = (InitializeSDK) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value = ((Result) obj).getValue();
                    thM7907exceptionOrNullimpl2 = Result.m7907exceptionOrNullimpl(value);
                    if (thM7907exceptionOrNullimpl2 != null) {
                        DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + thM7907exceptionOrNullimpl2.getMessage());
                    }
                    configuration = new Configuration();
                    if (Result.m7910isFailureimpl(value)) {
                        value = configuration;
                    }
                    configuration2 = (Configuration) value;
                    InitializeStateReset initializeStateReset3 = initializeSDK3.initializeStateReset;
                    InitializeStateReset.Params params15 = new InitializeStateReset.Params(configuration2);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK3;
                    this.L$2 = configuration2;
                    this.label = 3;
                    obj3 = initializeStateReset3.mo5927invokegIAlus(params15, this);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK4 = initializeSDK3;
                    value2 = obj3;
                    if (Result.m7910isFailureimpl(value2)) {
                        InitializeStateConfig initializeStateConfig3 = initializeSDK4.initializeStateConfig;
                        InitializeStateConfig.Params params16 = new InitializeStateConfig.Params(configuration2);
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK4;
                        this.L$2 = configuration2;
                        this.label = 5;
                        value3 = initializeStateConfig3.mo5927invokegIAlus(params16, this);
                        if (value3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        initializeSDK5 = initializeSDK4;
                        configuration3 = configuration2;
                        if (Result.m7910isFailureimpl(value3)) {
                            initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(value3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK5;
                            this.L$2 = configuration3;
                            this.L$3 = value3;
                            this.label = 6;
                            if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateLoadCache initializeStateLoadCache3 = initializeSDK5.initializeStateLoadCache;
                        ResultKt.throwOnFailure(value3);
                        InitializeStateLoadCache.Params params17 = new InitializeStateLoadCache.Params((Configuration) value3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK5;
                        this.L$2 = configuration3;
                        this.L$3 = value3;
                        this.label = 7;
                        value4 = initializeStateLoadCache3.mo5927invokegIAlus(params17, this);
                        if (value4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        CoroutineScope coroutineScope5 = coroutineScope2;
                        Object obj11 = value3;
                        obj4 = value4;
                        obj5 = obj11;
                        if (Result.m7910isFailureimpl(obj4)) {
                            errorState2 = ErrorState.LoadCache;
                            thM7907exceptionOrNullimpl5 = Result.m7907exceptionOrNullimpl(obj4);
                            this.L$0 = obj4;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 8;
                            if (initializeSDK5.m5931executeErrorStateBWLJW6A(errorState2, thM7907exceptionOrNullimpl5, configuration3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                            if (thM7907exceptionOrNullimpl6 == null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw thM7907exceptionOrNullimpl6;
                        }
                        ResultKt.throwOnFailure(obj4);
                        loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj4;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (!configuration3.getExperiments().isWebViewAsyncDownloadEnabled()) {
                            }
                            InitializeStateLoadWeb initializeStateLoadWeb3 = initializeSDK5.initializeStateLoadWeb;
                            ResultKt.throwOnFailure(obj5);
                            InitializeStateLoadWeb.Params params18 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                            this.L$0 = initializeSDK5;
                            this.L$1 = obj5;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 9;
                            value5 = initializeStateLoadWeb3.mo5927invokegIAlus(params18, this);
                            if (value5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj6 = obj5;
                            if (Result.m7910isFailureimpl(value5)) {
                                initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                                this.L$0 = initializeSDK5;
                                this.L$1 = obj6;
                                this.L$2 = value5;
                                this.label = 10;
                                if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            obj5 = obj6;
                            ResultKt.throwOnFailure(value5);
                            webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                            break;
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        InitializeStateCreate initializeStateCreate3 = initializeSDK5.initializeStateCreate;
                        ResultKt.throwOnFailure(obj5);
                        InitializeStateCreate.Params params19 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj5;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        obj7 = initializeStateCreate3.mo5927invokegIAlus(params19, this);
                        if (obj7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        initializeSDK6 = initializeSDK5;
                        obj8 = obj5;
                        value6 = obj7;
                        if (Result.m7910isFailureimpl(value6)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                            this.L$0 = initializeSDK6;
                            this.L$1 = obj8;
                            this.label = 12;
                            if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateComplete initializeStateComplete3 = initializeSDK6.initializeStateComplete;
                        ResultKt.throwOnFailure(obj8);
                        InitializeStateComplete.Params params110 = new InitializeStateComplete.Params((Configuration) obj8);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 13;
                        value7 = initializeStateComplete3.mo5927invokegIAlus(params110, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value7);
                        objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                        if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                        } else {
                            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                            if (thM7907exceptionOrNullimpl != null) {
                                Result.Companion companion7 = Result.INSTANCE;
                                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                            }
                        }
                        return Result.m7903boximpl(objM7904constructorimpl);
                    }
                    errorState = ErrorState.ResetWebApp;
                    thM7907exceptionOrNullimpl3 = Result.m7907exceptionOrNullimpl(value2);
                    this.L$0 = value2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (initializeSDK4.m5931executeErrorStateBWLJW6A(errorState, thM7907exceptionOrNullimpl3, configuration2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    thM7907exceptionOrNullimpl4 = Result.m7907exceptionOrNullimpl(value2);
                    if (thM7907exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM7907exceptionOrNullimpl4;
                case 3:
                    Configuration configuration4 = (Configuration) this.L$2;
                    initializeSDK4 = (InitializeSDK) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value2 = ((Result) obj).getValue();
                    configuration2 = configuration4;
                    if (Result.m7910isFailureimpl(value2)) {
                        InitializeStateConfig initializeStateConfig4 = initializeSDK4.initializeStateConfig;
                        InitializeStateConfig.Params params111 = new InitializeStateConfig.Params(configuration2);
                        this.L$0 = coroutineScope;
                        this.L$1 = initializeSDK4;
                        this.L$2 = configuration2;
                        this.label = 5;
                        value3 = initializeStateConfig4.mo5927invokegIAlus(params111, this);
                        if (value3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        initializeSDK5 = initializeSDK4;
                        configuration3 = configuration2;
                        if (Result.m7910isFailureimpl(value3)) {
                            initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(value3);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK5;
                            this.L$2 = configuration3;
                            this.L$3 = value3;
                            this.label = 6;
                            if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateLoadCache initializeStateLoadCache4 = initializeSDK5.initializeStateLoadCache;
                        ResultKt.throwOnFailure(value3);
                        InitializeStateLoadCache.Params params112 = new InitializeStateLoadCache.Params((Configuration) value3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK5;
                        this.L$2 = configuration3;
                        this.L$3 = value3;
                        this.label = 7;
                        value4 = initializeStateLoadCache4.mo5927invokegIAlus(params112, this);
                        if (value4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        CoroutineScope coroutineScope6 = coroutineScope2;
                        Object obj12 = value3;
                        obj4 = value4;
                        obj5 = obj12;
                        if (Result.m7910isFailureimpl(obj4)) {
                            errorState2 = ErrorState.LoadCache;
                            thM7907exceptionOrNullimpl5 = Result.m7907exceptionOrNullimpl(obj4);
                            this.L$0 = obj4;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 8;
                            if (initializeSDK5.m5931executeErrorStateBWLJW6A(errorState2, thM7907exceptionOrNullimpl5, configuration3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                            if (thM7907exceptionOrNullimpl6 == null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw thM7907exceptionOrNullimpl6;
                        }
                        ResultKt.throwOnFailure(obj4);
                        loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj4;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (!configuration3.getExperiments().isWebViewAsyncDownloadEnabled()) {
                            }
                            InitializeStateLoadWeb initializeStateLoadWeb4 = initializeSDK5.initializeStateLoadWeb;
                            ResultKt.throwOnFailure(obj5);
                            InitializeStateLoadWeb.Params params113 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                            this.L$0 = initializeSDK5;
                            this.L$1 = obj5;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 9;
                            value5 = initializeStateLoadWeb4.mo5927invokegIAlus(params113, this);
                            if (value5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj6 = obj5;
                            if (Result.m7910isFailureimpl(value5)) {
                                initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                                this.L$0 = initializeSDK5;
                                this.L$1 = obj6;
                                this.L$2 = value5;
                                this.label = 10;
                                if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            obj5 = obj6;
                            ResultKt.throwOnFailure(value5);
                            webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                            break;
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        InitializeStateCreate initializeStateCreate4 = initializeSDK5.initializeStateCreate;
                        ResultKt.throwOnFailure(obj5);
                        InitializeStateCreate.Params params114 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj5;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        obj7 = initializeStateCreate4.mo5927invokegIAlus(params114, this);
                        if (obj7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        initializeSDK6 = initializeSDK5;
                        obj8 = obj5;
                        value6 = obj7;
                        if (Result.m7910isFailureimpl(value6)) {
                            initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                            this.L$0 = initializeSDK6;
                            this.L$1 = obj8;
                            this.label = 12;
                            if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        InitializeStateComplete initializeStateComplete4 = initializeSDK6.initializeStateComplete;
                        ResultKt.throwOnFailure(obj8);
                        InitializeStateComplete.Params params115 = new InitializeStateComplete.Params((Configuration) obj8);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 13;
                        value7 = initializeStateComplete4.mo5927invokegIAlus(params115, this);
                        if (value7 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ResultKt.throwOnFailure(value7);
                        objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                        if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                            Result.Companion companion8 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                        } else {
                            thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                            if (thM7907exceptionOrNullimpl != null) {
                                Result.Companion companion9 = Result.INSTANCE;
                                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                            }
                        }
                        return Result.m7903boximpl(objM7904constructorimpl);
                    }
                    errorState = ErrorState.ResetWebApp;
                    thM7907exceptionOrNullimpl3 = Result.m7907exceptionOrNullimpl(value2);
                    this.L$0 = value2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (initializeSDK4.m5931executeErrorStateBWLJW6A(errorState, thM7907exceptionOrNullimpl3, configuration2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    thM7907exceptionOrNullimpl4 = Result.m7907exceptionOrNullimpl(value2);
                    if (thM7907exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM7907exceptionOrNullimpl4;
                case 4:
                    value2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                    thM7907exceptionOrNullimpl4 = Result.m7907exceptionOrNullimpl(value2);
                    if (thM7907exceptionOrNullimpl4 == null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw thM7907exceptionOrNullimpl4;
                case 5:
                    Configuration configuration5 = (Configuration) this.L$2;
                    InitializeSDK initializeSDK7 = (InitializeSDK) this.L$1;
                    CoroutineScope coroutineScope7 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    coroutineScope2 = coroutineScope7;
                    initializeSDK5 = initializeSDK7;
                    configuration3 = configuration5;
                    value3 = ((Result) obj).getValue();
                    if (Result.m7910isFailureimpl(value3)) {
                        initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(value3);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK5;
                        this.L$2 = configuration3;
                        this.L$3 = value3;
                        this.label = 6;
                        if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateLoadCache initializeStateLoadCache5 = initializeSDK5.initializeStateLoadCache;
                    ResultKt.throwOnFailure(value3);
                    InitializeStateLoadCache.Params params116 = new InitializeStateLoadCache.Params((Configuration) value3);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK5;
                    this.L$2 = configuration3;
                    this.L$3 = value3;
                    this.label = 7;
                    value4 = initializeStateLoadCache5.mo5927invokegIAlus(params116, this);
                    if (value4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    CoroutineScope coroutineScope8 = coroutineScope2;
                    Object obj13 = value3;
                    obj4 = value4;
                    obj5 = obj13;
                    if (Result.m7910isFailureimpl(obj4)) {
                        errorState2 = ErrorState.LoadCache;
                        thM7907exceptionOrNullimpl5 = Result.m7907exceptionOrNullimpl(obj4);
                        this.L$0 = obj4;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 8;
                        if (initializeSDK5.m5931executeErrorStateBWLJW6A(errorState2, thM7907exceptionOrNullimpl5, configuration3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                        if (thM7907exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM7907exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(obj4);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj4;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration3.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb5 = initializeSDK5.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj5);
                        InitializeStateLoadWeb.Params params117 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj5;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 9;
                        value5 = initializeStateLoadWeb5.mo5927invokegIAlus(params117, this);
                        if (value5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj6 = obj5;
                        if (Result.m7910isFailureimpl(value5)) {
                            initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                            this.L$0 = initializeSDK5;
                            this.L$1 = obj6;
                            this.L$2 = value5;
                            this.label = 10;
                            if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        obj5 = obj6;
                        ResultKt.throwOnFailure(value5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate5 = initializeSDK5.initializeStateCreate;
                    ResultKt.throwOnFailure(obj5);
                    InitializeStateCreate.Params params118 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                    this.L$0 = initializeSDK5;
                    this.L$1 = obj5;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 11;
                    obj7 = initializeStateCreate5.mo5927invokegIAlus(params118, this);
                    if (obj7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK6 = initializeSDK5;
                    obj8 = obj5;
                    value6 = obj7;
                    if (Result.m7910isFailureimpl(value6)) {
                        initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                        this.L$0 = initializeSDK6;
                        this.L$1 = obj8;
                        this.label = 12;
                        if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete5 = initializeSDK6.initializeStateComplete;
                    ResultKt.throwOnFailure(obj8);
                    InitializeStateComplete.Params params119 = new InitializeStateComplete.Params((Configuration) obj8);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 13;
                    value7 = initializeStateComplete5.mo5927invokegIAlus(params119, this);
                    if (value7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion10 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion11 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                case 6:
                    value3 = this.L$3;
                    configuration3 = (Configuration) this.L$2;
                    initializeSDK5 = (InitializeSDK) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    InitializeStateLoadCache initializeStateLoadCache6 = initializeSDK5.initializeStateLoadCache;
                    ResultKt.throwOnFailure(value3);
                    InitializeStateLoadCache.Params params1110 = new InitializeStateLoadCache.Params((Configuration) value3);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK5;
                    this.L$2 = configuration3;
                    this.L$3 = value3;
                    this.label = 7;
                    value4 = initializeStateLoadCache6.mo5927invokegIAlus(params1110, this);
                    if (value4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    CoroutineScope coroutineScope9 = coroutineScope2;
                    Object obj14 = value3;
                    obj4 = value4;
                    obj5 = obj14;
                    if (Result.m7910isFailureimpl(obj4)) {
                        errorState2 = ErrorState.LoadCache;
                        thM7907exceptionOrNullimpl5 = Result.m7907exceptionOrNullimpl(obj4);
                        this.L$0 = obj4;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 8;
                        if (initializeSDK5.m5931executeErrorStateBWLJW6A(errorState2, thM7907exceptionOrNullimpl5, configuration3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                        if (thM7907exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM7907exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(obj4);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj4;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration3.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb6 = initializeSDK5.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj5);
                        InitializeStateLoadWeb.Params params1111 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj5;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 9;
                        value5 = initializeStateLoadWeb6.mo5927invokegIAlus(params1111, this);
                        if (value5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj6 = obj5;
                        if (Result.m7910isFailureimpl(value5)) {
                            initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                            this.L$0 = initializeSDK5;
                            this.L$1 = obj6;
                            this.L$2 = value5;
                            this.label = 10;
                            if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        obj5 = obj6;
                        ResultKt.throwOnFailure(value5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate6 = initializeSDK5.initializeStateCreate;
                    ResultKt.throwOnFailure(obj5);
                    InitializeStateCreate.Params params1112 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                    this.L$0 = initializeSDK5;
                    this.L$1 = obj5;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 11;
                    obj7 = initializeStateCreate6.mo5927invokegIAlus(params1112, this);
                    if (obj7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK6 = initializeSDK5;
                    obj8 = obj5;
                    value6 = obj7;
                    if (Result.m7910isFailureimpl(value6)) {
                        initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                        this.L$0 = initializeSDK6;
                        this.L$1 = obj8;
                        this.label = 12;
                        if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete6 = initializeSDK6.initializeStateComplete;
                    ResultKt.throwOnFailure(obj8);
                    InitializeStateComplete.Params params1113 = new InitializeStateComplete.Params((Configuration) obj8);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 13;
                    value7 = initializeStateComplete6.mo5927invokegIAlus(params1113, this);
                    if (value7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion12 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion13 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                case 7:
                    value3 = this.L$3;
                    configuration3 = (Configuration) this.L$2;
                    initializeSDK5 = (InitializeSDK) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value4 = ((Result) obj).getValue();
                    CoroutineScope coroutineScope10 = coroutineScope2;
                    Object obj15 = value3;
                    obj4 = value4;
                    obj5 = obj15;
                    if (Result.m7910isFailureimpl(obj4)) {
                        errorState2 = ErrorState.LoadCache;
                        thM7907exceptionOrNullimpl5 = Result.m7907exceptionOrNullimpl(obj4);
                        this.L$0 = obj4;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 8;
                        if (initializeSDK5.m5931executeErrorStateBWLJW6A(errorState2, thM7907exceptionOrNullimpl5, configuration3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                        if (thM7907exceptionOrNullimpl6 == null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw thM7907exceptionOrNullimpl6;
                    }
                    ResultKt.throwOnFailure(obj4);
                    loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj4;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (!configuration3.getExperiments().isWebViewAsyncDownloadEnabled()) {
                        }
                        InitializeStateLoadWeb initializeStateLoadWeb7 = initializeSDK5.initializeStateLoadWeb;
                        ResultKt.throwOnFailure(obj5);
                        InitializeStateLoadWeb.Params params1114 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj5;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 9;
                        value5 = initializeStateLoadWeb7.mo5927invokegIAlus(params1114, this);
                        if (value5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj6 = obj5;
                        if (Result.m7910isFailureimpl(value5)) {
                            initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                            this.L$0 = initializeSDK5;
                            this.L$1 = obj6;
                            this.L$2 = value5;
                            this.label = 10;
                            if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        obj5 = obj6;
                        ResultKt.throwOnFailure(value5);
                        webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                        break;
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    InitializeStateCreate initializeStateCreate7 = initializeSDK5.initializeStateCreate;
                    ResultKt.throwOnFailure(obj5);
                    InitializeStateCreate.Params params1115 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                    this.L$0 = initializeSDK5;
                    this.L$1 = obj5;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 11;
                    obj7 = initializeStateCreate7.mo5927invokegIAlus(params1115, this);
                    if (obj7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK6 = initializeSDK5;
                    obj8 = obj5;
                    value6 = obj7;
                    if (Result.m7910isFailureimpl(value6)) {
                        initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                        this.L$0 = initializeSDK6;
                        this.L$1 = obj8;
                        this.label = 12;
                        if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete7 = initializeSDK6.initializeStateComplete;
                    ResultKt.throwOnFailure(obj8);
                    InitializeStateComplete.Params params1116 = new InitializeStateComplete.Params((Configuration) obj8);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 13;
                    value7 = initializeStateComplete7.mo5927invokegIAlus(params1116, this);
                    if (value7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion14 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion15 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                case 8:
                    obj4 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                    thM7907exceptionOrNullimpl6 = Result.m7907exceptionOrNullimpl(obj4);
                    if (thM7907exceptionOrNullimpl6 == null) {
                        throw new Exception(ErrorState.LoadCache.toString());
                    }
                    throw thM7907exceptionOrNullimpl6;
                case 9:
                    Object obj16 = this.L$1;
                    InitializeSDK initializeSDK8 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    initializeSDK5 = initializeSDK8;
                    obj6 = obj16;
                    value5 = ((Result) obj).getValue();
                    if (Result.m7910isFailureimpl(value5)) {
                        initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(value5);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj6;
                        this.L$2 = value5;
                        this.label = 10;
                        if (initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    obj5 = obj6;
                    ResultKt.throwOnFailure(value5);
                    webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                    InitializeStateCreate initializeStateCreate8 = initializeSDK5.initializeStateCreate;
                    ResultKt.throwOnFailure(obj5);
                    InitializeStateCreate.Params params1117 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                    this.L$0 = initializeSDK5;
                    this.L$1 = obj5;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 11;
                    obj7 = initializeStateCreate8.mo5927invokegIAlus(params1117, this);
                    if (obj7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK6 = initializeSDK5;
                    obj8 = obj5;
                    value6 = obj7;
                    if (Result.m7910isFailureimpl(value6)) {
                        initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                        this.L$0 = initializeSDK6;
                        this.L$1 = obj8;
                        this.label = 12;
                        if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete8 = initializeSDK6.initializeStateComplete;
                    ResultKt.throwOnFailure(obj8);
                    InitializeStateComplete.Params params1118 = new InitializeStateComplete.Params((Configuration) obj8);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 13;
                    value7 = initializeStateComplete8.mo5927invokegIAlus(params1118, this);
                    if (value7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion16 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion17 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                case 10:
                    value5 = this.L$2;
                    obj6 = this.L$1;
                    initializeSDK5 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj5 = obj6;
                    ResultKt.throwOnFailure(value5);
                    webViewData = ((InitializeStateLoadWeb.LoadWebResult) value5).getWebViewDataString();
                    InitializeStateCreate initializeStateCreate9 = initializeSDK5.initializeStateCreate;
                    ResultKt.throwOnFailure(obj5);
                    InitializeStateCreate.Params params1119 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                    this.L$0 = initializeSDK5;
                    this.L$1 = obj5;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 11;
                    obj7 = initializeStateCreate9.mo5927invokegIAlus(params1119, this);
                    if (obj7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK6 = initializeSDK5;
                    obj8 = obj5;
                    value6 = obj7;
                    if (Result.m7910isFailureimpl(value6)) {
                        initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                        this.L$0 = initializeSDK6;
                        this.L$1 = obj8;
                        this.label = 12;
                        if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete9 = initializeSDK6.initializeStateComplete;
                    ResultKt.throwOnFailure(obj8);
                    InitializeStateComplete.Params params11110 = new InitializeStateComplete.Params((Configuration) obj8);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 13;
                    value7 = initializeStateComplete9.mo5927invokegIAlus(params11110, this);
                    if (value7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion18 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion19 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                case 11:
                    obj8 = this.L$1;
                    initializeSDK6 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    value6 = ((Result) obj).getValue();
                    if (Result.m7910isFailureimpl(value6)) {
                        initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(value6);
                        this.L$0 = initializeSDK6;
                        this.L$1 = obj8;
                        this.label = 12;
                        if (initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InitializeStateComplete initializeStateComplete10 = initializeSDK6.initializeStateComplete;
                    ResultKt.throwOnFailure(obj8);
                    InitializeStateComplete.Params params11111 = new InitializeStateComplete.Params((Configuration) obj8);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 13;
                    value7 = initializeStateComplete10.mo5927invokegIAlus(params11111, this);
                    if (value7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion110 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion111 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                case 12:
                    obj8 = this.L$1;
                    initializeSDK6 = (InitializeSDK) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    InitializeStateComplete initializeStateComplete11 = initializeSDK6.initializeStateComplete;
                    ResultKt.throwOnFailure(obj8);
                    InitializeStateComplete.Params params11112 = new InitializeStateComplete.Params((Configuration) obj8);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 13;
                    value7 = initializeStateComplete11.mo5927invokegIAlus(params11112, this);
                    if (value7 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion112 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion113 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                case 13:
                    ResultKt.throwOnFailure(obj);
                    value7 = ((Result) obj).getValue();
                    ResultKt.throwOnFailure(value7);
                    objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
                    if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
                        Result.Companion companion114 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(objM7904constructorimpl);
                    } else {
                        thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                        if (thM7907exceptionOrNullimpl != null) {
                            Result.Companion companion115 = Result.INSTANCE;
                            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(thM7907exceptionOrNullimpl));
                        }
                    }
                    return Result.m7903boximpl(objM7904constructorimpl);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion20 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }
}
