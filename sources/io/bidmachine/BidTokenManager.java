package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.banner.BannerRequest;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.core.Logger;
import io.bidmachine.interstitial.InterstitialRequest;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.nativead.NativeRequest;
import io.bidmachine.protobuf.RequestTokenPayload;
import io.bidmachine.protobuf.ResponsePayload;
import io.bidmachine.protobuf.TokenConfiguration;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.protobuf.sdk.SDK;
import io.bidmachine.protobuf.sdk.User;
import io.bidmachine.rewarded.RewardedRequest;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
class BidTokenManager {
    private static final int DEFAULT_EXPIRATION_SEC = 300;
    private static final String TAG = "BidTokenManager";
    private static final TrackingObject TRACKING_OBJECT = new BidMachineTrackingObject();
    private static final Map<AdsFormat, TokenConfiguration> TOKEN_CONFIGURATION_MAP = new ConcurrentHashMap();
    private static final Map<String, BidToken> STORED_BID_TOKEN = new ConcurrentHashMap();

    BidTokenManager() {
    }

    static String createBidToken(Context context) {
        return createBidToken(context, null);
    }

    static String createBidToken(Context context, AdsFormat adsFormat) {
        RequestTokenPayload requestTokenPayloadCreateRequestTokenPayload = createRequestTokenPayload(context, adsFormat);
        if (requestTokenPayloadCreateRequestTokenPayload == null) {
            sendFailEvent(adsFormat, BMError.internal("Failed to create RequestTokenPayload"));
            return "";
        }
        try {
            String strEncodeToString = Base64.encodeToString(requestTokenPayloadCreateRequestTokenPayload.toByteArray(), 2);
            sendSuccessEvent(adsFormat);
            return strEncodeToString;
        } catch (Exception e) {
            sendFailEvent(adsFormat, BMError.throwable("Failed to encode RequestTokenPayload", e));
            removeBidToken(requestTokenPayloadCreateRequestTokenPayload.getTokenHashValue());
            return "";
        }
    }

