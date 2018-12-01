<template>
    <div class="container">
        <cart-header></cart-header>
        <cart-list></cart-list>
    </div>
</template>
<script>
import CartHeader from './components/Header';
import CartList from './components/List';
export default {
    name:'ShoppingCart',
    components:{
        CartHeader,
        CartList,
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
</style>
