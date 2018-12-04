<template>
    <div id="footer">
        <el-menu class="menu" mode="horizontal">
            <div class="router"  v-for="item in items" :key="item.index" @click="getOrderList(item.index)">
                <el-menu-item :index="String(item.index)">
                    <i class="iconfont" v-html="item.icon"></i>
                    <div class="name">{{item.message}}</div>
                </el-menu-item> 
            </div>
        </el-menu>
    </div>
</template>
<script>
export default {
    name:'footer',
    data(){
        return{
            items:[
                {
                    icon:'&#xe600;',
                    message:'所有订单',
                    index:1
                },
                {
                    icon:'&#xe600;',
                    message:'已完成',
                    index:2
                },
                {
                    icon:'&#xe600;',
                    message:'未完成',
                    index:3
                },
            ]
        }
    },
    methods:{
        getOrderList(id){
            console.log(id)
            this.$emit('tabClick',id);
        }
    }
}
</script>
<style lang="stylus" scoped>
    .menu
        display flex;
    .menu >>> .router
        flex 1
        text-align center
    .menu >>> .name
        font-size .4rem
        line-height .4rem
    #footer
        height 1rem
        position fixed
        bottom 0
        width 100%
        border-top .02rem solid #c6c6c6
        .iconfont
            font-size .4rem
            line-height .4rem
            display block
            margin .1rem 0           
</style> 