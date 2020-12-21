## 数据来源
排序算法是在原始学习的基础上参考了[网站](https://zhuanlan.zhihu.com/p/335048580?utm_source=wechat_session&utm_medium=social&utm_oi=811189580006060032&utm_campaign=shareopn) 的方法

排序法	平均时间	最差情形	稳定度	额外空间	备注
冒泡	O(n2)	O(n2)	稳定	O(1)	n小时较好
选择	O(n2)	O(n2)	不稳定	O(1)	n小时较好
插入	O(n2)	O(n2)	稳定	O(1)	大部分已排序时较好
Shell(希尔)	O(nlogn)	O(ns)	不稳定	O(1)	s是所选分组
快速	O(nlogn)	O(n2)	不稳定	O(nlogn)	n大时较好
归并	O(nlogn)	O(nlogn)	稳定	O(1)	n大时较好
堆	O(nlogn)	O(nlogn)	不稳定	O(1)	n大时较好
桶式	O(k+n)	O(k+n)	稳定	O(1)	只能排整形数组
