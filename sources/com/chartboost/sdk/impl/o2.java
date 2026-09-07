package com.chartboost.sdk.impl;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.amazon.device.ads.DtbDeviceData;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.vungle.ads.internal.model.AdPayload;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import java.io.File;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010b\u001a\u00020`\u0012\u0006\u0010d\u001a\u00020\u0004\u0012\u0006\u0010i\u001a\u00020e\u0012\u0006\u0010l\u001a\u00020j\u0012\b\u0010o\u001a\u0004\u0018\u00010m\u0012\b\u0010u\u001a\u0004\u0018\u00010p\u0012\b\u0010y\u001a\u0004\u0018\u00010v\u0012\b\u0010{\u001a\u0004\u0018\u00010\u0004\u0012\u0007\u0010\u0081\u0001\u001a\u00020|\u0012\b\u0010\u0084\u0001\u001a\u00030\u0082\u0001\u0012\b\u0010\u0088\u0001\u001a\u00030\u0085\u0001\u0012\u0007\u0010\u008a\u0001\u001a\u00020\u0001\u0012(\b\u0002\u0010\u0090\u0001\u001a!\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00040\u008c\u00010\u008b\u0001j\u0003`\u008d\u0001¢\u0006\u0006\b×\u0001\u0010Ø\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000eJ \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b \u0010\u0016J\u0014\u0010\u0015\u001a\u00020\u0013*\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010!J\u0014\u0010\u0017\u001a\u00020\u0013*\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0017\u0010!J\u0014\u0010\u001a\u001a\u00020\u0018*\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\"J\u0014\u0010\u001e\u001a\u00020\u001c*\u00020\u001cH\u0096\u0001¢\u0006\u0004\b\u001e\u0010#J\u0014\u0010 \u001a\u00020\u0013*\u00020\u0013H\u0096\u0001¢\u0006\u0004\b \u0010!J\u0019\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010*J\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010*J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u0010*J\u0019\u0010\u0007\u001a\u0004\u0018\u00010+2\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b\u0007\u00102J\u0017\u0010\u0007\u001a\u0004\u0018\u00010+2\u0006\u00104\u001a\u000203¢\u0006\u0004\b\u0007\u00105J\u0015\u00107\u001a\u00020+2\u0006\u00106\u001a\u00020\u0004¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0006¢\u0006\u0004\b9\u0010*J\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010*J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b\u0007\u0010:J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0000¢\u0006\u0004\b\u0007\u0010=J\u000f\u0010>\u001a\u00020\u0006H\u0000¢\u0006\u0004\b>\u0010*J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010@J\u0015\u0010'\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b'\u0010AJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010EJ\r\u0010F\u001a\u00020\u0006¢\u0006\u0004\bF\u0010*J\u0017\u0010H\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bH\u0010IJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020J¢\u0006\u0004\b\u0007\u0010MJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020N¢\u0006\u0004\b\u0007\u0010OJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\b\u0007\u0010RJ\r\u0010S\u001a\u00020\u0006¢\u0006\u0004\bS\u0010*J\r\u0010T\u001a\u00020\u0006¢\u0006\u0004\bT\u0010*J%\u0010\u0007\u001a\u00020\u00062\f\u0010W\u001a\b\u0012\u0004\u0012\u00020V0U2\b\u0010X\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010YR\u001a\u0010%\u001a\u00020$8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010Z\u001a\u0004\b[\u0010\\R\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010]\u001a\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010aR\u0017\u0010d\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bH\u0010]\u001a\u0004\bc\u0010_R\u001a\u0010i\u001a\u00020e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b>\u0010f\u001a\u0004\bg\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010kR\u0016\u0010o\u001a\u0004\u0018\u00010m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010nR\u001c\u0010u\u001a\u0004\u0018\u00010p8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0016\u0010y\u001a\u0004\u0018\u00010v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010]R\u001c\u0010\u0081\u0001\u001a\u00020|8\u0004X\u0084\u0004¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0017\u0010\u0084\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b^\u0010\u0083\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0016\u0010\u008a\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0089\u0001R6\u0010\u0090\u0001\u001a!\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00040\u008c\u00010\u008b\u0001j\u0003`\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\r\n\u0005\b\u0092\u0001\u0010]\u001a\u0004\bq\u0010_R\u0019\u0010\u0096\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bs\u0010\u0095\u0001R\u0019\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bg\u0010\u0095\u0001R\u0019\u0010\u009a\u0001\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R1\u0010 \u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\t8\u0006@BX\u0087\u000e¢\u0006\u0017\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u0012\u0005\b\u009f\u0001\u0010*\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R1\u0010¤\u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\t8\u0006@BX\u0087\u000e¢\u0006\u0017\n\u0006\b¡\u0001\u0010\u009c\u0001\u0012\u0005\b£\u0001\u0010*\u001a\u0006\b¢\u0001\u0010\u009e\u0001R\u0018\u0010¥\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bT\u0010\u009c\u0001R\u0018\u0010¦\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b)\u0010\u009c\u0001R\u0018\u0010§\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\n\u0010\u009c\u0001R/\u0010¬\u0001\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u001e\n\u0005\b\u000b\u0010\u009c\u0001\u0012\u0005\b«\u0001\u0010*\u001a\u0006\b¨\u0001\u0010\u009e\u0001\"\u0006\b©\u0001\u0010ª\u0001R/\u0010°\u0001\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u001e\n\u0005\b.\u0010\u009c\u0001\u0012\u0005\b¯\u0001\u0010*\u001a\u0006\b\u00ad\u0001\u0010\u009e\u0001\"\u0006\b®\u0001\u0010ª\u0001R/\u0010´\u0001\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u001e\n\u0005\b,\u0010\u009c\u0001\u0012\u0005\b³\u0001\u0010*\u001a\u0006\b±\u0001\u0010\u009e\u0001\"\u0006\b²\u0001\u0010ª\u0001R/\u0010¸\u0001\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u001e\n\u0005\b9\u0010\u009c\u0001\u0012\u0005\b·\u0001\u0010*\u001a\u0006\bµ\u0001\u0010\u009e\u0001\"\u0006\b¶\u0001\u0010ª\u0001R\u0018\u0010¹\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bF\u0010\u009c\u0001R\u0018\u0010º\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bS\u0010\u009c\u0001R\u0019\u0010¼\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010\u009c\u0001R\u0019\u0010¾\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u009c\u0001R\u0018\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010\u0099\u0001R\u0019\u0010Á\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010\u009c\u0001R\u0019\u0010Ã\u0001\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010Â\u0001R.\u0010Æ\u0001\u001a\u0004\u0018\u00010&2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010Ä\u0001\u001a\u0006\b¡\u0001\u0010Å\u0001R'\u0010K\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÇ\u0001\u0010½\u0001\u001a\u0006\b\u0098\u0001\u0010È\u0001\"\u0005\b\u0007\u0010É\u0001R(\u0010Ë\u0001\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÊ\u0001\u0010½\u0001\u001a\u0006\b\u009b\u0001\u0010È\u0001\"\u0005\b'\u0010É\u0001R\u0019\u0010Í\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010½\u0001R\u001f\u0010Ò\u0001\u001a\u00030Î\u00018\u0000X\u0080\u0004¢\u0006\u000f\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0005\bz\u0010Ñ\u0001R\u0013\u0010Ó\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010_R\u0013\u0010Ô\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010_R\u0013\u0010Õ\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010_R\u0012\u0010Ö\u0001\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b}\u0010_R\u0011\u0010L\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bw\u0010_¨\u0006Ù\u0001"}, d2 = {"Lcom/chartboost/sdk/impl/o2;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/ma;", "name", "", "message", "", "a", "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;)V", "", VastAttributes.HORIZONTAL_POSITION, VastAttributes.VERTICAL_POSITION, "width", "height", "(IIII)Ljava/lang/String;", "type", "location", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", "Landroid/content/Context;", "context", "Lcom/chartboost/sdk/impl/vb;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/vb;", "w", "()V", "Lcom/chartboost/sdk/internal/Model/CBError$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/chartboost/sdk/internal/Model/CBError$b;", "z", InneractiveMediationDefs.GENDER_FEMALE, "Landroid/view/ViewGroup;", "hostView", "(Landroid/view/ViewGroup;)Lcom/chartboost/sdk/internal/Model/CBError$b;", "Lcom/chartboost/sdk/view/CBImpressionActivity;", "activity", "(Lcom/chartboost/sdk/view/CBImpressionActivity;)Lcom/chartboost/sdk/internal/Model/CBError$b;", "error", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)Lcom/chartboost/sdk/internal/Model/CBError$b;", "B", "(Landroid/content/Context;)V", "Landroid/webkit/WebView;", "webView", "(Landroid/webkit/WebView;)V", "e", "orientation", "(I)Ljava/lang/String;", "(Ljava/lang/String;)I", "", "allowOrientationChange", "forceOrientationString", "(ZLjava/lang/String;)V", "C", "url", "d", "(Ljava/lang/String;)V", "", "videoDuration", "currentPosition", "(FF)V", "Lcom/chartboost/sdk/impl/db;", "(Lcom/chartboost/sdk/impl/db;)V", "Lcom/chartboost/sdk/impl/h8;", "newState", "(Lcom/chartboost/sdk/impl/h8;)V", "D", "v", "", "Lcom/chartboost/sdk/impl/fb;", "verificationScriptResourceList", UnifiedMediationParams.KEY_SKIP_OFFSET, "(Ljava/util/List;Ljava/lang/Integer;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "Lcom/chartboost/sdk/impl/d7;", "Lcom/chartboost/sdk/impl/d7;", "adUnitMType", "g", "adTypeTraitsName", "Lcom/chartboost/sdk/impl/sa;", "Lcom/chartboost/sdk/impl/sa;", "r", "()Lcom/chartboost/sdk/impl/sa;", "uiPoster", "Lcom/chartboost/sdk/impl/f5;", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/g2;", "Lcom/chartboost/sdk/impl/g2;", "networkRequestService", "Lcom/chartboost/sdk/impl/l2;", "h", "Lcom/chartboost/sdk/impl/l2;", CampaignEx.JSON_KEY_AD_Q, "()Lcom/chartboost/sdk/impl/l2;", "templateProxy", "Lcom/chartboost/sdk/Mediation;", "i", "Lcom/chartboost/sdk/Mediation;", "mediation", "j", "templateHtml", "Lcom/chartboost/sdk/impl/s7;", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/s7;", "n", "()Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lcom/chartboost/sdk/impl/j0;", "Lcom/chartboost/sdk/impl/j0;", "adUnitRendererCallback", "Lcom/chartboost/sdk/impl/yb;", "m", "Lcom/chartboost/sdk/impl/yb;", "webViewTimeoutInterface", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lkotlin/Function2;", "Lcom/chartboost/sdk/impl/c2;", "Lcom/chartboost/sdk/internal/impression/ImpressionTrackerRequestFactory;", "o", "Lkotlin/jvm/functions/Function2;", "impressionTrackerRequestFactory", "<set-?>", "p", "baseExternalPathURL", "", "J", "adWebViewIntializeTime", "adWebViewFinishTime", "s", "Z", "isPageFinishedLoading", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "I", "getScreenWidth", "()I", "getScreenWidth$annotations", "screenWidth", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "getScreenHeight", "getScreenHeight$annotations", "screenHeight", "maxContainerWidth", "maxContainerHeight", "contentViewTop", "getDefaultXPos", "setDefaultXPos", "(I)V", "getDefaultXPos$annotations", "defaultXPos", "getDefaultYPos", "setDefaultYPos", "getDefaultYPos$annotations", "defaultYPos", "getDefaultWidth", "setDefaultWidth", "getDefaultWidth$annotations", "defaultWidth", "getDefaultHeight", "setDefaultHeight", "getDefaultHeight$annotations", "defaultHeight", "currentXPos", "currentYPos", ExifInterface.LONGITUDE_EAST, "currentWidth", "F", "currentHeight", "G", "H", "forceOrientation", "Lcom/chartboost/sdk/impl/h8;", "state", "Lcom/chartboost/sdk/impl/vb;", "()Lcom/chartboost/sdk/impl/vb;", "view", "K", "()F", "(F)V", "L", "videoPosition", "M", "templateVideoVolume", "Lcom/chartboost/sdk/impl/t3;", "N", "Lcom/chartboost/sdk/impl/t3;", "()Lcom/chartboost/sdk/impl/t3;", "customWebViewInterface", "orientationProperties", SDKConstants.PARAM_CONTEXT_MAX_SIZE, DtbDeviceData.DEVICE_DATA_SCREEN_SIZE_KEY, "defaultPosition", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/chartboost/sdk/impl/d7;Ljava/lang/String;Lcom/chartboost/sdk/impl/sa;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/g2;Lcom/chartboost/sdk/impl/l2;Lcom/chartboost/sdk/Mediation;Ljava/lang/String;Lcom/chartboost/sdk/impl/s7;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/yb;Lcom/chartboost/sdk/impl/m4;Lkotlin/jvm/functions/Function2;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public abstract class o2 implements m4 {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public int defaultWidth;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public int defaultHeight;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public int currentXPos;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public int currentYPos;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public int currentWidth;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public int currentHeight;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    public boolean allowOrientationChange;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    public int forceOrientation;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    public h8 state;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    public vb view;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public float videoDuration;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public float videoPosition;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public float templateVideoVolume;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public final t3 customWebViewInterface;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final d7 adUnitMType;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String adTypeTraitsName;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final sa uiPoster;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final g2 networkRequestService;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final l2 templateProxy;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final String templateHtml;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final s7 openMeasurementImpressionCallback;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final j0 adUnitRendererCallback;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final yb webViewTimeoutInterface;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Function2<String, m4, c2<String>> impressionTrackerRequestFactory;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public String baseExternalPathURL;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public long adWebViewIntializeTime;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public long adWebViewFinishTime;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean isPageFinishedLoading;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public int screenWidth;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public int screenHeight;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public int maxContainerWidth;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public int maxContainerHeight;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    public int contentViewTop;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    public int defaultXPos;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    public int defaultYPos;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function2<String, m4, m6> {
        public static final a b = new a();

        public a() {
            super(2, m6.class, "<init>", "<init>(Ljava/lang/String;Lcom/chartboost/sdk/tracking/EventTrackerExtensions;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m6 invoke(String p0, m4 p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return new m6(p0, p1);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1090a;

        static {
            int[] iArr = new int[db.values().length];
            try {
                iArr[db.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[db.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[db.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[db.BUFFER_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[db.BUFFER_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[db.QUARTILE1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[db.MIDPOINT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[db.QUARTILE3.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[db.COMPLETED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[db.SKIP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[db.VOLUME_CHANGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f1090a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o2(Context context, String location, d7 adUnitMType, String adTypeTraitsName, sa uiPoster, f5 fileCache, g2 g2Var, l2 l2Var, Mediation mediation, String str, s7 openMeasurementImpressionCallback, j0 adUnitRendererCallback, yb webViewTimeoutInterface, m4 eventTracker, Function2<? super String, ? super m4, ? extends c2<String>> impressionTrackerRequestFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adUnitMType, "adUnitMType");
        Intrinsics.checkNotNullParameter(adTypeTraitsName, "adTypeTraitsName");
        Intrinsics.checkNotNullParameter(uiPoster, "uiPoster");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(adUnitRendererCallback, "adUnitRendererCallback");
        Intrinsics.checkNotNullParameter(webViewTimeoutInterface, "webViewTimeoutInterface");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(impressionTrackerRequestFactory, "impressionTrackerRequestFactory");
        this.context = context;
        this.location = location;
        this.adUnitMType = adUnitMType;
        this.adTypeTraitsName = adTypeTraitsName;
        this.uiPoster = uiPoster;
        this.fileCache = fileCache;
        this.networkRequestService = g2Var;
        this.templateProxy = l2Var;
        this.mediation = mediation;
        this.templateHtml = str;
        this.openMeasurementImpressionCallback = openMeasurementImpressionCallback;
        this.adUnitRendererCallback = adUnitRendererCallback;
        this.webViewTimeoutInterface = webViewTimeoutInterface;
        this.eventTracker = eventTracker;
        this.impressionTrackerRequestFactory = impressionTrackerRequestFactory;
        this.allowOrientationChange = true;
        this.forceOrientation = -1;
        this.state = h8.PLAYING;
        this.customWebViewInterface = new c();
    }

    public abstract vb b(Context context);

    @Override // com.chartboost.sdk.impl.l4
    public void clear(String type, String location) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.eventTracker.clear(type, location);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka clearFromStorage(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.eventTracker.clearFromStorage(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka persist(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.eventTracker.persist(kaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ia refresh(ia iaVar) {
        Intrinsics.checkNotNullParameter(iaVar, "<this>");
        return this.eventTracker.refresh(iaVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public da store(da daVar) {
        Intrinsics.checkNotNullParameter(daVar, "<this>");
        return this.eventTracker.store(daVar);
    }

    @Override // com.chartboost.sdk.impl.m4
    public ka track(ka kaVar) {
        Intrinsics.checkNotNullParameter(kaVar, "<this>");
        return this.eventTracker.track(kaVar);
    }

    public abstract void w();

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: clearFromStorage */
    public void mo4737clearFromStorage(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventTracker.mo4737clearFromStorage(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: persist */
    public void mo4738persist(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventTracker.mo4738persist(event);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: refresh */
    public void mo4739refresh(ia config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.eventTracker.mo4739refresh(config);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: store */
    public void mo4740store(da ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.eventTracker.mo4740store(ad);
    }

    @Override // com.chartboost.sdk.impl.l4
    /* JADX INFO: renamed from: track */
    public void mo4741track(ka event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventTracker.mo4741track(event);
    }

    public final int b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual(name, "portrait")) {
            return 1;
        }
        return Intrinsics.areEqual(name, "landscape") ? 0 : -1;
    }

    public final CBError.b c(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(ma.i.WEBVIEW_ERROR, error);
        b7.b(error, null, 2, null);
        this.isPageFinishedLoading = true;
        return CBError.b.WEB_VIEW_CLIENT_RECEIVED_ERROR;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getAdTypeTraitsName() {
        return this.adTypeTraitsName;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final sa getUiPoster() {
        return this.uiPoster;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final l2 getTemplateProxy() {
        return this.templateProxy;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final s7 getOpenMeasurementImpressionCallback() {
        return this.openMeasurementImpressionCallback;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getBaseExternalPathURL() {
        return this.baseExternalPathURL;
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final vb getView() {
        return this.view;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final float getVideoDuration() {
        return this.videoDuration;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final float getVideoPosition() {
        return this.videoPosition;
    }

    public final void a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.maxContainerWidth = webView.getWidth();
        this.maxContainerHeight = webView.getHeight();
    }

    public final CBError.b A() {
        File file = this.fileCache.a().f1027a;
        if (file == null) {
            b7.b("External Storage path is unavailable or media not mounted", null, 2, null);
            return CBError.b.ERROR_LOADING_WEB_VIEW;
        }
        this.baseExternalPathURL = AdPayload.FILE_SCHEME + file.getAbsolutePath() + '/';
        String str = this.templateHtml;
        if (str == null || str.length() != 0) {
            return null;
        }
        b7.b("Empty template being passed in the response", null, 2, null);
        return CBError.b.ERROR_DISPLAYING_VIEW;
    }

    public void z() {
        p2 webView;
        l2 l2Var;
        vb vbVar = this.view;
        if (vbVar == null || (webView = vbVar.getWebView()) == null || (l2Var = this.templateProxy) == null) {
            return;
        }
        l2Var.b(webView, this.location, this.adTypeTraitsName);
        webView.onResume();
    }

    public void y() {
        p2 webView;
        l2 l2Var;
        vb vbVar = this.view;
        if (vbVar == null || (webView = vbVar.getWebView()) == null || (l2Var = this.templateProxy) == null) {
            return;
        }
        l2Var.a(webView, this.location, this.adTypeTraitsName);
        webView.onPause();
    }

    public void f() {
        this.openMeasurementImpressionCallback.e();
        vb vbVar = this.view;
        if (vbVar != null) {
            this.uiPoster.a(1000L, new d(vbVar));
        }
        this.view = null;
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ vb b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(vb vbVar) {
            super(0);
            this.b = vbVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.b.a();
            this.b.removeAllViews();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function0<Unit> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            if (o2.this.isPageFinishedLoading) {
                return;
            }
            b7.a("Webview seems to be taking more time loading the html content, so closing the view.", (Throwable) null, 2, (Object) null);
            o2.this.a(ma.i.TIMEOUT_EVENT, "");
            o2.this.webViewTimeoutInterface.a();
        }
    }

    public final void B() {
        this.uiPoster.a(15000L, new e());
    }

    public void x() {
        p2 webView;
        Context context;
        this.isPageFinishedLoading = true;
        this.adWebViewFinishTime = System.currentTimeMillis();
        b7.a("Total web view load response time " + ((this.adWebViewFinishTime - this.adWebViewIntializeTime) / ((long) 1000)), (Throwable) null, 2, (Object) null);
        vb vbVar = this.view;
        if (vbVar != null && (context = vbVar.getContext()) != null) {
            a(context);
        }
        vb vbVar2 = this.view;
        if (vbVar2 == null || (webView = vbVar2.getWebView()) == null) {
            return;
        }
        a((WebView) webView);
        e();
    }

    public final void e() {
        vb vbVar = this.view;
        if (vbVar != null && this.isPageFinishedLoading) {
            int[] iArr = new int[2];
            vbVar.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1] - this.contentViewTop;
            int width = vbVar.getWidth();
            int height = vbVar.getHeight();
            this.defaultXPos = i;
            this.defaultYPos = i2;
            int i3 = width + i;
            this.defaultWidth = i3;
            int i4 = height + i2;
            this.defaultHeight = i4;
            this.currentXPos = i;
            this.currentYPos = i2;
            this.currentWidth = i3;
            this.currentHeight = i4;
            b7.a("CalculatePosition: defaultXPos: " + this.defaultXPos + " , currentXPos: " + this.currentXPos, (Throwable) null, 2, (Object) null);
            return;
        }
        this.currentXPos = this.defaultXPos;
        this.currentYPos = this.defaultYPos;
        this.currentWidth = this.defaultWidth;
        this.currentHeight = this.defaultHeight;
    }

    public final String o() {
        String string = z1.a(z1.a("allowOrientationChange", Boolean.valueOf(this.allowOrientationChange)), z1.a("forceOrientation", a(this.forceOrientation))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "load.toString()");
        return string;
    }

    public final void C() {
        this.adUnitRendererCallback.a();
        this.allowOrientationChange = true;
        this.forceOrientation = -1;
    }

    public final String m() {
        String string = z1.a(z1.a("width", Integer.valueOf(this.maxContainerWidth)), z1.a("height", Integer.valueOf(this.maxContainerHeight))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject(\n            …\n            ).toString()");
        return string;
    }

    public final String p() {
        String string = z1.a(z1.a("width", Integer.valueOf(this.screenWidth)), z1.a("height", Integer.valueOf(this.screenHeight))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject(\n            …\n            ).toString()");
        return string;
    }

    public final String k() {
        e();
        return a(this.defaultXPos, this.defaultYPos, this.defaultWidth, this.defaultHeight);
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
    }

    public final String i() {
        e();
        return a(this.currentXPos, this.currentYPos, this.currentWidth, this.currentHeight);
    }

    public final void d(String url) {
        g2 g2Var;
        if (url != null && url.length() != 0 && (g2Var = this.networkRequestService) != null) {
            g2Var.a(this.impressionTrackerRequestFactory.invoke(url, this.eventTracker));
            b7.a("###### Sending VAST Tracking Event: " + url, (Throwable) null, 2, (Object) null);
        } else {
            b7.a("###### Sending VAST Tracking Event Failed: " + url, (Throwable) null, 2, (Object) null);
        }
    }

    public final void b(float f) {
        this.videoPosition = f;
    }

    public final void D() {
        this.templateVideoVolume = 1.0f;
    }

    public final void v() {
        this.templateVideoVolume = 0.0f;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final t3 getCustomWebViewInterface() {
        return this.customWebViewInterface;
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004¨\u0006\u000e"}, d2 = {"com/chartboost/sdk/impl/o2$c", "Lcom/chartboost/sdk/impl/t3;", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()V", "a", "", "message", "(Ljava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/View;", "obstructionView", "(Landroid/view/View;)V", "d", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c implements t3 {
        public c() {
        }

        @Override // com.chartboost.sdk.impl.t3
        public void a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            o2.this.c(message);
        }

        @Override // com.chartboost.sdk.impl.t3
        public void c() {
            vb view = o2.this.getView();
            p2 webView = view != null ? view.getWebView() : null;
            if (o2.this.adUnitMType == d7.VIDEO || webView == null) {
                return;
            }
            s7 openMeasurementImpressionCallback = o2.this.getOpenMeasurementImpressionCallback();
            d7 d7Var = o2.this.adUnitMType;
            List<fb> listEmptyList = Collections.emptyList();
            Intrinsics.checkNotNullExpressionValue(listEmptyList, "emptyList()");
            openMeasurementImpressionCallback.a(d7Var, webView, null, listEmptyList);
        }

        @Override // com.chartboost.sdk.impl.t3
        public void a(View obstructionView) {
            Intrinsics.checkNotNullParameter(obstructionView, "obstructionView");
            o2.this.getOpenMeasurementImpressionCallback().a(obstructionView);
        }

        @Override // com.chartboost.sdk.impl.t3
        public void b() {
            o2.this.B();
        }

        @Override // com.chartboost.sdk.impl.t3
        public void d() {
            o2.this.x();
        }

        @Override // com.chartboost.sdk.impl.t3
        public void a() {
            o2.this.adWebViewIntializeTime = System.currentTimeMillis();
        }
    }

    public /* synthetic */ o2(Context context, String str, d7 d7Var, String str2, sa saVar, f5 f5Var, g2 g2Var, l2 l2Var, Mediation mediation, String str3, s7 s7Var, j0 j0Var, yb ybVar, m4 m4Var, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, d7Var, str2, saVar, f5Var, g2Var, l2Var, mediation, str3, s7Var, j0Var, ybVar, m4Var, (i & 16384) != 0 ? a.b : function2);
    }

    public final String a(int orientation) {
        if (orientation == -1) {
            return "none";
        }
        if (orientation == 0) {
            return "landscape";
        }
        if (orientation != 1) {
            return "error";
        }
        return "portrait";
    }

    public final String a(int x, int y, int width, int height) {
        String string = z1.a(z1.a(VastAttributes.HORIZONTAL_POSITION, Integer.valueOf(x)), z1.a(VastAttributes.VERTICAL_POSITION, Integer.valueOf(y)), z1.a("width", Integer.valueOf(width)), z1.a("height", Integer.valueOf(height))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject(\n            …ht),\n        ).toString()");
        return string;
    }

    public final void a(List<fb> verificationScriptResourceList, Integer skipOffset) {
        p2 webView;
        Intrinsics.checkNotNullParameter(verificationScriptResourceList, "verificationScriptResourceList");
        vb vbVar = this.view;
        if (vbVar == null || (webView = vbVar.getWebView()) == null) {
            return;
        }
        this.openMeasurementImpressionCallback.a(this.adUnitMType, webView, skipOffset, verificationScriptResourceList);
    }

    public final void a(float videoDuration, float currentPosition) {
        float f = 4;
        float f2 = videoDuration / f;
        float f3 = videoDuration / 2;
        float f4 = (videoDuration * 3) / f;
        if (currentPosition >= f2 && currentPosition < f3) {
            a(db.QUARTILE1);
            return;
        }
        if (currentPosition >= f3 && currentPosition < f4) {
            a(db.MIDPOINT);
        } else if (currentPosition >= f4) {
            a(db.QUARTILE3);
        }
    }

    public final void a(db event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b7.a("sendWebViewVastOmEvent: " + event.name(), (Throwable) null, 2, (Object) null);
        if (this.adUnitMType != d7.VIDEO) {
        }
        s7 s7Var = this.openMeasurementImpressionCallback;
        switch (b.f1090a[event.ordinal()]) {
            case 1:
                s7Var.a(this.videoDuration, this.templateVideoVolume);
                break;
            case 2:
                if (this.state == h8.PAUSED) {
                    s7Var.b();
                }
                break;
            case 3:
                s7Var.c();
                break;
            case 4:
                s7Var.a(true);
                break;
            case 5:
                s7Var.a(false);
                break;
            case 6:
                s7Var.a(t8.FIRST);
                break;
            case 7:
                s7Var.a(t8.MIDDLE);
                break;
            case 8:
                s7Var.a(t8.THIRD);
                break;
            case 9:
                s7Var.a();
                break;
            case 10:
                s7Var.f();
                break;
            case 11:
                s7Var.a(this.templateVideoVolume);
                break;
        }
    }

    public final void a(boolean allowOrientationChange, String forceOrientationString) {
        Intrinsics.checkNotNullParameter(forceOrientationString, "forceOrientationString");
        this.allowOrientationChange = allowOrientationChange;
        int iB = b(forceOrientationString);
        this.forceOrientation = iB;
        this.adUnitRendererCallback.a(iB, allowOrientationChange);
    }

    public final void a(float f) {
        this.videoDuration = f;
    }

    public final void a(ma name, String message) {
        if (message == null) {
            message = "no message";
        }
        track((ka) new r3(name, message, this.adTypeTraitsName, this.location, this.mediation, null, 32, null));
    }

    public final CBError.b a(CBImpressionActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.view == null) {
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            this.view = b(applicationContext);
        }
        this.adUnitRendererCallback.a(this.context);
        return null;
    }

    public final CBError.b a(ViewGroup hostView) {
        if (this.view == null) {
            if ((hostView != null ? hostView.getContext() : null) != null) {
                Context context = hostView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "hostView.context");
                this.view = b(context);
            } else {
                return CBError.b.ERROR_CREATING_VIEW;
            }
        }
        return null;
    }

    public final void a(h8 newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        this.state = newState;
    }
}
