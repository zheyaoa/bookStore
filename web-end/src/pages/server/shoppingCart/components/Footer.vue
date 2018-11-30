<template>
   <div class="footer">
        <el-checkbox :label="checked" class="checkBox">
            <span class="message">全选</span>
        </el-checkbox>
        <el-button type="danger" class="submit">
            结算
        </el-button>
        <div class="price">
            合计：¥ <span v-text="price"></span>
        </div>

   </div> 
</template>
<script>
export default {
    name:'CartFooter',
    data(){
        return{
            checked:false,
            price:100
        }
    }
}
</script>
<style lang="stylus" scoped>
    .footer
        position fixed
        height .8rem
        width 100%
        bottom 0
        border-top .02rem solid #c6c6c6
        .checkBox
            float left
            margin 0 .1rem
            padding-left .2rem
            height .8rem
            line-height .8rem
            .check
                display inline-block
                margin-top .1rem
                color #fff
                font-size .48rem
                border .02rem solid #c6c6c6
                border-radius 100%
            .message
                margin-left .2rem
                margin-top .1rem
                line-height .8rem
        .price
            float right 
            font-size .36rem 
            line-height .8rem 
            padding-right .1rem 
        .submit
            float right
</style>
