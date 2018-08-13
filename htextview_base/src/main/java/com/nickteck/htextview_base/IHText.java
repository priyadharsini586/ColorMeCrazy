package com.nickteck.htextview_base;

import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by admin on 8/3/2018.
 */

public interface IHText {

    void init(HTextView hTextView, AttributeSet attrs, int defStyle);

    void animateText(CharSequence text);

    void onDraw(Canvas canvas);

    void setAnimationListener(AnimationListener listener);
}
