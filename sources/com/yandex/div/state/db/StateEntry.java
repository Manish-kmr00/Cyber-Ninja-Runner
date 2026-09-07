package com.yandex.div.state.db;

import android.provider.BaseColumns;
import kotlin.Metadata;

/* JADX INFO: compiled from: DB.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div/state/db/StateEntry;", "Landroid/provider/BaseColumns;", "()V", "COLUMN_CARD_ID", "", "COLUMN_ID", "COLUMN_MOD_TIME", "COLUMN_PATH", "COLUMN_STATE_ID", "INDICES_NAME", "INIT_DB_VERSION", "", "TABLE_NAME", "div-states_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StateEntry implements BaseColumns {
    public static final String COLUMN_CARD_ID = "card_id";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MOD_TIME = "modification_time";
    public static final String COLUMN_PATH = "path";
    public static final String COLUMN_STATE_ID = "state_id";
    public static final String INDICES_NAME = "index_div_card_states_card_id_path";
    public static final int INIT_DB_VERSION = 1;
    public static final StateEntry INSTANCE = new StateEntry();
    public static final String TABLE_NAME = "div_card_states";

    private StateEntry() {
    }
}
