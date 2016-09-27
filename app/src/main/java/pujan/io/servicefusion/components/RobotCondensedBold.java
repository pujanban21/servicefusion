package pujan.io.servicefusion.components;

/**
 * Created by pujan on 9/25/2016.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class RobotCondensedBold extends TextView {
    public RobotCondensedBold(Context context) {
        super(context);
        typeFace();
    }

    public RobotCondensedBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        typeFace();
    }

    public void typeFace(){
        Typeface customTypeFace = Typeface.createFromAsset(getContext().getAssets(),
                "roboto/RobotoCondensed-Bold.ttf");
        setTypeface(customTypeFace);
    }

}

