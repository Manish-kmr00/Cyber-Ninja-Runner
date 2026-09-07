package com.smaato.sdk.nativead.model.utils;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.nativead.NativeAdAssets;
import com.smaato.sdk.nativead.model.NativeAdComponents;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class IconImagesLoader {
    private final Application application;
    private final Logger logger;
    private final SimpleHttpClient simpleHttpClient;

    public IconImagesLoader(SimpleHttpClient simpleHttpClient, Logger logger, Application application) {
        this.application = application;
        this.logger = logger;
        this.simpleHttpClient = simpleHttpClient;
    }

    public NativeAdComponents loadIconAndImages(NativeAdComponents nativeAdComponents) {
        NativeAdAssets nativeAdAssetsAssets = nativeAdComponents.assets();
        NativeAdAssets.Builder builderBuildUpon = nativeAdAssetsAssets.buildUpon();
        if (nativeAdAssetsAssets.icon() != null) {
            try {
                builderBuildUpon.icon(nativeAdAssetsAssets.icon().withDrawable(createDrawable(this.simpleHttpClient.readBitmap(nativeAdAssetsAssets.icon().uri().toString()))));
            } catch (IOException e) {
                this.logger.error(LogDomain.NETWORK, "Error loading icon: " + nativeAdAssetsAssets.icon().uri(), e);
            }
        }
        if (!nativeAdAssetsAssets.images().isEmpty()) {
            ArrayList arrayList = new ArrayList(nativeAdAssetsAssets.images().size());
            for (NativeAdAssets.Image image : nativeAdAssetsAssets.images()) {
                try {
                    arrayList.add(image.withDrawable(createDrawable(this.simpleHttpClient.readBitmap(image.uri().toString()))));
                } catch (IOException e2) {
                    this.logger.error(LogDomain.NETWORK, "Error loading image: " + image.uri(), e2);
                }
            }
            builderBuildUpon.images(arrayList);
        }
        return nativeAdComponents.buildUpon().assets(builderBuildUpon.build()).build();
    }

    private Drawable createDrawable(Bitmap bitmap) {
        return new BitmapDrawable(this.application.getResources(), bitmap);
    }
}
