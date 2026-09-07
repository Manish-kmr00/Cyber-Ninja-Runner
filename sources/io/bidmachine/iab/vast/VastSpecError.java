package io.bidmachine.iab.vast;

/* JADX INFO: loaded from: classes13.dex */
public class VastSpecError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12271a;
    public static final VastSpecError XML_PARSING = new VastSpecError(100);
    public static final VastSpecError XML_VALIDATE = new VastSpecError(101);
    public static final VastSpecError DURATION = new VastSpecError(202);
    public static final VastSpecError GENERAL_WRAPPER = new VastSpecError(300);
    public static final VastSpecError BAD_URI = new VastSpecError(301);
    public static final VastSpecError EXCEEDED_WRAPPER_LIMIT = new VastSpecError(302);
    public static final VastSpecError WRAPPER_RESPONSE_NO_AD = new VastSpecError(303);
    public static final VastSpecError GENERAL_LINEAR = new VastSpecError(400);
    public static final VastSpecError NO_FILE = new VastSpecError(401);
    public static final VastSpecError BAD_FILE = new VastSpecError(403);
    public static final VastSpecError SHOWING = new VastSpecError(405);
    public static final VastSpecError GENERAL_COMPANION = new VastSpecError(600);
    public static final VastSpecError UNKNOWN = new VastSpecError(900);

    private VastSpecError(int code) {
        this.f12271a = code;
    }

    public int getCode() {
        return this.f12271a;
    }

    public String toString() {
        return String.format("%s", Integer.valueOf(this.f12271a));
    }
}
