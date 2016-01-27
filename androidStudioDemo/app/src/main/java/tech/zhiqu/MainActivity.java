package tech.zhiqu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;

import tech.zhiqu.cache.AndroidCache;

public class MainActivity extends AppCompatActivity {
    private String TAG = "AndroidCacheDemo";
    AndroidCache cache = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demo();
    }

    private void demo() {
        try {
            cache = AndroidCache.getInstance(this);
            cache.put("key1", "value1");
            cache.put("key2", "value2");
            cache.put("key3", "value3");
            cache.put("key4", "value4");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("jsonKey1", "jsonKey1");
            jsonObject.put("jsonKey2", "jsonKey2");
            cache.put("json1", jsonObject);

            ArrayList<String> keyList = cache.findKeys("key");


            for (int i = 0; i < keyList.size(); i++) {
                Log.i(TAG, cache.getAsString(keyList.get(i)));
                cache.remove(keyList.get(i));
            }

            Log.i(TAG, "key size:" + cache.findKeys("key").size());

            if (cache.existsKey("json1")) {
                Log.i(TAG, "Json value:" + cache.getAsJSONObject("json1").toString());
            }


        } catch (Exception e) {
          e.getStackTrace();
        }
    }


}
