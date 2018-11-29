<template>
    <div class="header">
        <div class="header-left">
            <i class="iconfont">&#xe6b1;</i>
        </div>
        <div class="header-input">
            <i class="el-icon-search"></i>
            输入书籍名称/类别
        </div>
    </div>
</template>
<script>
export default {
    name:'ServerHeader'
}
</script>
<style lang="stylus" scoped>
@import '~style/common.styl'
.header 
   display flex
   line-height 0.86rem
   background $headBackground
   color #fff
  .header-left 
    width 0.64rem
    float left
    .iconfont
        font-size .4rem
        padding-left .2rem
  .header-input 
    flex 1
    background #fff
    height 0.62rem
    line-height 0.62rem
    padding-left .1rem
    margin  0 0.2rem
    margin-top 0.12rem
    border-radius 0.1rem
    color #ccc
</style>

