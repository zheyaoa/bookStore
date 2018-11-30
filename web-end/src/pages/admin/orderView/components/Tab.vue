<template>
    <div id="footer">
        <el-menu class="menu" mode="horizontal">
            <div class="router">
                <el-menu-item index="1">
                    <i class="iconfont">&#xe600;</i>
                    <div class="name">所有订单</div>
                </el-menu-item> 
            </div>
            <div  class="router">
                <el-menu-item index="2">
                    <i class="iconfont">&#xe602;</i>
                    <div class="name">已完成</div>
                </el-menu-item>
            </div >
            <div  class="router">
                <el-menu-item index="3">
                    <i class="iconfont">&#xe604;</i>
                    <div class="name">未完成</div>
                </el-menu-item>
            </div>
        </el-menu>
    </div>
</template>
<script>
export default {
    name:'footer'
}
</script>
<style lang="stylus" scoped>
    .menu
        display flex;
    .menu >>> .router
        flex 1
        text-align center
    .menu >>> .name
        font-size .4rem
        line-height .4rem
    #footer
        height 1rem
        position fixed
        bottom 0
        width 100%
        border-top .02rem solid #c6c6c6
        .iconfont
            font-size .4rem
            line-height .4rem
            display block
            margin .1rem 0           
</style> 