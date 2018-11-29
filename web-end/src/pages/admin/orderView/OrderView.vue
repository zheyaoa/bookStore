<template>
    <div class="container">
        <view-header></view-header>
        <view-list></view-list>
    </div>
</template>
<script>
import ViewHeader from './components/Header'
import ViewList from './components/List'
export default {
    name:'OrderView',
    components:{
        ViewHeader,
        ViewList
    }
}
</script>
<style lang="stylus" scoped>

</style>
