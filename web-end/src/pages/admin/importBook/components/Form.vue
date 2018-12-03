<template>
    <div class="content">
        <el-form>
            <el-form-item label="书籍类型" v-model="bookForm"><br>
                <el-select filterable placeholder="请选择" v-model="bookForm.value">
                    <el-option
                    v-for="item in typeList"
                    :key="item.typeId"
                    :label="item.typeName"
                    :value="item.typeId">
                    </el-option>
                </el-select>            
            </el-form-item>
            <el-form-item label="书籍名称">
                <el-input placeholder="请输入书籍名称" v-model="bookForm.name"></el-input>
            </el-form-item>
            <el-form-item label="书籍详情">
                <el-input type="textarea" v-model="bookForm.datail"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button class="submit" type="primary" @click="handleSubmit">
                        提交
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
export default {
    name:'ImportForm',
    data(){
        return{
            typeList:[
                {
                   'typeName':'电子书',
                   'typeId':0 
                },
                {
                   'typeName':'小说',
                   'typeId':1 
                },
                {
                   'typeName':'漫画',
                   'typeId':2 
                },
                                {
                   'typeName':'科技',
                   'typeId':3 
                },                
                {
                   'typeName':'童书',
                   'typeId':4 
                }
            ],
            bookForm:{
                name:'',
                value:'',
                datail:''
            }
        }
    },
    methods:{
        handleSubmit(){
            let data = this.bookForm
            data.typeId = data.value;
            delete data.value;
            data = JSON.stringify(data);
            this.axios.post('./api/addBook',data)
            .then(rs => {
                this.$message({
                    type:'success',
                    message:'录入成功'
                })
            })
        }
    }
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
