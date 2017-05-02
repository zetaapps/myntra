package zeta.android.thunderbird.models.common;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        GenderType.MALE,
        GenderType.FEMALE,
        GenderType.UNKNOWN,
})
public @interface GenderType {
    String MALE = "MALE";
    String FEMALE = "FEMALE";
    String UNKNOWN = "UNKNOWN";
}
