# PCN - 私有云导航

支持离线使用的                    轻量化多功能导航

## 适用场景

1. 家庭内部服务器部署 -> 家庭内部服务导航
2. 公司内网计算机部署 -> 公司内务导航

> 建议使用Docker进行部署, 请勿直接使用静态文件!

## 加载逻辑

1. 加载表层样式
2. 加载配置文件
3. 加载核心脚本
4. 动态注入其他依赖脚本
5. 动态注入页面主体内容
6. 加载内部服务数据(若`security`为`true`则需先输入解密密钥)
7. 装载订阅数据与内部服务数据
8. 加载完成

浏览器一般默认背景是#fff, 所以我将加载过渡的初始色定位#fff, 然后使用动画过渡成主题色