package com.vungle.ads.internal.network;

import com.vungle.ads.TpatError;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.ErrorInfo;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: TpatSender.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018H\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0007H\u0000¢\u0006\u0002\b%J\u001c\u0010&\u001a\u00020\u001f2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0002J\u001c\u0010(\u001a\u00020\u001f2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u0017H\u0002J&\u0010)\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010$\u001a\u00020\u0007J\u0016\u0010-\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0007J\u001c\u0010.\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0018002\u0006\u0010$\u001a\u00020\u0007J\u0016\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lcom/vungle/ads/internal/network/TpatSender;", "", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "logEntry", "Lcom/vungle/ads/internal/util/LogEntry;", "ioExecutor", "Ljava/util/concurrent/Executor;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "signalManager", "Lcom/vungle/ads/internal/signals/SignalManager;", "(Lcom/vungle/ads/internal/network/VungleApiClient;Lcom/vungle/ads/internal/util/LogEntry;Ljava/util/concurrent/Executor;Lcom/vungle/ads/internal/util/PathProvider;Lcom/vungle/ads/internal/signals/SignalManager;)V", "genericTpatFilePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "getLogEntry", "()Lcom/vungle/ads/internal/util/LogEntry;", "getSignalManager", "()Lcom/vungle/ads/internal/signals/SignalManager;", "tpatFilePreferences", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "getStoredGenericTpats", "", "", "Lcom/vungle/ads/internal/network/GenericTpatRequest;", "getStoredTpats", "", "injectSessionIdToUrl", "url", "logTpatError", "", "error", "Lcom/vungle/ads/internal/model/ErrorInfo;", "urlWithSessionId", "resendStoredTpats", "executor", "resendStoredTpats$vungle_ads_release", "saveStoredGenericTpats", "tpats", "saveStoredTpats", "sendGenericTpat", "request", "retry", "", "sendTpat", "sendTpats", "urls", "", "sendWinNotification", "urlString", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TpatSender {
    private static final String FAILED_GENERIC_TPATS = "FAILED_GENERIC_TPATS";
    private static final String FAILED_TPATS = "FAILED_TPATS";
    private static final int MAX_RETRIES = 5;
    private static final String TAG = "TpatSender";
    private final FilePreferences genericTpatFilePreferences;
    private final LogEntry logEntry;
    private final SignalManager signalManager;
    private final FilePreferences tpatFilePreferences;
    private final VungleApiClient vungleApiClient;

    /* JADX INFO: compiled from: TpatSender.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            iArr[HttpMethod.GET.ordinal()] = 1;
            iArr[HttpMethod.POST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TpatSender(VungleApiClient vungleApiClient, LogEntry logEntry, Executor ioExecutor, PathProvider pathProvider, SignalManager signalManager) {
        Intrinsics.checkNotNullParameter(vungleApiClient, "vungleApiClient");
        Intrinsics.checkNotNullParameter(ioExecutor, "ioExecutor");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        this.vungleApiClient = vungleApiClient;
        this.logEntry = logEntry;
        this.signalManager = signalManager;
        this.tpatFilePreferences = FilePreferences.INSTANCE.get(ioExecutor, pathProvider, FilePreferences.TPAT_FAILED_FILENAME);
        this.genericTpatFilePreferences = FilePreferences.INSTANCE.get(ioExecutor, pathProvider, FilePreferences.GENERIC_TPAT_FAILED_FILENAME);
    }

    public /* synthetic */ TpatSender(VungleApiClient vungleApiClient, LogEntry logEntry, Executor executor, PathProvider pathProvider, SignalManager signalManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vungleApiClient, (i & 2) != 0 ? null : logEntry, executor, pathProvider, (i & 16) != 0 ? null : signalManager);
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final LogEntry getLogEntry() {
        return this.logEntry;
    }

    public final SignalManager getSignalManager() {
        return this.signalManager;
    }

    public final void sendWinNotification(String urlString, Executor executor) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(executor, "executor");
        final String strInjectSessionIdToUrl = injectSessionIdToUrl(urlString);
        executor.execute(new Runnable() { // from class: com.vungle.ads.internal.network.TpatSender$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TpatSender.m6057sendWinNotification$lambda0(this.f$0, strInjectSessionIdToUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendWinNotification$lambda-0, reason: not valid java name */
    public static final void m6057sendWinNotification$lambda0(TpatSender this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        ErrorInfo errorInfoPingTPAT$default = VungleApiClient.pingTPAT$default(this$0.vungleApiClient, url, null, null, null, this$0.logEntry, 14, null);
        if (errorInfoPingTPAT$default != null) {
            new TpatError(Sdk.SDKError.Reason.AD_WIN_NOTIFICATION_ERROR, "Fail to send " + url + ", error: " + errorInfoPingTPAT$default.getDescription()).setLogEntry$vungle_ads_release(this$0.logEntry).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public final void sendTpat(final String url, Executor executor) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(executor, "executor");
        final String strInjectSessionIdToUrl = injectSessionIdToUrl(url);
        executor.execute(new Runnable() { // from class: com.vungle.ads.internal.network.TpatSender$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TpatSender.m6056sendTpat$lambda2(this.f$0, url, strInjectSessionIdToUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendTpat$lambda-2, reason: not valid java name */
    public static final void m6056sendTpat$lambda2(TpatSender this$0, String url, String urlWithSessionId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(urlWithSessionId, "$urlWithSessionId");
        Map<String, Integer> storedTpats = this$0.getStoredTpats();
        Integer num = storedTpats.get(url);
        int iIntValue = num != null ? num.intValue() : 0;
        ErrorInfo errorInfoPingTPAT$default = VungleApiClient.pingTPAT$default(this$0.vungleApiClient, urlWithSessionId, null, null, null, this$0.logEntry, 14, null);
        if (errorInfoPingTPAT$default == null) {
            if (iIntValue != 0) {
                storedTpats.remove(url);
                this$0.saveStoredTpats(storedTpats);
                return;
            }
            return;
        }
        if (!errorInfoPingTPAT$default.getErrorIsTerminal()) {
            if (iIntValue >= 5) {
                storedTpats.remove(url);
                this$0.saveStoredTpats(storedTpats);
                new TpatError(Sdk.SDKError.Reason.TPAT_RETRY_FAILED, urlWithSessionId).setLogEntry$vungle_ads_release(this$0.logEntry).logErrorNoReturnValue$vungle_ads_release();
            } else {
                storedTpats.put(url, Integer.valueOf(iIntValue + 1));
                this$0.saveStoredTpats(storedTpats);
            }
        }
        this$0.logTpatError(errorInfoPingTPAT$default, urlWithSessionId);
    }

    public final void sendGenericTpat(final String url, final GenericTpatRequest request, final boolean retry, Executor executor) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(executor, "executor");
        final String strInjectSessionIdToUrl = injectSessionIdToUrl(url);
        executor.execute(new Runnable() { // from class: com.vungle.ads.internal.network.TpatSender$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TpatSender.m6055sendGenericTpat$lambda3(this.f$0, url, request, strInjectSessionIdToUrl, retry);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendGenericTpat$lambda-3, reason: not valid java name */
    public static final void m6055sendGenericTpat$lambda3(TpatSender this$0, String url, GenericTpatRequest request, String urlWithSessionId, boolean z) {
        ErrorInfo errorInfoPingTPAT$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(urlWithSessionId, "$urlWithSessionId");
        Map<String, GenericTpatRequest> storedGenericTpats = this$0.getStoredGenericTpats();
        GenericTpatRequest genericTpatRequest = storedGenericTpats.get(url);
        int attempt = genericTpatRequest != null ? genericTpatRequest.getAttempt() : 0;
        int i = WhenMappings.$EnumSwitchMapping$0[request.getMethod().ordinal()];
        if (i == 1) {
            errorInfoPingTPAT$default = VungleApiClient.pingTPAT$default(this$0.vungleApiClient, urlWithSessionId, request.getHeaders(), null, null, this$0.logEntry, 12, null);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            errorInfoPingTPAT$default = this$0.vungleApiClient.pingTPAT(urlWithSessionId, request.getHeaders(), request.getBody(), HttpMethod.POST, this$0.logEntry);
        }
        if (errorInfoPingTPAT$default == null) {
            if (attempt != 0) {
                storedGenericTpats.remove(url);
                this$0.saveStoredGenericTpats(storedGenericTpats);
                return;
            }
            return;
        }
        if (!errorInfoPingTPAT$default.getErrorIsTerminal() && z) {
            if (attempt >= 5) {
                storedGenericTpats.remove(url);
                this$0.saveStoredGenericTpats(storedGenericTpats);
                new TpatError(Sdk.SDKError.Reason.TPAT_RETRY_FAILED, urlWithSessionId).setLogEntry$vungle_ads_release(this$0.logEntry).logErrorNoReturnValue$vungle_ads_release();
            } else {
                GenericTpatRequest genericTpatRequest2 = storedGenericTpats.get(url);
                GenericTpatRequest genericTpatRequestCopy$default = genericTpatRequest2 != null ? GenericTpatRequest.copy$default(genericTpatRequest2, null, null, null, attempt + 1, 7, null) : null;
                if (genericTpatRequestCopy$default == null) {
                    genericTpatRequestCopy$default = new GenericTpatRequest(request.getMethod(), request.getHeaders(), request.getBody(), attempt + 1);
                }
                storedGenericTpats.put(url, genericTpatRequestCopy$default);
                this$0.saveStoredGenericTpats(storedGenericTpats);
            }
        }
        this$0.logTpatError(errorInfoPingTPAT$default, urlWithSessionId);
    }

    private final Map<String, Integer> getStoredTpats() {
        Object objM7904constructorimpl;
        String string = this.tpatFilePreferences.getString(FAILED_TPATS);
        if (string != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TpatSender tpatSender = this;
                Json.Companion companion2 = Json.INSTANCE;
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(companion2.getSerializersModule(), Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE)))));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objM7904constructorimpl = Result.m7904constructorimpl((Map) companion2.decodeFromString(kSerializerSerializer, string));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null) {
                Logger.INSTANCE.e(TAG, "Failed to decode stored tpats: " + thM7907exceptionOrNullimpl);
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            LinkedHashMap linkedHashMap = (Map) objM7904constructorimpl;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            if (linkedHashMap != null) {
                return linkedHashMap;
            }
        }
        return new LinkedHashMap();
    }

    private final Map<String, GenericTpatRequest> getStoredGenericTpats() {
        Object objM7904constructorimpl;
        String string = this.genericTpatFilePreferences.getString(FAILED_GENERIC_TPATS);
        if (string != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TpatSender tpatSender = this;
                Json.Companion companion2 = Json.INSTANCE;
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(companion2.getSerializersModule(), Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GenericTpatRequest.class)))));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                objM7904constructorimpl = Result.m7904constructorimpl((Map) companion2.decodeFromString(kSerializerSerializer, string));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
            if (thM7907exceptionOrNullimpl != null) {
                Logger.INSTANCE.e(TAG, "Failed to decode stored generic tpats: " + thM7907exceptionOrNullimpl);
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            LinkedHashMap linkedHashMap = (Map) objM7904constructorimpl;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            if (linkedHashMap != null) {
                return linkedHashMap;
            }
        }
        return new LinkedHashMap();
    }

    private final void saveStoredTpats(Map<String, Integer> tpats) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            TpatSender tpatSender = this;
            FilePreferences filePreferences = this.tpatFilePreferences;
            Json.Companion companion2 = Json.INSTANCE;
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(companion2.getSerializersModule(), Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE)))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            filePreferences.put(FAILED_TPATS, companion2.encodeToString(kSerializerSerializer, tpats)).apply();
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            Logger.INSTANCE.e(TAG, "Failed to encode the about to storing tpats: " + tpats);
        }
    }

    private final void saveStoredGenericTpats(Map<String, GenericTpatRequest> tpats) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            TpatSender tpatSender = this;
            FilePreferences filePreferences = this.genericTpatFilePreferences;
            Json.Companion companion2 = Json.INSTANCE;
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(companion2.getSerializersModule(), Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(GenericTpatRequest.class)))));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            filePreferences.put(FAILED_GENERIC_TPATS, companion2.encodeToString(kSerializerSerializer, tpats)).apply();
            objM7904constructorimpl = Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            Logger.INSTANCE.e(TAG, "Failed to encode the about to storing generic tpats: " + tpats);
        }
    }

    private final void logTpatError(ErrorInfo error, String urlWithSessionId) {
        Logger.INSTANCE.e(TAG, "Failed with " + error.getDescription() + ", url:" + urlWithSessionId);
        new TpatError(error.getReason(), "Fail to send " + urlWithSessionId + ", error: " + error.getDescription()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
    }

    public final void resendStoredTpats$vungle_ads_release(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Iterator<Map.Entry<String, Integer>> it = getStoredTpats().entrySet().iterator();
        while (it.hasNext()) {
            sendTpat(it.next().getKey(), executor);
        }
        for (Map.Entry<String, GenericTpatRequest> entry : getStoredGenericTpats().entrySet()) {
            String key = entry.getKey();
            GenericTpatRequest value = entry.getValue();
            sendGenericTpat(key, new GenericTpatRequest(value.getMethod(), value.getHeaders(), value.getBody(), 0, 8, (DefaultConstructorMarker) null), true, executor);
        }
    }

    public final String injectSessionIdToUrl(String url) {
        String uuid;
        Intrinsics.checkNotNullParameter(url, "url");
        SignalManager signalManager = this.signalManager;
        if (signalManager == null || (uuid = signalManager.getUuid()) == null) {
            uuid = "";
        }
        if (uuid.length() <= 0) {
            return url;
        }
        String strQuote = Pattern.quote(Constants.SESSION_ID);
        Intrinsics.checkNotNullExpressionValue(strQuote, "quote(Constants.SESSION_ID)");
        return new Regex(strQuote).replace(url, uuid);
    }

    public final void sendTpats(Iterable<String> urls, Executor executor) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Iterator<String> it = urls.iterator();
        while (it.hasNext()) {
            sendTpat(it.next(), executor);
        }
    }
}
