package com.bykv.vk.openvk.preload.a;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: LongSerializationPolicy.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f894a = new p("DEFAULT") { // from class: com.bykv.vk.openvk.preload.a.p.1
        {
            byte b2 = 0;
        }
    };
    private static p b = new p("STRING") { // from class: com.bykv.vk.openvk.preload.a.p.2
        {
            int i = 1;
            byte b2 = 0;
        }
    };

    private p(String str, int i) {
        super(str, i);
    }

    /* synthetic */ p(String str, int i, byte b2) {
        this(str, i);
    }
}
