<template>
    <div id="list">
        <div class="item" v-for="item in  list" :key="item.cId">
            <div class="img">
                <img :src="item.image">
            </div>
            <div class="detail">
                <h5 class="title">{{item.cName}}</h5>
                <div class="status">
                    {{getStatus(item.status)}}
                </div>
                <div class="footer">
                    <span class="price">
                        ¥{{item.price}}
                    </span>
                    <span class="sum">
                        X{{item.sum}}
                    </span>

                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            list:[]
        }
    },
    props:{
        list:Array,
    },
    methods:{
        getStatus(status){
            if(status == 0){
                return "订单未完成"
            }else{
                return　"订单已完成"
            }
        }
    }
}
</script>
<style lang="stylus" scoped>
    #list
        .item
            display flex
            box-sizing border-box
            height 2.2rem
            padding .1rem
            border-bottom .02rem solid #c6c6c6
            .img
                img
                    padding  0rem .2rem
                    width  1.6rem
                    height 2.0rem
            .detail
                flex 1
                display flex
                padding .1rem .2rem
                box-sizing border-box
                overflow hidden
                flex-direction column
                .title
                    font-size .36rem
                    line-height .48rem
                    padding-bottom .1rem
                    overflow hidden
                    word-break break-word
                .status
                    line-height .48rem
                    font-size .36rem
                .footer
                    padding-top .2rem
                    .price
                        color #f56c6c                      
                    .sum
                        color #6a737d
                        font-size .24rem
                        margin-left .1rem  
</style>
