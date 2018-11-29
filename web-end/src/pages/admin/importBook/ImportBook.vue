<template>
    <div class="container">
        <import-header></import-header>
        <import-form></import-form>
    </div>
</template>
<script>
import ImportHeader from './components/Header.vue'
import ImportForm from './components/Form.vue'
export default {
    name:'ImportBook',
    components:{
        ImportHeader,
        ImportForm
    }
}
</script>
<style lang="stylus" scoped>

</style>
