**注：因iOS限制，本插件暂时不支持iOS。**
## 首次使用请安装插件
```js
eeui plugin add SetWallpaper
```

## 模块引用方式
```js
const SetWallpaper = app.requireModule('SetWallpaper');

/**
* 设置壁纸 @param path 图片的路径
*/
SetWallpaper.setWallpaper(path)
    `
```


## path 参数说明
| Prop      | Type   |Required  | Default   | Description  |
|-------------|------------|--------|--------|-----|
| path | `Bool` | `String`|  `` |传入本地图片路径|



## 示例代码
```vue
const SetWallpaper = app.requireModule('SetWallpaper');
// 简单使用
SetWallpaper.setWallpaper(path)

// 使用网络图片
setPaper() {
    let hasWriteStorage = SetWallpaper.hasWriteStorage(); //先获取文件读写权限
    if (!hasWriteStorage) {
        return;
    }

    // 可以使用eeui自带的下载图片功能，将网络图片下载下来设置壁纸，也可以直接传参数
    eeui.saveImage('http://ww1.sinaimg.cn/large/e83ffacfgy1g329cg38xdj210n0lq15y.jpg', (result) => {
        console.log('resultxxx', result);
        if (result.status === 'success') {
            // 设置壁纸
            SetWallpaper.setWallpaper(result.path || '')
        }
    });
}
```