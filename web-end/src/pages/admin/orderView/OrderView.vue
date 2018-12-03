<template>
    <div class="container">
        <view-header></view-header>
        <view-list></view-list>
        <view-tab></view-tab>
    </div>
</template>
<script>
import ViewHeader from './components/Header'
import ViewList from './components/List'
import ViewTab from './components/Tab'
export default {
    name:'OrderView',
    components:{
        ViewHeader,
        ViewList,
        ViewTab
    },
    data(){
        return{

        }
    }
}
</script>
<style lang="stylus" scoped>

</style>
