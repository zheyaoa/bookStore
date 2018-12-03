<template>
    <el-container class="container">
        <el-header class="header" height='44px'>
            <i class="iconfont back" @click="handleBack">&#xe601;</i>
            登录
            <router-link to="/register">
                <span class="register">注册</span>
            </router-link>
        </el-header>
        <el-main>
            <el-form v-model="loginForm">
                <el-form-item label="活动名称">
                    <el-input placeholder="请输入手机号" v-model="loginForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input placeholder="请输入密码" type="password" v-model="login.password"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button class="login" @click="handleLogin">
                        登入
                    </el-button>
                </el-form-item>
            </el-form>
        </el-main>
    </el-container>
</template>
<script>
export default {
    name:'Login',
    data(){
        return {
            loginForm:{
                username:'',
                password:''
            }
        }
    },
    methods:{
        handleBack(){
            this.$router.go(-1)
        },
        handleLogin(){
            let data = JSON.stringify(this.loginForm);
            this.axios.post('https://www.easy-mock.com/mock/5c03b2ae125d962d127404d1/login',data)
            .then(rs => {
                this.$message({
                    "type":"success",
                    "message":'登入成功'
                })
                this.$router.push('./')
            })
        }
    }
}
</script>
<style lang="stylus" scoped>
      .container >>> .el-form-item__label
          font-size .32rem
          line-height .6rem
      .container >>> .el-input__inner
          height .9rem
          line-height .9rem
          font-size .32rem 
          background #fff
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
                color #fff
                position absolute
                right  .2rem 
          .login
            background #409eff
            margin-top .6rem
            border-radius .1rem
            height 1rem
            width 100%
</style>
