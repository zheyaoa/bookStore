<template>
    <div class="nav">
        <div class="menu">
            <router-link to="./order">
                <div class="menu-item">
                    <i class="iconfont">&#xe603;</i>
                    我的订单
                    <i class="iconfont join">&#xe605;</i>
                </div>
            </router-link>
            <router-link to="./shoppingCart">
                <div class="menu-item">
                    <i class="iconfont ">&#xe602;</i>
                    我的购物车
                    <i class="iconfont join">&#xe605;</i>
                </div>
            </router-link>
            <div class="menu-item">
                <i class="iconfont">&#xe602;</i>
                收货地址
                <i class="iconfont join">&#xe605;</i>
            </div>
        </div>
        <div class="footer">
            <el-button type="danger" class="quit">退出</el-button>
        </div>
    </div>
</template>
<script>
export default {
    name:'Nav'
}
</script>
<style lang="stylus" scoped>
    .nav
        margin-top .2rem
        .menu-item
            height .9rem
            background #fff
            border-bottom .02rem solid #c6c6c6
            line-height .9rem
            padding-left .2rem
            color #4d4d4d
            .join
                position absolute
                right .2rem
        .footer
            position absolute
            width 100%
            bottom 0
            text-align center
            .quit
                width 100%
</style>
