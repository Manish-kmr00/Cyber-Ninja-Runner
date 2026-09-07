package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/ironsource/ad;", "Lcom/ironsource/lo;", "Lcom/ironsource/bd;", "loadListener", "", "a", "Lcom/ironsource/cd;", "showListener", "onInterstitialInitSuccess", "", "description", "onInterstitialInitFailed", "Lcom/ironsource/rj;", b9.h.p0, "onInterstitialLoadSuccess", "onInterstitialLoadFailed", "onInterstitialOpen", "demandSourceId", "", "amount", "onInterstitialAdRewarded", "onInterstitialClose", "onInterstitialShowSuccess", "onInterstitialShowFailed", "onInterstitialClick", b9.h.j0, "Lorg/json/JSONObject;", b9.h.l0, "onInterstitialEventNotificationReceived", "Lcom/ironsource/bd;", "Ljava/lang/ref/WeakReference;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/ref/WeakReference;", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public final class ad implements lo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private bd loadListener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private WeakReference<cd> showListener = new WeakReference<>(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ironsource/ad$a;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "AD_VISIBLE_EVENT_NAME", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3519a = new a();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static final String AD_VISIBLE_EVENT_NAME = "impressions";

        private a() {
        }
    }

    public final void a(bd loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        this.loadListener = loadListener;
    }

    public final void a(cd showListener) {
        Intrinsics.checkNotNullParameter(showListener, "showListener");
        this.showListener = new WeakReference<>(showListener);
    }

    @Override // com.json.lo
    public void onInterstitialAdRewarded(String demandSourceId, int amount) {
        cd cdVar = this.showListener.get();
        if (cdVar != null) {
            cdVar.onAdInstanceDidReward(demandSourceId, amount);
        }
    }

    @Override // com.json.lo
    public void onInterstitialClick() {
        cd cdVar = this.showListener.get();
        if (cdVar != null) {
            cdVar.onAdInstanceDidClick();
        }
    }

    @Override // com.json.lo
    public void onInterstitialClose() {
        cd cdVar = this.showListener.get();
        if (cdVar != null) {
            cdVar.onAdInstanceDidDismiss();
        }
    }

    @Override // com.json.lo
    public void onInterstitialEventNotificationReceived(String eventName, JSONObject extData) {
        cd cdVar;
        if (!Intrinsics.areEqual(eventName, "impressions") || (cdVar = this.showListener.get()) == null) {
            return;
        }
        cdVar.onAdInstanceDidBecomeVisible();
    }

    @Override // com.json.lo
    public void onInterstitialInitFailed(String description) {
    }

    @Override // com.json.lo
    public void onInterstitialInitSuccess() {
    }

    @Override // com.json.lo
    public void onInterstitialLoadFailed(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        bd bdVar = this.loadListener;
        if (bdVar != null) {
            bdVar.a(description);
        }
    }

    @Override // com.json.lo
    public void onInterstitialLoadSuccess(rj adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        bd bdVar = this.loadListener;
        if (bdVar != null) {
            bdVar.a(adInstance);
        }
    }

    @Override // com.json.lo
    public void onInterstitialOpen() {
        cd cdVar = this.showListener.get();
        if (cdVar != null) {
            cdVar.onAdInstanceDidShow();
        }
    }

    @Override // com.json.lo
    public void onInterstitialShowFailed(String description) {
        cd cdVar = this.showListener.get();
        if (cdVar != null) {
            cdVar.a(description);
        }
    }

    @Override // com.json.lo
    public void onInterstitialShowSuccess() {
    }
}
