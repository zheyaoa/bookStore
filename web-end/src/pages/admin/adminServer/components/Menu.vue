
<template>
    <div class="nav">
        <div class="menu">
            <router-link to="./importBook">
                <div class="menu-item">
                    <i class="iconfont">&#xe603;</i>
                    书籍录入
                    <i class="iconfont join">&#xe605;</i>
                </div>
            </router-link>
            <router-link to="./orderView">
                <div class="menu-item">
                    <i class="iconfont ">&#xe603;</i>
                    查看订单
                    <i class="iconfont join">&#xe605;</i>
                </div>
            </router-link>
            <router-link to="./search">
                <div class="menu-item">
                    <i class="iconfont">&#xe612;</i>
                    信息查询
                    <i class="iconfont join">&#xe605;</i>
                </div>
            </router-link>
        </div>
    </div>
</template>
<script>
export default {
    name:'adminNav'
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
</style>
