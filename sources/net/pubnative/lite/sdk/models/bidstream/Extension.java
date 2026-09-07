package net.pubnative.lite.sdk.models.bidstream;

import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class Extension extends Signal {

    @BidParam(name = "airplane")
    public Integer airplane;

    @BidParam(name = "batterylevel")
    public Integer batterylevel;

    @BidParam(name = "batterysaver")
    public Integer batterysaver;

    @BidParam(name = "charging")
    public Integer charging;

    @BidParam(name = "darkmode")
    public Integer darkmode;

    @BidParam(name = "diskspace")
    public Integer diskspace;

    @BidParam(name = "dnd")
    public Integer dnd;

    @BidParam(name = "headset")
    public Integer headset;

    @BidParam(name = "inputlanguage")
    public List<String> inputlanguages;

    @BidParam(name = "ringmute")
    public Integer ringmute;

    @BidParam(name = "totaldisk")
    public Integer totaldisk;

    public Extension() {
    }

    public Extension(List<String> list, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10) {
        this.inputlanguages = list;
        this.charging = num;
        this.batterylevel = num2;
        this.batterysaver = num3;
        this.diskspace = num4;
        this.totaldisk = num5;
        this.darkmode = num6;
        this.dnd = num7;
        this.airplane = num8;
        this.headset = num9;
        this.ringmute = num10;
    }
}
