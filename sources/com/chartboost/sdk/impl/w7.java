package com.chartboost.sdk.impl;

import android.view.View;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010(\u001a\u00020&¢\u0006\u0004\b.\u0010/J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u001d\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\b\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b\b\u0010\"R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010'R\u0016\u0010*\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010'R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010,\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010'R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010'¨\u00060"}, d2 = {"Lcom/chartboost/sdk/impl/w7;", "", "", "l", "()V", "m", "", UnifiedMediationParams.KEY_SKIP_OFFSET, "a", "(Ljava/lang/Integer;)V", "Landroid/view/View;", "obstructionView", "(Landroid/view/View;)V", "", "videoDuration", "videoVolume", "(FF)V", "e", InneractiveMediationDefs.GENDER_FEMALE, "j", "d", "g", "h", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(F)V", "i", "Lcom/chartboost/sdk/impl/g8;", "playerState", "(Lcom/chartboost/sdk/impl/g8;)V", CampaignEx.JSON_KEY_AD_K, "", com.ironsource.b9.f.b, "Lcom/chartboost/sdk/impl/c7;", "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/c7;", "Lcom/chartboost/sdk/impl/v7$a;", "Lcom/chartboost/sdk/impl/v7$a;", "sessionHolder", "", "Z", "isOmSdkEnabled", "isQuartile1Notified", "isMidpointNotified", "isQuartile3Notified", "isCompleteNotified", "isSkipped", "<init>", "(Lcom/chartboost/sdk/impl/v7$a;Z)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class w7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v7.a sessionHolder;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final boolean isOmSdkEnabled;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean isQuartile1Notified;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean isMidpointNotified;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean isQuartile3Notified;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean isCompleteNotified;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean isSkipped;

    public w7(v7.a sessionHolder, boolean z) {
        Intrinsics.checkNotNullParameter(sessionHolder, "sessionHolder");
        this.sessionHolder = sessionHolder;
        this.isOmSdkEnabled = z;
    }

    public final void l() {
        Unit unit;
        if (!this.isOmSdkEnabled) {
            b7.b("OMSDK start session OM is disabled by the cb config!", null, 2, null);
            return;
        }
        try {
            p omSession = this.sessionHolder.getOmSession();
            if (omSession != null) {
                omSession.b();
                b7.a("Omid session started successfully! Version: " + p7.a(), (Throwable) null, 2, (Object) null);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Omid start session is null!", (Throwable) null, 2, (Object) null);
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m() {
        try {
            if (!this.isOmSdkEnabled) {
                b7.b("OMSDK stop session OM is disabled by the cb config!", null, 2, null);
                return;
            }
            try {
                p omSession = this.sessionHolder.getOmSession();
                if (omSession != null) {
                    omSession.a();
                    omSession.a(null);
                }
                p7.c();
                b7.a("Omid session finished!", (Throwable) null, 2, (Object) null);
            } catch (Exception e) {
                b7.b("OMSDK stop session exception", e);
            }
        } finally {
            this.sessionHolder.a((p) null);
            this.sessionHolder.a((k) null);
        }
    }

    public final void e() {
        try {
            if (this.isQuartile1Notified) {
                return;
            }
            b7.a("Signal media first quartile", (Throwable) null, 2, (Object) null);
            c7 c7VarA = a("signalMediaFirstQuartile");
            if (c7VarA != null) {
                c7VarA.d();
            }
            this.isQuartile1Notified = true;
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void f() {
        try {
            if (this.isMidpointNotified) {
                return;
            }
            b7.a("Signal media midpoint", (Throwable) null, 2, (Object) null);
            c7 c7VarA = a("signalMediaMidpoint");
            if (c7VarA != null) {
                c7VarA.e();
            }
            this.isMidpointNotified = true;
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void j() {
        try {
            if (this.isQuartile3Notified) {
                return;
            }
            b7.a("Signal media third quartile", (Throwable) null, 2, (Object) null);
            c7 c7VarA = a("signalMediaThirdQuartile");
            if (c7VarA != null) {
                c7VarA.i();
            }
            this.isQuartile3Notified = true;
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void d() {
        try {
            c7 c7VarA = a("signalMediaComplete");
            if (c7VarA != null) {
                c7VarA.c();
            }
            this.isCompleteNotified = true;
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void g() {
        try {
            c7 c7VarA = a("signalMediaPause");
            if (c7VarA != null) {
                c7VarA.f();
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void h() {
        try {
            c7 c7VarA = a("signalMediaResume");
            if (c7VarA != null) {
                c7VarA.g();
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void c() {
        try {
            c7 c7VarA = a("signalMediaBufferStart");
            if (c7VarA != null) {
                c7VarA.b();
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void b() {
        try {
            c7 c7VarA = a("signalMediaBufferFinish");
            if (c7VarA != null) {
                c7VarA.a();
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void i() {
        try {
            if (this.isSkipped || this.isCompleteNotified) {
                return;
            }
            b7.a("Signal media skipped", (Throwable) null, 2, (Object) null);
            c7 c7VarA = a("signalMediaSkipped");
            if (c7VarA != null) {
                c7VarA.h();
            }
            this.isSkipped = true;
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void k() {
        try {
            c7 c7VarA = a("signalUserInteractionClick");
            if (c7VarA != null) {
                c7VarA.a(x6.CLICK);
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final c7 a(String functionName) {
        if (this.sessionHolder.getMediaEvents() == null) {
            b7.a("MediaEvents are null when executing " + functionName, (Throwable) null, 2, (Object) null);
        } else {
            b7.a("MediaEvents valid when executing: " + functionName, (Throwable) null, 2, (Object) null);
        }
        return this.sessionHolder.getMediaEvents();
    }

    public final void a(View obstructionView) {
        Intrinsics.checkNotNullParameter(obstructionView, "obstructionView");
        p omSession = this.sessionHolder.getOmSession();
        if (omSession != null) {
            omSession.a(obstructionView, h5.OTHER, "Industry Icon");
        }
    }

    public final void a() {
        Unit unit;
        if (!this.isOmSdkEnabled) {
            b7.b("OMSDK signal impression event OM is disabled by the cb config!", null, 2, null);
            return;
        }
        try {
            k omAdEvents = this.sessionHolder.getOmAdEvents();
            if (omAdEvents != null) {
                omAdEvents.a();
                b7.a("Signal om ad event impression occurred!", (Throwable) null, 2, (Object) null);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Omid signal impression event is null!", (Throwable) null, 2, (Object) null);
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void a(Integer skipOffset) {
        Unit unit;
        cb cbVarA;
        if (!this.isOmSdkEnabled) {
            b7.b("OMSDK signal load OM is disabled by the cb config!", null, 2, null);
            return;
        }
        try {
            k omAdEvents = this.sessionHolder.getOmAdEvents();
            if (omAdEvents != null) {
                boolean z = skipOffset != null && skipOffset.intValue() > 0;
                if (z) {
                    if (z) {
                        cbVarA = cb.a(skipOffset != null ? skipOffset.intValue() : 0.0f, true, i8.STANDALONE);
                    } else {
                        cbVarA = cb.a(true, i8.STANDALONE);
                    }
                    omAdEvents.a(cbVarA);
                } else {
                    omAdEvents.b();
                }
                b7.a("Signal om ad event loaded!", (Throwable) null, 2, (Object) null);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                b7.a("Omid load event is null!", (Throwable) null, 2, (Object) null);
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void a(float videoDuration, float videoVolume) {
        this.isQuartile1Notified = false;
        this.isMidpointNotified = false;
        this.isQuartile3Notified = false;
        try {
            c7 c7VarA = a("signalMediaStart duration: " + videoDuration + " and volume " + videoVolume);
            if (c7VarA != null) {
                c7VarA.a(videoDuration, videoVolume);
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void a(g8 playerState) {
        Intrinsics.checkNotNullParameter(playerState, "playerState");
        try {
            c7 c7VarA = a("signalMediaStateChange state: " + playerState.name());
            if (c7VarA != null) {
                c7VarA.a(playerState);
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }

    public final void a(float videoVolume) {
        try {
            c7 c7VarA = a("signalMediaVolumeChange volume: " + videoVolume);
            if (c7VarA != null) {
                c7VarA.c(videoVolume);
            }
        } catch (Exception e) {
            b7.b("Error", e);
        }
    }
}
