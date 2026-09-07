package net.pubnative.lite.sdk.models.bidstream;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;

/* JADX INFO: loaded from: classes13.dex */
public class DeviceExtension extends JsonModel {

    @BindField
    public Integer airplane;

    @BindField
    public Integer batterylevel;

    @BindField
    public Integer batterysaver;

    @BindField
    public Integer charging;

    @BindField
    public Integer darkmode;

    @BindField
    public Integer diskspace;

    @BindField
    public Integer dnd;

    @BindField
    public Integer headset;

    @BindField
    public List<String> inputlanguages;

    @BindField
    public Integer ringmute;

    @BindField
    public Integer totaldisk;

    public DeviceExtension(List<String> list, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10) {
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
