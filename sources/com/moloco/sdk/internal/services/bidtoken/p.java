package com.moloco.sdk.internal.services.bidtoken;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.moloco.sdk.BidToken;
import com.moloco.sdk.internal.services.e0;
import com.moloco.sdk.internal.services.f0;
import com.moloco.sdk.internal.services.h0;
import java.util.Date;
import java.util.TimeZone;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p implements o {
    public final com.moloco.sdk.internal.services.y b;
    public final f0 c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6329a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[h0.values().length];
            try {
                iArr[h0.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h0.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h0.LANDSCAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6329a = iArr;
            int[] iArr2 = new int[com.moloco.sdk.internal.services.z.values().length];
            try {
                iArr2[com.moloco.sdk.internal.services.z.SILENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[com.moloco.sdk.internal.services.z.VIBRATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[com.moloco.sdk.internal.services.z.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    public p(com.moloco.sdk.internal.services.y deviceInfoService, f0 screenInfoService) {
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(screenInfoService, "screenInfoService");
        this.b = deviceInfoService;
        this.c = screenInfoService;
    }

    public final long a(long j) {
        return j * ((long) 1000000);
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidTokenComponents b(byte[] payload) throws InvalidProtocolBufferException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BidToken.ClientBidTokenComponents from = BidToken.ClientBidTokenComponents.parseFrom(payload);
        Intrinsics.checkNotNullExpressionValue(from, "parseFrom(payload)");
        return from;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public byte[] a(byte[] bidTokenComponents, byte[] secret) {
        Intrinsics.checkNotNullParameter(bidTokenComponents, "bidTokenComponents");
        Intrinsics.checkNotNullParameter(secret, "secret");
        BidToken.ClientBidToken.Builder builderNewBuilder = BidToken.ClientBidToken.newBuilder();
        builderNewBuilder.setEs(ByteString.copyFrom(secret));
        builderNewBuilder.setPayload(ByteString.copyFrom(bidTokenComponents));
        byte[] byteArray = builderNewBuilder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "newBuilder().apply {\n   …  }.build().toByteArray()");
        return byteArray;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidTokenComponents a(com.moloco.sdk.internal.services.bidtoken.providers.k clientSignals, f bidTokenConfig) {
        BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus batteryStatus;
        BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType connectionType;
        Intrinsics.checkNotNullParameter(clientSignals, "clientSignals");
        Intrinsics.checkNotNullParameter(bidTokenConfig, "bidTokenConfig");
        com.moloco.sdk.internal.services.x xVarB = this.b.b();
        e0 e0VarA = this.c.a();
        BidToken.ClientBidTokenComponents.Builder builderNewBuilder = BidToken.ClientBidTokenComponents.newBuilder();
        BidToken.ClientBidTokenComponents.SdkInfo.Builder builderNewBuilder2 = BidToken.ClientBidTokenComponents.SdkInfo.newBuilder();
        builderNewBuilder2.setInitialized(clientSignals.t());
        builderNewBuilder.setInfo(builderNewBuilder2.build());
        BidToken.ClientBidTokenComponents.MemoryInfo.Builder builderNewBuilder3 = BidToken.ClientBidTokenComponents.MemoryInfo.newBuilder();
        Boolean boolD = clientSignals.q().d();
        if (boolD != null) {
            builderNewBuilder3.setLowMem(boolD.booleanValue());
        }
        Long lE = clientSignals.q().e();
        if (lE != null) {
            builderNewBuilder3.setLowMemThresholdBytes(lE.longValue());
        }
        Long lF = clientSignals.q().f();
        if (lF != null) {
            builderNewBuilder3.setTotalMemBytes(lF.longValue());
        }
        builderNewBuilder.setMemoryInfo(builderNewBuilder3.build());
        BidToken.ClientBidTokenComponents.DirInfo.Builder builderNewBuilder4 = BidToken.ClientBidTokenComponents.DirInfo.newBuilder();
        Long lB = clientSignals.m().b();
        if (lB != null) {
            builderNewBuilder4.setDsizeBytes(lB.longValue());
        }
        builderNewBuilder.setDirInfo(builderNewBuilder4.build());
        BidToken.ClientBidTokenComponents.NetworkInfo.Builder builderNewBuilder5 = BidToken.ClientBidTokenComponents.NetworkInfo.newBuilder();
        Integer numE = clientSignals.r().e();
        if (numE != null) {
            numE.intValue();
            builderNewBuilder5.setMcc(clientSignals.r().e().intValue());
        }
        Integer numF = clientSignals.r().f();
        if (numF != null) {
            builderNewBuilder5.setMnc(numF.intValue());
        }
        Boolean boolG = clientSignals.r().g();
        if (boolG != null) {
            builderNewBuilder5.setRestricted(boolG.booleanValue());
        }
        com.moloco.sdk.internal.services.a0 a0VarH = clientSignals.r().h();
        if (a0VarH != null) {
            if (a0VarH instanceof com.moloco.sdk.internal.services.a0.a) {
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.CELLULAR;
            } else if (Intrinsics.areEqual(a0VarH, com.moloco.sdk.internal.services.a0.b.f6300a)) {
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.NO_NETWORK;
            } else {
                if (!Intrinsics.areEqual(a0VarH, com.moloco.sdk.internal.services.a0.c.f6301a)) {
                    throw new NoWhenBranchMatchedException();
                }
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.WIFI;
            }
            builderNewBuilder5.setType(connectionType);
        }
        builderNewBuilder.setNetworkInfo(builderNewBuilder5.build());
        BidToken.ClientBidTokenComponents.BatteryInfo.Builder builderNewBuilder6 = BidToken.ClientBidTokenComponents.BatteryInfo.newBuilder();
        Integer numE2 = clientSignals.o().e();
        if (numE2 != null) {
            builderNewBuilder6.setMaxBatteryLevel(numE2.intValue());
        }
        Integer numD = clientSignals.o().d();
        if (numD != null) {
            int iIntValue = numD.intValue();
            if (iIntValue == 2) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.CHARGING;
            } else if (iIntValue == 3) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.DISCHARGING;
            } else if (iIntValue == 4) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.NOT_CHARGING;
            } else if (iIntValue != 5) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.UNKNOWN;
            } else {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.FULL;
            }
            builderNewBuilder6.setBatteryStatus(batteryStatus);
        }
        Boolean boolF = clientSignals.o().f();
        if (boolF != null) {
            builderNewBuilder6.setLowPowMode(boolF.booleanValue());
        }
        builderNewBuilder.setBatteryInfo(builderNewBuilder6.build());
        BidToken.ClientBidTokenComponents.AdvertisingInfo.Builder builderNewBuilder7 = BidToken.ClientBidTokenComponents.AdvertisingInfo.newBuilder();
        com.moloco.sdk.internal.services.c cVarL = clientSignals.l();
        if (cVarL instanceof com.moloco.sdk.internal.services.c.a) {
            builderNewBuilder7.setDnt(false);
            builderNewBuilder7.setId(((com.moloco.sdk.internal.services.c.a) cVarL).b());
        } else if (Intrinsics.areEqual(cVarL, com.moloco.sdk.internal.services.c.b.f6355a)) {
            builderNewBuilder7.setDnt(true);
        }
        builderNewBuilder.setAdInfo(builderNewBuilder7.build());
        BidToken.ClientBidTokenComponents.Privacy.Builder builderNewBuilder8 = BidToken.ClientBidTokenComponents.Privacy.newBuilder();
        Boolean isAgeRestrictedUser = clientSignals.s().getIsAgeRestrictedUser();
        if (isAgeRestrictedUser != null) {
            builderNewBuilder8.setCoppa(isAgeRestrictedUser.booleanValue());
        }
        Boolean isUserConsent = clientSignals.s().getIsUserConsent();
        if (isUserConsent != null) {
            builderNewBuilder8.setGdpr(isUserConsent.booleanValue());
        }
        Boolean isDoNotSell = clientSignals.s().getIsDoNotSell();
        if (isDoNotSell != null) {
            builderNewBuilder8.setCcpa(isDoNotSell.booleanValue());
        }
        String tCFConsent = clientSignals.s().getTCFConsent();
        if (tCFConsent != null) {
            builderNewBuilder8.setTcfConsentString(tCFConsent);
        }
        builderNewBuilder8.setUsPrivacy(clientSignals.s().getUsPrivacy());
        builderNewBuilder.setPrivacy(builderNewBuilder8.build());
        BidToken.ClientBidTokenComponents.Device.Builder builderNewBuilder9 = BidToken.ClientBidTokenComponents.Device.newBuilder();
        builderNewBuilder9.setLanguage(xVarB.o());
        builderNewBuilder9.setOsv(xVarB.t());
        builderNewBuilder9.setMake(xVarB.p());
        builderNewBuilder9.setModel(xVarB.r());
        builderNewBuilder9.setHwv(xVarB.n());
        builderNewBuilder9.setCarrier(xVarB.q());
        builderNewBuilder9.setDevicetype(xVarB.v() ? 5 : 1);
        builderNewBuilder9.setJs(1);
        BidToken.ClientBidTokenComponents.Geo.Builder builderNewBuilder10 = BidToken.ClientBidTokenComponents.Geo.newBuilder();
        builderNewBuilder10.setUtcoffset(TimeZone.getDefault().getOffset(new Date().getTime()) / 60000);
        builderNewBuilder9.setGeo(builderNewBuilder10.build());
        builderNewBuilder9.setW(e0VarA.n());
        builderNewBuilder9.setH(e0VarA.l());
        builderNewBuilder9.setPxratio(e0VarA.i());
        builderNewBuilder9.setPpi(e0VarA.j());
        builderNewBuilder9.setOs(xVarB.s());
        if (bidTokenConfig.b()) {
            builderNewBuilder9.setDbt(a(xVarB.m()));
        }
        h0 h0VarF = clientSignals.p().f();
        if (h0VarF != null) {
            builderNewBuilder9.setOrtn(a(h0VarF));
        }
        Boolean boolA = this.b.a();
        if (boolA != null) {
            builderNewBuilder9.setHasGy(boolA.booleanValue());
        }
        String strD = clientSignals.p().d();
        if (strD != null) {
            builderNewBuilder9.setKbLoc(strD);
        }
        String strE = clientSignals.p().e();
        if (strE != null) {
            builderNewBuilder9.setLocale(strE);
        }
        builderNewBuilder9.setXdpi(e0VarA.o());
        builderNewBuilder9.setYdpi(e0VarA.p());
        builderNewBuilder.setDevice(builderNewBuilder9.build());
        BidToken.ClientBidTokenComponents.AudioInfo.Builder builderNewBuilder11 = BidToken.ClientBidTokenComponents.AudioInfo.newBuilder();
        com.moloco.sdk.internal.services.z zVarD = clientSignals.n().d();
        if (zVarD != null) {
            builderNewBuilder11.setMuteSwitch(a(zVarD));
        }
        Integer numC = clientSignals.n().c();
        if (numC != null) {
            builderNewBuilder11.setVol(numC.intValue());
        }
        builderNewBuilder.setAudioInfo(builderNewBuilder11.build());
        BidToken.ClientBidTokenComponents.AccessibilityInfo.Builder builderNewBuilder12 = BidToken.ClientBidTokenComponents.AccessibilityInfo.newBuilder();
        Float fG = clientSignals.k().g();
        if (fG != null) {
            builderNewBuilder12.setFontScale(fG.floatValue());
        }
        Boolean boolF2 = clientSignals.k().f();
        if (boolF2 != null) {
            builderNewBuilder12.setAccessibilityLargePointerIcon(boolF2.booleanValue());
        }
        Boolean boolE = clientSignals.k().e();
        if (boolE != null) {
            builderNewBuilder12.setAccessibilityCaptioningEnabled(boolE.booleanValue());
        }
        Boolean boolH = clientSignals.k().h();
        if (boolH != null) {
            builderNewBuilder12.setReduceBrightColorsActivated(boolH.booleanValue());
        }
        builderNewBuilder.setAccessibilityInfo(builderNewBuilder12.build());
        BidToken.ClientBidTokenComponents clientBidTokenComponentsBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(clientBidTokenComponentsBuild, "newBuilder().apply {\n   …build()\n        }.build()");
        return clientBidTokenComponentsBuild;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidToken a(byte[] payload) throws InvalidProtocolBufferException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BidToken.ClientBidToken from = BidToken.ClientBidToken.parseFrom(payload);
        Intrinsics.checkNotNullExpressionValue(from, "parseFrom(payload)");
        return from;
    }

    public final BidToken.ClientBidTokenComponents.Device.Orientation a(h0 h0Var) {
        int i = a.f6329a[h0Var.ordinal()];
        if (i == 1) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.UNKNOWN;
        }
        if (i == 2) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.PORTRAIT;
        }
        if (i == 3) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.LANDSCAPE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState a(com.moloco.sdk.internal.services.z zVar) {
        int i = a.b[zVar.ordinal()];
        if (i == 1) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.SILENT;
        }
        if (i == 2) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.VIBRATE;
        }
        if (i == 3) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.NORMAL;
        }
        throw new NoWhenBranchMatchedException();
    }
}
