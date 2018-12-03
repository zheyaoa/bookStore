<template>
    <div class="List">
        <el-table :data="list" style="width: 100%" :border="true">
            <el-table-column prop="uId" label="id" width="80"></el-table-column>
            <el-table-column prop="username" label="姓名" width="120"></el-table-column>
            <el-table-column prop="address" label="地址"> </el-table-column>
    </el-table>
    </div>
</template>
<script>
export default {
    name:'SearchList',
    props:{
        list:Array
    },
    data(){
        return{

        }
    }
}
</script>
<style lang="stylus" scoped>
    .List
        .item
            p
                font-size .36rem
                line-height 1.5em
</style>
