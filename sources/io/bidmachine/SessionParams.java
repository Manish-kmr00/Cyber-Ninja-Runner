package io.bidmachine;

import android.content.Context;
import com.explorestack.protobuf.Any;
import io.bidmachine.analytics.BidMachineAnalytics;
import io.bidmachine.core.TimeManager;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.RequestTokenPayload;
import io.bidmachine.protobuf.sdk.ContextualData;
import io.bidmachine.protobuf.sdk.Session;
import io.bidmachine.utils.time.DateUtils;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
final class SessionParams {
    SessionParams() {
    }

    void build(Context context, RequestTokenPayload.Builder builder, AdsFormat adsFormat) {
        Session.Builder builderCreateSessionBuilder = createSessionBuilder(context, adsFormat != null ? adsFormat.getAdsType() : null);
        if (builderCreateSessionBuilder != null) {
            builder.setSession(builderCreateSessionBuilder);
        }
    }

    void build(Context context, com.explorestack.protobuf.adcom.Context.User.Builder builder, AdsType adsType) {
        Session.Builder builderCreateSessionBuilder = createSessionBuilder(context, adsType);
        if (builderCreateSessionBuilder != null) {
            builder.addExtProto(Any.pack(builderCreateSessionBuilder.build()));
        }
    }

    private Session.Builder createSessionBuilder(Context context, AdsType adsType) {
        try {
            final Session.Builder sessionId = Session.newBuilder().setSessionId(SessionManager.get().getSessionId());
            Session.Context.Builder builderCreateSessionContextBuilder = createSessionContextBuilder(context, adsType);
            Objects.requireNonNull(sessionId);
            Utils.ifNotNull(builderCreateSessionContextBuilder, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda0
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    sessionId.setContext((Session.Context.Builder) obj);
                }
            });
            return sessionId;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Session.Context.Builder createSessionContextBuilder(Context context, AdsType adsType) {
        try {
            final Session.Context.Builder retention = Session.Context.newBuilder().setSessionduration(SessionManager.get().getSessionDuration()).setSc(SessionManager.get().getSessionCount()).setRetention(DateUtils.daysBetween(new Date(BidMachineSharedPreference.obtainFirstLaunchTimeMs(context)), new Date(TimeManager.currentTimeMillis())));
            for (Map.Entry<String, Map<String, Object>> entry : BidMachineAnalytics.getImpData(getAdsTypeId(adsType)).entrySet()) {
                ContextualData.Builder builderCreateContextualDataBuilder = createContextualDataBuilder(adsType, entry.getKey(), entry.getValue());
                Objects.requireNonNull(retention);
                Utils.ifNotNull(builderCreateContextualDataBuilder, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda9
                    @Override // io.bidmachine.Executable
                    public final void execute(Object obj) {
                        retention.addData((ContextualData.Builder) obj);
                    }
                });
            }
            return retention;
        } catch (Throwable unused) {
            return null;
        }
    }

    private ContextualData.Builder createContextualDataBuilder(AdsType adsType, String str, Map<String, Object> map) {
        try {
            final ContextualData.Builder mediatorName = ContextualData.newBuilder().setMediatorName(str);
            Utils.ifNotNull(adsType, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda1
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    mediatorName.setPlacement(((AdsType) obj).getName());
                }
            });
            ContextualData.ImpressionData.Builder builderCreateImpressionDataBuilder = createImpressionDataBuilder(map);
            Objects.requireNonNull(mediatorName);
            Utils.ifNotNull(builderCreateImpressionDataBuilder, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda2
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    mediatorName.setData((ContextualData.ImpressionData.Builder) obj);
                }
            });
            return mediatorName;
        } catch (Throwable unused) {
            return null;
        }
    }

    private ContextualData.ImpressionData.Builder createImpressionDataBuilder(Map<String, Object> map) {
        try {
            final ContextualData.ImpressionData.Builder builderNewBuilder = ContextualData.ImpressionData.newBuilder();
            Integer numConvertToIntOrDefault = Utils.convertToIntOrDefault(map.get("imimd"), null);
            Objects.requireNonNull(builderNewBuilder);
            Utils.ifNotNull(numConvertToIntOrDefault, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda3
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builderNewBuilder.setImimd(((Integer) obj).intValue());
                }
            });
            Integer numConvertToIntOrDefault2 = Utils.convertToIntOrDefault(map.get("imd"), null);
            Objects.requireNonNull(builderNewBuilder);
            Utils.ifNotNull(numConvertToIntOrDefault2, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda4
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builderNewBuilder.setImd(((Integer) obj).intValue());
                }
            });
            Float fConvertToFloatOrDefault = Utils.convertToFloatOrDefault(map.get("imwp"), null);
            Objects.requireNonNull(builderNewBuilder);
            Utils.ifNotNull(fConvertToFloatOrDefault, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda5
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builderNewBuilder.setImwp(((Float) obj).floatValue());
                }
            });
            Float fConvertToFloatOrDefault2 = Utils.convertToFloatOrDefault(map.get("wp"), null);
            Objects.requireNonNull(builderNewBuilder);
            Utils.ifNotNull(fConvertToFloatOrDefault2, new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda6
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builderNewBuilder.setWp(((Float) obj).floatValue());
                }
            });
            Utils.ifNotNull(map.get("imagency"), new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda7
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builderNewBuilder.setImagency(obj.toString());
                }
            });
            Utils.ifNotNull(map.get("agency"), new Executable() { // from class: io.bidmachine.SessionParams$$ExternalSyntheticLambda8
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    builderNewBuilder.setAgency(obj.toString());
                }
            });
            return builderNewBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.SessionParams$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$AdsType;

        static {
            int[] iArr = new int[AdsType.values().length];
            $SwitchMap$io$bidmachine$AdsType = iArr;
            try {
                iArr[AdsType.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsType[AdsType.Interstitial.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsType[AdsType.Rewarded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsType[AdsType.Native.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int getAdsTypeId(AdsType adsType) {
        if (adsType == null) {
            return 0;
        }
        int i = AnonymousClass1.$SwitchMap$io$bidmachine$AdsType[adsType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }
}
