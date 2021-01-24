# FlutterAndroid
Android已有项目中集成Flutter

# 关键修改
1. 已有Android项目 新增Flutter Module
2. Android项目 settings.gradle 新增如下配置
```
setBinding(new Binding([gradle: this]))
evaluate(new File(
        settingsDir,
        //flutter_module即为创建的模块名称
        './flutter_module/.android/include_flutter.groovy'
))
```
3. 同步Project后，在主app build.gradle中增加依赖
```
implementation project(':flutter')
```
4. 启动内置的代码
```
findViewById<Button>(R.id.startFlutter).setOnClickListener {
    startActivity(Intent(this@MainActivity, MyFlutterActivity::class.java))
}

findViewById<Button>(R.id.startFlutter2).setOnClickListener {
    startActivity(Intent(this@MainActivity, SecondFlutterActivity::class.java))
}

findViewById<Button>(R.id.startFlutter3).setOnClickListener {
    val intent = FlutterActivity.withNewEngine()
        .initialRoute("main")
        .build(this)
    startActivity(intent)
}
```
