<template>
    <div class="container">
        <cart-header></cart-header>
        <cart-list></cart-list>
        <cart-footer></cart-footer>
    </div>
</template>
<script>
import CartHeader from './components/Header';
import CartList from './components/List';
import CartFooter from './components/Footer'
export default {
    name:'ShoppingCart',
    components:{
        CartHeader,
        CartList,
        CartFooter
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
</style>
