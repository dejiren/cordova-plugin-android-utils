
<!---
   The MIT License (MIT)

Copyright (c) 2015 Bruno Grossi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
-->

# cordova-plugin-android-utils

From the Command line:

    cordova plugin add cordova-plugin-android-utils


## method

### notification setting manager
window.cordova?.plugins.androidEnv.getNotificationChannel(channelId)
.then(console.log).catch(console.log);

window.cordova?.plugins.androidEnv.openAppNotificationSettings(channelId)
.then(console.log).catch(console.log);

window.cordova?.plugins.androidEnv.openNotificationChannelSettings(channelId)
.then(console.log).catch(console.log);


### env const 
window.cordova?.plugins.androidEnv.getDirectory(
        // Ringtones
        "Ringtones");

### media scanner
window.cordova.plugins.androidMediaScanner.scanFile(filePath)
.catch(console.error);



## 注意点
 - 呼ぶ時に、cordova.plugins.androidxxxに統一
 - 共通index.d.tsの追加により、typescriptの問題解消

## index.d.tsの作成について　　

新たな修正が発生また新たな機能を導入するとき、以下の手順でコマンドを実行して、  
作成されたtypes/xxxx.d.tsの内容により、index.d.tsを修正

 - npm install 
 - npx tsc


