package com.android.gatofalante.armario.utilities;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by gatofalante on 12/29/17.
 */

public class GridImageView extends android.support.v7.widget.AppCompatImageView {
    public GridImageView(Context ctx) {
        super(ctx);
    }

    public GridImageView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
    }

    public GridImageView(Context ctx, AttributeSet attrs, int defStyle) {
        super(ctx, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
