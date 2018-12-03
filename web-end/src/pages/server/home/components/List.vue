<template>
    <div id="list">
        <div class="item" v-for="item in  list" :key="item.cId">
            <div class="img">
                <img :src="item.image">
            </div>
            <div class="detail">
                <h5 class="title">{{item.cName}}</h5>
                <div class="content">{{item.des}}</div>
                <div class="footer">
                    <span class="price">
                        ¥{{item.price}}
                    </span>
                    <i class="iconfont add" @click="addShoppingCart(item.cId)">&#xe606;</i>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name:'BookList',
    props:['list'],
    data(){
        return{

        }
    },
    methods:{
        addShoppingCart(cId){
        let data = JSON.stringify({cId});
        this.axios.post('api/addShoppingCart',data);
        this.$message({
                message: '添加成功',
                type: 'success'
            });
        }
    }
}
</script>
<style lang="stylus" scoped>
    #list
        margin-bottom 1.2rem
        .item
            display flex
            box-sizing border-box
            height 2.6rem
            padding .1rem
            border-bottom .02rem solid #c6c6c6
            .img
                img
                    padding  .1rem .2rem
                    width  1.6rem
                    height 2.2rem
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
                .content
                    display -webkit-box
                    -webkit-box-orient vertical
                    overflow hidden
                    -webkit-line-clamp:2;
                    color #999999
                    overflow hidden
                    font-size .32rem
                    height .96rem
                    line-height .48rem
                .footer
                    padding-top .2rem
                    .price
                        color #f56c6c                      
                    .add
                        float right
                        display inline-block
                        margin-right .2rem
</style>
