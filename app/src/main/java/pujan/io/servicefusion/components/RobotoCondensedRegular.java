package pujan.io.servicefusion.components;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by pujan on 9/23/2016.
 */
public class RobotoCondensedRegular extends TextView {
    public RobotoCondensedRegular(Context context) {
        super(context);
        typeFace();
    }

    public RobotoCondensedRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        typeFace();
    }

    public void typeFace(){
        Typeface customTypeFace = Typeface.createFromAsset(getContext().getAssets(),
                "roboto/RobotoCondensed-Regular.ttf");
        setTypeface(customTypeFace);
    }

}
