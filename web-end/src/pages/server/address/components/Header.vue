<template>
    <div class="header">
            <i class="iconfont back" @click="handleBack">&#xe601;</i>
            添加地址
    </div>
</template>
<script>
export default {
    name:'Register',
    data(){
        return {
        }
    },
    methods:{
        handleBack(){
            this.$router.go(-1)
        }  
    }
}
</script>
<style lang="stylus" scoped>
    .header
        background #409eff
        height .88rem
        line-height .88rem
        font-size .36rem
        color #fff
        text-align center
        .back
            position absolute
            left .2rem
            color #fff

</style>
