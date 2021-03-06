# 提供一个与题解不同的思路

记录所有列当中连续的不降区间，比如序列**1 2 3 4 1 3 3** 对应 **[0,3]** 和 **[4,6]** 两个区间， **[]** 中数字表示数组下标，这些区间的集合记为**A**。

对于每个询问 **[l<sub>i</sub>,r<sub>i</sub>]** ，如果**A**中存在区间 **[x,y]** 包含 **[l<sub>i</sub>,r<sub>i</sub>]** ,即存在从第**l<sub>i</sub>** 行到第 **r<sub>i</sub>** 行的不降序列，此时输出Yes,否则输出No。

离线处理询问，将询问的集合记作**B**。

将集合**A**中的区间按左端点升序，右端点升序排列，集合**B**中的区间按右端点升序，左端点降序排列。这样排列可以满足：如果**B**中的区间**j**不被A中的区间**i**包含，则**j**后面的元素也不会被i及i前面的元素包含。

因此使用双指针**i**,**j**扫描一遍，判断**j**是否被**i**包含即可。

时间复杂度**O(n*mlog(n*m)+klogk)**
