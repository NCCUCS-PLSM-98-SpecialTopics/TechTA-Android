package web.test;

import android.os.Bundle;
import org.apache.cordova.*;
//import android.app.Activity;
import android.view.Menu;
//import com.strumsoft.websocket.phonegap.*;

public class MainActivity extends DroidGap {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //super.loadUrl("file:///android_asset/www/index.html");
        super.loadUrl("file:///android_asset/www/TEST.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
