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
        this.axios.post('http://localhost:8080/api/getUserOrderList')
        .then(rs => {
            this.list = rs.data
        })
    }
}
</script>
<style lang="stylus" scoped>

</style>
