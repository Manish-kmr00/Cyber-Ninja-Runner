package net.pubnative.lite.sdk.models.bidstream;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class ImpressionBanner extends Signal {

    @BidParam(name = "expdir")
    public final List<Integer> expdir;

    @BidParam(name = "mimes")
    public final List<String> mimes;

    @BidParam(name = POBConstants.KEY_POSITION)
    public final int pos;

    @BidParam(name = "topframe")
    public final int topframe;

    public ImpressionBanner() {
        this(0);
    }

    public ImpressionBanner(int i) {
        this(i, new ArrayList());
    }

    public ImpressionBanner(int i, List<Integer> list) {
        this.topframe = 1;
        this.pos = i;
        this.expdir = list;
        ArrayList arrayList = new ArrayList();
        this.mimes = arrayList;
        arrayList.add(POBCommonConstants.CONTENT_TYPE_HTML);
        arrayList.add(POBCommonConstants.CONTENT_TYPE_JAVASCRIPT);
    }
}
