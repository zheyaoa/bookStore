<template>
    <div class="container">
        <order-header></order-header>
        <order-list></order-list>
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
    }
}
</script>
<style lang="stylus" scoped>

</style>
