package io.bidmachine;

import android.graphics.Point;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.adcom.NativeDataAssetType;
import com.explorestack.protobuf.adcom.NativeImageAssetType;
import com.explorestack.protobuf.adcom.Placement;
import com.explorestack.protobuf.adcom.SizeUnit;
import com.explorestack.protobuf.adcom.VideoCreativeType;
import io.bidmachine.AdContentType;
import io.bidmachine.AdsType;
import io.bidmachine.Constants;
import io.bidmachine.ContextProvider;
import io.bidmachine.MediaAssetType;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfig;
import io.bidmachine.ads.networks.nast.NastAdapter;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.core.Logger;
import io.bidmachine.displays.DisplayPlacementBuilder;
import io.bidmachine.displays.PlacementBuilder;
import io.bidmachine.displays.VideoPlacementBuilder;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public enum AdsType {
    Banner("banner", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new DisplayPlacementBuilder<UnifiedBannerAdRequestParams>(false) { // from class: io.bidmachine.AdsType.1
        @Override // io.bidmachine.displays.DisplayPlacementBuilder, io.bidmachine.displays.ISizableDisplayPlacement
        public Point getSize(ContextProvider contextProvider, UnifiedBannerAdRequestParams unifiedBannerAdRequestParams) {
            BannerSize bannerSize = unifiedBannerAdRequestParams.getAdRequestParameters().getBannerSize();
            return new Point(bannerSize.width, bannerSize.height);
        }
    }}),
    Interstitial("interstitial", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new DisplayPlacementBuilder(true), new VideoPlacementBuilder(true)}),
    Rewarded("rewarded", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new DisplayPlacementBuilder(true), new VideoPlacementBuilder(false)}),
    Native("native", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new PlacementBuilder<UnifiedNativeAdRequestParams>() { // from class: io.bidmachine.displays.NativePlacementBuilder
        static final int AD_LABEL_ASSET_ID = 101;
        static final int CTA_ASSET_ID = 8;
        static final int DESC_ASSET_ID = 127;
        static final int ICON_ASSET_ID = 124;
        static final int IMAGE_ASSET_ID = 128;
        static final int PRIVACY_SHEET_ASSET_ID = 102;
        static final int RATING_ASSET_ID = 7;
        static final int TITLE_ASSET_ID = 123;
        static final int VIDEO_ASSET_ID = 4;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder adLabelAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder ctaAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder descAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder privacySheetAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder ratingAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder titleAsset;

        @Override // io.bidmachine.displays.PlacementBuilder
        public /* bridge */ /* synthetic */ Message.Builder createPlacement(ContextProvider contextProvider, UnifiedAdRequestParams unifiedAdRequestParams, AdsType adsType, Collection collection, List list, int i) throws Exception {
            return createPlacement(contextProvider, (UnifiedNativeAdRequestParams) unifiedAdRequestParams, adsType, (Collection<NetworkConfig>) collection, (List<NetworkAdUnit>) list, i);
        }

        static {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            titleAsset = builderNewBuilder;
            builderNewBuilder.setId(123);
            builderNewBuilder.setReq(true);
            builderNewBuilder.setTitle(Placement.DisplayPlacement.NativeFormat.AssetFormat.TitleAssetFormat.newBuilder().setLen(104).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder2 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            descAsset = builderNewBuilder2;
            builderNewBuilder2.setId(127);
            builderNewBuilder2.setReq(true);
            builderNewBuilder2.setData(Placement.DisplayPlacement.NativeFormat.AssetFormat.DataAssetFormat.newBuilder().setType(NativeDataAssetType.NATIVE_DATA_ASSET_TYPE_DESC).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder3 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            ctaAsset = builderNewBuilder3;
            builderNewBuilder3.setId(8);
            builderNewBuilder3.setReq(true);
            builderNewBuilder3.setData(Placement.DisplayPlacement.NativeFormat.AssetFormat.DataAssetFormat.newBuilder().setType(NativeDataAssetType.NATIVE_DATA_ASSET_TYPE_CTA_TEXT).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder4 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            ratingAsset = builderNewBuilder4;
            builderNewBuilder4.setId(7);
            builderNewBuilder4.setReq(false);
            builderNewBuilder4.setData(Placement.DisplayPlacement.NativeFormat.AssetFormat.DataAssetFormat.newBuilder().setType(NativeDataAssetType.NATIVE_DATA_ASSET_TYPE_RATING).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder5 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            adLabelAsset = builderNewBuilder5;
            builderNewBuilder5.setId(101);
            builderNewBuilder5.setReq(false);
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder6 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            privacySheetAsset = builderNewBuilder6;
            builderNewBuilder6.setId(102);
            builderNewBuilder6.setReq(false);
        }

        static Placement.DisplayPlacement.NativeFormat.AssetFormat createIconAsset(UnifiedNativeAdRequestParams unifiedNativeAdRequestParams) {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            builderNewBuilder.setId(124);
            builderNewBuilder.setReq(unifiedNativeAdRequestParams.getAdRequestParameters().containsAssetType(MediaAssetType.Icon));
            builderNewBuilder.setImg(Placement.DisplayPlacement.NativeFormat.AssetFormat.ImageAssetFormat.newBuilder().setType(NativeImageAssetType.NATIVE_IMAGE_ASSET_TYPE_ICON_IMAGE).addAllMime(Arrays.asList(Constants.IMAGE_MIME_TYPES)).build());
            return builderNewBuilder.build();
        }

        static Placement.DisplayPlacement.NativeFormat.AssetFormat createImageAsset(UnifiedNativeAdRequestParams unifiedNativeAdRequestParams) {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            builderNewBuilder.setId(128);
            builderNewBuilder.setReq(unifiedNativeAdRequestParams.getAdRequestParameters().containsAssetType(MediaAssetType.Image));
            builderNewBuilder.setImg(Placement.DisplayPlacement.NativeFormat.AssetFormat.ImageAssetFormat.newBuilder().setType(NativeImageAssetType.NATIVE_IMAGE_ASSET_TYPE_MAIN_IMAGE).addAllMime(Arrays.asList(Constants.IMAGE_MIME_TYPES)).build());
            return builderNewBuilder.build();
        }

        static Placement.DisplayPlacement.NativeFormat.AssetFormat createVideoAsset(UnifiedNativeAdRequestParams unifiedNativeAdRequestParams) {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder builderNewBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            builderNewBuilder.setId(4);
            builderNewBuilder.setReq(unifiedNativeAdRequestParams.getAdRequestParameters().containsAssetType(MediaAssetType.Video));
            builderNewBuilder.setVideo(Placement.VideoPlacement.newBuilder().setSkip(false).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_2_0).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_3_0).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_WRAPPER_2_0).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_WRAPPER_3_0).addAllMime(Arrays.asList(Constants.VIDEO_MIME_TYPES)).setMinbitr(56).setMaxbitr(4096).setMindur(5).setMaxdur(30).setLinearValue(1).build());
            return builderNewBuilder.build();
        }

        {
            AdContentType adContentType = AdContentType.All;
        }

        public Message.Builder createPlacement(ContextProvider contextProvider, UnifiedNativeAdRequestParams unifiedNativeAdRequestParams, AdsType adsType, Collection<NetworkConfig> collection, List<NetworkAdUnit> list, int i) throws Exception {
            Placement.DisplayPlacement.Builder builderAddAllMime = Placement.DisplayPlacement.newBuilder().setInstl(false).setUnit(SizeUnit.SIZE_UNIT_DIPS).addAllMime(Arrays.asList(Constants.IMAGE_MIME_TYPES)).addAllMime(Arrays.asList(Constants.VIDEO_MIME_TYPES));
            Placement.DisplayPlacement.NativeFormat.Builder builderNewBuilder = Placement.DisplayPlacement.NativeFormat.newBuilder();
            builderNewBuilder.addAsset(titleAsset);
            builderNewBuilder.addAsset(descAsset);
            builderNewBuilder.addAsset(ctaAsset);
            builderNewBuilder.addAsset(ratingAsset);
            builderNewBuilder.addAsset(createIconAsset(unifiedNativeAdRequestParams));
            builderNewBuilder.addAsset(createImageAsset(unifiedNativeAdRequestParams));
            builderNewBuilder.addAsset(createVideoAsset(unifiedNativeAdRequestParams));
            builderNewBuilder.addAsset(adLabelAsset);
            builderNewBuilder.addAsset(privacySheetAsset);
            builderAddAllMime.setNativefmt(builderNewBuilder);
            HeaderBiddingPlacement.Builder builderCreateHeaderBiddingPlacement = createHeaderBiddingPlacement(contextProvider, unifiedNativeAdRequestParams, adsType, collection, list, i);
            if (builderCreateHeaderBiddingPlacement != null) {
                builderAddAllMime.addExtProto(Any.pack(builderCreateHeaderBiddingPlacement.build()));
            }
            return builderAddAllMime;
        }

        @Override // io.bidmachine.displays.PlacementBuilder
        public AdObjectParams createAdObjectParams(Ad ad) {
            AdObjectParams adObjectParamsCreateHeaderBiddingAdObjectParams = createHeaderBiddingAdObjectParams(ad);
            return (adObjectParamsCreateHeaderBiddingAdObjectParams == null && ad.hasDisplay() && ad.getDisplay().hasNative()) ? new NativeAdObjectParams(ad) : adObjectParamsCreateHeaderBiddingAdObjectParams;
        }
    }});

    private final ApiRequest.ApiAuctionDataBinder binder;
    private final String name;
    private final PlacementBuilder[] placementBuilders;
    private final Executor placementCreateExecutor = Executors.newFixedThreadPool(Math.max(8, Runtime.getRuntime().availableProcessors() * 4));

    AdsType(String str, ApiRequest.ApiAuctionDataBinder apiAuctionDataBinder, PlacementBuilder[] placementBuilderArr) {
        this.name = str;
        this.binder = apiAuctionDataBinder;
        this.placementBuilders = placementBuilderArr;
    }

    public String getName() {
        return this.name;
    }

    ApiRequest.ApiAuctionDataBinder getBinder() {
        return this.binder;
    }

    public boolean isFullscreen() {
        return this == Interstitial || this == Rewarded;
    }

    NetworkAdapter findNetworkAdapter(Ad ad) {
        HeaderBiddingAd headerBiddingAdObtainHeaderBiddingAd = obtainHeaderBiddingAd(ad);
        NetworkAdapter adapter = headerBiddingAdObtainHeaderBiddingAd != null ? NetworkRegistry.getAdapter(headerBiddingAdObtainHeaderBiddingAd.getBidder()) : null;
        if (adapter != null) {
            return adapter;
        }
        if (this == Native) {
            return NetworkRegistry.getAdapter(NastAdapter.KEY);
        }
        if (ad.hasDisplay()) {
            return NetworkRegistry.getAdapter("mraid");
        }
        return ad.hasVideo() ? NetworkRegistry.getAdapter("vast") : adapter;
    }

    AdObjectParams createAdObjectParams(Ad ad) {
        for (PlacementBuilder placementBuilder : this.placementBuilders) {
            AdObjectParams adObjectParamsCreateAdObjectParams = placementBuilder.createAdObjectParams(ad);
            if (adObjectParamsCreateAdObjectParams != null) {
                return adObjectParamsCreateAdObjectParams;
            }
        }
        return null;
    }

    HeaderBiddingAd obtainHeaderBiddingAd(Ad ad) {
        for (PlacementBuilder placementBuilder : this.placementBuilders) {
            HeaderBiddingAd headerBiddingAdObtainHeaderBiddingAd = placementBuilder.obtainHeaderBiddingAd(ad);
            if (headerBiddingAdObtainHeaderBiddingAd != null) {
                return headerBiddingAdObtainHeaderBiddingAd;
            }
        }
        return null;
    }

    void collectPlacements(final ContextProvider contextProvider, AdRequest adRequest, final UnifiedAdRequestParams unifiedAdRequestParams, final Collection<NetworkConfig> collection, final List<Message.Builder> list, final List<NetworkAdUnit> list2, final int i) {
        AdsType adsType = this;
        final CountDownLatch countDownLatch = new CountDownLatch(adsType.placementBuilders.length);
        PlacementBuilder[] placementBuilderArr = adsType.placementBuilders;
        int length = placementBuilderArr.length;
        int i2 = 0;
        while (i2 < length) {
            final PlacementBuilder placementBuilder = placementBuilderArr[i2];
            if (adRequest.isPlacementBuilderMatch(placementBuilder)) {
                adsType.placementCreateExecutor.execute(new Runnable() { // from class: io.bidmachine.AdsType.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Message.Builder builderCreatePlacement = placementBuilder.createPlacement(contextProvider, unifiedAdRequestParams, AdsType.this, collection, list2, i);
                            synchronized (list) {
                                list.add(builderCreatePlacement);
                            }
                            countDownLatch.countDown();
                        } catch (Exception e) {
                            Logger.w(e);
                            countDownLatch.countDown();
                        }
                    }
                });
            } else {
                countDownLatch.countDown();
            }
            i2++;
            adsType = this;
            placementBuilderArr = placementBuilderArr;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Logger.w(e);
        }
    }
}
