<template>
    <el-container class="container">
        <el-header class="header" height='44px'>
            <i class="iconfont back" @click="handleBack">&#xe601;</i>
            注册
        </el-header>
        <el-main>
            <el-form>
                <el-form-item label="账号">
                    <el-input placeholder="请输入账号/学号"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input placeholder="请输入密码" ></el-input>
                </el-form-item>
                <el-item>
                    <el-button class="register">
                        注册
                    </el-button>
                </el-item>
            </el-form>
        </el-main>
    </el-container>
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
            this.$router.go(-2)
        }  
    }
}
</script>
<style lang="stylus" scoped>
      .container >>> .el-form-item__label
          font-weight  100
          font-size .36rem
          line-height .6rem
      .container >>> .el-input__inner
          height .9rem
          line-height .9rem
          font-size .32rem 
      .container
          background #ebeced
          height 100%
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
          .register
            background #409eff
            margin-top .6rem
            border-radius .1rem
            height 1rem
            width 100%
</style>
