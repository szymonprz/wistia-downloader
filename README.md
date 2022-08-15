# wistia-downloader Project

## How to download video from wistia?

1. Download released version from [releases](https://github.com/szymonprz/wistia-downloader/releases)
2. Copy link and thumbnail to clipboard by right click on wistia video
3. run command ```./wistia-downloader -l='PASTE_COPIED_LINK_AND_THUMBNAIL' -o=OUTPUT_FILE_NAME.mp4```
*** 
example command to download a file 
```
./wistia-downloader -l='<p><a href="https://wistia.com/support/embed-and-share/media-on-your-website?wvideo=lbo2kwzc81"><img src="https://embed-ssl.wistia.com/deliveries/eebda18f9dabbb968c24a3e6d1f0ddb3.jpg?image_play_button_size=2x&amp;image_crop_resized=960x540&amp;image_play_button=1&amp;image_play_button_color=4267b2e0" width="400" height="225" style="width: 400px; height: 225px;"></a></p><p><a href="https://wistia.com/support/embed-and-share/media-on-your-website?wvideo=lbo2kwzc81">Embedding Media on Your Website — Support — Wistia</a></p>' -o=test.mp4
```
