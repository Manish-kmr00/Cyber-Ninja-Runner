package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.internal.Model.CBError;
import com.chartboost.sdk.internal.Networking.EndpointRepository;
import com.chartboost.sdk.view.CBImpressionActivity;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.smaato.sdk.video.vast.model.Ad;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\b\u0006*\u0002¸\u0001\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B¢\u0001\u0012\b\u0010\u0087\u0001\u001a\u00030\u0085\u0001\u0012\b\u0010\u008a\u0001\u001a\u00030\u0088\u0001\u0012\b\u0010\u008d\u0001\u001a\u00030\u008b\u0001\u0012\b\u0010\u0090\u0001\u001a\u00030\u008e\u0001\u0012\b\u0010\u0093\u0001\u001a\u00030\u0091\u0001\u0012\b\u0010\u0096\u0001\u001a\u00030\u0094\u0001\u0012\b\u0010\u0099\u0001\u001a\u00030\u0097\u0001\u0012\b\u0010\u009c\u0001\u001a\u00030\u009a\u0001\u0012\b\u0010\u009f\u0001\u001a\u00030\u009d\u0001\u0012\b\u0010¢\u0001\u001a\u00030 \u0001\u0012\b\u0010¥\u0001\u001a\u00030£\u0001\u0012\n\u0010ª\u0001\u001a\u0005\u0018\u00010¦\u0001\u0012\n\b\u0002\u0010\u00ad\u0001\u001a\u00030«\u0001\u0012\u0007\u0010¯\u0001\u001a\u00020\u0006\u0012\b\u0010²\u0001\u001a\u00030°\u0001¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000bJ+\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0012\u0010\u001eJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\r\u0010 J\u0019\u0010\n\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\n\u0010 J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J \u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b'\u0010(J\u0018\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0096\u0001¢\u0006\u0004\b+\u0010,J\u0018\u0010-\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0096\u0001¢\u0006\u0004\b-\u0010,J\u0018\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0096\u0001¢\u0006\u0004\b0\u00101J\u0018\u00104\u001a\u00020\t2\u0006\u00103\u001a\u000202H\u0096\u0001¢\u0006\u0004\b4\u00105J\u0018\u00106\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0096\u0001¢\u0006\u0004\b6\u0010,J\u0014\u0010+\u001a\u00020)*\u00020)H\u0096\u0001¢\u0006\u0004\b+\u00107J\u0014\u0010-\u001a\u00020)*\u00020)H\u0096\u0001¢\u0006\u0004\b-\u00107J\u0014\u00100\u001a\u00020.*\u00020.H\u0096\u0001¢\u0006\u0004\b0\u00108J\u0014\u00104\u001a\u000202*\u000202H\u0096\u0001¢\u0006\u0004\b4\u00109J\u0014\u00106\u001a\u00020)*\u00020)H\u0096\u0001¢\u0006\u0004\b6\u00107J\r\u0010:\u001a\u00020\t¢\u0006\u0004\b:\u0010;J\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b\u0012\u0010>J\u000f\u0010?\u001a\u00020\tH\u0016¢\u0006\u0004\b?\u0010;J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\b\u0012\u0010BJ\u000f\u0010C\u001a\u00020\tH\u0016¢\u0006\u0004\bC\u0010;J\u000f\u0010D\u001a\u00020\tH\u0016¢\u0006\u0004\bD\u0010;J\u000f\u0010E\u001a\u00020\tH\u0016¢\u0006\u0004\bE\u0010;J\u000f\u0010F\u001a\u00020\tH\u0016¢\u0006\u0004\bF\u0010;J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010;J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010GJ\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010 J)\u0010\u0012\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00172\b\u0010H\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020IH\u0016¢\u0006\u0004\b\u0012\u0010JJ!\u0010\u0012\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010K\u001a\u00020#H\u0016¢\u0006\u0004\b\u0012\u0010LJ\u0019\u0010\u0012\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0012\u0010 J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\b\u0012\u0010OJ\u000f\u0010P\u001a\u00020\tH\u0016¢\u0006\u0004\bP\u0010;J\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010Q\u001a\u00020#2\u0006\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\b\u0012\u0010TJ\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010;J\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0015J\u000f\u0010U\u001a\u00020\tH\u0016¢\u0006\u0004\bU\u0010;J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010V\u001a\u00020RH\u0016¢\u0006\u0004\b\u0019\u0010WJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010X\u001a\u00020RH\u0016¢\u0006\u0004\b\u0012\u0010WJ!\u0010\u0012\u001a\u00020\t2\b\u0010H\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020IH\u0016¢\u0006\u0004\b\u0012\u0010YJ\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010;J\u000f\u0010Z\u001a\u00020\tH\u0016¢\u0006\u0004\bZ\u0010;J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010[\u001a\u00020RH\u0016¢\u0006\u0004\b\u0016\u0010WJ\u000f\u0010\\\u001a\u00020RH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010_\u001a\u00020^H\u0016¢\u0006\u0004\b\u0012\u0010`J\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010;J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010;J\u000f\u0010a\u001a\u00020\tH\u0016¢\u0006\u0004\ba\u0010;J\u000f\u0010b\u001a\u00020\u0017H\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u0017H\u0016¢\u0006\u0004\bd\u0010cJ\u000f\u0010e\u001a\u00020\u0017H\u0016¢\u0006\u0004\be\u0010cJ\u000f\u0010f\u001a\u00020\u0017H\u0016¢\u0006\u0004\bf\u0010cJ\u000f\u0010g\u001a\u00020\u0017H\u0016¢\u0006\u0004\bg\u0010cJ\u000f\u0010h\u001a\u00020\u0017H\u0016¢\u0006\u0004\bh\u0010cJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010j\u001a\u00020iH\u0016¢\u0006\u0004\b\u0012\u0010kJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010m\u001a\u00020lH\u0016¢\u0006\u0004\b\u0012\u0010nJ\u000f\u0010o\u001a\u00020\tH\u0016¢\u0006\u0004\bo\u0010;J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\b\u0012\u0010rJ\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\b\u0019\u0010rJ\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010s\u001a\u00020p2\u0006\u0010t\u001a\u00020pH\u0016¢\u0006\u0004\b\u0012\u0010uJ\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010 J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010;J\u000f\u0010v\u001a\u00020\tH\u0016¢\u0006\u0004\bv\u0010;J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0014\u0010 J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010H\u001a\u00020wH\u0016¢\u0006\u0004\b\u0016\u0010xJ\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010y\u001a\u00020wH\u0016¢\u0006\u0004\b\u0019\u0010xJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010H\u001a\u00020wH\u0016¢\u0006\u0004\b\u0012\u0010xJ\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010H\u001a\u00020wH\u0016¢\u0006\u0004\b\u0014\u0010xJ\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010S\u001a\u00020R2\u0006\u0010Q\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0012\u0010zJ\u000f\u0010{\u001a\u00020\tH\u0016¢\u0006\u0004\b{\u0010;J\u000f\u0010|\u001a\u00020\tH\u0016¢\u0006\u0004\b|\u0010;J\u000f\u0010}\u001a\u00020\tH\u0016¢\u0006\u0004\b}\u0010;J\u000f\u0010~\u001a\u00020\tH\u0016¢\u0006\u0004\b~\u0010;J\u000f\u0010\u007f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u007f\u0010;J\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010;J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010;J,\u0010\u0012\u001a\u00020\t2\u000f\u0010\u0082\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u00012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0005\b\u0012\u0010\u0084\u0001R\u0017\u0010\u0087\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0012\u0010\u0086\u0001R\u0017\u0010\u008a\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0019\u0010\u0089\u0001R\u0017\u0010\u008d\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0016\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0014\u0010\u008f\u0001R\u0017\u0010\u0093\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001a\u0010\u0092\u0001R\u0017\u0010\u0096\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\r\u0010\u0095\u0001R\u0017\u0010\u0099\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\n\u0010\u0098\u0001R\u0017\u0010\u009c\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\f\u0010\u009b\u0001R\u0017\u0010\u009f\u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bd\u0010\u009e\u0001R\u0017\u0010¢\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bv\u0010¡\u0001R\u0017\u0010¥\u0001\u001a\u00030£\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b}\u0010¤\u0001R\u001e\u0010ª\u0001\u001a\u0005\u0018\u00010¦\u00018\u0006¢\u0006\u000f\n\u0005\bb\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R\u0017\u0010\u00ad\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b~\u0010¬\u0001R\u0016\u0010¯\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010®\u0001R\u0017\u0010²\u0001\u001a\u00030°\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bo\u0010±\u0001R\u0019\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bP\u0010³\u0001R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bF\u0010´\u0001R#\u0010·\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070µ\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bU\u0010¶\u0001R\u0017\u0010º\u0001\u001a\u00030¸\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bE\u0010¹\u0001¨\u0006½\u0001"}, d2 = {"Lcom/chartboost/sdk/impl/g0;", "Lcom/chartboost/sdk/impl/j0;", "Lcom/chartboost/sdk/impl/j6;", "Lcom/chartboost/sdk/impl/x5;", "Lcom/chartboost/sdk/impl/i6;", "Lcom/chartboost/sdk/impl/h0;", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/y0;", "appRequest", "", "g", "(Lcom/chartboost/sdk/impl/y0;)V", "h", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/y1;", "impression", "Lcom/chartboost/sdk/internal/Model/CBError$b;", "error", "a", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/y1;Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "d", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/internal/Model/CBError$b;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "(Lcom/chartboost/sdk/impl/y0;)Ljava/lang/String;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "e", "Lcom/chartboost/sdk/impl/ma;", "trackName", "msg", "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;)V", "location", "(Ljava/lang/String;)V", "impressionId", "(Lcom/chartboost/sdk/impl/y1;)V", "", "G", "()I", "type", "clear", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/chartboost/sdk/impl/ka;", "event", "clearFromStorage", "(Lcom/chartboost/sdk/impl/ka;)V", "persist", "Lcom/chartboost/sdk/impl/ia;", DTBMetricsConfiguration.CONFIG_DIR, ToolBar.REFRESH, "(Lcom/chartboost/sdk/impl/ia;)V", "Lcom/chartboost/sdk/impl/da;", Reporting.Key.CLICK_SOURCE_TYPE_AD, com.ironsource.b9.h.U, "(Lcom/chartboost/sdk/impl/da;)V", "track", "(Lcom/chartboost/sdk/impl/ka;)Lcom/chartboost/sdk/impl/ka;", "(Lcom/chartboost/sdk/impl/ia;)Lcom/chartboost/sdk/impl/ia;", "(Lcom/chartboost/sdk/impl/da;)Lcom/chartboost/sdk/impl/da;", ExifInterface.LONGITUDE_EAST, "()V", "Lcom/chartboost/sdk/impl/i0;", "callback", "(Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/i0;)V", "v", "Lcom/chartboost/sdk/view/CBImpressionActivity;", "activity", "(Lcom/chartboost/sdk/view/CBImpressionActivity;)V", VastAttributes.VERTICAL_POSITION, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "s", CampaignEx.JSON_KEY_AD_Q, "(Lcom/chartboost/sdk/internal/Model/CBError$b;)V", "url", "Lcom/chartboost/sdk/internal/Model/CBError$a;", "(Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$a;)V", "reward", "(Ljava/lang/String;I)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "p", "forceOrientation", "", "allowOrientationChange", "(IZ)V", "r", "close", "(Z)V", "click", "(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$a;)V", "B", "showProcessed", "H", "()Z", "Lcom/chartboost/sdk/impl/l6;", "state", "(Lcom/chartboost/sdk/impl/l6;)V", "D", "l", "()Ljava/lang/String;", "i", "w", "C", "n", VastAttributes.HORIZONTAL_POSITION, "Lcom/chartboost/sdk/impl/db;", "vastVideoEvent", "(Lcom/chartboost/sdk/impl/db;)V", "Lcom/chartboost/sdk/impl/h8;", "playerState", "(Lcom/chartboost/sdk/impl/h8;)V", "o", "", POBConstants.KEY_POSITION, "(F)V", "videoDuration", "currentInSec", "(FF)V", "j", "Lcom/chartboost/sdk/impl/m2;", "(Lcom/chartboost/sdk/impl/m2;)V", "cbUrl", "(ZLjava/lang/String;)V", ApsMetricsDataMap.APSMETRICS_FIELD_URL, "z", CampaignEx.JSON_KEY_AD_K, "m", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "", "Lcom/chartboost/sdk/impl/fb;", "verificationScriptResourceList", UnifiedMediationParams.KEY_SKIP_OFFSET, "(Ljava/util/List;Ljava/lang/Integer;)V", "Lcom/chartboost/sdk/impl/u;", "Lcom/chartboost/sdk/impl/u;", Ad.AD_TYPE, "Lcom/chartboost/sdk/impl/h2;", "Lcom/chartboost/sdk/impl/h2;", "reachability", "Lcom/chartboost/sdk/impl/f5;", "Lcom/chartboost/sdk/impl/f5;", "fileCache", "Lcom/chartboost/sdk/impl/qb;", "Lcom/chartboost/sdk/impl/qb;", "videoRepository", "Lcom/chartboost/sdk/impl/v5;", "Lcom/chartboost/sdk/impl/v5;", "impressionBuilder", "Lcom/chartboost/sdk/impl/k0;", "Lcom/chartboost/sdk/impl/k0;", "adUnitRendererShowRequest", "Lcom/chartboost/sdk/impl/r7;", "Lcom/chartboost/sdk/impl/r7;", "openMeasurementController", "Lcom/chartboost/sdk/impl/p6;", "Lcom/chartboost/sdk/impl/p6;", "viewProtocolBuilder", "Lcom/chartboost/sdk/impl/z8;", "Lcom/chartboost/sdk/impl/z8;", "rendererActivityBridge", "Lcom/chartboost/sdk/impl/g7;", "Lcom/chartboost/sdk/impl/g7;", "nativeBridgeCommand", "Lcom/chartboost/sdk/impl/aa;", "Lcom/chartboost/sdk/impl/aa;", "templateLoader", "Lcom/chartboost/sdk/Mediation;", "Lcom/chartboost/sdk/Mediation;", "F", "()Lcom/chartboost/sdk/Mediation;", "mediation", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "uiScope", "Lcom/chartboost/sdk/impl/m4;", "eventTracker", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "endpointRepository", "Lcom/chartboost/sdk/impl/i0;", "Lcom/chartboost/sdk/impl/y1;", "", "Ljava/util/Map;", "appRequests", "com/chartboost/sdk/impl/g0$c", "Lcom/chartboost/sdk/impl/g0$c;", "webViewTimeoutInterface", "<init>", "(Lcom/chartboost/sdk/impl/u;Lcom/chartboost/sdk/impl/h2;Lcom/chartboost/sdk/impl/f5;Lcom/chartboost/sdk/impl/qb;Lcom/chartboost/sdk/impl/v5;Lcom/chartboost/sdk/impl/k0;Lcom/chartboost/sdk/impl/r7;Lcom/chartboost/sdk/impl/p6;Lcom/chartboost/sdk/impl/z8;Lcom/chartboost/sdk/impl/g7;Lcom/chartboost/sdk/impl/aa;Lcom/chartboost/sdk/Mediation;Lkotlinx/coroutines/CoroutineScope;Lcom/chartboost/sdk/impl/m4;Lcom/chartboost/sdk/internal/Networking/EndpointRepository;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class g0 implements j0, j6, x5, i6, h0, m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final u adType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final h2 reachability;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final f5 fileCache;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final qb videoRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final v5 impressionBuilder;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final k0 adUnitRendererShowRequest;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final r7 openMeasurementController;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final p6 viewProtocolBuilder;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final z8 rendererActivityBridge;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final g7 nativeBridgeCommand;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final aa templateLoader;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final CoroutineScope uiScope;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final m4 eventTracker;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final EndpointRepository endpointRepository;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public i0 callback;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public y1 impression;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final Map<String, y0> appRequests;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final c webViewTimeoutInterface;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.AdUnitManager.render.AdUnitRenderer$detachBannerImpression$1$1$1", f = "AdUnitRenderer.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ ViewGroup c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ViewGroup viewGroup, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.c.removeAllViews();
            this.c.invalidate();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.AdUnitManager.render.AdUnitRenderer$showImpressionOrHandleError$1", f = "AdUnitRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ y1 c;
        public final /* synthetic */ g0 d;
        public final /* synthetic */ y0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y1 y1Var, g0 g0Var, y0 y0Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = y1Var;
            this.d = g0Var;
            this.e = y0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Unit unit;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            y1 y1Var = this.c;
            if (y1Var != null) {
                y1Var.L();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                this.d.d(this.e, CBError.b.PENDING_IMPRESSION_ERROR);
            }
            return Unit.INSTANCE;
        }
    }

    public g0(u adType, h2 reachability, f5 fileCache, qb videoRepository, v5 impressionBuilder, k0 adUnitRendererShowRequest, r7 openMeasurementController, p6 viewProtocolBuilder, z8 rendererActivityBridge, g7 nativeBridgeCommand, aa templateLoader, Mediation mediation, CoroutineScope uiScope, m4 eventTracker, EndpointRepository endpointRepository) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(reachability, "reachability");
        Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        Intrinsics.checkNotNullParameter(videoRepository, "videoRepository");
        Intrinsics.checkNotNullParameter(impressionBuilder, "impressionBuilder");
        Intrinsics.checkNotNullParameter(adUnitRendererShowRequest, "adUnitRendererShowRequest");
        Intrinsics.checkNotNullParameter(openMeasurementController, "openMeasurementController");
        Intrinsics.checkNotNullParameter(viewProtocolBuilder, "viewProtocolBuilder");
        Intrinsics.checkNotNullParameter(rendererActivityBridge, "rendererActivityBridge");
        Intrinsics.checkNotNullParameter(nativeBridgeCommand, "nativeBridgeCommand");
        Intrinsics.checkNotNullParameter(templateLoader, "templateLoader");
        Intrinsics.checkNotNullParameter(uiScope, "uiScope");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(endpointRepository, "endpointRepository");
        this.adType = adType;
        this.reachability = reachability;
        this.fileCache = fileCache;
        this.videoRepository = videoRepository;
        this.impressionBuilder = impressionBuilder;
        this.adUnitRendererShowRequest = adUnitRendererShowRequest;
        this.openMeasurementController = openMeasurementController;
        this.viewProtocolBuilder = viewProtocolBuilder;
        this.rendererActivityBridge = rendererActivityBridge;
        this.nativeBridgeCommand = nativeBridgeCommand;
        this.templateLoader = templateLoader;
        this.mediation = mediation;
        this.uiScope = uiScope;
        this.eventTracker = eventTracker;
        this.endpointRepository = endpointRepository;
        this.appRequests = new LinkedHashMap();
        this.webViewTimeoutInterface = new c();
    }

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

    /* JADX INFO: renamed from: F, reason: from getter */
    public final Mediation getMediation() {
        return this.mediation;
    }

    public final void E() {
        try {
            y1 y1Var = this.impression;
            if (y1Var != null) {
                this.openMeasurementController.e();
                ViewGroup viewGroupO = y1Var.o();
                if (viewGroupO != null) {
                    BuildersKt__Builders_commonKt.launch$default(this.uiScope, null, null, new a(viewGroupO, null), 3, null);
                }
                y1Var.R();
                this.impression = null;
                this.callback = null;
            }
        } catch (Exception e) {
            b7.b("detachBannerImpression error", e);
        }
    }

    private final String c(y0 appRequest) {
        v adUnit;
        if (appRequest == null || (adUnit = appRequest.getAdUnit()) == null) {
            return null;
        }
        return adUnit.getImpressionId();
    }

    @Override // com.chartboost.sdk.impl.i6
    public void c(m2 url) {
        Intrinsics.checkNotNullParameter(url, "url");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.b(url);
        }
    }

    public final void d(y0 appRequest) {
        k0 k0Var = this.adUnitRendererShowRequest;
        URL endPointUrl = this.endpointRepository.getEndPointUrl(this.adType.getShowEndPoint());
        v adUnit = appRequest.getAdUnit();
        k0Var.a(endPointUrl, new v9(adUnit != null ? adUnit.getAdId() : null, appRequest.getLocation(), G(), this.adType.getName(), this.mediation));
    }

    @Override // com.chartboost.sdk.impl.i6
    public void d(m2 url) {
        Intrinsics.checkNotNullParameter(url, "url");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.c(url);
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void v() {
        Unit unit;
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.b(l6.LOADED);
            if (y1Var.N()) {
                y1Var.a(y1Var.o());
            } else {
                this.rendererActivityBridge.a(this);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.b("Cannot display missing impression onImpressionReadyToBeDisplayed", null, 2, null);
        }
    }

    @Override // com.chartboost.sdk.impl.h0
    public void y() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.g();
        }
    }

    @Override // com.chartboost.sdk.impl.h0
    public void A() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.c();
        }
    }

    @Override // com.chartboost.sdk.impl.h0
    public void s() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.f();
        }
    }

    @Override // com.chartboost.sdk.impl.h0
    public void q() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.l();
        }
        this.nativeBridgeCommand.a((n5) null);
        this.nativeBridgeCommand.a();
    }

    @Override // com.chartboost.sdk.impl.j0
    public void p() {
        this.rendererActivityBridge.b();
    }

    public final int G() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            return y1Var.z();
        }
        return -1;
    }

    @Override // com.chartboost.sdk.impl.j6
    public void r() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.R();
        }
        this.impression = null;
        this.callback = null;
    }

    @Override // com.chartboost.sdk.impl.x5
    public void b() {
        Unit unit;
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.G();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Missing impression on impression click success callback ", (Throwable) null, 2, (Object) null);
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void b(String impressionId) {
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        a(ma.b.SUCCESS, "");
        i0 i0Var = this.callback;
        if (i0Var != null) {
            i0Var.b(impressionId);
        }
    }

    @Override // com.chartboost.sdk.impl.x5
    public void B() {
        y1 y1Var = this.impression;
        if ((y1Var != null ? y1Var.getState() : null) != l6.DISPLAYED || Intrinsics.areEqual(this.adType, u.a.g)) {
            return;
        }
        this.rendererActivityBridge.b();
    }

    public boolean H() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            return y1Var.getIsVisible();
        }
        return false;
    }

    @Override // com.chartboost.sdk.impl.j6
    public void h() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.d();
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void a(int forceOrientation, boolean allowOrientationChange) {
        this.rendererActivityBridge.a(forceOrientation, allowOrientationChange);
    }

    @Override // com.chartboost.sdk.impl.j6
    public void e() {
        b7.a("DISMISS_MISSING event was successfully removed upon dismiss callback", (Throwable) null, 2, (Object) null);
        clearFromStorage((ka) new j4(ma.i.DISMISS_MISSING, "", "", "", null, 16, null));
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.e();
        }
    }

    @Override // com.chartboost.sdk.impl.x5
    public void a(String url, CBError.a error) {
        Unit unit;
        Intrinsics.checkNotNullParameter(error, "error");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(url, error);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Missing impression on impression click failure callback ", (Throwable) null, 2, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/chartboost/sdk/impl/g0$c", "Lcom/chartboost/sdk/impl/yb;", "", "a", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c implements yb {
        public c() {
        }

        @Override // com.chartboost.sdk.impl.yb
        public void a() {
            y1 y1Var = g0.this.impression;
            if (y1Var != null) {
                y1Var.b(CBError.b.WEB_VIEW_PAGE_LOAD_TIMEOUT);
            }
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void D() {
        this.rendererActivityBridge.b();
    }

    @Override // com.chartboost.sdk.impl.i6
    public String l() {
        String strR;
        y1 y1Var = this.impression;
        return (y1Var == null || (strR = y1Var.r()) == null) ? "" : strR;
    }

    @Override // com.chartboost.sdk.impl.i6
    public String i() {
        String strW;
        y1 y1Var = this.impression;
        return (y1Var == null || (strW = y1Var.w()) == null) ? "" : strW;
    }

    @Override // com.chartboost.sdk.impl.i6
    public String w() {
        String strY;
        y1 y1Var = this.impression;
        return (y1Var == null || (strY = y1Var.y()) == null) ? "" : strY;
    }

    @Override // com.chartboost.sdk.impl.i6
    public String C() {
        String strU;
        y1 y1Var = this.impression;
        return (y1Var == null || (strU = y1Var.u()) == null) ? "" : strU;
    }

    @Override // com.chartboost.sdk.impl.i6
    public String n() {
        String strV;
        y1 y1Var = this.impression;
        return (y1Var == null || (strV = y1Var.v()) == null) ? "" : strV;
    }

    @Override // com.chartboost.sdk.impl.i6
    public String x() {
        String strX;
        y1 y1Var = this.impression;
        return (y1Var == null || (strX = y1Var.x()) == null) ? "" : strX;
    }

    @Override // com.chartboost.sdk.impl.i6
    public void o() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.O();
        }
    }

    public /* synthetic */ g0(u uVar, h2 h2Var, f5 f5Var, qb qbVar, v5 v5Var, k0 k0Var, r7 r7Var, p6 p6Var, z8 z8Var, g7 g7Var, aa aaVar, Mediation mediation, CoroutineScope coroutineScope, m4 m4Var, EndpointRepository endpointRepository, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, h2Var, f5Var, qbVar, v5Var, k0Var, r7Var, p6Var, z8Var, g7Var, aaVar, mediation, (i & 4096) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope, m4Var, endpointRepository);
    }

    @Override // com.chartboost.sdk.impl.i6
    public void g() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.I();
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void j() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.C();
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void u() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.B();
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void z() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.H();
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void k() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.K();
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void m() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.J();
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void t() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.p();
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void f() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.F();
        }
    }

    public final void h(y0 appRequest) {
        if (appRequest.getIsTrackedShow()) {
            return;
        }
        appRequest.b(true);
        track((ka) new r6(ma.i.START, "", this.adType.getName(), appRequest.getLocation(), null, null, 48, null));
    }

    private final void e(y0 appRequest) {
        appRequest.b(false);
        appRequest.a((v) null);
    }

    @Override // com.chartboost.sdk.impl.i6
    public void e(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        b7.b("WebView warning occurred closing the webview " + msg, null, 2, null);
    }

    @Override // com.chartboost.sdk.impl.j0
    public void b(y0 appRequest) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        e(appRequest);
        this.openMeasurementController.g();
    }

    @Override // com.chartboost.sdk.impl.i6
    public CBError.b c(String str) {
        return i6.a.a(this, str);
    }

    public final void g(String impressionId) {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(true);
        }
        i0 i0Var = this.callback;
        if (i0Var != null) {
            i0Var.c(impressionId);
        }
        this.openMeasurementController.i();
        y0 y0Var = (y0) TypeIntrinsics.asMutableMap(this.appRequests).remove(impressionId);
        if (y0Var != null) {
            i0 i0Var2 = this.callback;
            if (i0Var2 != null) {
                i0Var2.e(impressionId);
            }
            d(y0Var);
        }
    }

    @Override // com.chartboost.sdk.impl.h0
    public void a(CBError.b error) {
        Intrinsics.checkNotNullParameter(error, "error");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(error);
        }
    }

    public final void f(String location) {
        if (Intrinsics.areEqual(this.adType, u.a.g)) {
            return;
        }
        persist((ka) new r6(ma.i.DISMISS_MISSING, "dismiss_missing due to ad not finished", this.adType.getName(), location, this.mediation, null, 32, null));
    }

    private final void c(y0 appRequest, CBError.b error) {
        Unit unit;
        i0 i0Var = this.callback;
        if (i0Var != null) {
            i0Var.a(c(appRequest), error);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("Missing AdUnitRendererAdCallback while sending onShowFailure with error: " + error, (Throwable) null, 2, (Object) null);
        }
    }

    public final void g(final y0 appRequest) {
        String str;
        String videoFilename;
        v adUnit = appRequest.getAdUnit();
        if (adUnit != null && adUnit.getIsPrecacheVideoAd()) {
            qb qbVar = this.videoRepository;
            v adUnit2 = appRequest.getAdUnit();
            String str2 = "";
            if (adUnit2 == null || (str = adUnit2.getIo.bidmachine.unified.UnifiedMediationParams.KEY_VIDEO_URL java.lang.String()) == null) {
                str = "";
            }
            v adUnit3 = appRequest.getAdUnit();
            if (adUnit3 != null && (videoFilename = adUnit3.getVideoFilename()) != null) {
                str2 = videoFilename;
            }
            qbVar.a(str, str2, true, new l0() { // from class: com.chartboost.sdk.impl.g0$$ExternalSyntheticLambda0
                @Override // com.chartboost.sdk.impl.l0
                public final void a(String str3) {
                    g0.a(this.f$0, appRequest, str3);
                }
            });
            return;
        }
        f(appRequest);
    }

    @Override // com.chartboost.sdk.impl.h0
    public void d() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.Q();
        }
    }

    public final void f(y0 appRequest) {
        if (this.impression != null && appRequest.getBannerData() == null) {
            b7.b("Fullscreen impression is currently loading.", null, 2, null);
            return;
        }
        if (!this.reachability.e()) {
            c(appRequest, CBError.b.INTERNET_UNAVAILABLE_AT_SHOW);
            return;
        }
        i0 i0Var = this.callback;
        if (i0Var != null) {
            i0Var.d(c(appRequest));
        }
        v5 v5Var = this.impressionBuilder;
        w bannerData = appRequest.getBannerData();
        h6 h6VarA = v5Var.a(appRequest, this, bannerData != null ? bannerData.getBannerView() : null, this, this, this.viewProtocolBuilder, this, this.webViewTimeoutInterface, this.nativeBridgeCommand, this.templateLoader);
        this.impression = h6VarA.getImpression();
        a(appRequest, h6VarA.getImpression(), h6VarA.getError());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    @Override // com.chartboost.sdk.impl.h0
    public void a(CBImpressionActivity activity) {
        Unit unit;
        Intrinsics.checkNotNullParameter(activity, "activity");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(y1Var.getState(), activity);
            vb vbVarA = y1Var.A();
            if (vbVarA != null) {
                this.rendererActivityBridge.a(vbVarA);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.b("Cannot display missing impression onActivityIsReadyToDisplay", null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(y0 appRequest, CBError.b error) {
        c(appRequest, error);
        if (error == CBError.b.NO_AD_FOUND) {
            return;
        }
        StringBuilder sbAppend = new StringBuilder("reportError: adTypeTraits: ").append(this.adType.getName()).append(" reason: cache  format: web error: ").append(error).append(" adId: ");
        v adUnit = appRequest.getAdUnit();
        b7.b(sbAppend.append(adUnit != null ? adUnit.getAdId() : null).append(" appRequest.location: ").append(appRequest.getLocation()).toString(), null, 2, null);
    }

    public final void b(y0 appRequest, CBError.b error) {
        d(appRequest, error);
        if (error != CBError.b.IMPRESSION_ALREADY_VISIBLE) {
            e(appRequest);
        }
        this.openMeasurementController.g();
    }

    @Override // com.chartboost.sdk.impl.i6
    public void b(m2 cbUrl) {
        Intrinsics.checkNotNullParameter(cbUrl, "cbUrl");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.d(cbUrl);
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void d(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(event);
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void a(String impressionId, String url, CBError.a error) {
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(error, "error");
        a(ma.b.FAILURE, error.name());
        i0 i0Var = this.callback;
        if (i0Var != null) {
            i0Var.a(impressionId, url, error);
        }
    }

    public void c(boolean showProcessed) {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.b(showProcessed);
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void a(String impressionId) {
        i0 i0Var = this.callback;
        if (i0Var != null) {
            i0Var.a(impressionId);
        }
        this.openMeasurementController.g();
    }

    @Override // com.chartboost.sdk.impl.j0
    public void a(y0 appRequest, CBError.b error) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(error, "error");
        b(appRequest, error);
        track((ka) new r3(ma.i.UNEXPECTED_DISMISS_ERROR, "", this.adType.getName(), appRequest.getLocation(), this.mediation, null, 32, null));
        this.rendererActivityBridge.b();
    }

    @Override // com.chartboost.sdk.impl.i6
    public void c() {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.P();
        }
    }

    @Override // com.chartboost.sdk.impl.x5
    public void b(boolean close) {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.f(close);
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void b(float pos) {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(pos);
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void a(String impressionId, int reward) {
        i0 i0Var = this.callback;
        if (i0Var != null) {
            i0Var.a(impressionId, reward);
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void a(y0 appRequest) {
        Unit unit;
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        c(true);
        String strC = c(appRequest);
        if (strC != null) {
            this.appRequests.put(strC, appRequest);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.b("Unable to store app request because impression ID is missing. Impression tracking will not work.", null, 2, null);
        }
        f(appRequest.getLocation());
        if (H()) {
            g(strC);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0046  */
    @Override // com.chartboost.sdk.impl.j0
    public void a(Context context) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        final y1 y1Var = this.impression;
        if (y1Var == null) {
            unit = null;
        } else if (!this.openMeasurementController.h()) {
            y1Var.d(true);
            b7.a("Cannot create visibility tracker due to the OM SDK being disabled!", (Throwable) null, 2, (Object) null);
            return;
        } else {
            if (y1Var.E()) {
                b7.b("Cannot create VisibilityTracker due to missing view!", null, 2, null);
                return;
            }
            vb vbVarA = y1Var.A();
            if (vbVarA != null) {
                r7 r7Var = this.openMeasurementController;
                View rootView = vbVarA.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                r7Var.a(context, vbVarA, rootView, new wb.b() { // from class: com.chartboost.sdk.impl.g0$$ExternalSyntheticLambda1
                    @Override // com.chartboost.sdk.impl.wb.b
                    public final void a() {
                        g0.a(this.f$0, y1Var);
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
        }
        if (unit == null) {
            b7.b("Missing impression onImpressionViewCreated", null, 2, null);
        }
    }

    public static final void a(g0 this$0, y1 it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.a(it);
    }

    @Override // com.chartboost.sdk.impl.i6
    public void a(m2 url) {
        Intrinsics.checkNotNullParameter(url, "url");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(url);
        }
    }

    public final void a(y1 impression) {
        b7.b("Visibility check success!", null, 2, null);
        impression.d(true);
        if (!impression.getIsShowProcessed() || impression.getWasImpressionSignaled()) {
            return;
        }
        g(impression.q());
    }

    @Override // com.chartboost.sdk.impl.i6
    public void a(List<fb> verificationScriptResourceList, Integer skipOffset) {
        Intrinsics.checkNotNullParameter(verificationScriptResourceList, "verificationScriptResourceList");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(verificationScriptResourceList, skipOffset);
        }
    }

    public final void a(y0 appRequest, i0 callback) {
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        if (!this.reachability.e()) {
            c(appRequest, CBError.b.INTERNET_UNAVAILABLE_AT_SHOW);
            return;
        }
        v adUnit = appRequest.getAdUnit();
        if (adUnit == null) {
            d(appRequest, CBError.b.NO_AD_FOUND);
        } else if (!this.fileCache.a(adUnit).booleanValue()) {
            d(appRequest, CBError.b.ASSET_MISSING);
        } else {
            h(appRequest);
            g(appRequest);
        }
    }

    @Override // com.chartboost.sdk.impl.j0
    public void a() {
        this.rendererActivityBridge.a();
    }

    @Override // com.chartboost.sdk.impl.i6
    public void a(float videoDuration, float currentInSec) {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(videoDuration, currentInSec);
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void a(db vastVideoEvent) {
        Intrinsics.checkNotNullParameter(vastVideoEvent, "vastVideoEvent");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(vastVideoEvent);
        }
    }

    @Override // com.chartboost.sdk.impl.x5
    public void a(boolean click) {
        y1 y1Var = this.impression;
        if (y1Var == null) {
            return;
        }
        y1Var.e(click);
    }

    @Override // com.chartboost.sdk.impl.j6
    public void a(l6 state) {
        Intrinsics.checkNotNullParameter(state, "state");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.b(state);
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void a(boolean allowOrientationChange, String forceOrientation) {
        Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(allowOrientationChange, forceOrientation);
        }
    }

    @Override // com.chartboost.sdk.impl.i6
    public void a(float pos) {
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.b(pos);
        }
    }

    public final void a(y0 appRequest, y1 impression, CBError.b error) {
        if (error == null) {
            BuildersKt__Builders_commonKt.launch$default(this.uiScope, null, null, new b(impression, this, appRequest, null), 3, null);
        } else {
            d(appRequest, error);
            e(appRequest);
        }
    }

    public static final void a(g0 this$0, y0 appRequest, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appRequest, "$appRequest");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f(appRequest);
    }

    public final void a(ma trackName, String msg) {
        String strT;
        String name = this.adType.getName();
        y1 y1Var = this.impression;
        if (y1Var == null || (strT = y1Var.t()) == null) {
            strT = "No location";
        }
        track((ka) new r6(trackName, msg, name, strT, this.mediation, null, 32, null));
    }

    @Override // com.chartboost.sdk.impl.i6
    public void a(h8 playerState) {
        Intrinsics.checkNotNullParameter(playerState, "playerState");
        y1 y1Var = this.impression;
        if (y1Var != null) {
            y1Var.a(playerState);
        }
    }
}
