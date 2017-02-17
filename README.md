# mkloader
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MK%20Loader-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5285)
[![Build Status](https://travis-ci.org/nntuyen/mkloader.svg?branch=master)](https://travis-ci.org/nntuyen/mkloader)
[![Android Gems](http://www.android-gems.com/badge/nntuyen/mkloader.svg?branch=master)](http://www.android-gems.com/lib/nntuyen/mkloader)

Beautiful and smooth custom loading views

![](screenshot/screenshot.gif)

## Usage

```xml
<com.tuyenmonkey.mkloader.MKLoader
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          app:mk_type="<loading_type>" (Optional. Default is ClassicSpinner)
          app:mk_color="<color>" (Optional. Default is #ffffff)
      />
```

## Supported Types
- `Sharingan`
- `TwinFishesSpinner`
- `ClassicSpinner`
- `LineSpinner`
- `FishSpinner`
- `PhoneWave`
- `ThreePulse`
- `FourPulse`
- `FivePulse`
- `Worm`
- `Whirlpool`
- `Radar`
- `...more types are in development`

## Download
Gradle

```javascript
dependencies {
  compile 'com.tuyenmonkey:mkloader:1.0.0'
}
```
Snapshots of the development version are available in [Sonatype's `snapshots` repository](https://oss.sonatype.org/content/repositories/snapshots/).

## License

    Copyright 2017 Tuyen Monkey

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
