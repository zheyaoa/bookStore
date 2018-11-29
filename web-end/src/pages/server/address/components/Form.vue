<template>
    <div class="content">
        <el-form>
            <el-form-item label="收货地址">
                <el-input></el-input>
            </el-form-item>
            <el-button type="primary" class="submit">
                修改
            </el-button>
        </el-form>
    </div>
</template>
<script>
export default {
    name:'AddressForm'    
}
</script>
<style lang="stylus" scoped>
    .content >>> .el-form-item__label
        font-size .32rem
        line-height .9rem
    .content >>> .el-input__inner
        height .9rem
        line-height .9rem
        font-size .32rem 
    .content
        margin 0.8rem .3rem 0 .3rem
        .submit
            width 100%
            margin .4rem 0
</style>
