<template>
    <div id="type">
        <el-tag type="success" v-for="item in typeList" :key="item.typeId" @click="handleTagClick(item.typeId)">
            {{item.name}}
        </el-tag>
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
                    typeId:0
                },
                {
                    name:'小说',
                    typeId:1
                },
                {
                    name:'漫画',
                    typeId:2
                },
                {
                    name:'科技',
                    typeId:3
                },
                {
                    name:'童书',
                    typeId:4
                }
            ]
        }
    },
    methods:{
        handleTagClick(typeId){
            
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
