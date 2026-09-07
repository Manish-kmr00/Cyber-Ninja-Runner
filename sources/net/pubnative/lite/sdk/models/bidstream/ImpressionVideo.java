package net.pubnative.lite.sdk.models.bidstream;

import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class ImpressionVideo extends Signal {

    @BidParam(name = POBConstants.KEY_VIDEO_BOXING_ALLOWED)
    public final int boxingallowed;

    @BidParam(name = "clktype")
    public final int clktype;

    @BidParam(name = "delivery")
    public final List<Integer> delivery;

    @BidParam(name = POBConstants.KEY_VIDEO_LINEARITY)
    public final int linearity;

    @BidParam(name = "videomimes")
    public final List<String> mimes;

    @BidParam(name = "mraidendcard")
    public final boolean mraidendcard;

    @BidParam(name = "placement")
    public final Integer placement;

    @BidParam(name = POBConstants.KEY_VIDEO_PLAYBACK_END)
    public final int playbackend;

    @BidParam(name = "playbackmethod")
    public final List<Integer> playbackmethod;

    @BidParam(name = POBConstants.KEY_VIDEO_PLCMT)
    public final Integer plcmt;

    @BidParam(name = "videopos")
    public final int pos;

    public ImpressionVideo(Integer num, Integer num2, int i, List<Integer> list) {
        this.pos = i;
        this.placement = num;
        this.plcmt = num2;
        this.playbackmethod = list;
        ArrayList arrayList = new ArrayList();
        this.mimes = arrayList;
        arrayList.add("video/mp4");
        arrayList.add("video/webm");
        arrayList.add("video/3gpp");
        arrayList.add("video/3gpp2");
        arrayList.add("video/x-m4v");
        this.boxingallowed = 0;
        this.linearity = 1;
        this.playbackend = 1;
        this.mraidendcard = true;
        this.clktype = 3;
        ArrayList arrayList2 = new ArrayList();
        this.delivery = arrayList2;
        arrayList2.add(3);
    }
}
