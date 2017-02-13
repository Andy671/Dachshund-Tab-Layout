package com.kekstudio.dachshundtablayout.indicators;

import android.graphics.Canvas;
import android.support.annotation.ColorInt;

/**
 * Created by Andy671
 */

public interface AnimatedIndicatorInterface {

    long DEFAULT_DURATION = 500;

    void setSelectedTabIndicatorColor(@ColorInt int color);

    void setSelectedTabIndicatorHeight(int height);

    void setIntValues(int startXLeft, int endXLeft,
                      int startXCenter, int endXCenter,
                      int startXRight, int endXRight);

    void setCurrentPlayTime(long currentPlayTime);

    void draw(Canvas canvas);

    long getDuration();
}
