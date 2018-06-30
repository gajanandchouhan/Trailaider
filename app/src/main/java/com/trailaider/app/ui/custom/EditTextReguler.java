package com.trailaider.app.ui.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Divya on 20-11-2017.
 */

public class EditTextReguler extends EditText {
    public EditTextReguler(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public EditTextReguler(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public EditTextReguler(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface(FontTypes.REGULAR, context);
        setTypeface(customFont);
    }
}
