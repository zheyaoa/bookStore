<template>
    <div class="header">
        <img src="https://s.qunarzz.com/usercenter_mobile/images/my/mybgnew-20161111.jpg" alt="">
        <div class="content">
            <div class="link">
                <img src="https://source.qunarzz.com/usercenter/touch/avatar.png" alt="">
            </div>
            <p class="login">管理员Aster</p>
        </div>
    </div>
</template>
<script>
export default {
    name:'adminHeader',
}
</script>
<style lang="stylus" scoped>
    .header
        height 3.2rem
        img 
            height 3.2rem
            width 100%
        .content
            height 2rem
            width 100%
            position absolute
            top .88rem
            text-align center
            .link
                display inline-block
                boeder-radius 100%
                padding .06rem
                height 1.42rem
                width 1.42rem
                img 
                    height 1.3rem
                    width 1.3rem
                    margin-bottom .1rem
                    border-radius 100%
            .login
                color #fff
</style>
