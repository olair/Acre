package cn.olair.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 数据类型
 * <p>
 * Created by olair on 18.3.25.
 */

@Entity(tableName = "acres")
public class Acre {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "acre_id")
    private String mId;

    @NonNull
    @ColumnInfo(name = "landowner")
    private String mLandowner;

    @Nullable
    @ColumnInfo(name = "landowner_phone")
    private String mLandownerPhone;




}
