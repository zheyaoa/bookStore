<template>
    <div id="list" ref="list">
        <div class="item" v-for="item in  list" :key="item.cId" >
            <el-checkbox v-model="item.checked" @change="handleCheckChange" :data-index='item.cId'></el-checkbox>
            <div class="img">
                <img :src="item.image">
            </div>
            <div class="detail">
                <h5 class="title">{{item.cName}}</h5>
                <div class="foot">
                    <span class="price">
                        ¥{{item.price}}
                    </span>
                </div>
                <div class="action">
                    <el-input-number v-model="item.num" size="medium" :min="1" :max="10" label="描述文字" @change="handleNumChange"></el-input-number>
                    <el-button type="danger" size="mini" class="delete" @click="handleDelete(item.cId)">删除</el-button>
                </div>
            </div>
        </div>
        <div class="footer">
            <el-checkbox  class="checkBox" v-model="checked" @change="handleAllCheckClick">
                <span class="message">
                    全选
                </span>
            </el-checkbox>
            <el-button type="danger" class="submit" @click="account">
                结算
            </el-button>
            <div class="price">
                 <span>{{allPrice}}</span>
            </div>
        </div> 
    </div>
</template>
<script>
export default {
    name:'CartList',
    props:{
        list:Array
    },
    data(){
        return{
            price:0,
            checked:false
        }
    },

    computed:{
        allPrice(){
            return '合计：¥' + this.price
        }
    },
    methods:{
        //提交订单
        account(){
            this.handleCheckList()
            this.$emit('account')
        },
        //处理选中的货物
        handleCheckList(){
            let checkList = [];　//选中的货物　
            let list = []; //未选中的货物
            for(var i=0;i<this.list.length;i++){
                if(this.list[i].checked){
                    checkList.push(this.list[i])
                }else{
                    list.push(this.list[i]);
                }
            }
            this.$emit('updateList',list);
            this.axios.post('api/addOrders',checkList)
            .then(rs => {
                this.$message({
                    'type':success,
                    'message':'提交成功'
                })
                this.$emit('update')
            })
        },
        getPrice(){
            let sum = 0;
            this.list.forEach(item => {
                if(item.checked){
                    sum += item.num*item.price;
                }      
            })
            this.price =  sum;
        },
        handleCheckChange(){
            this.getPrice();
        },
        handleNumChange(){
            this.getPrice();
        },
        handleAllCheckClick(check){
            if(check){
                this.allChecked()
                this.getPrice()
            }
        },
        handleDelete(id){
            for(var i = 0;i<this.list.length;i++){
                if(this.list[i].cId == id){
                    this.list.splice(i,1)
                }
            }
            this.getPrice()
        },
        allChecked(){
            this.list.forEach(item => {
                item.checked = true;
            })
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
            >>> .el-checkbox__input
                line-height 2rem
            >>> .el-checkbox__label
                width 100%
                display flex
            >>> .el-checkbox
                margin-left 0
            .img
                width  1.6rem
                img
                    padding  0rem .2rem
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
                .content
                    display -webkit-box
                    -webkit-box-orient vertical
                    overflow hidden
                    -webkit-line-clamp:3;
                    color #999999
                    overflow hidden
                    font-size .32rem
                    height 1.44rem
                    line-height .48rem
                .foot
                    padding-top .1rem
                    padding-bottom .2rem
                    .price
                        color #f56c6c                      
                    .add
                        float right
                        display inline-block
                        margin-right .2rem
                .action
                    display flex
                    .delete
                        margin-left .1rem
        .footer
            position fixed
            height .8rem
            width 100%
            bottom 0
            border-top .02rem solid #c6c6c6
            .checkBox
                float left
                margin 0 .1rem
                padding-left .2rem
                height .8rem
                line-height .8rem
                .check
                    display inline-block
                    margin-top .1rem
                    color #fff
                    font-size .48rem
                    border .02rem solid #c6c6c6
                    border-radius 100%
                .message
                    margin-left .2rem
                    margin-top .1rem
                    line-height .8rem
            .price
                float right 
                font-size .36rem 
                line-height .8rem 
                padding-right .1rem 
            .submit
                float right
</style>
