<template>
    <div class="container">
        <address-header></address-header>
        <address-form></address-form>
    </div>
</template>
<script>
import AddressHeader from './components/Header'
import AddressForm from './components/Form'
export default {
    name:'Address',
    components:{
        AddressHeader,
        AddressForm
    }
}
</script>
<style lang="stylus" scoped>
    .container
        height 100%
        background #ebeced
</style>
