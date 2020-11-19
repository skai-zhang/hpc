const conf = {
    "network": {
        "online": false, // 是否使用在线资源
        "cache": false // 是否缓存资源文件
    },
    "resources": {
        "online": ["https://cdn.jsdelivr.net/npm/zui@1.9.2/dist/js/zui.lite.min.js","https://cdn.jsdelivr.net/npm/jquery.nicescroll@3.7.6/jquery.nicescroll.min.js","res/icons/iconfont.js"], // 在线资源列表
        "offline": ["res/js/nicescroll.min.js","res/js/zui.lite.min.js","res/icons/iconfont.js"] // 离线资源列表
    },
    "search":{
        "placeholder": "你在找些什么?",
        "url": "https://www.google.com/search?q={{keyword}}" // 搜索功能api地址
    },
    "security": false, // 是否启用安全加密
    "subscribe": "", // 导航目录订阅地址
    "update": "", // 程序更新检测地址
    "version": "1.0.0", // 当前程序版本
    "title": "PCN - 私有云导航", // 页面标题
    "name": "私有云导航" // 页面名称
}