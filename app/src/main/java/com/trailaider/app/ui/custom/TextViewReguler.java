package com.trailaider.app.ui.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Divya on 20-11-2017.
 */

public class TextViewReguler extends TextView {
    public TextViewReguler(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public TextViewReguler(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public TextViewReguler(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface(FontTypes.REGULAR, context);
        setTypeface(customFont);
    }
}
