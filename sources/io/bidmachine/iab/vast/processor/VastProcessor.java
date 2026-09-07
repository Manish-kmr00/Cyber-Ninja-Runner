package io.bidmachine.iab.vast.processor;

import android.text.TextUtils;
import android.util.Pair;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.tags.AdContentTag;
import io.bidmachine.iab.vast.tags.AdTag;
import io.bidmachine.iab.vast.tags.AdVerificationsExtensionTag;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.CompanionAdsCreativeTag;
import io.bidmachine.iab.vast.tags.CompanionTag;
import io.bidmachine.iab.vast.tags.CreativeContentTag;
import io.bidmachine.iab.vast.tags.CreativeTag;
import io.bidmachine.iab.vast.tags.ExtensionTag;
import io.bidmachine.iab.vast.tags.InLineAdTag;
import io.bidmachine.iab.vast.tags.LinearCreativeTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import io.bidmachine.iab.vast.tags.VastParser;
import io.bidmachine.iab.vast.tags.VastTag;
import io.bidmachine.iab.vast.tags.VideoClicksTag;
import io.bidmachine.iab.vast.tags.WrapperAdTag;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes13.dex */
public class VastProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VastRequest f12311a;
    private final VastMediaPicker b;
    final int c;
    final Stack d;
    private int e;

    public VastProcessor(VastRequest vastRequest, VastMediaPicker<MediaFileTag> mediaPicker) {
        this(vastRequest, mediaPicker, 5);
    }

    private Pair a(InLineAdTag inLineAdTag) {
        LinearCreativeTag linearCreativeTag;
        List<MediaFileTag> mediaFileTagList;
        List<CreativeTag> creativeTagList = inLineAdTag.getCreativeTagList();
        if (creativeTagList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CreativeTag creativeTag : creativeTagList) {
            if (creativeTag != null) {
                CreativeContentTag creativeContentTag = creativeTag.getCreativeContentTag();
                if ((creativeContentTag instanceof LinearCreativeTag) && (mediaFileTagList = (linearCreativeTag = (LinearCreativeTag) creativeContentTag).getMediaFileTagList()) != null && !mediaFileTagList.isEmpty()) {
                    Iterator<MediaFileTag> it = mediaFileTagList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Pair(linearCreativeTag, it.next()));
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Pair pairPickVideo = this.b.pickVideo(arrayList);
        return pairPickVideo != null ? pairPickVideo : new Pair(null, null);
    }

    private boolean b() {
        return this.e >= this.c;
    }

    public VastProcessorResult process(String xmlData) {
        VastSpecError vastSpecError;
        VastLog.d("VastProcessor", "process", new Object[0]);
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        try {
            VastTag vast = VastParser.parseVast(xmlData);
            if (vast != null && vast.hasAd()) {
                return a(null, vast, new a());
            }
            vastSpecError = VastSpecError.XML_VALIDATE;
            vastProcessorResult.a(vastSpecError);
            return vastProcessorResult;
        } catch (Exception unused) {
            vastSpecError = VastSpecError.XML_PARSING;
        }
    }

    VastProcessor(VastRequest vastRequest, VastMediaPicker vastMediaPicker, int i) {
        this.e = 0;
        this.f12311a = vastRequest;
        this.b = vastMediaPicker;
        this.c = i;
        this.d = new Stack();
    }

    private ArrayList a(AdContentTag adContentTag) {
        ArrayList arrayList = new ArrayList();
        List<CreativeTag> creativeTagList = adContentTag.getCreativeTagList();
        if (creativeTagList == null) {
            return arrayList;
        }
        for (CreativeTag creativeTag : creativeTagList) {
            if (creativeTag != null) {
                CreativeContentTag creativeContentTag = creativeTag.getCreativeContentTag();
                if (creativeContentTag instanceof CompanionAdsCreativeTag) {
                    arrayList.addAll(((CompanionAdsCreativeTag) creativeContentTag).getCompanionTagList());
                }
            }
        }
        return arrayList;
    }

    void b(AdContentTag adContentTag) {
        if (this.d.empty()) {
            return;
        }
        int iSearch = this.d.search(adContentTag);
        for (int i = 0; i < iSearch; i++) {
            this.d.pop();
        }
    }

    private ArrayList a() {
        ArrayList arrayList = new ArrayList();
        if (this.d.empty()) {
            return arrayList;
        }
        for (AdContentTag adContentTag : this.d) {
            if (adContentTag != null && adContentTag.getErrorUrlList() != null) {
                arrayList.addAll(adContentTag.getErrorUrlList());
            }
        }
        return arrayList;
    }

    private VastProcessorResult b(InLineAdTag inLineAdTag) {
        VastSpecError vastSpecError;
        this.d.push(inLineAdTag);
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        Pair pairA = a(inLineAdTag);
        if (pairA != null) {
            if (pairA.first == null && pairA.second == null) {
                vastSpecError = VastSpecError.BAD_FILE;
            } else {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<String> arrayList3 = new ArrayList<>();
                EnumMap enumMap = new EnumMap(TrackingEvent.class);
                ArrayList arrayList4 = new ArrayList();
                AppodealExtensionTag appodealExtensionTag = null;
                if (!this.d.empty()) {
                    for (AdContentTag adContentTag : this.d) {
                        if (adContentTag != null) {
                            if (adContentTag.getImpressionUrlList() != null) {
                                arrayList.addAll(adContentTag.getImpressionUrlList());
                            }
                            List<CreativeTag> creativeTagList = adContentTag.getCreativeTagList();
                            if (creativeTagList != null) {
                                for (CreativeTag creativeTag : creativeTagList) {
                                    if (creativeTag != null) {
                                        CreativeContentTag creativeContentTag = creativeTag.getCreativeContentTag();
                                        if (creativeContentTag instanceof LinearCreativeTag) {
                                            LinearCreativeTag linearCreativeTag = (LinearCreativeTag) creativeContentTag;
                                            VideoClicksTag videoClicksTag = linearCreativeTag.getVideoClicksTag();
                                            if (videoClicksTag != null && videoClicksTag.getClickTrackingUrlList() != null) {
                                                arrayList2.addAll(videoClicksTag.getClickTrackingUrlList());
                                            }
                                            a(enumMap, linearCreativeTag.getTrackingEventListMap());
                                        } else if (creativeContentTag instanceof CompanionAdsCreativeTag) {
                                            a(arrayList3, (CompanionAdsCreativeTag) creativeContentTag);
                                        }
                                    }
                                }
                            }
                            List<ExtensionTag> extensionTagList = adContentTag.getExtensionTagList();
                            if (extensionTagList != null) {
                                for (ExtensionTag extensionTag : extensionTagList) {
                                    if (extensionTag instanceof AppodealExtensionTag) {
                                        if (appodealExtensionTag == null) {
                                            appodealExtensionTag = (AppodealExtensionTag) extensionTag;
                                        }
                                    } else if (extensionTag instanceof AdVerificationsExtensionTag) {
                                        arrayList4.add((AdVerificationsExtensionTag) extensionTag);
                                    }
                                }
                            }
                        }
                    }
                }
                VastAd vastAd = new VastAd((LinearCreativeTag) pairA.first, (MediaFileTag) pairA.second);
                vastAd.d(arrayList);
                vastAd.c(a());
                vastAd.a(arrayList2);
                vastAd.setWrapperCompanionClickTrackingUrlList(arrayList3);
                vastAd.a(enumMap);
                vastAd.b(a((AdContentTag) inLineAdTag));
                vastAd.a(appodealExtensionTag);
                vastAd.setAdVerificationsExtensionList(arrayList4);
                vastProcessorResult.a(vastAd);
            }
            return vastProcessorResult;
        }
        vastSpecError = VastSpecError.XML_VALIDATE;
        vastProcessorResult.a(inLineAdTag, vastSpecError);
        return vastProcessorResult;
    }

    private VastProcessorResult a(AdContentTag adContentTag, VastTag vastTag, a aVar) {
        VastSpecError vastSpecError;
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        for (int i = 0; i < vastTag.getAdTagList().size(); i++) {
            AdTag adTag = vastTag.getAdTagList().get(i);
            if (adTag != null && adTag.getAdContentTag() != null) {
                AdContentTag adContentTag2 = adTag.getAdContentTag();
                if (adContentTag2 instanceof InLineAdTag) {
                    VastProcessorResult vastProcessorResultB = b((InLineAdTag) adContentTag2);
                    if (vastProcessorResultB.hasVastAd()) {
                        return vastProcessorResultB;
                    }
                    a(vastProcessorResultB.a());
                    if (adContentTag == null) {
                        vastProcessorResult.a(vastProcessorResultB.getVastSpecError());
                    } else if (vastProcessorResultB.b()) {
                        VastSpecError vastSpecError2 = vastProcessorResultB.getVastSpecError();
                        if (vastSpecError2 == null) {
                            vastSpecError2 = VastSpecError.UNKNOWN;
                        }
                        vastProcessorResult.a(adContentTag, vastSpecError2);
                    }
                } else if ((adContentTag2 instanceof WrapperAdTag) && aVar.c()) {
                    VastProcessorResult vastProcessorResultA = a((WrapperAdTag) adContentTag2);
                    if (vastProcessorResultA.hasVastAd()) {
                        return vastProcessorResultA;
                    }
                    a(vastProcessorResultA.a());
                    if (adContentTag != null) {
                        if (vastProcessorResultA.b()) {
                            vastSpecError = vastProcessorResultA.getVastSpecError();
                            if (vastSpecError == null) {
                                vastSpecError = VastSpecError.UNKNOWN;
                            }
                        } else {
                            vastSpecError = VastSpecError.WRAPPER_RESPONSE_NO_AD;
                        }
                        vastProcessorResult.a(adContentTag, vastSpecError);
                    } else {
                        vastProcessorResult.a(VastSpecError.WRAPPER_RESPONSE_NO_AD);
                    }
                    if (i == 0 && !aVar.b()) {
                        return vastProcessorResult;
                    }
                }
                b(adContentTag2);
            }
        }
        if (vastProcessorResult.getVastSpecError() == null && adContentTag != null) {
            vastProcessorResult.a(adContentTag, VastSpecError.WRAPPER_RESPONSE_NO_AD);
        }
        return vastProcessorResult;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    VastProcessorResult a(WrapperAdTag wrapperAdTag) {
        VastSpecError vastSpecError;
        VastProcessorResult vastProcessorResult = new VastProcessorResult();
        if (b()) {
            VastLog.e("VastProcessor", "VAST wrapping exceeded max limit of %d", Integer.valueOf(this.c));
            vastSpecError = VastSpecError.EXCEEDED_WRAPPER_LIMIT;
        } else {
            this.e++;
            this.d.push(wrapperAdTag);
            if (!TextUtils.isEmpty(wrapperAdTag.getVastAdTagUri())) {
                a aVar = new a(wrapperAdTag);
                InputStream inputStream = null;
                try {
                    try {
                        try {
                            URLConnection uRLConnectionOpenConnection = new URL(wrapperAdTag.getVastAdTagUri()).openConnection();
                            int iHttpUrlConnectionGetResponseCode = BidMachineNetworkBridge.httpUrlConnectionGetResponseCode((HttpURLConnection) uRLConnectionOpenConnection);
                            if (iHttpUrlConnectionGetResponseCode != 200) {
                                if (iHttpUrlConnectionGetResponseCode != 204) {
                                    vastProcessorResult.a(wrapperAdTag, VastSpecError.BAD_URI);
                                    return vastProcessorResult;
                                }
                                VastLog.e("VastProcessor", "Wrapper response code: 204", new Object[0]);
                                vastProcessorResult.a(wrapperAdTag, VastSpecError.WRAPPER_RESPONSE_NO_AD);
                                return vastProcessorResult;
                            }
                            InputStream inputStreamUrlConnectionGetInputStream = BidMachineNetworkBridge.urlConnectionGetInputStream(uRLConnectionOpenConnection);
                            VastTag vast = VastParser.parseVast(inputStreamUrlConnectionGetInputStream);
                            if (vast == null) {
                                VastLog.e("VastProcessor", "Invalid Vast", new Object[0]);
                                vastProcessorResult.a(wrapperAdTag, VastSpecError.XML_VALIDATE);
                                if (inputStreamUrlConnectionGetInputStream != null) {
                                    try {
                                        inputStreamUrlConnectionGetInputStream.close();
                                    } catch (Exception e) {
                                        VastLog.e("VastProcessor", e);
                                    }
                                }
                                return vastProcessorResult;
                            }
                            if (!vast.hasAd()) {
                                VastLog.e("VastProcessor", "Vast has no ad", new Object[0]);
                                vastProcessorResult.a(wrapperAdTag, VastSpecError.WRAPPER_RESPONSE_NO_AD);
                                if (inputStreamUrlConnectionGetInputStream != null) {
                                    try {
                                        inputStreamUrlConnectionGetInputStream.close();
                                    } catch (Exception e2) {
                                        VastLog.e("VastProcessor", e2);
                                    }
                                }
                                return vastProcessorResult;
                            }
                            if (vast.getAdTagList().size() > 1 && !aVar.a()) {
                                vastProcessorResult.a(wrapperAdTag, VastSpecError.GENERAL_WRAPPER);
                                if (inputStreamUrlConnectionGetInputStream != null) {
                                    try {
                                        inputStreamUrlConnectionGetInputStream.close();
                                    } catch (Exception e3) {
                                        VastLog.e("VastProcessor", e3);
                                    }
                                }
                                return vastProcessorResult;
                            }
                            VastProcessorResult vastProcessorResultA = a(wrapperAdTag, vast, aVar);
                            vastProcessorResultA.a(false);
                            if (inputStreamUrlConnectionGetInputStream != null) {
                                try {
                                    inputStreamUrlConnectionGetInputStream.close();
                                } catch (Exception e4) {
                                    VastLog.e("VastProcessor", e4);
                                }
                            }
                            return vastProcessorResultA;
                        } catch (MalformedURLException e5) {
                            VastLog.e("VastProcessor", e5);
                            vastProcessorResult.a(wrapperAdTag, VastSpecError.BAD_URI);
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (Exception e6) {
                                    VastLog.e("VastProcessor", e6);
                                }
                            }
                            return vastProcessorResult;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            VastLog.e("VastProcessor", e);
                            vastProcessorResult.a(wrapperAdTag, VastSpecError.BAD_URI);
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (Exception e8) {
                                    VastLog.e("VastProcessor", e8);
                                }
                            }
                            return vastProcessorResult;
                        } catch (SSLException e9) {
                            e = e9;
                            VastLog.e("VastProcessor", e);
                            vastProcessorResult.a(wrapperAdTag, VastSpecError.BAD_URI);
                            if (0 != 0) {
                                inputStream.close();
                            }
                            return vastProcessorResult;
                        } catch (Exception e10) {
                            VastLog.e("VastProcessor", e10);
                            vastProcessorResult.a(wrapperAdTag, VastSpecError.XML_PARSING);
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (Exception e11) {
                                    VastLog.e("VastProcessor", e11);
                                }
                            }
                            return vastProcessorResult;
                        }
                    } catch (UnknownHostException e12) {
                        e = e12;
                        VastLog.e("VastProcessor", e);
                        vastProcessorResult.a(wrapperAdTag, VastSpecError.BAD_URI);
                        if (0 != 0) {
                            inputStream.close();
                        }
                        return vastProcessorResult;
                    } catch (ConnectTimeoutException e13) {
                        e = e13;
                        VastLog.e("VastProcessor", e);
                        vastProcessorResult.a(wrapperAdTag, VastSpecError.BAD_URI);
                        if (0 != 0) {
                            inputStream.close();
                        }
                        return vastProcessorResult;
                    } catch (IOException e14) {
                        VastLog.e("VastProcessor", e14);
                        vastProcessorResult.a(wrapperAdTag, VastSpecError.BAD_URI);
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                                VastLog.e("VastProcessor", e15);
                            }
                        }
                        return vastProcessorResult;
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                            VastLog.e("VastProcessor", e16);
                        }
                    }
                    throw th;
                }
            }
            VastLog.e("VastProcessor", "VASTAdTagURI is null or empty", new Object[0]);
            vastSpecError = VastSpecError.BAD_URI;
        }
        vastProcessorResult.a(wrapperAdTag, vastSpecError);
        return vastProcessorResult;
    }

    private void a(Map map, Map map2) {
        if (map2 == null || map2.isEmpty()) {
            return;
        }
        for (Map.Entry entry : map2.entrySet()) {
            TrackingEvent trackingEvent = (TrackingEvent) entry.getKey();
            List arrayList = (List) map.get(trackingEvent);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(trackingEvent, arrayList);
            }
            arrayList.addAll((Collection) entry.getValue());
        }
    }

    private void a(List list, CompanionAdsCreativeTag companionAdsCreativeTag) {
        List<String> companionClickTrackingList;
        for (CompanionTag companionTag : companionAdsCreativeTag.getCompanionTagList()) {
            if (!companionTag.hasCreative() && (companionClickTrackingList = companionTag.getCompanionClickTrackingList()) != null) {
                list.addAll(companionClickTrackingList);
            }
        }
    }

    void a(List list) {
        this.f12311a.fireErrorUrls(list, null);
    }
}
