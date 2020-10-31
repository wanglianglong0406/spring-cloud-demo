--
-- Created by IntelliJ IDEA.
-- User: Administrator
-- Date: 2020/10/30
-- Time: 16:14
-- To change this template use File | Settings | File Templates.
--

-- 模拟限流
-- 用作限流的key
local key = "My Key"
-- 限流的最大阈值
local limit =2

-- 当前流量的大小

local currentLimit=0

if currentLimit +1 >limit then
    print "reject"
else
    print "accept"
end