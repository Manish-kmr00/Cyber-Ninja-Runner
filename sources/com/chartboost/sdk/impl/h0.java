package com.chartboost.sdk.impl;

import androidx.exifinterface.media.ExifInterface;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0005\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/chartboost/sdk/impl/h0;", "", "Lcom/chartboost/sdk/view/CBImpressionActivity;", "activity", "", "a", "(Lcom/chartboost/sdk/view/CBImpressionActivity;)V", VastAttributes.VERTICAL_POSITION, "()V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "s", CampaignEx.JSON_KEY_AD_Q, "d", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "error", "(Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface h0 {
    void A();

    void a(CBError.b error);

    void a(CBImpressionActivity activity);

    void d();

    void q();

    void s();

    void y();
}
