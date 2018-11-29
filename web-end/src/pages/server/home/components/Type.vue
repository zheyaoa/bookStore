<template>
    <div id="type">
        <el-tag>电子书</el-tag>
        <el-tag type="success">小说</el-tag>
        <el-tag type="info">漫画</el-tag>
        <el-tag type="warning">科技</el-tag>
        <el-tag type="danger">童书</el-tag>
    </div>
</template>
<script>
export default {
    name:'BookType',
    data(){
        return{
            typeList:[
                {
                    name:'电子书',
                    typeId:1
                },
                {
                    name:'电子书',
                    typeId:2
                },
                {
                    name:'电子书',
                    typeId:3
                },
                {
                    name:'电子书',
                    typeId:4
                },
                {
                    name:'电子书',
                    typeId:5
                }
            ]
        }
    }
}
</script>
<style lang="stylus" scoped>
    #type
        background #ebeced
        display flex
        justify-content space-around
</style>
