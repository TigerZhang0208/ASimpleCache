AndroidCache
============
对ASimpleCache项目进行一些优化。
使用方式如下：

```java

cache = AndroidCache.getInstance(this);
cache.put("key1", "value1");
cache.put("key2", "value2");
cache.put("key3", "value3");
cache.put("key4", "value4");

JSONObject jsonObject = new JSONObject();
try {
    jsonObject.put("jsonKey1", "jsonKey1");
    jsonObject.put("jsonKey2", "jsonKey2");
} catch (JSONException e) {
    e.printStackTrace();
}

cache.put("json1", jsonObject);

ArrayList<String> keyList = cache.findKeys("key");
for (int i = 0; i < keyList.size(); i++) {
    Log.i("MainActivity", cache.getAsString(keyList.get(i)));
    cache.remove(keyList.get(i));
}

Log.i("MainActivity", "key size:" + cache.findKeys("key").size());

if(cache.existsKey("json1")){
    Log.i("MainActivity", "Json value:" + cache.getAsJSONObject("json1").toString());
}



