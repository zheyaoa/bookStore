<template>
    <div class="content">
        <el-form v-model="addressForm">
            <el-form-item label="收货地址">
                <el-input v-model="addressForm.address"></el-input>
            </el-form-item>
            <el-button type="primary" class="submit" @click="changeAddress">
                修改
            </el-button>
        </el-form>
    </div>
</template>
<script>
export default {
    name:'AddressForm',
    data(){
        return{
            addressForm:{
                address:''
            }
        }
    },
    methods:{
        getAddress(){
            
        },
        changeAddress(){
            let data = JSON.stringify(this.addressForm);
            this.axios.post('http://localhost:8080/api/changeAddress',data)
            .then(rs =>{
                this.$message({
                    "type":"success",
                    "title":"修改成功"
                })
            })
        }
    }
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
