<template>
    <div class="content">
        <el-form>
            <el-form-item label="书籍类型"><br>
                <el-select filterable placeholder="请选择">
                    <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>            
            </el-form-item>
            <el-form-item label="书籍名称">
                <el-input placeholder="请输入密码" ></el-input>
            </el-form-item>
            <el-form-item label="书籍详情">
                <el-input type="textarea"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button class="submit" type="primary">
                        提交
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
export default {
    name:'ImportForm'
}
</script>
<style lang="stylus" scoped>
    .content >>> .el-form-item__label
        font-size .32rem
        line-height .6rem
    .content >>> .el-input__inner
        height .9rem
        line-height .9rem
        font-size .32rem 
    .content >>> .el-select
        width 100%
    .content
        margin-top .6rem
        margin .6rem .2rem 0 .2rem
        .submit
            width 100%
            margin-top .6rem
</style>
