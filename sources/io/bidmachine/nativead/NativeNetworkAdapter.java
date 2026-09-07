package io.bidmachine.nativead;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import io.bidmachine.ImageData;
import io.bidmachine.LabelData;
import io.bidmachine.PrivacySheetData;
import io.bidmachine.nativead.view.NativeAdOverlayContainer;
import io.bidmachine.nativead.view.NativeMediaView;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class NativeNetworkAdapter implements NativeData {
    private LabelData adLabelData;
    private String callToAction;
    private String clickUrl;
    private String description;
    private boolean hasVideo;
    private ImageData iconImageData;
    private ImageData mainImageData;
    private PrivacySheetData privacySheetData;
    private String title;
    private String videoAdm;
    private String videoUrl;
    private float rating = -1.0f;
    private boolean isNetworkControlLoadingAssets = true;

    public ViewGroup configureContainer(Context context) {
        return null;
    }

    public View createCustomMediaView(Context context) {
        return null;
    }

    public void destroy() {
    }

    public void registerNative(ViewGroup viewGroup, ImageView imageView, NativeMediaView nativeMediaView, Set<View> set) {
    }

    public void unregisterNative() {
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getTitle() {
        return this.title;
    }

    public NativeNetworkAdapter setTitle(String str) {
        this.title = str;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getDescription() {
        return this.description;
    }

    public NativeNetworkAdapter setDescription(String str) {
        this.description = str;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public String getCallToAction() {
        return this.callToAction;
    }

    public NativeNetworkAdapter setCallToAction(String str) {
        this.callToAction = str;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public float getRating() {
        return this.rating;
    }

    public NativeNetworkAdapter setRating(float f) {
        this.rating = f;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getIcon() {
        return this.iconImageData;
    }

    public NativeNetworkAdapter setIcon(ImageData imageData) {
        this.iconImageData = imageData;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public ImageData getMainImage() {
        return this.mainImageData;
    }

    public NativeNetworkAdapter setMainImage(ImageData imageData) {
        this.mainImageData = imageData;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getClickUrl() {
        return this.clickUrl;
    }

    public NativeNetworkAdapter setClickUrl(String str) {
        this.clickUrl = str;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getVideoUrl() {
        return this.videoUrl;
    }

    public NativeNetworkAdapter setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public String getVideoAdm() {
        return this.videoAdm;
    }

    public NativeNetworkAdapter setVideoAdm(String str) {
        this.videoAdm = str;
        return this;
    }

    @Override // io.bidmachine.nativead.NativePublicData
    public boolean hasVideo() {
        return this.hasVideo;
    }

    public NativeNetworkAdapter setHasVideo(boolean z) {
        this.hasVideo = z;
        return this;
    }

    public boolean isNetworkControlLoadingAssets() {
        return this.isNetworkControlLoadingAssets;
    }

    public NativeNetworkAdapter setNetworkControlLoadingAssets(boolean z) {
        this.isNetworkControlLoadingAssets = z;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public LabelData getAdLabelData() {
        return this.adLabelData;
    }

    public NativeNetworkAdapter setAdLabelData(LabelData labelData) {
        this.adLabelData = labelData;
        return this;
    }

    @Override // io.bidmachine.nativead.NativeData
    public PrivacySheetData getPrivacySheetData() {
        return this.privacySheetData;
    }

    public NativeNetworkAdapter setPrivacySheetData(PrivacySheetData privacySheetData) {
        this.privacySheetData = privacySheetData;
        return this;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(getTitle()) || TextUtils.isEmpty(getDescription()) || TextUtils.isEmpty(getCallToAction())) ? false : true;
    }

    public View createProviderView(Context context) {
        if (this.adLabelData == null && this.privacySheetData == null) {
            return null;
        }
        NativeAdOverlayContainer nativeAdOverlayContainer = new NativeAdOverlayContainer(context);
        nativeAdOverlayContainer.bindNativeData(this);
        nativeAdOverlayContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return nativeAdOverlayContainer;
    }
}
