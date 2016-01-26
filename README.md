AndroidCache
============
对ASimpleCache项目进行一些优化。调用方式如下：

```java
AndroidCache mCache = AndroidCache(this);
mCache.put("test_key1", "test value");
mCache.put("test_key2", "test value", 10);//保存10秒，如果超过10秒去获取这个key，将为null
mCache.put("test_key3", "test value", 2 * ACache.TIME_DAY);//保存两天，如果超过两天去获取这个key，将为null
```
获取数据
```java
AndroidCache mCache = AndroidCache(this);
String value = mCache.getAsString("test_key1");