    private static RequestTokenPayload createRequestTokenPayload(Context context, AdsFormat adsFormat) {
        try {
            BidMachineImpl bidMachineImpl = BidMachineImpl.get();
            RequestTokenPayload.Builder builderNewBuilder = RequestTokenPayload.newBuilder();
            if (adsFormat != null) {
                builderNewBuilder.setAdType(adsFormat.getAdsType().getName());
            }
            App.Builder builderNewBuilder2 = App.newBuilder();
            bidMachineImpl.getAppParams().build(context, builderNewBuilder2);
            builderNewBuilder.setAppData(builderNewBuilder2);
            User.Builder builderCreateUserBuilder = createUserBuilder(bidMachineImpl);
            if (builderCreateUserBuilder != null) {
                builderNewBuilder.setUserData(builderCreateUserBuilder);
            }
            SDK.Builder sdkver = SDK.newBuilder().setSdk(BidMachine.NAME).setSdkver("3.2.1");
            OMSDKSettings.fill(sdkver);
            builderNewBuilder.setPlacementData(sdkver);
            bidMachineImpl.getDeviceParams().build(context, builderNewBuilder, bidMachineImpl.getUserRestrictionParams());
            bidMachineImpl.getSessionParams().build(context, builderNewBuilder, adsFormat);
            processAdNetworks(context, builderNewBuilder, adsFormat);
            Struct.Builder builderNewBuilder3 = Struct.newBuilder();
            Struct privateStruct = ExtraParamsManager.get().getPrivateStruct(context);
            if (privateStruct != null) {
                builderNewBuilder3.putAllFields(privateStruct.getFieldsMap());
            }
            if (builderNewBuilder3.getFieldsCount() > 0) {
                builderNewBuilder.setExt(builderNewBuilder3.build());
            }
            return builderNewBuilder.build();
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    private static User.Builder createUserBuilder(BidMachineImpl bidMachineImpl) {
        try {
            UserRestrictionParams userRestrictionParams = bidMachineImpl.getUserRestrictionParams();
            User.Builder builderNewBuilder = User.newBuilder();
            userRestrictionParams.fill(builderNewBuilder);
            return builderNewBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void processAdNetworks(Context context, RequestTokenPayload.Builder builder, AdsFormat adsFormat) {
        if (adsFormat == null) {
            return;
        }
        try {
            AdRequest<?, ?, ?> adRequestMapToAdRequest = mapToAdRequest(adsFormat);
            if (adRequestMapToAdRequest == null) {
                return;
            }
            NetworkRegistry.registerAndInitializeCoreNetworks(context);
            TokenConfiguration tokenConfigurationObtainTokenConfiguration = obtainTokenConfiguration(adsFormat);
            HeaderBiddingPlacement.Builder builderNewBuilder = HeaderBiddingPlacement.newBuilder();
            for (Message.Builder builder2 : adRequestMapToAdRequest.collectPlacementFormats(context, tokenConfigurationObtainTokenConfiguration.getAdNetworksList())) {
                if (builder2 instanceof Placement.DisplayPlacement.Builder) {
                    fillHeaderBiddingPlacementBuilder(builderNewBuilder, ((Placement.DisplayPlacement.Builder) builder2).getExtProtoList());
                } else if (builder2 instanceof Placement.VideoPlacement.Builder) {
                    fillHeaderBiddingPlacementBuilder(builderNewBuilder, ((Placement.VideoPlacement.Builder) builder2).getExtProtoList());
                }
            }
            if (builderNewBuilder.getAdUnitsList().isEmpty()) {
                return;
            }
            final BidToken bidToken = new BidToken(adRequestMapToAdRequest, tokenConfigurationObtainTokenConfiguration.getExpirationTime(), new BidTokenExpirationListener(null));
            storeBidToken(bidToken);
            builder.setHbPlacement(builderNewBuilder);
            builder.setTokenHashValue(bidToken.getId());
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("BidTokenId - %s", bidToken.getId());
                }
            });
        } catch (Throwable unused) {
            removeBidToken(builder.getTokenHashValue());
        }
    }

    private static TokenConfiguration obtainTokenConfiguration(AdsFormat adsFormat) {
        TokenConfiguration tokenConfiguration = getTokenConfiguration(adsFormat);
        if (tokenConfiguration == null) {
            tokenConfiguration = getTokenConfiguration(adsFormat.getParent());
        }
        return tokenConfiguration == null ? TokenConfiguration.newBuilder().setExpirationTime(300).build() : tokenConfiguration;
    }

    private static void fillHeaderBiddingPlacementBuilder(HeaderBiddingPlacement.Builder builder, List<Any> list) {
        Iterator<Any> it = list.iterator();
        while (it.hasNext()) {
            try {
                builder.addAllAdUnits(((HeaderBiddingPlacement) it.next().unpack(HeaderBiddingPlacement.class)).getAdUnitsList());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.BidTokenManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$AdsFormat;

        static {
            int[] iArr = new int[AdsFormat.values().length];
            $SwitchMap$io$bidmachine$AdsFormat = iArr;
            try {
                iArr[AdsFormat.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Banner_320x50.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Banner_300x250.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Banner_728x90.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Interstitial.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.InterstitialStatic.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.InterstitialVideo.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Rewarded.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.RewardedStatic.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.RewardedVideo.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Native.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private static AdRequest<?, ?, ?> mapToAdRequest(AdsFormat adsFormat) {
        switch (AnonymousClass1.$SwitchMap$io$bidmachine$AdsFormat[adsFormat.ordinal()]) {
            case 1:
            case 2:
                return new BannerRequest.Builder().setSize(BannerSize.Size_320x50).build();
            case 3:
                return new BannerRequest.Builder().setSize(BannerSize.Size_300x250).build();
            case 4:
                return new BannerRequest.Builder().setSize(BannerSize.Size_728x90).build();
            case 5:
                return new InterstitialRequest.Builder().setAdContentType(AdContentType.All).build();
            case 6:
                return new InterstitialRequest.Builder().setAdContentType(AdContentType.Static).build();
            case 7:
                return new InterstitialRequest.Builder().setAdContentType(AdContentType.Video).build();
            case 8:
                return new RewardedRequest.Builder().setAdContentType(AdContentType.All).build();
            case 9:
                return new RewardedRequest.Builder().setAdContentType(AdContentType.Static).build();
            case 10:
                return new RewardedRequest.Builder().setAdContentType(AdContentType.Video).build();
            case 11:
                return new NativeRequest.Builder().setMediaAssetTypes(MediaAssetType.All).build();
            default:
                return null;
        }
    }

    private static void sendSuccessEvent(AdsFormat adsFormat) {
        trackEvent(adsFormat, null);
    }

    private static void sendFailEvent(AdsFormat adsFormat, BMError bMError) {
        trackEvent(adsFormat, bMError);
    }

    private static void trackEvent(AdsFormat adsFormat, BMError bMError) {
        TRACKING_OBJECT.eventFinish(TrackEventType.GetBidToken, adsFormat != null ? adsFormat.getAdsType() : null, null, bMError);
    }

    static void storeBidToken(BidToken bidToken) {
        STORED_BID_TOKEN.put(bidToken.getId(), bidToken);
        bidToken.startExpiration();
    }

    static BidToken removeBidToken(BidToken bidToken) {
        return removeBidToken(bidToken.getId());
    }

    static BidToken removeBidToken(String str) {
        BidToken bidTokenRemove = STORED_BID_TOKEN.remove(str);
        if (bidTokenRemove != null) {
            bidTokenRemove.stopExpiration();
        }
        return bidTokenRemove;
    }

    static <T extends AdRequest<?, ?, ?>> T findPreparedAdRequest(ResponsePayload responsePayload) {
        if (responsePayload == null) {
            return null;
        }
        final String strFindTokenIdFromResponsePayload = findTokenIdFromResponsePayload(responsePayload);
        Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return String.format("BidTokenId from bidPayload - %s", strFindTokenIdFromResponsePayload);
            }
        });
        if (TextUtils.isEmpty(strFindTokenIdFromResponsePayload)) {
            return null;
        }
        BidToken bidTokenRemoveBidToken = removeBidToken(strFindTokenIdFromResponsePayload);
        if (bidTokenRemoveBidToken == null) {
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("BidToken is null by bidTokenId - %s", strFindTokenIdFromResponsePayload);
                }
            });
            return null;
        }
        return (T) bidTokenRemoveBidToken.getAdRequest();
    }

    private static String findTokenIdFromResponsePayload(ResponsePayload responsePayload) {
        try {
            Value value = responsePayload.getResponseCache().getResponse().getExt().getFieldsMap().get("tokenHashValue");
            if (value == null) {
                return null;
            }
            return value.getStringValue();
        } catch (Throwable unused) {
            return null;
        }
    }

    static void setupTokenConfigurations(List<TokenConfiguration> list) {
        TOKEN_CONFIGURATION_MAP.clear();
        if (list != null) {
            for (TokenConfiguration tokenConfiguration : list) {
                AdsFormat adsFormatByRemoteName = AdsFormat.byRemoteName(tokenConfiguration.getType());
                if (adsFormatByRemoteName != null) {
                    TOKEN_CONFIGURATION_MAP.put(adsFormatByRemoteName, tokenConfiguration);
                }
            }
        }
    }

    static TokenConfiguration getTokenConfiguration(AdsFormat adsFormat) {
        if (adsFormat == null) {
            return null;
        }
        return TOKEN_CONFIGURATION_MAP.get(adsFormat);
    }

    static Map<String, BidToken> getStoredBidToken() {
        return STORED_BID_TOKEN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class BidTokenExpirationListener implements ExpirationListener<BidToken> {
        private BidTokenExpirationListener() {
        }

        /* synthetic */ BidTokenExpirationListener(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.bidmachine.ExpirationListener
        public void onExpired(final BidToken bidToken) {
            Logger.d(BidTokenManager.TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$BidTokenExpirationListener$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return String.format("BidToken expired - %s", bidToken.getId());
                }
            });
            BidTokenManager.removeBidToken(bidToken);
            bidToken.destroyAdRequest();
        }
    }
}
