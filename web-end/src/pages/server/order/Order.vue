<template>
    <div class="container">
        <order-header></order-header>
        <order-list :list=list></order-list>
    </div>
</template>
<script>
import OrderHeader from './components/Header';
import OrderList from './components/List'
export default {
    name:'Order',
    components:{
        OrderHeader,
        OrderList
    },
    data(){
        return{
            list:[]
        }
    },
    mounted(){
        this.axios.post('https://www.easy-mock.com/mock/5c03b2ae125d962d127404d1/getOrders')
        .then(rs => {
            this.list = rs.data.list
        })
    }
}
</script>
<style lang="stylus" scoped>

</style>
