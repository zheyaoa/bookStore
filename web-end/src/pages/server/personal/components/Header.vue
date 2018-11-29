<template>
    <div class="header">
        <img src="https://s.qunarzz.com/usercenter_mobile/images/my/mybgnew-20161111.jpg" alt="">
        <i class="iconfont back" @click="handleBack">&#xe601;</i>            
        <div class="content">
            <router-link to="login" class="link">
                <img src="https://source.qunarzz.com/usercenter/touch/avatar.png" alt="">
            </router-link>
            <p class="login">登陆/注册</p>
        </div>
    </div>
</template>
<script>
export default {
    name:'PersonalHeader',
    methods:{
        handleBack(){
            this.$router.go(-1)
        }   
    }
}
</script>
<style lang="stylus" scoped>
    .header
        height 3.2rem
        img 
            height 3.2rem
            width 100%
        .back
            color #ffffff
            height .88rem
            line-height .88rem
            width 100%
            position absolute
            left .1rem
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
